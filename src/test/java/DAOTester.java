import DataBase.DAO;
import DataBase.DataSourceFactory;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.junit.After;
import org.junit.Before;

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
        myDataSource = DataSourceFactory.getDataSource();
    }
    
    @After
    public void tearDown() {
    }
}
