package booksystem.utils;

import java.sql.*;

public class JDBCUtils {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_ORL = "jdbc:mysql://www.rocketss.net:3306/Douz";
    static final String USER = "root";
    static final String PASSWORD = "123456";

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    public ResultSet searchQuery(String sql) {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_ORL,USER,PASSWORD);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException E) {
            System.out.print(E);
        } catch (ClassNotFoundException E2) {
            System.out.print(E2);
        } finally {
            return rs;
        }
    }

    public Integer editOrUpdate(String sql) {
        Integer i = 0;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_ORL,USER,PASSWORD);
            stmt = conn.createStatement();
            i = stmt.executeUpdate(sql);
        } catch (ClassNotFoundException e) {
            System.out.print(e);
        } catch (SQLException e1) {
            System.out.print(e1);
        }
        return i;
    }

    public void close(){
        try {
            if(stmt != null) {
                stmt.close();
            }
            if(conn != null) {
                conn.close();
            }
        } catch (SQLException E4) {
            System.out.print(E4);
        }
    }
}
