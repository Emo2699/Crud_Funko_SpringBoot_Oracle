package com.example.Crud_Oracle.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FunkoDTO implements Serializable {
    private String id_funko;
    private String nombre;
    private String numero;
    private String serie;
}
