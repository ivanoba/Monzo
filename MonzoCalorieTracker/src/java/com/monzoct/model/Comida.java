/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monzoct.model;

/**
 *
 * @author M I C I F U S
 */
public class Comida {
    //vic
    private Integer codigoComida;
    private String nombreComida;
    private String serving;
    private double servingSize;
    private double calorias;
    private double carbohidratos;
    private double grasas;
    private double proteinas;
    private double sodio;
    private double azucar;
    private CalorieTracker codigoTracker;
    
    
    //Constructores
    public Comida() {
        codigoComida = 0;
        nombreComida = "";
        serving = "";
        servingSize = 0;
        calorias = 0;
        carbohidratos = 0;
        grasas = 0;
        proteinas = 0;
        sodio = 0;
        azucar = 0;
        codigoTracker = new CalorieTracker();
    }
    
    public Comida(Integer codigoComida, String nombreComida, String serving, double servingSize, int calorias, 
    double carbohidratos, double grasas, double proteinas, double sodio, 
    double azucar, CalorieTracker idCalorieTracker) {
        this.codigoComida = codigoComida;
        this.nombreComida = nombreComida;
        this.servingSize = servingSize;
        this.calorias = calorias;
        this.carbohidratos = carbohidratos;
        this.grasas = grasas;
        this.proteinas = proteinas;
        this.sodio = sodio;
        this.azucar = azucar;
        this.codigoTracker = idCalorieTracker;
    }
    
    //Getters
    public Integer getCodigoComida() {
        return codigoComida;
    }
    
    public String getNombreComida() {
        return nombreComida;
    }

    public String getServing() {
        return serving;
    }

    public double getServingSize() {
        return servingSize;
    }

    public double getCalorias() {
        return calorias;
    }

    public double getCarbohidratos() {
        return carbohidratos;
    }

    public double getGrasas() {
        return grasas;
    }

    public double getProteinas() {
        return proteinas;
    }

    public double getSodio() {
        return sodio;
    }

    public double getAzucar() {
        return azucar;
    }

    public CalorieTracker getCodigoTracker() {
        return codigoTracker;
    }
    
    //Setters
    public void setCodigoComida(Integer codigoComida) {
        this.codigoComida = codigoComida;
    }
    
    public void setNombreComida(String nombreComida) {
        this.nombreComida = nombreComida;
    }

    public void setServing(String serving) {
        this.serving = serving;
    }

    public void setServingSize(double servingSize) {
        this.servingSize = servingSize;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    public void setCarbohidratos(double carbohidratos) {
        this.carbohidratos = carbohidratos;
    }

    public void setGrasas(double grasas) {
        this.grasas = grasas;
    }

    public void setProteinas(double proteinas) {
        this.proteinas = proteinas;
    }

    public void setSodio(double sodio) {
        this.sodio = sodio;
    }

    public void setAzucar(double azucar) {
        this.azucar = azucar;
    }

    public void setCodigoTracker(CalorieTracker codigoTracker) {
        this.codigoTracker = codigoTracker;
    }
}
