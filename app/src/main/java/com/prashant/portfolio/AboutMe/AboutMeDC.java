package com.prashant.portfolio.AboutMe;

public class AboutMeDC {
    public String name, level, new_projects, new_skills, post, profile_pic;

    public AboutMeDC() {}

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setNew_projects(String new_projects) {
        this.new_projects = new_projects;
    }

    public void setNew_skills(String new_skills) {
        this.new_skills = new_skills;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public void setProfile_pic(String profile_pic) {
        this.profile_pic = profile_pic;
    }

    public String getName() {
        return name;
    }

    public String getLevel() {
        return level;
    }

    public String getNew_projects() {
        return new_projects;
    }

    public String getNew_skills() {
        return new_skills;
    }

    public String getPost() {
        return post;
    }

    public String getProfile_pic() {
        return profile_pic;
    }

    public AboutMeDC(String name, String level, String new_projects, String new_skills, String post, String profile_pic) {
        this.name = name;
        this.level = level;
        this.new_projects = new_projects;
        this.new_skills = new_skills;
        this.post = post;
        this.profile_pic = profile_pic;
    }
}
