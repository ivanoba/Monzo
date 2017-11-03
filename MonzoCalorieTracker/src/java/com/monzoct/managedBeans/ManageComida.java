/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monzoct.managedBeans;

import com.monzoct.db.Conexion;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import com.monzoct.model.CalorieTracker;
import com.monzoct.model.Comida;
import java.util.ArrayList;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
/**
 *
 * @author M I C I F U S
 */
@Named(value = "manageComida")
@ManagedBean
@RequestScoped
public class ManageComida {
    private static final String COMIDA_PAGE_REDIRECT = "templates/calorieT/user-profile.xhtml?face-redirect=true";
    public static ArrayList<Comida> listaComida;
    public static ArrayList listaC;
    //public static List<Object> fchead;
    //public static List<Object> fcbody;
    
    private Comida comida;
    private CalorieTracker calT;
    
    public ManageComida() {
        comida = new Comida();
        calT = new CalorieTracker();
    }
    
    public ManageComida(Comida comida, CalorieTracker calT) {
        this.comida = comida;
        this.calT = calT;
    }
    
    public Comida getComida() {
        return comida;
    }
    
    public void setComida(Comida comida) {
        this.comida = comida;
    }
    
    FacesContext context = FacesContext.getCurrentInstance();
    HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    HttpSession sesion = request.getSession(true);
    
    //Metodos

    public String AgregarComida() {
        calT = Conexion.getInstancia().Buscar(CalorieTracker.class, comida.getCodigoTracker());
        Comida c = new Comida(
                null,
                comida.getNombreComida(),
                comida.getServing(),
                comida.getServingSize(),
                (int) comida.getCalorias(),
                comida.getCarbohidratos(),
                comida.getGrasas(),
                comida.getProteinas(),
                comida.getSodio(),
                comida.getAzucar(),
                calT
        );
        Conexion.getInstancia().agregar(c);
        return null;
    }
      
    public void ModificarComida() {
        //MODIFICAR BD
        
    }
    
    //public double AnularComida() {
        //anular de bd
        
   //}
}
