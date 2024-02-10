package com.Aptcoder.Assignment.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.beans.ConstructorProperties;

@Entity
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String subject;
    private int chapters;
    private int numberOfClasses;
    private String type; // Personalised, Group
    private String learnMode; // Assisted, Self-learning

//    public Course() {
//    }
//
//    public Course(String name, String subject, int chapters,int numberOfClasses,  String type,String learnMode) {
//        this.name = name;
//        this.subject = subject;
//        this.chapters = chapters;
//        this.numberOfClasses = numberOfClasses;
//        this.type = type;
//        this.learnMode = learnMode;
//    }
//
//    // Getters and Setters
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getSubject() {
//        return subject;
//    }
//
//    public void setSubject(String subject) {
//        this.subject = subject;
//    }
//
//    public int getChapters() {
//        return chapters;
//    }
//
//    public void setChapters(int chapters) {
//        this.chapters = chapters;
//    }
//
//    public int getNumberOfClasses() {
//        return numberOfClasses;
//    }
//
//    public void setNumberOfClasses(int numberOfClasses) {
//        this.numberOfClasses = numberOfClasses;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//
//    public String getLearnMode() {
//        return learnMode;
//    }
//
//    public void setLearnMode(String learnMode) {
//        this.learnMode = learnMode;
//    }
}
