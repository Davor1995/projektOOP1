package com.example;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Vehicle {
    private final SimpleStringProperty hersteller;
    private final SimpleStringProperty modell;
    private final SimpleIntegerProperty leistung;
    
    public Vehicle(String hersteller, String modell, int leistung) {
        this.hersteller = new SimpleStringProperty(hersteller);
        this.modell = new SimpleStringProperty(modell);
        this.leistung = new SimpleIntegerProperty(leistung);
    }

    public String getHersteller() {
        return hersteller.get();
    }

    public void setHersteller(String hersteller) {
        this.hersteller.set(hersteller);
    }

    public SimpleStringProperty herstellerProperty() {
        return hersteller;
    }

    public String getModell() {
        return modell.get();
    }

    public void setModell(String modell) {
        this.modell.set(modell);
    }

    public SimpleStringProperty modellProperty(){
        return modell;
    }

    public int getLeistung() {
        return leistung.get();
    }

    public void setLeistung(int leistung) {
        this.leistung.set(leistung);
    }

    public SimpleIntegerProperty leistungProperty(){
        return leistung;
    }
}
