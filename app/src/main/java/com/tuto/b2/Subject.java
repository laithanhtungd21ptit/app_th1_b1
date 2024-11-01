package com.tuto.b2;

public class Subject {
    private String name;
    private int credits;
    private String year;
    private String instructor;
    private float score;

    public Subject(String name, int credits, String year, String instructor, float score) {
        this.name = name;
        this.credits = credits;
        this.year = year;
        this.instructor = instructor;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public String getYear() {
        return year;
    }

    public String getInstructor() {
        return instructor;
    }

    public float getScore() {
        return score;
    }
}
