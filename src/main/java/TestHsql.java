import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Dzmitry Misiuk
 */
public class TestHsql {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.hsqldb.jdbc.JDBCDriver");
        Connection conn = DriverManager.getConnection( "jdbc:hsqldb:mem:mydb", "", "");

        System.out.println(conn.getMetaData().getDatabaseProductName());

        String bookTableSQL = "create memory table MY_TABLE ("+
                " TITLE varchar(256) not null primary key,"+
                " AUTHOR varchar(256) not null"+
                ");";
        Statement st = conn.createStatement();
        st.execute(bookTableSQL);
    }
}
