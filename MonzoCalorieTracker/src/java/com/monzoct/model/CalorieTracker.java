/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monzoct.model;

import java.util.Date;
import com.monzoct.model.Persona;

/**
 *
 * @author M I C I F U S
 */
public class CalorieTracker {
    //VIC
    private Integer codigoTracker;
    private double budget;
    private double totalCal;
    private double ejercicio;
    private double remaining;
    private Date time24h;
    private Persona codigoP;
    
    //CONSTRUCTORES
    public CalorieTracker() {
        codigoTracker = 0;
        budget = 0;
        totalCal = 0;
        ejercicio = 0;
        remaining = 0;
        time24h = new Date();
        codigoP = new Persona();
    }
    
    public CalorieTracker(Integer codigo, double budget, double totalCal, double ejercicio, double remaining, Date datetime, Persona nickPersona) {
        this.codigoTracker = codigo;
        this.budget = budget;
        this.totalCal = totalCal;
        this.ejercicio = ejercicio;
        this.remaining = remaining;
        this.time24h = datetime;
        this.codigoP = nickPersona;
    }
    
    //Getter
    public Integer getCodigoTracker() {
        return codigoTracker;
    }

    public double getBudget() {
        return budget;
    }

    public double getTotalCal() {
        return totalCal;
    }

    public double getEjercicio() {
        return ejercicio;
    }

    public double getRemaining() {
        return remaining;
    }

    public Date getTime24h() {
        return time24h;
    }

    public Persona getCodigoP() {
        return codigoP;
    }
    
    //Setter
    public void setCodigoTracker(Integer codigoTracker) {
        this.codigoTracker = codigoTracker;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public void setTotalCal(double totalCal) {
        this.totalCal = totalCal;
    }

    public void setEjercicio(double ejercicio) {
        this.ejercicio = ejercicio;
    }

    public void setRemaining(double remaining) {
        this.remaining = remaining;
    }

    public void setTime24h(Date time24h) {
        this.time24h = time24h;
    }

    public void setCodigoP(Persona codigoP) {
        this.codigoP = codigoP;
    }
}
