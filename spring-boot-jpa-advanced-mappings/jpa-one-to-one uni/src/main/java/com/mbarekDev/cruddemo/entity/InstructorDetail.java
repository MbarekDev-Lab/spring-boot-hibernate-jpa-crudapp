package com.mbarekDev.cruddemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class InstructorDetail {

    // annotate the class as an entity and map to db table

    // define the feilds

    //annotate the feilds with db column name

    // create constructors

    // generated getter / setter methods

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private int id;

    @Column(name = "youtube_channel")
    private String myWork;

    @Column(name = "hobby")
    private String hobby;

    public InstructorDetail( String myWork, String hobby) {
        this.myWork = myWork;
        this.hobby = hobby;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMyWork() {
        return myWork;
    }

    public void setMyWork(String myWork) {
        this.myWork = myWork;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "InstructorDetail{" +
                "id=" + id +
                ", myWork='" + myWork + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
