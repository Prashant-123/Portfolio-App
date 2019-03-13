package com.prashant.portfolio.Education;

public class CoursesModel {

    String name, image, institution, instructor;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public CoursesModel(String name, String image, String institution, String instructor) {
        this.name = name;
        this.image = image;
        this.institution = institution;
        this.instructor = instructor;
    }

    public CoursesModel() {}
}
