package DataBase;

//import Structures.ClientInfo;
import javax.sql.DataSource;

public class DAO_Client 
{
    private final DataSource myDataSource;
    
    public DAO_Client(DataSource dataSource)
    {
        this.myDataSource = dataSource;
    }
    
    
    
    
    
    public void editOrder(int orderNumber, String product, int quantity)
    {
        
    }
    
    public void deleteOrder(int orderNumber)
    {
        
    }
}
