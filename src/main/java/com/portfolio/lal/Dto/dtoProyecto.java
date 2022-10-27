package com.portfolio.lal.Dto;

import javax.validation.constraints.NotBlank;


public class dtoProyecto {
    @NotBlank
    private String nombre;
    @NotBlank
    private String enlace;  
    @NotBlank
    private String descripcion;   
    @NotBlank
    private String img;
    
    //constructor

    public dtoProyecto() {
    }

    public dtoProyecto(String nombre, String enlace, String descripcion, String img) {
        this.nombre = nombre;
        this.enlace = enlace;
        this.descripcion = descripcion;
        this.img = img;
    }
    
    //Getters & setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    
}
