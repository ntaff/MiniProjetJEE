package DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author Marshall
 */
public class DAO 
{
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date date;
    private final String admin="admin";
    private final DataSource myDataSource;
    
    public DAO(DataSource dataSource)
    {
        this.myDataSource = dataSource;
        this.date=new Date();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Shared DAO methods. Click on the + sign on the left to edit the code.">
    
    public boolean loginCheck(String Mail, String ID) throws DAOException   //Check if admin or Client. Tested
    {        
        if(Mail==admin && ID==admin)
        {
            return true;
        }
        String sql = "SELECT * FROM CUSTOMER WHERE CUSTOMER_ID=? and EMAIL=?";
        
        try(Connection connection = myDataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql))
        {
            stmt.setString(1, ID);
            stmt.setString(2, Mail);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
                return true;
            }
            
        } catch (SQLException ex) {
            throw new DAOException("DataBase Connection Failed.");
        }
        return false;
    }
    
    public List<Integer> getAllOrderNumbers()   //For DAO. Tested
    {
        List<Integer> NumOrders = new ArrayList();
        String sql = "Select ORDER_NUM FROM PURCHASE_ORDER";
        
        try (Connection connection = myDataSource.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql))
        {
            try (ResultSet rs = stmt.executeQuery())
            {
                while(rs.next())
                {
                    NumOrders.add(rs.getInt("ORDER_NUM"));
                }
            }
            
        } catch (SQLException ex) {
            //throws exception
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return NumOrders;
    }
    
    public int OrdDescToNum(String desc) throws DAOException   //For DAO. Tested
    {
        int Num=0;
        String sql ="SELECT PRODUCT_ID FROM PRODUCT WHERE DESCRIPTION=?";
        
        try(Connection connection = myDataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql))
        {
            stmt.setString(1,desc);
            ResultSet rs = stmt.executeQuery();
            if(rs.next())
            {
                Num=rs.getInt("PRODUCT_ID");
            }
            
        }catch (SQLException ex) {
            throw new DAOException("DataBase Connection Failed.");
        }
        
        return Num;
    }

    public float shipPrice(int PID, int quantity) throws DAOException   //For DAO. Tested
    {
        float price=0;
        String sql = "SELECT PURCHASE_COST FROM PRODUCT WHERE PRODUCT_ID=?";
        
        try(Connection connection = myDataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql))
        {
            stmt.setInt(1,PID);
            ResultSet rs = stmt.executeQuery();
            if(rs.next())
            {
                price=rs.getFloat("PURCHASE_COST");
            }
            
        }catch (SQLException ex) {
            throw new DAOException("DataBase Connection Failed.");
        }
        
        return price*quantity;
    }
    
    public List<Integer> getOrderNumbers(int customerID) //toImplement
    {
        List<Integer> Orders = new ArrayList();
        
        
        return Orders;
    }
    
    public List<String> getProductIDs() //toImplement
    {
        List<String> PID = new ArrayList();
        
        
        return PID;
    }
    
    public List<String> getFCompany() //toImplement
    {
        List<String> FC = new ArrayList();
        
        
        return FC;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Client DAO methods. Click on the + sign on the left to edit the code.">
    
    public int addOrder(int customerID, String product, int quantity, String fCompany) throws DAOException
    {
        String currentDate=dateFormat.format(date);
        
        List<Integer> ON = this.getAllOrderNumbers();
        int NewON = Collections.max(ON)+1;
        int prodID = this.OrdDescToNum(product);
        float price = this.shipPrice(prodID, quantity);
        
        String sql = "INSERT INTO PURCHASE_ORDER VALUES(?,?,?,?,?,?,?,?)";

        try (Connection connection = myDataSource.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql))
        {
            stmt.setObject(1, NewON);
            stmt.setObject(2, customerID);  
            stmt.setObject(3, prodID);  
            stmt.setObject(4, quantity);
            stmt.setObject(5, price);
            stmt.setObject(6, currentDate);
            stmt.setObject(7, currentDate);
            stmt.setObject(8, fCompany);
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            //throws exception
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return NewON;
    }
    
    public void editOrder(int orderNumber, String product, int quantity) throws DAOException
    {
        int prodID = this.OrdDescToNum(product);
        String currentDate=dateFormat.format(date);
        String sql="UPDATE PURCHASE_ORDER SET PRODUCT_ID=?, QUANTITY=?, SALES_DATE=?, SHIPPING_DATE=? WHERE ORDER_NUM=?";
        
        try(Connection connection =myDataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql))
        {
            stmt.setInt(1,prodID);
            stmt.setInt(2, quantity);
            stmt.setString(3, currentDate);
            stmt.setString(4, currentDate);
            stmt.setInt(5, orderNumber);
            
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            //throw exception
        }
    }
    
    public void deleteOrder(int orderNumber)
    {
        String sql="DELETE FROM PURCHASE_ORDER WHERE ORDER_NUM=?";
        
        try(Connection connection = myDataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql))
        {
            stmt.setInt(1, orderNumber);
            stmt.executeUpdate();
            
        }catch (SQLException ex) {
            //throws exception
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Admin DAO methods. Click on the + sign on the left to edit the code.">
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Other Test methods. Click on the + sign on the left to edit the code.">
    
    public String showDate()
    {
        return dateFormat.format(date);
    }
    
    // </editor-fold>
}
