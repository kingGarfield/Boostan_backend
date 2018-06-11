package com.hejazi.boostan.database.mysql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class availableCourses {
    @Id
    private int id;
    @Column
    private int Term;
    @Column
    private int teacherId;
    @Column
    private int courseId;
    @Column
    private int classCapacity;
    @Column
    private String presentedTime;

    public int getId() { return id; }

    public int getTerm() { return Term; }

    public void setTerm(int term) { Term = term; }

    public int getTeacherId() { return teacherId; }

    public void setTeacherId(int teacherId) { this.teacherId = teacherId; }

    public int getCourseId() { return courseId; }

    public void setCourseId(int courseId) { this.courseId = courseId; }

    public int getClassCapacity() { return classCapacity; }

    public void setClassCapacity(int classCapacity) { this.classCapacity = classCapacity; }

    public String getPresentedTime() { return presentedTime; }

    public void setPresentedTime(String presentedTime) { this.presentedTime = presentedTime; }
}
