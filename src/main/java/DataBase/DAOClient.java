package DataBase;

//import Structures.ClientInfo;
import javax.sql.DataSource;

public class DAOClient 
{
    private final DataSource myDataSource;
    
    public DAOClient(DataSource dataSource)
    {
        this.myDataSource = dataSource;
    }
    
    public void addOrder(int customerID, String product, int quantity, String fCompany)
    {
        String orderSql = "INSERT INTO PURCHASE_ORDER(?,?,?,?,?,?,?,?)";
        
        
    }
    
    public void editOrder(int orderNumber, String product, int quantity)
    {
        
    }
    
    public void deleteOrder(int orderNumber)
    {
        
    }
}
