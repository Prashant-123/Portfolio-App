package com.prashant.portfolio.Education;

public class HigherStudiesDC {

    public HigherStudiesDC(String institute_name, String course, String post, String yop, String about, String image) {
        this.institute_name = institute_name;
        this.course = course;
        this.post = post;
        this.yop = yop;
        this.performance = about;
        this.image = image;
    }

    public HigherStudiesDC() {}

    String institute_name;
    String course;
    String post;
    String yop;
    String performance;
    String image;

    public String getInstitute_name() {
        return institute_name;
    }

    public void setInstitute_name(String institute_name) {
        this.institute_name = institute_name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getYop() {
        return yop;
    }

    public void setYop(String yop) {
        this.yop = yop;
    }

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
