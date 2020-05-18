// Copyright © 2019. All rights reserved.
// Authors: Vitalii Babenko, Anastasiia Dydyk
// Contacts: vbabenko2191@gmail.com

package diploma.classes;

public class Patient {
    private int patientID;
    private String patientSurname;
    private String patientFirstname;
    private String patientMiddlename;
    private String uraGroup;
    private String sex;


    public int getPatientID() {
        return patientID;
    }

    public String getPatientSurname() {
        return patientSurname;
    }

    public String getPatientFirstname() {
        return patientFirstname;
    }

    public String getPatientMiddlename() {
        return patientMiddlename;
    }

    public String getUraGroup(){
        return uraGroup;
    }

    public String getSex() {
        return sex;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public void setPatientSurname(String patientSurname) {
        this.patientSurname = patientSurname;
    }

    public void setPatientFirstname(String patientFirstname) {
        this.patientFirstname = patientFirstname;
    }

    public void setPatientMiddlename(String patientMiddlename) {
        this.patientMiddlename = patientMiddlename;
    }

    public void setUraGroup(String uraGroup) {
        this.uraGroup = uraGroup;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
