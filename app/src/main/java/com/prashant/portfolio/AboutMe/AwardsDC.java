package com.prashant.portfolio.AboutMe;

public class AwardsDC {
    String heading, event_name, description, image;

    public AwardsDC(){}

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public AwardsDC(String heading, String event_name, String description, String image) {
        this.heading = heading;
        this.event_name = event_name;
        this.description = description;
        this.image = image;
    }
}
