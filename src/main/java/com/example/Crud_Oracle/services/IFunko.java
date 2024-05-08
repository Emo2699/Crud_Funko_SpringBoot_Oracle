package com.example.Crud_Oracle.services;

import com.example.Crud_Oracle.models.dto.FunkoDTO;
import com.example.Crud_Oracle.models.entities.Funko;

import java.util.List;
import java.util.Optional;

public interface IFunko {
    List<Funko> findFunkos();

    Optional<Funko> buscarID(String id);
    int crearFunko(Funko funko);

    boolean eliminarById(String id);

    boolean actualizarFunko(String id, FunkoDTO funko);
    boolean actualizarFunko(Funko funko);


}
