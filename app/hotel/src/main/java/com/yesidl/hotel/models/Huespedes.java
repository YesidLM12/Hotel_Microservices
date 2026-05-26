package com.yesidl.hotel.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import java.util.List;

import com.yesidl.hotel.common.Enums.Genero;

@Entity
@Table(name = "huespedes")
public class Huespedes {

    @Id
    @Column(name = "documento", nullable = false)
    private String documento;
    
    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @Column(name = "apellido", nullable = false)
    private String apellido;
    
    @Column(name = "edad", nullable = false)
    private int edad;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "genero", nullable = false)
    private Genero genero;

    @OneToMany(mappedBy = "huesped", cascade = CascadeType.ALL)
    private List<Reservas> reservas;

  
}
