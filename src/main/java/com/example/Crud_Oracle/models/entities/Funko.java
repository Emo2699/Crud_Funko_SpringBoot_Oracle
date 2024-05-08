package com.example.Crud_Oracle.models.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="FUNKO")
public class Funko implements Serializable {

    @Id
    @Column(name="ID_FUNKO")
    private String id_funko;

    @Column(name="NOMBRE")
    private String nombre;

    @Column(name="NUMERO")
    private String numero;

    @Column(name="SERIE")
    private String serie;

    /*public boolean isEmpty(){
        if(this.id_funko == null || this.id_funko.isBlank()){
            return true;
        }
        if(this.nombre == null || this.nombre.isBlank()){
            return true;
        }
        if(this.numero == null || this.numero.isBlank()){
            return true;
        }
        if(this.serie == null || this.serie.isBlank()){
            return true;
        }
        return false;
    }
*/
}
