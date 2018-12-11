package DataBaseTest;

import DataBase.*;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Marshall
 */
public class DAOTester 
{
    private DAO myDAO;
    private DataSource myDataSource;
    
    @Before
    public void setUp() throws SQLException 
    {
        myDataSource = DataSourceFactoryUnit.getDataSource();
        myDAO=new DAO(myDataSource);
    }
    
    // <editor-fold defaultstate="collapsed" desc="Shared Test. Click on the + sign on the left to edit the code.">
    @Test
    public void testLogin() throws DAOException
    {
        String Mail="jumboeagle@example.com";
        String ID="1";
        //Test Admin.
        assertEquals(myDAO.loginCheck("admin", "admin"),true);
        //Test Client
        assertEquals(myDAO.loginCheck(Mail, ID),true);
        //Test ClientFail
        assertEquals(myDAO.loginCheck(Mail, "2"),false);
    }
    
    @Test
    public void testAllOrderNumber() throws DAOException
    {
        List<Integer> ON = myDAO.getAllOrderNumbers();
        assertEquals(ON.size(),15);
    }
    
    @Test
    public void testDescToNum() throws DAOException
    {
        String desc="Identity Server";
        assertEquals(myDAO.OrdDescToNum(desc),980001);
    }
    
    @Test
    public void testPrice() throws DAOException
    {
        int quantity=3;
        int PID = 980601;
        assertEquals(myDAO.shipPrice(PID, quantity),2000.95*quantity,2000.95*quantity);
    }
    
    @Test
    public void testOrderNumbers() throws DAOException
    {
        int cID=1;
        int size=2;
        List test=myDAO.getOrderNumbers(cID);
        assertEquals(test.size(),size);
    }
    
    @Test
    public void testProducts() throws DAOException
    {
        int size = 30;
        List test = myDAO.getProduct();
        for (int i=0; i<test.size();i++)
        {
            System.out.println(test.get(i));
        }
        assertEquals(test.size(), size);
    }
    
    @Test
    public void testCompany() throws DAOException 
    {
        List fcomp = myDAO.getFCompany();
        assertEquals(fcomp.size(),7);
    }
    
    @Test
    public void testDiscountCodes() throws DAOException 
    {
        List dC = myDAO.getDiscountCode();
        assertEquals(dC.size(),4);
    }
    
    @Test
    public void testStates() throws DAOException
    {
        List states = myDAO.getStates();
        assertEquals(states.size(),6);
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Client Test. Click on the + sign on the left to edit the code.">
    
    /*@Test public void testClientOrders() throws DAOException
    {
        String clientLogin = "www.smallbill.example.com";
        String clientMDP = "3";
        String product="Sound Card";
        String company="Western Fast";
        int clientID = clientMDP.indexOf(0);
        int quantity = 2;
        int befor = myDAO.getAllOrderNumbers().size();
        
        
        assertEquals(myDAO.loginCheck(clientLogin, clientMDP),true);
        int orderNum = myDAO.addOrder(clientID, product, quantity, company);
        //int after=myDAO.getAllOrderNumbers().size();
        //assertEquals(after,befor+1);
        //myDAO.editOrder(orderNum, "Learn Java in 1/2 hour", 1);
        //myDAO.deleteOrder(orderNum);
        //assertEquals(myDAO.getAllOrderNumbers().size(),befor);
    }*/
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Other Test. Click on the + sign on the left to edit the code.">
    
    @Test
    public void testDate()
    {
        System.out.println(myDAO.showDate());
    }
    
    // </editor-fold>
}
