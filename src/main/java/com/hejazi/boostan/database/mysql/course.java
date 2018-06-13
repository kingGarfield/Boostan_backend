package com.hejazi.boostan.database.mysql;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class course {
    @Id
    private int id;

    @Column
    private String name;

    @Column
    private String type;

    @Column
    private int value;

    @Column
    private String pishniazCouses;

    public String getPishniazCouses() { return pishniazCouses; }

    public void setPishniazCouses(String pishniazCouses) { this.pishniazCouses = pishniazCouses; }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public int getValue() { return value; }

    public void setValue(int value) { this.value = value; }
}
