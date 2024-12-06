package com.example.petcase.Domain;

public class HealthRecord {

    private String healthRecordId;
    private String petId;          // ID thú cưng liên quan
    private String date;
    private String description;
    private String vaccine;

    private String time;
    private String newdescription;
    private String qualify;


    public HealthRecord(String healthRecordId, String petId, String date, String description, String vaccine) {
    }

    public HealthRecord(String healthRecordId, String petId, String date, String description, String vaccine, String time, String newdescription, String qualify) {
        this.healthRecordId = healthRecordId;
        this.petId = petId;
        this.date = date;
        this.description = description;
        this.vaccine = vaccine;
        this.time = time;
        this.newdescription = newdescription;
        this.qualify = qualify;
    }

    public String getHealthRecordId() {
        return healthRecordId;
    }

    public void setHealthRecordId(String healthRecordId) {
        this.healthRecordId = healthRecordId;
    }

    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        this.petId = petId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVaccine() {
        return vaccine;
    }

    public void setVaccine(String vaccine) {
        this.vaccine = vaccine;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNewdescription() {
        return newdescription;
    }

    public void setNewdescription(String newdescription) {
        this.newdescription = newdescription;
    }

    public String getQualify() {
        return qualify;
    }

    public void setQualify(String qualify) {
        this.qualify = qualify;
    }
}


