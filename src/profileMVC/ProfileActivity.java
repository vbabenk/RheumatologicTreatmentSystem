// Copyright © 2019. All rights reserved.
// Authors: Vitalii Babenko
// Contacts: vbabenko2191@gmail.com

package diploma.profileMVC;

import org.sqlite.JDBC;

import java.sql.*;

public class ProfileActivity {
    public void addNewPatient(String patientSurname, String patientFirstname, String patientMiddlename, String uraGroup,
                              String x101, String x102, String x103, String x104, String x105, String x106, String x107,
                              String x108, String x109, String x110, String x111, String x112, String x113, String x114,
                              String x115, String x116, String x117, String x118, String x119, String x120, String x121,
                              String x122, String x123, String x124, String x125, String x126, String x127) throws SQLException {
        DriverManager.registerDriver(new JDBC());
        Connection con = DriverManager.getConnection("jdbc:sqlite:Databases\\RheumatologyDB.db");
        String comma = ",";
        String symbol = "'";
        String insert = "INSERT INTO Patients(patientSurname, patientFirstname, patientMiddlename, uraGroup, x101, x102, x103, " +
                "x104, x105, x106, x107, x108, x109, x110, x111, x112, x113, x114, x115, x116, x117, x118, x119, x120," +
                "x121, x122, x123, x124, x125, x126, x127) VALUES('" + patientSurname + symbol + comma + symbol +
                patientFirstname + symbol + comma + symbol + patientMiddlename + symbol + comma + symbol + uraGroup +
                symbol + comma + symbol + x101 + symbol + comma + x102 + comma + x103 + comma + symbol + x104 + symbol +
                comma + symbol + x105 + symbol + comma + symbol + x106 + symbol + comma + symbol + x107 + symbol +
                comma + symbol + x108 + symbol + comma + symbol + x109 + symbol + comma + symbol + x110 + symbol +
                comma + symbol + x111 + symbol + comma + symbol + x112 + symbol + comma + symbol + x113 + symbol +
                comma + symbol + x114 + symbol + comma + x115 + comma + symbol + x116 + symbol + comma + symbol +
                x117 + symbol + comma + symbol + x118 + symbol + comma + symbol + x119 + symbol + comma + x120 + comma
                + x121 + comma + x122 + comma + x123 + comma + x124 + comma + x125 + comma + x126 + comma + x127 + ")";
        Statement stmt = con.createStatement();
        stmt.executeUpdate(insert);
        con.close();
    }
}
