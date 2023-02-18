package com.example.pm2e177.transacciones;

public class Contactos {

    private Integer id;
    private String nombres;
    private Integer telefono;
    private String nota;

    public Contactos(Integer id, String nombres, Integer telefono, String nota) {
        this.id = id;
        this.nombres = nombres;
        this.telefono = telefono;
        this.nota = nota;


    }

    public Contactos(){}


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }


}
