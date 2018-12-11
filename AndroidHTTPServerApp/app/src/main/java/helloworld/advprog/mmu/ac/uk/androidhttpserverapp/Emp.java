package helloworld.advprog.mmu.ac.uk.androidhttpserverapp;

import java.io.Serializable;

/**
 * Created by Kristen on 02/03/2017.
 */

public class Emp implements Serializable {
    private String id, name, gender, dob, address, postcode, natInscNo, title, startDate, salary, email;
    public Emp(String id, String name, String gender, String dob, String address, String postcode, String natInscNo, String jobTitle, String startDate, String salary, String email) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.postcode = postcode;
        this.natInscNo = natInscNo;
        this.title = jobTitle;
        this.salary = salary;
        this.startDate = startDate;
        this.email = email;
    }
    //getters and setters for employee
    public void setID(String id) { this.id = id; }
    public String getID() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getGender() {
        return gender;
    }
    public void setNatInscNo(String natInscNo) {
        this.natInscNo = natInscNo;
    }
    public String getNatInscNo() {
        return natInscNo;
    }
    public void setDoB(String dob) {
        this.dob = dob;
    }
    public String getDoB() {
        return dob;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return address;
    }
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
    public String getPostcode() {
        return postcode;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public String getStartDate() {
        return startDate;
    }
    public void setSalary(String salary) {
        this.salary = salary;
    }
    public String getSalary() {
        return salary;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
}
