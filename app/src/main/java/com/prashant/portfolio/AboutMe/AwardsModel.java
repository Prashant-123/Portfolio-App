package com.prashant.portfolio.AboutMe;

public class AwardsModel {
    String certificate;
    String event_name;
    String description;
    String image;
    String sub_heading;


    public AwardsModel(String certificate, String event_name, String description, String image, String sub_heading) {
        this.certificate = certificate;
        this.event_name = event_name;
        this.description = description;
        this.image = image;
        this.sub_heading = sub_heading;
    }


    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
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

    public String getSub_heading() {
        return sub_heading;
    }

    public void setSub_heading(String sub_heading) {
        this.sub_heading = sub_heading;
    }

    public AwardsModel(){}

}
