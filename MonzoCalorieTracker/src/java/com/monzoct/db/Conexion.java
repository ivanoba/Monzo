/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monzoct.db;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.stat.Statistics;

import com.monzoct.model.*;
import javax.inject.Named;
/**
 *
 * @author M I C I F U S
 */

@Named(value = "conexion")
public class Conexion {
    private SessionFactory session;
    private static Conexion instancia = null;
    private static Statistics estadisticas;
    
    public void setInstancia() {
        this.instancia = null;
    }
    
    public Conexion() {
        try {
            session = new Configuration().configure().buildSessionFactory();
            estadisticas = session.getStatistics();
            estadisticas.setStatisticsEnabled(true);
            System.out.println("Configuracion finalizada");
        } catch(Throwable ex) {
            System.out.println("Mensaje de ERROR");
            ex.getMessage();
            System.out.println("Traza de error");
            ex.printStackTrace();
            System.out.println("Error al establecer conexion con motor de base de datos");            
        }
    }
    
    //cerrar la sesion
    public void closeSession() throws HibernateException {
        try {
            if(session.isClosed() == false | session.getCurrentSession().isOpen()) {
                session.close();
                session.getCurrentSession().close();
            }
        } catch(HibernateException ex) {
            throw new HibernateException(ex);
        }
    }
    
    public Statistics getEstadisticas() {
        return this.estadisticas;
    }
    
    public synchronized static Conexion getInstancia() {
        if(instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }
    
    public Session getSession() {
        return session.getCurrentSession();
    }
    
    public void setSession(SessionFactory session) {
        this.session = session;
    }
    
    @SuppressWarnings("unchecked")
    public List<Object> hacerConsulta(String consulta) {
        Session session = this.getSession();
        List<Object> listado = null;
        session.beginTransaction();
        listado = session.createQuery(consulta).list();
        session.getTransaction().commit();
        return listado;
    }
    /*
    @SuppressWarnings("unchecked")
    public List<Persona> getPersona() {
        Session session = this.getSession();
        List<Persona> listado;
        session.beginTransaction();
        listado = session.createQuery("From Persona").list();
        session.getTransaction().commit();
        return listado;
    }
    
    @SuppressWarnings("unchecked")
    public List<Comida> getComida() {
        Session session = this.getSession();
        List<Comida> listado;
        session.beginTransaction();
        listado = session.createQuery("From Comida").list();
        session.getTransaction().commit();
        return listado;
    }
    
    @SuppressWarnings("unchecked")
    public List<CalorieTracker> getCalorieTracker() {
        Session session = this.getSession();
        List<CalorieTracker> listado;
        session.beginTransaction();
        listado = session.createQuery("From calorieTracker").list();
        session.getTransaction().commit();
        return listado;
    }*/
    
    public void modificar(Object obj) {
        Session session = this.getSession();
        session.beginTransaction();
        session.merge(obj);
        session.getTransaction().commit();
    }
    
    public void agregar(Object obj) {
        Session session = this.getSession();
        session.beginTransaction();
        session.save(obj);
        session.getTransaction().commit();
    }
    
    public Object Buscar(Class<?> classX, int ID) {
		Session session = this.getSession();
		session.beginTransaction();
		Object objeto=session.get(classX, ID);
		session.getTransaction().commit();
		return objeto;
	}

	public Object Buscar(Class<?> classX, String ID) {
		Session session = this.getSession();
		session.beginTransaction();
		Object objeto=session.get(classX, ID);
		session.getTransaction().commit();
		return objeto;
	}
    
    public void eliminar(Object obj) {
        Session session = getSession();
        session.beginTransaction();
        session.delete(obj);
        session.getTransaction().commit();
    }
    
    public Persona autenticarPersona(String usuario, String password) {
        Persona usr = new Persona();
        Session sesion = this.getSession();
        sesion.beginTransaction();
        
        try {
            usr = (Persona)hacerConsulta("From Persona u WHERE u.nombre='" + usuario + "' OR u.nick='" + usuario + "' AND u.contrasena='" + password + "'").get(0);
            if(password.equals(usr.getPassword())) {
                
            } else {
                usr.setNick("n");
            }
        } catch(IndexOutOfBoundsException aiobs) {
            
        }
        return usr;
        /*
        List<Object> lista = null;
        Persona user;
        user = null;
        lista = this.hacerConsulta("From Persona u WHERE u.nombre='" + usuario + "' OR u.nick='" + usuario + "' AND u.contrasena='" + password + "'");
        if(!lista.isEmpty()) {
            user = (Persona)lista.get(0);
        }
        return user;*/
    }

    public CalorieTracker Buscar(Class<CalorieTracker> aClass, CalorieTracker idCalorieTracker) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
