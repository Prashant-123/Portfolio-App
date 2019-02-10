package com.prashant.portfolio.Education;

public class CoursesDC {

    String name, type, institution, instructor, status;

    public CoursesDC() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CoursesDC(String name, String type, String institution, String instructor, String status) {
        this.name = name;
        this.type = type;
        this.institution = institution;
        this.instructor = instructor;
        this.status = status;
    }
}
