package com.delivery.trabalhoDelivery.controller;

import com.delivery.trabalhoDelivery.model.Restaurante;
import com.delivery.trabalhoDelivery.repositories.RestauranteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurante")
public class RestaunteController {
    @Autowired
    RestauranteRepositorio repositorio;

    @PostMapping("/cadastrar")
    public Restaurante cadastrar(@RequestBody Restaurante restaurante){
        return this.repositorio.save(restaurante);
    }

    @GetMapping("/{id}")
    public Restaurante restaurante(@PathVariable("id") Long id){
        Optional<Restaurante> restaurante = repositorio.findById(id);
        return restaurante.get();
    }

    @DeleteMapping("/deletar/{id}")
    public List<Restaurante> delete(@PathVariable("id") Long id){
        Optional<Restaurante> restaurante = repositorio.findById(id);
        repositorio.delete(restaurante.get());
        return listar();
    }

    @PostMapping("/editar")
    public List<Restaurante> editar(@RequestBody Restaurante restaurante){
        this.repositorio.save(restaurante);
        return listar();
    }

    @GetMapping("/listar")
    public List<Restaurante> listar(){
        List<Restaurante> restaurantes = new ArrayList<>();
        restaurantes.addAll(repositorio.findAll());
        return restaurantes;
    }
}
