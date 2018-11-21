/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author pedago
 */
public class DAO 
{
    private final DataSource myDataSource;
    
    public DAO(DataSource dataSource)
    {
        this.myDataSource = dataSource;
    }
    
    public List<Integer> getOrderNumbers(int customerID)
    {
        List<Integer> Orders = new ArrayList();
        
        
        return Orders;
    }
    
    public List<String> getProductIDs()
    {
        List<String> PID = new ArrayList();
        
        
        return PID;
    }
    
    public List<String> getFCompany()
    {
        List<String> FC = new ArrayList();
        
        
        return FC;
    }
}
