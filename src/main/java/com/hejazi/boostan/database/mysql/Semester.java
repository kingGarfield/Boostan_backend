package com.hejazi.boostan.database.mysql;



import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Semester {

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

    public int getMark() {
        return mark;
    }

    @EmbeddedId
    private key primaryKey;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private int mark;
}

@Embeddable
class key implements Serializable{
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

    @Column
    private int course;

    @Column
    private int student;

    @Column
    private int teacher;

    @Column(nullable = false)
    private int term;
}