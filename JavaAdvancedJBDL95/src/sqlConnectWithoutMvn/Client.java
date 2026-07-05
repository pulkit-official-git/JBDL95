package sqlConnectWithoutMvn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Client {

    public static void main(String[] args) throws SQLException {

        /*
        * mysql
        * create a db
        * make a connection
        * create a table
        * */


//        sql, h2, oracle, postgress,  rdbms
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","oooooooo");
        Statement statement = connection.createStatement();
        statement.execute("create table dummy(id int ,name varchar(50) )");

    }
}
