package com.example.dipto.ieeemadc;

/**
 * Created by Dipto on 10/05/2016.
 */
public class Contact {
    private String name;
    private String email;
    private String password;
    private String contactNo;
    private String education;
    private String job;
    private String sex;
    private String interest;

    public Contact(String name,String email,String password,String contactNo,String job,String education,String interest,String birthday,String sex) {
        this.birthday = birthday;
        this.contactNo = contactNo;
        this.education = education;
        this.email = email;
        this.interest = interest;
        this.job = job;
        this.name = name;
        this.sex = sex;
        this.password = password;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {

        return birthday;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getEducation() {
        return education;
    }

    public String getInterest() {
        return interest;
    }

    public String getJob() {
        return job;
    }

    public String getSex() {
        return sex;
    }

    private String birthday;


    public void setName(String name){
        this.name=name;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }
}
