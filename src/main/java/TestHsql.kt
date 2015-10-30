import java.sql.DriverManager

/**
 * @author Dzmitry Misiuk
 */
fun main(args: Array<String>) {
    Class.forName("org.hsqldb.jdbc.JDBCDriver")
    val conn = DriverManager.getConnection("jdbc:hsqldb:mem:mydb", "", "")

    println(conn.metaData.databaseProductName + " " +  conn.metaData.databaseProductVersion)

    val bookTableSQL = "create memory table MY_TABLE (" + " TITLE varchar(256) not null primary key," + " AUTHOR varchar(256) not null" + ");"
    val st = conn.createStatement()
    st.execute(bookTableSQL)
}
