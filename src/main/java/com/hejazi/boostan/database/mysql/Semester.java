package com.hejazi.boostan.database.mysql;



import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Semester {
    @EmbeddedId
    private key primaryKey;

    @Column(nullable = false)
    private String status;

    public Semester() {
    }

    public Semester(int course, int student, int teacher, int term, String status, double mark, String markType, String registerType) {
        this.primaryKey = new key(course,student,teacher,term);
        this.status = status;
        this.mark = mark;
        this.markType = markType;
        this.registerType = registerType;
    }

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

    public String getRegisterType() { return registerType; }

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

    public key() {
    }

    public key(int course, int student, int teacher, int term) {
        this.course = course;
        this.student = student;
        this.teacher = teacher;
        this.term = term;
    }

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