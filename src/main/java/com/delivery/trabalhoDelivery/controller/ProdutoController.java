package com.delivery.trabalhoDelivery.controller;

import com.delivery.trabalhoDelivery.model.Produto;
import com.delivery.trabalhoDelivery.repositories.ProdutoRepositorio;
import jakarta.websocket.server.PathParam;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    ProdutoRepositorio repositorio;

    @PostMapping("/cadastrar")
    public Produto cadastrar(@RequestBody Produto produto){
        return this.repositorio.save(produto);
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

    @PostMapping("/editar")
    public List<Produto> editar(@RequestBody Produto produto){
        this.repositorio.save(produto);
        return listar();
    }

    @GetMapping("/listar")
    public List<Produto> listar(){
        List<Produto> produtos = new ArrayList<>();
        produtos.addAll(repositorio.findAll());
        return produtos;
    }
}
