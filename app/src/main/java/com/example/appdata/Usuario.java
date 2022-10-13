package com.example.appdata;

import android.widget.EditText;

import java.io.Serializable;

public class Usuario implements Serializable {

    public String nombrePersona;
    public String apellidoPersona;
    public int edadPersona;
    public double estaturaPersona;
    public double pesoPersona;
    public double dineroPersona;

    public Usuario(String nombrePersona,String apellidoPersona,int edadPersona,double estaturaPersona,double pesoPersona,double dineroPersona){
        this.nombrePersona = nombrePersona;
        this.apellidoPersona = apellidoPersona;
        this.edadPersona = edadPersona;
        this.estaturaPersona = estaturaPersona;
        this.pesoPersona = pesoPersona;
        this.dineroPersona = dineroPersona;
    }

    public Usuario(){

    }
    public String getnombrePersona() {return nombrePersona;}
    public void setnombrePersona( String nombrePersona) {this.nombrePersona = nombrePersona;}

    public String getapellidoPersona() {return apellidoPersona;}
    public void setapellidoPersona( String apellidoPersona) {this.apellidoPersona = apellidoPersona;}

    public int getedadPersona() {return edadPersona;}
    public void setedadPersona( int edadPersona) {this.edadPersona = edadPersona;}

    public double getestaturaPersona() {return estaturaPersona;}
    public void setestaturaPersona( double estaturaPersona) {this.estaturaPersona = estaturaPersona;}

    public double getpesoPersona() {return pesoPersona;}
    public void setpesoPersona( int pesoPersona) {this.edadPersona = pesoPersona;}

    public double getdineroPersona() {return dineroPersona;}
    public void setdineroPersona( double dineroPersona) {this.dineroPersona = dineroPersona;}

}
