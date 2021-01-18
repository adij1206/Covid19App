package com.example.covidstatus.Model;

public class StateData {
    public String region,totalInfected,newInfected,recovered,newRecovered,deceased,newDeceased;

    public StateData(String region, String totalInfected, String newInfected, String recovered, String newRecovered, String deceased, String newDeceased) {
        this.region = region;
        this.totalInfected = totalInfected;
        this.newInfected = newInfected;
        this.recovered = recovered;
        this.newRecovered = newRecovered;
        this.deceased = deceased;
        this.newDeceased = newDeceased;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getTotalInfected() {
        return totalInfected;
    }

    public void setTotalInfected(String totalInfected) {
        this.totalInfected = totalInfected;
    }

    public String getNewInfected() {
        return newInfected;
    }

    public void setNewInfected(String newInfected) {
        this.newInfected = newInfected;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getNewRecovered() {
        return newRecovered;
    }

    public void setNewRecovered(String newRecovered) {
        this.newRecovered = newRecovered;
    }

    public String getDeceased() {
        return deceased;
    }

    public void setDeceased(String deceased) {
        this.deceased = deceased;
    }

    public String getNewDeceased() {
        return newDeceased;
    }

    public void setNewDeceased(String newDeceased) {
        this.newDeceased = newDeceased;
    }
}
