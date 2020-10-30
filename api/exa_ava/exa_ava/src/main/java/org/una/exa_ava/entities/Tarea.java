/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.una.exa_ava.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author thony
 */

@Entity
@Table(name = "exa_ava_tareas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Tarea implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 50)
    private String nombre;
    
    @Column
    private boolean estado;
    
    @Column(name = "descripcion", length = 200)
    private String descripcion;
    
    @Column(name = "fecha_inicio", updatable = true)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaInicio;

    @Column(name = "fecha_registro")
    @Setter(AccessLevel.NONE)
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    
    @Column
    private double importancia;
    
    @Column
    private double urgencia;
    
    @Column(name = "procentaje_avance")
    private double procentajeAvance;

    private static final long serialVersionUID = 1L;
    
    @ManyToOne
    @JoinColumn(name = "proyecto_id")
    private Proyecto proyecto;

    @PrePersist
    public void prePersist() {
        estado=true;
        fechaInicio = new Date();
        fechaRegistro = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        fechaRegistro = new Date();
    }
}