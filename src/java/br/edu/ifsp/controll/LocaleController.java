/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.controll;

import java.io.Serializable;
import java.util.Locale;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author aluno
 */
@Named
@SessionScoped
public class LocaleController implements Serializable{
    
    public void setLocalenUS(){
        FacesContext
                .getCurrentInstance()
                .getViewRoot()
                .setLocale(Locale.US);
    }
    
    public void setLocalptBR(){
        FacesContext
                .getCurrentInstance()
                .getViewRoot()
                .setLocale(new Locale("pt", "BR"));
    }
    
}
