package DataBase;

import DataStructure.ChiffreAff;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
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
    
    public boolean loginCheck(String Mail, String ID) throws DAOException   //Check if admin or Client.
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
    
    public List<Integer> getAllOrderNumbers() throws DAOException   //For DAO. Gets all orders.
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
            throw new DAOException("DataBase Connection Failed.");
        }
        
        return NumOrders;
    }
    
    public int OrdDescToNum(String desc) throws DAOException   //For DAO. Uses the product description then returns it's ID.
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

    public float shipPrice(int PID, int quantity) throws DAOException   //For DAO. Computes the total price for the order. 
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
    
    public List<Integer> getOrderNumbers(int customerID) throws DAOException //Returns a list of orders available for a customer. 
    {
        List<Integer> Orders = new ArrayList();
        
        String sql = "SELECT ORDER_NUM FROM PURCHASE_ORDER WHERE CUSTOMER_ID=?";
        
        try(Connection connection = myDataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql))
        {
            stmt.setObject(1, customerID);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                Orders.add(rs.getInt("ORDER_NUM"));
            }
            
        } catch (SQLException ex)
        {
            throw new DAOException("DataBase Connection Failed.");
        }
        return Orders;
    }
    
    public List<String> getProduct() throws DAOException //Returns a list of all the products descriptions.
    {
        List<String> P = new ArrayList();
        
        String sql = "SELECT DESCRIPTION FROM PRODUCT";
        
        try(Connection connection = myDataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql))
        {
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                P.add(rs.getString("DESCRIPTION"));
            }
            
        } catch(SQLException ex) {
            throw new DAOException("DataBase Connection Failed.");
        }
        return P;
    }
    
    public List<String> getFCompany() throws DAOException //Returns all the Freight Companies.
    {
        List<String> FC = new ArrayList();
        
        String sql = "SELECT DISTINCT FREIGHT_COMPANY FROM PURCHASE_ORDER";
        
        try(Connection connection = myDataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql))
        {
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                FC.add(rs.getString("FREIGHT_COMPANY"));
            }
            
        } catch(SQLException ex){
            throw new DAOException("DataBase Connection Failed.");
        }
        
        return FC;
    }
    
    public List<Character> getDiscountCode() throws DAOException    //Returns all the discount codes.
    {
        List<Character> dC = new ArrayList();
        
        String sql = "SELECT DISCOUNT_CODE FROM DISCOUNT_CODE";
        
        try(Connection connection = myDataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql))
        {
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                dC.add(rs.getString("DISCOUNT_CODE").charAt(0));
            }
            
        } catch (SQLException ex) {
            throw new DAOException("DataBase Connection Failed.");
        }
        
        return dC;
    }
    
    public List<String> getStates() throws DAOException //Returns all states currently populated by customers.
    {
        List<String> states = new ArrayList();
        
        String sql = "SELECT DISTINCT STATE FROM CUSTOMER";
        
        try(Connection connection = myDataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery())
        {
            while(rs.next())
            {
                states.add(rs.getString("STATE"));
            }
            
        } catch (SQLException ex)
        {
            throw new DAOException("DataBase Connection Failed.");
        }
        
        return states;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Client DAO methods. Click on the + sign on the left to edit the code.">
    
    public void editCustomer(   int customerID, char discountCode, int ZIP, String Nom, String addr1, String addr2, String City, 
                                String state, String phone, String Fax, String email, int creditLimit)  //To test
    {
        String sql =    "UPDATE CUSTOMER "
                        + "SET discount_code=?, zip=?, name=?, adressline1=?, adresseline2=?, city=?, state=?, "
                        + "phone=?, fax=?, email=?, credit_limit=? "
                        + "where order_num=?";
        
        try(Connection connection =myDataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql))
        {
            stmt.setObject(1, discountCode);
            stmt.setObject(2, ZIP);
            stmt.setObject(3, Nom);
            stmt.setObject(4, addr1);
            stmt.setObject(5, addr2);
            stmt.setObject(6, City);
            stmt.setObject(7, state);
            stmt.setObject(8, phone);
            stmt.setObject(9, Fax);
            stmt.setObject(10, email);
            stmt.setObject(11, creditLimit);
            stmt.setObject(12, customerID);
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            //throw connection exception
        }
    }
    
    public int addOrder(int customerID, String product, int quantity, String fCompany) throws DAOException  //To test
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
    
    public void editOrder(int orderNumber, String product, int quantity) throws DAOException    //To test
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
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            //throw exception
        }
    }
    
    public void deleteOrder(int orderNumber)    //To test
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
    
    public ChiffreAff getChiffresAffairesProduit(String produit, String dateDeb, String dateFin) throws DAOException, ParseException   //toTest
    {
        ChiffreAff cA = new ChiffreAff(produit,0.f);
        int PID = OrdDescToNum(produit);
        Date deb = dateFormat.parse(dateDeb);
        Date fin = dateFormat.parse(dateFin);
        
        String sql = "SELECT SHIPPING_COST FROM PURCHASE_ORDER WHERE PRODUCT_ID=? AND SALES_DATE>=? AND SHIPPING_DATE<=?;";
        
        try(Connection connection = myDataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql))
        {
            stmt.setInt(1, PID);
            stmt.setDate(2, (java.sql.Date) deb);
            stmt.setDate(3, (java.sql.Date) fin);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                float num = rs.getFloat("SHIPPING_COST");
                cA.addToSales(num); 
            }
            
        } catch (SQLException ex){
            //Throw exception
        }
        return cA;
    }
    
    public ChiffreAff getChiffresAffairesState(String state, String dateDeb, String dateFin) throws ParseException  //toTest
    {
        ChiffreAff cA = new ChiffreAff(state,0.f);
        Date deb = dateFormat.parse(dateDeb);
        Date fin = dateFormat.parse(dateFin);
        
        String sql= "SELECT PURCHASE_ORDER.SHIPPING_COST "
                    + "FROM CUSTOMER INNER JOIN PURCHASE_ORDER ON CUSTOMER.CUSTOMER_ID=PURCHASE_ORDER.CUSTOMER_ID"
                    + "WHERE CUSTOMER.STATE=?";
        
        try(Connection connection = myDataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql))
        {
            stmt.setString(1, state);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                cA.addToSales(rs.getFloat("SHIPPING_COST"));
            }
            
        } catch (SQLException ex)
        {
            //Throw Exception.
        }
        
        return cA;
    }
    
    public ChiffreAff getChiffresAffairesClient(String clientName, String dateDeb, String dateFin) throws ParseException  //toTest
    {
        ChiffreAff cA = new ChiffreAff(clientName,0.f);
        Date deb = dateFormat.parse(dateDeb);
        Date fin = dateFormat.parse(dateFin);
        
        String sql = "SELECT PURCHASE_ORDER.SHIPPING_COST "
                    + "FROM CUSTOMER INNER JOIN PURCHASE_ORDER ON CUSTOMER.CUSTOMER_ID=PURCHASE_ORDER.CUSTOMER_ID"
                    + "WHERE CUSTOMER.NAME=?";
        
        try(Connection connection = myDataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql))
        {
            stmt.setString(1, clientName);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                cA.addToSales(rs.getFloat("SHIPPING_COST"));
            }
            
        } catch (SQLException ex)
        {
            //Throw Exception.
        }
        
        return cA;
    }
    
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Other Test methods. Click on the + sign on the left to edit the code.">
    
    public String showDate()    //Gets current date.
    {
        return dateFormat.format(date);
    }
    
    // </editor-fold>
}
