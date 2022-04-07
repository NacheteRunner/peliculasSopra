package com.scaffolding.scaffolding.controlador;

import com.scaffolding.scaffolding.modelo.PeliculaDTO;
import com.scaffolding.scaffolding.modelo.PeliculaEntity;
import com.scaffolding.scaffolding.modelo.PeliculaResponse;
import com.scaffolding.scaffolding.servicios.PelisServicioImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController   //@RestController there is no need to do explicit json conversion.
                    // Just return a POJO and jackson serializer will take care of converting to json.
                    // It is equivalent to using @ResponseBody when used with @Controller.
                    // Rather than placing @ResponseBody on every controller method we place @RestController instead of vanilla @Controller and @ResponseBody by default is applied on all resources in that controller.
@RequestMapping("/")
public class PelisController {

    @Autowired

    private PelisServicioImpl pelisServicioImpl;

    @GetMapping(value="listarPeliculas")
    public ResponseEntity<List<PeliculaResponse>> listarPeliculas(){
       List<PeliculaResponse> peliculas = pelisServicioImpl.listarPeliculas();
        return new ResponseEntity<List<PeliculaResponse>>(peliculas, HttpStatus.OK);
    }

    @RequestMapping(value="listarPeliculas",params = "id", method= RequestMethod.GET)
    public ResponseEntity<PeliculaResponse> consultarPorId(@RequestParam("id")int id){
        PeliculaResponse peliculaResponse = pelisServicioImpl.listarPeliculaPorId(id);
        return new ResponseEntity<PeliculaResponse>(peliculaResponse, HttpStatus.OK);
    }

    @RequestMapping(value="insertarPelicula",method= RequestMethod.POST)
    public ResponseEntity<PeliculaResponse> insertarPelicula (@RequestBody PeliculaDTO peliculaDTOInsertar){
        PeliculaResponse peliculaResponse= pelisServicioImpl.addPelicula(peliculaDTOInsertar);
        return new ResponseEntity<PeliculaResponse> (peliculaResponse, HttpStatus.OK);
    }

    @RequestMapping(value="/listarPeliculas", params = "titulo", method= RequestMethod.GET)
    public ResponseEntity<List<PeliculaResponse>> consultarPorNombre(@RequestParam("titulo")String titulo){
        List<PeliculaResponse> peliculas = pelisServicioImpl.findPeliculaByName(titulo);
        return new ResponseEntity<List<PeliculaResponse>>(peliculas, HttpStatus.OK);
    }

    @RequestMapping(value="/listarPeliculas", params = "texto", method= RequestMethod.GET)
    public ResponseEntity<List<PeliculaResponse>> consultarPorTexto(@RequestParam("texto")String texto){
        List<PeliculaResponse> peliculas = pelisServicioImpl.findPeliculaByTexto(texto);
        return new ResponseEntity<List<PeliculaResponse>>(peliculas, HttpStatus.OK);
    }

}




