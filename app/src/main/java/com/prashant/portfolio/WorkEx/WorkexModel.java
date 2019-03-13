package com.prashant.portfolio.WorkEx;

import java.util.ArrayList;

public class WorkexModel {
    String heading, image;
    public ArrayList<String> roles = new ArrayList<>();


    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ArrayList<String> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<String> roles) {
        this.roles = roles;
    }

    public WorkexModel(String heading, String image, ArrayList<String> roles) {
        this.heading = heading;
        this.image = image;
        this.roles = roles;
    }

    public WorkexModel() { }
}
