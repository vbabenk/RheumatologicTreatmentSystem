package diploma.patientChooserMVC;

import diploma.classes.Patient;
import org.sqlite.JDBC;

import java.sql.*;

public class PatientChooserActivity {
    public Patient loadPatient(String something) throws SQLException {
        Patient patient = new Patient();
        DriverManager.registerDriver(new JDBC());
        Connection con = DriverManager.getConnection("jdbc:sqlite:Databases\\RheumatologyDB.db");
        String select = "SELECT * FROM Patients WHERE patientID = '" + something + "' OR patientSurname = '" + something + "'";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(select);
        while(rs.next()){
            patient.setPatientID(rs.getInt(1));
            patient.setPatientSurname(rs.getString(2));
            patient.setPatientFirstname(rs.getString(3));
            patient.setPatientMiddlename(rs.getString(4));
            patient.setUraGroup(rs.getString(5));
            patient.setSex(rs.getString(6));
        }
        con.close();
        return patient;
    }
}
