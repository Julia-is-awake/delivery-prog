package com.delivery.trabalhoDelivery.controller;

import com.delivery.trabalhoDelivery.model.Produto;
import com.delivery.trabalhoDelivery.model.Restaurante;
import com.delivery.trabalhoDelivery.repositories.ProdutoRepositorio;
import com.delivery.trabalhoDelivery.repositories.RestauranteRepositorio;
import jakarta.websocket.server.PathParam;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:5173/")
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    ProdutoRepositorio repositorio;

    @Autowired
    RestauranteRepositorio restauranteRepositorio;

    @PostMapping("/cadastrar/{restaurante_id}")
    public Produto cadastrar(@RequestBody Produto produto, @PathVariable(value = "restaurante_id") Long restaurante_id){
        Optional<Restaurante> restaurante = restauranteRepositorio.findById(restaurante_id);
        if (restaurante.isPresent()) {
            produto.setRestaurante(restaurante.get());
            return this.repositorio.save(produto);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurante não encontrado");
        }
    }

    @GetMapping("/{id}")
    public Produto produto(@PathVariable("id") Long id){
        Optional<Produto> produto = repositorio.findById(id);
        return produto.get();
    }

    @DeleteMapping("/deletar/{id}")
    public List<Produto> delete(@PathVariable("id") Long id){
        Optional<Produto> produto = repositorio.findById(id);
        repositorio.delete(produto.get());
        return listar();
    }

    @PostMapping("/editar/{restaurante_id}")
    public List<Produto> editar(@RequestBody Produto produto, @PathVariable(value = "restaurante_id") Long restaurante_id){
        Optional<Restaurante> restaurante = restauranteRepositorio.findById(restaurante_id);
        if (restaurante.isPresent()) {
            produto.setRestaurante(restaurante.get());
            this.repositorio.save(produto);
            return listar();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurante não encontrado");
        }
    }

    @GetMapping("/listar")
    public List<Produto> listar(){
        List<Produto> produtos = new ArrayList<>();
        produtos.addAll(repositorio.findAll());
        return produtos;
    }
}
