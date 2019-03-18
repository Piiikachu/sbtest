package com.example.adidas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int ID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLisence() {
        return lisence;
    }

    public void setLisence(String lisence) {
        this.lisence = lisence;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public double getHC() {
        return HC;
    }

    public void setHC(double HC) {
        this.HC = HC;
    }

    public double getNOx() {
        return NOx;
    }

    public void setNOx(double NOx) {
        this.NOx = NOx;
    }

    public double getPM() {
        return PM;
    }

    public void setPM(double PM) {
        this.PM = PM;
    }

    String lisence;
    Date datetime;
    double HC;
    double NOx;
    double PM;

}