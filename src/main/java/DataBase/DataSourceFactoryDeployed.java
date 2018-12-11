package DataBase;

import javax.sql.DataSource;

/**
 *
 * @author Marshall
 */
public class DataSourceFactoryDeployed 
{
    public enum DriverType
    {
        embedded, server
    };
    
    private static final DriverType TYPE = DriverType.embedded;
    
    public static DataSource getDataSource()
    {
        DataSource result;
        
        switch (TYPE)
        {
            case server:
                org.apache.derby.jdbc.ClientDataSource ds = new org.apache.derby.jdbc.ClientDataSource();
                ds.setDatabaseName("sample");
                ds.setUser("app");
                ds.setPassword("app");
                // The host on which Network Server is running
                ds.setServerName("localhost");
                // port on which Network Server is listening
                ds.setPortNumber(1527);
                result = ds;
                break;
            default:
                org.apache.derby.jdbc.EmbeddedDataSource es = new org.apache.derby.jdbc.EmbeddedDataSource();
                es.setCreateDatabase("create");
                es.setDatabaseName("embedded_sample");
                result = es;
        }
        return result;
    }
}
