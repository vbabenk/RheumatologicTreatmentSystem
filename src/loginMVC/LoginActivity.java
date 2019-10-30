package diploma.loginMVC;

import org.sqlite.JDBC;

import java.sql.*;

public class LoginActivity {
    public boolean checkAccount(String login, String password) throws SQLException {
        DriverManager.registerDriver(new JDBC());
        Connection con = DriverManager.getConnection("jdbc:sqlite:Databases\\RheumatologyDB.db");
        String select = "SELECT COUNT(*) FROM Accounts WHERE accountLogin = '" + login + "' AND accountPassword = '" +
                password + "'";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(select);
        if (rs.getInt(1) == 1) {
            con.close();
            return true;
        } else {
            con.close();
            return false;
        }
    }
}