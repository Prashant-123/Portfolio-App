package com.prashant.portfolio.AboutMe;

public class AboutMeDC {
    public String name;
    public String level;
    public String new_projects;
    public String new_skills;
    public String post;
    public String profile_pic;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getNew_projects() {
        return new_projects;
    }

    public void setNew_projects(String new_projects) {
        this.new_projects = new_projects;
    }

    public String getNew_skills() {
        return new_skills;
    }

    public void setNew_skills(String new_skills) {
        this.new_skills = new_skills;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getProfile_pic() {
        return profile_pic;
    }

    public void setProfile_pic(String profile_pic) {
        this.profile_pic = profile_pic;
    }

    public String getCv_pdf() {
        return cv_pdf;
    }

    public void setCv_pdf(String cv_pdf) {
        this.cv_pdf = cv_pdf;
    }

    public AboutMeDC(String name, String level, String new_projects, String new_skills, String post, String profile_pic, String cv_pdf) {
        this.name = name;
        this.level = level;
        this.new_projects = new_projects;
        this.new_skills = new_skills;
        this.post = post;
        this.profile_pic = profile_pic;
        this.cv_pdf = cv_pdf;
    }

    public String cv_pdf;

    public AboutMeDC() {}
}
