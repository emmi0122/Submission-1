package se.yrgo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

public class Student {
    private String enrollmentID;
    private String name;
    private String tutorName; // This will become a class soon

    public Student() {

    }

    public Student(String name, String tutorName)  {
    	this.name = name;
    	this.tutorName = tutorName;
    }


    public Student(String name)  {
    	this.name = name;
    	this.tutorName = null;
    }

    @Id
    private int id;

    public String toString() {
      return "name:" + name + " tutor name : " + tutorName;
   }

    public String getId() {
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }
}
