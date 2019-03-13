package com.prashant.portfolio.AboutMe;

public class AboutMeModel {
    public String name;
    public String level;
    public String new_projects;
    public String new_skills;
    public String post;
    public String profile_pic;
    public String cv_pdf;
    public String interests;

    public AboutMeModel(String name, String level, String new_projects, String new_skills, String post, String profile_pic, String cv_pdf, String interests) {
        this.name = name;
        this.level = level;
        this.new_projects = new_projects;
        this.new_skills = new_skills;
        this.post = post;
        this.profile_pic = profile_pic;
        this.cv_pdf = cv_pdf;
        this.interests = interests;
    }

    public AboutMeModel() {}
}
