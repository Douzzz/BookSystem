package booksystem.dao;

import booksystem.model.User;
import booksystem.utils.JDBCUtils;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public User getUser(String username, String password) {
        String sql = "select id,username,password from users where username = '" + username + "' and password = '" + password + "'";
        JDBCUtils jdbcUtils = new JDBCUtils();
        ResultSet rs = jdbcUtils.searchQuery(sql);
        User user = null;
        try {
            if (rs != null && rs.first()) {
                Integer id = rs.getInt("id");
                user = new User(username, "", id);
            }
            rs.close();
        } catch (SQLException E) {
            System.out.print(E);
        } finally {
            jdbcUtils.close();
            return user;
        }
    }
}
