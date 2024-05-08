package com.example.Crud_Oracle.services.impl;

import com.example.Crud_Oracle.models.dao.FunkoDAO;
import com.example.Crud_Oracle.models.dto.FunkoDTO;
import com.example.Crud_Oracle.models.entities.Funko;
import com.example.Crud_Oracle.services.IFunko;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FunkoService implements IFunko {

    /*Inyectamos el DAO*/
    @Autowired
    private FunkoDAO repository;

    @Transactional
    @Override
    public List<Funko> findFunkos() {
        return (List<Funko>) repository.findAll();
    }

    @Transactional
    @Override
    public Optional<Funko> buscarID(String id) {
        return this.repository.findById(id);
    }



    /*crearFunko()
    * return -1 Si hubo un error
    * return 0 si hay un duplicado
    * return 1 Si se agrego correctamente
    *
    * */
    @Transactional
    @Override
    public int crearFunko(Funko funko) {
        try{
            //Antes de agregar debo de saber si no existe en la BD
            Optional<Funko> query = buscarID(funko.getId_funko());

            if(query.isEmpty()){
                //Debo de agregar
                this.repository.save(funko);
                return 1;

            }else{
                //Ya existe un registro con ese ID
                return 0;
            }
        }catch (Exception e){
            //Si ocurrio un error devuelvo -1
            return -1;
        }
    }

    @Transactional
    @Override
    public boolean eliminarById(String id) {
        Optional<Funko> query = buscarID(id);

        if(query.isEmpty()){
            return false;
        }else{
            this.repository.deleteById(id);
            return true;
        }
    }

    @Transactional
    @Override
    public boolean actualizarFunko(String id, FunkoDTO funko) {
        //Reviso que exista en la base de datos un registro con el parametro id

        Optional<Funko> query = buscarID(id);

        if(query.isEmpty()){
            return false;
        }else{
            //Obtengo la referencia del objeto encontrado
            Funko actualizado = query.get();

            //Comienzo a actualizar sus datos
            actualizado.setNombre(funko.getNombre());
            actualizado.setNumero(funko.getNumero());
            actualizado.setSerie(funko.getSerie());

            //Guardo los cambios
            this.repository.save(actualizado);
            return true;
        }


    }

    @Override
    public boolean actualizarFunko(Funko funko) {
        //Reviso que exista en la base de datos un registro con el atributo id del funko

        Optional<Funko> query = buscarID(funko.getId_funko());
        if(query.isEmpty()){
            return false;
        }else{
            //Obtengo la referencia del objeto encontrado
            Funko actualizado = query.get();

            //Comienzo a actualizar sus datos
            actualizado.setNombre(funko.getNombre());
            actualizado.setNumero(funko.getNumero());
            actualizado.setSerie(funko.getSerie());

            //Guardo los cambios
            this.repository.save(actualizado);
            return true;
        }
    }
}
