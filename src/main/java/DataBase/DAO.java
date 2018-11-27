package DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    private final DataSource myDataSource;
    
    public DAO(DataSource dataSource)
    {
        this.myDataSource = dataSource;
    }
    
    // <editor-fold defaultstate="collapsed" desc="Shared DAO methods. Click on the + sign on the left to edit the code.">
    
    public List<Integer> getAllOrderNumbers()
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
    
    public void addOrder(int customerID, String product, int quantity, String fCompany)
    {
        String sql = "INSERT INTO PURCHASE_ORDER VALUES(?,?,?,?,?,?,?,?)";

        try (Connection connection = myDataSource.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql))
        {
            stmt.setObject(1, "");  //New Order_number
            stmt.setObject(2, customerID);  
            stmt.setObject(3, "");  //Convert desc to ID
            stmt.setObject(4, quantity);
            stmt.setObject(5, "");  //Compute total cost
            stmt.setObject(6, "");  //Get Date
            stmt.setObject(7, "");  //Get Date
            stmt.setObject(8, fCompany);
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            //throws exception
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Admin DAO methods. Click on the + sign on the left to edit the code.">
    // </editor-fold>
}
