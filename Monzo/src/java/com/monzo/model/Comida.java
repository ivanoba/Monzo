package com.monzo.model;

public class Comida  implements java.io.Serializable {


     private Integer codigoComida;
     private Calorietracker calorietracker;
     private String nombre;
     private String serving;
     private double servingSize;
     private double calorias;
     private double carbohidratos;
     private double proteinas;
     private double grasas;
     private double sodio;
     private double azucar;

    public Comida() {
    }

    public Comida(Integer codigoComida, Calorietracker calorietracker, String nombre, String serving, double servingSize, double calorias, double carbohidratos, double proteinas, double grasas, double sodio, double azucar) {
       this.codigoComida = codigoComida;
       this.calorietracker = calorietracker;
       this.nombre = nombre;
       this.serving = serving;
       this.servingSize = servingSize;
       this.calorias = calorias;
       this.carbohidratos = carbohidratos;
       this.proteinas = proteinas;
       this.grasas = grasas;
       this.sodio = sodio;
       this.azucar = azucar;
    }
   
    public Integer getCodigoComida() {
        return this.codigoComida;
    }
    
    public void setCodigoComida(Integer codigoComida) {
        this.codigoComida = codigoComida;
    }
    public Calorietracker getCalorietracker() {
        return this.calorietracker;
    }
    
    public void setCalorietracker(Calorietracker calorietracker) {
        this.calorietracker = calorietracker;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getServing() {
        return this.serving;
    }
    
    public void setServing(String serving) {
        this.serving = serving;
    }
    public double getServingSize() {
        return this.servingSize;
    }
    
    public void setServingSize(double servingSize) {
        this.servingSize = servingSize;
    }
    public double getCalorias() {
        return this.calorias;
    }
    
    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }
    public double getCarbohidratos() {
        return this.carbohidratos;
    }
    
    public void setCarbohidratos(double carbohidratos) {
        this.carbohidratos = carbohidratos;
    }
    public double getProteinas() {
        return this.proteinas;
    }
    
    public void setProteinas(double proteinas) {
        this.proteinas = proteinas;
    }
    public double getGrasas() {
        return this.grasas;
    }
    
    public void setGrasas(double grasas) {
        this.grasas = grasas;
    }
    public double getSodio() {
        return this.sodio;
    }
    
    public void setSodio(double sodio) {
        this.sodio = sodio;
    }
    public double getAzucar() {
        return this.azucar;
    }
    
    public void setAzucar(double azucar) {
        this.azucar = azucar;
    }
}


