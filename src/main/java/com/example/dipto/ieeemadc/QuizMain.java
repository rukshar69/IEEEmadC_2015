package com.example.dipto.ieeemadc;

/**
 * Created by Dipto on 11/05/2016.
 */
public class QuizMain {
    private int Id;
    private String Name;
    private String Subject;

    public QuizMain(int Id,String Name,String Subject){
        this.Id=Id;
        this.Name=Name;
        this.Subject=Subject;
    }

    public void setId(int Id){
        this.Id=Id;
    }

    public void setName(String Name){
        this.Name=Name;
    }

    public void setSubject(String Subject){
        this.Subject=Subject;
    }

    public int getId(){
        return Id;
    }

    public String getName(){
        return Name;
    }

    public String getSubject(){
        return Subject;
    }
}
