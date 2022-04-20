package com.peliculas.controlador;

import com.peliculas.modelo.PeliculaDTO;
import com.peliculas.modelo.PeliculaResponse;
import com.peliculas.servicios.PelisServicioImpl;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController   //@RestController there is no need to do explicit json conversion.
                    // Just return a POJO and jackson serializer will take care of converting to json.
                    // It is equivalent to using @ResponseBody when used with @Controller.
                    // Rather than placing @ResponseBody on every controller method we place @RestController instead of vanilla @Controller and @ResponseBody by default is applied on all resources in that controller.
@Validated        //https://www.yawintutor.com/how-to-validate-request-body-in-spring-boot/
@RequestMapping("/peliculas")
public class PelisController {

    @Autowired

    private PelisServicioImpl pelisServicioImpl;

    @Operation(summary = "Ver peliculas", description = "Sin parametros muestra un listado de todas las peliculas de la base de datos, o busca por titulo, " +
            "id, o un texto determinado en cualquier campo de la pelicula ", method = "GET")
    @GetMapping(value="/listar")
    public ResponseEntity<List<PeliculaResponse>> listarPeliculas(){
       List<PeliculaResponse> peliculas = pelisServicioImpl.listarPeliculas();
        return new ResponseEntity<List<PeliculaResponse>>(peliculas, HttpStatus.OK);
    }

    @GetMapping(value="/buscarPorId/{id}")
    public ResponseEntity<PeliculaResponse> consultarPorId(@PathVariable("id") int id){
        PeliculaResponse peliculaResponse = pelisServicioImpl.listarPeliculaPorId(id);
        return new ResponseEntity<PeliculaResponse>(peliculaResponse, HttpStatus.OK);
    }

    @Operation(summary = "Insertar película", description = "Inserta una pelicula en la base de datos", method = "POST")
    @PostMapping(value="/insertar")
    public ResponseEntity<PeliculaResponse> insertarPelicula (@Valid @RequestBody PeliculaDTO peliculaDTOInsertar){
        PeliculaResponse peliculaResponse= pelisServicioImpl.addPelicula(peliculaDTOInsertar);
        return ResponseEntity.ok(peliculaResponse);
    }

    @GetMapping(value="/buscarPorTitulo/{titulo}")
    public ResponseEntity<List<PeliculaResponse>> consultarPorNombre(@PathVariable("titulo") String titulo){
        List<PeliculaResponse> peliculas = pelisServicioImpl.findPeliculaByName(titulo);
        return new ResponseEntity<List<PeliculaResponse>>(peliculas, HttpStatus.OK);
    }

    @GetMapping(value="/buscarPorTexto/{texto}")
    public ResponseEntity<List<PeliculaResponse>> consultarPorTexto(@PathVariable("texto") String texto){
        List<PeliculaResponse> peliculas = pelisServicioImpl.findPeliculaByTexto(texto);
        return new ResponseEntity<List<PeliculaResponse>>(peliculas, HttpStatus.OK);
    }

}




