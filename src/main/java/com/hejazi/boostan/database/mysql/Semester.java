package com.hejazi.boostan.database.mysql;



import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Semester {
    @EmbeddedId
    private key primaryKey;

    @Column(nullable = false)
    private String status;

    @Column(nullable = true)
    private double mark;

    public void setStatus(String status) { this.status = status; }

    public void setMark(double mark) { this.mark = mark; }

    public String getMarkType() { return markType; }

    public void setMarkType(String markType) { this.markType = markType; }

    @Column(nullable = true)
    private String markType;

    @Column
    private String registerType;

    public String getRegisterType() {
        return registerType;
    }

    public void setRegisterType(String registerType) {
        this.registerType = registerType;
    }

    public int getCourse() {
        return primaryKey.getCourse();
    }

    public int getStudent() { return primaryKey.getStudent(); }

    public int getTeacher() { return primaryKey.getTeacher(); }

    public int getTerm() {
        return primaryKey.getTerm();
    }

    public key getPrimaryKey() {
        return primaryKey;
    }

    public String getStatus() {
        return status;
    }

    public double getMark() {
        return mark;
    }
}

@Embeddable
class key implements Serializable{
    @Column
    private int course;

    @Column
    private int student;

    @Column
    private int teacher;

    @Column(nullable = false)
    private int term;

    public int getCourse() {
        return course;
    }

    public int getStudent() {
        return student;
    }

    public int getTeacher() {
        return teacher;
    }

    public int getTerm() {
        return term;
    }
}