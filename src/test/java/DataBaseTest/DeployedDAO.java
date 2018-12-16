package DataBaseTest;

import DataBase.DAO;
import DataBase.DataSourceFactoryDeployed;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.hsqldb.cmdline.SqlFile;
import org.hsqldb.cmdline.SqlToolError;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marshall
 */
public class DeployedDAO 
{
    private DAO myDAO;
    private DataSource myDataSource;
    private static Connection myConnection;
    
    @Before
    public void setUp() throws SQLException, IOException, SqlToolError 
    {
        myDataSource = DataSourceFactoryDeployed.getDataSource();
        myConnection = myDataSource.getConnection();
        
        String dataBase = DeployedDAO.class.getResource("DataBase.sql").getFile();
        SqlFile sql = new SqlFile(new File(dataBase));
        sql.setConnection(myConnection);
        sql.execute();
        sql.closeReader();
        
        myDAO = new DAO(myDataSource);
    }
    
    @After
    public void tearDown() throws SQLException 
    {
        myConnection.close();
        myDAO = null;
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
