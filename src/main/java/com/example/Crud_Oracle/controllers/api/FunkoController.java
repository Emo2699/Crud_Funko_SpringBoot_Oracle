package com.example.Crud_Oracle.controllers.api;


import com.example.Crud_Oracle.models.entities.Funko;
import com.example.Crud_Oracle.services.IFunko;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class FunkoController {

    @Autowired
    private IFunko funkoService;


    @GetMapping("listar")
    public ResponseEntity<Map<String,Object>> listaFunkos(){
        try{
            List<Funko> query = this.funkoService.findFunkos();
            Map<String,Object> json = new HashMap<>();

            json.put("data",query);
            json.put("status", HttpStatus.OK);

            return new ResponseEntity<>(json,HttpStatus.OK);
        }catch(Exception e){
            Map<String,Object> json = new HashMap<>();

            json.put("message","Error al obtener los funkos");
            json.put("status", HttpStatus.INTERNAL_SERVER_ERROR);

            return new ResponseEntity<>(json,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("producto")
    public ResponseEntity<Map<String,Object>> buscarFunko(@RequestBody String id){
        try{
            Optional<Funko> query = this.funkoService.buscarID(id);
            Map<String,Object> json = new HashMap<>();

            if(query.isEmpty()){
                //No se encontro registros...
                json.put("message","No se encontro un funko con ese id");
                json.put("status",HttpStatus.BAD_REQUEST);

                return new ResponseEntity<>(json,HttpStatus.BAD_REQUEST);
            }else{
                json.put("data",query);
                json.put("status",HttpStatus.OK);

                return new ResponseEntity<>(json,HttpStatus.OK);
            }

        }catch(Exception e){
            Map<String,Object> json = new HashMap<>();

            json.put("message","Error con el servidor...");
            json.put("status",HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(json,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("crear")
    public ResponseEntity<Map<String,Object>> agregar(@RequestBody Funko funko){
        try{
            Map<String,Object> json = new HashMap<>();

            int resultado = this.funkoService.crearFunko(funko);
            if(resultado == 1){
                json.put("message","Funko agregado correctamente...");
                json.put("status",HttpStatus.OK);

                return new ResponseEntity<>(json,HttpStatus.OK);
            }
            else if(resultado == 0){
                json.put("message","Ya existe un registro de ese producto....");
                json.put("status",HttpStatus.BAD_REQUEST);
                return new ResponseEntity<>(json,HttpStatus.BAD_REQUEST);
            }

            json.put("message","Error en el servidor....");
            json.put("status",HttpStatus.INTERNAL_SERVER_ERROR);

            return new ResponseEntity<>(json,HttpStatus.INTERNAL_SERVER_ERROR);

        }catch(Exception e){
            Map<String,Object> json = new HashMap<>();

            json.put("message","Error en el servidor....");
            json.put("status",HttpStatus.INTERNAL_SERVER_ERROR);

            return new ResponseEntity<>(json,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("actualizar")
    public ResponseEntity<Map<String,Object>> actualizar1(@RequestBody Funko funko){
        try{
            boolean resultado = this.funkoService.actualizarFunko(funko);
            Map<String,Object> json = new HashMap<>();
            if(resultado){
                json.put("message","Producto actualizado correctamente....");
                json.put("status",HttpStatus.OK);
                return new ResponseEntity<>(json,HttpStatus.OK);
            }else{
                json.put("message","Error al actualizar....");
                json.put("status",HttpStatus.BAD_REQUEST);
                return new ResponseEntity<>(json,HttpStatus.BAD_REQUEST);
            }



        }catch(Exception e){
            Map<String,Object> json = new HashMap<>();

            json.put("message","Error en el servidor....");
            json.put("status",HttpStatus.INTERNAL_SERVER_ERROR);

            return new ResponseEntity<>(json,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("eliminar")
    public ResponseEntity<Map<String,Object>> eliminarFunko(@RequestBody String id){
        try{
            boolean resultado = this.funkoService.eliminarById(id);
            Map<String,Object> json = new HashMap<>();
            if(resultado){
                json.put("message","Funko eliminado correctamente....");
                json.put("status",HttpStatus.OK);
                return new ResponseEntity<>(json,HttpStatus.OK);
            }else{
                json.put("message","Error al eliminar....");
                json.put("status",HttpStatus.BAD_REQUEST);

                return new ResponseEntity<>(json,HttpStatus.BAD_REQUEST);
            }

        }catch(Exception e){
            Map<String,Object> json = new HashMap<>();

            json.put("message","Error en el servidor....");
            json.put("status",HttpStatus.INTERNAL_SERVER_ERROR);

            return new ResponseEntity<>(json,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
