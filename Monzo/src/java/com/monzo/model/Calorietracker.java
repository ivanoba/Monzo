package com.monzo.model;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Calorietracker  implements java.io.Serializable {


     private Integer codigoTracker;
     private Persona persona;
     private double budget;
     private double totalCal;
     private double ejercicio;
     private double remaining;
     private Date time24h;
     private Set comidas = new HashSet(0);

    public Calorietracker() {
    }

    public Calorietracker(Integer codigoTracker, Persona persona, double budget, double totalCal, double ejercicio, double remaining, Date time24h) {
        this.codigoTracker = codigoTracker;
        this.persona = persona;
        this.budget = budget;
        this.totalCal = totalCal;
        this.ejercicio = ejercicio;
        this.remaining = remaining;
        this.time24h = time24h;
    }


   
    public Integer getCodigoTracker() {
        return this.codigoTracker;
    }
    
    public void setCodigoTracker(Integer codigoTracker) {
        this.codigoTracker = codigoTracker;
    }
    public Persona getPersona() {
        return this.persona;
    }
    
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public double getBudget() {
        return this.budget;
    }
    
    public void setBudget(double budget) {
        this.budget = budget;
    }
    public double getTotalCal() {
        return this.totalCal;
    }
    
    public void setTotalCal(double totalCal) {
        this.totalCal = totalCal;
    }
    public double getEjercicio() {
        return this.ejercicio;
    }
    
    public void setEjercicio(double ejercicio) {
        this.ejercicio = ejercicio;
    }
    public double getRemaining() {
        return this.remaining;
    }
    
    public void setRemaining(double remaining) {
        this.remaining = remaining;
    }
    public Date getTime24h() {
        return this.time24h;
    }
    
    public void setTime24h(Date time24h) {
        this.time24h = time24h;
    }
    public Set getComidas() {
        return this.comidas;
    }
    
    public void setComidas(Set comidas) {
        this.comidas = comidas;
    }
}


