package com.prashant.portfolio.Projects;

public class ProjectsModel {
    String name, duration, image, tech_stack, description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTech_stack() {
        return tech_stack;
    }

    public void setTech_stack(String tech_stack) {
        this.tech_stack = tech_stack;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProjectsModel(String name, String duration, String image, String tech_stack, String description) {
        this.name = name;
        this.duration = duration;
        this.image = image;
        this.tech_stack = tech_stack;
        this.description = description;
    }

    public ProjectsModel(){}
}
