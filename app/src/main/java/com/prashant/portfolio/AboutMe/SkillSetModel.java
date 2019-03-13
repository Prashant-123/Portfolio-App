package com.prashant.portfolio.AboutMe;

public class SkillSetModel {

    public SkillSetModel() {}
    String skill, image;

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public SkillSetModel(String skill, String image) {
        this.skill = skill;
        this.image = image;
    }
}
