package com.delivery.trabalhoDelivery.controller;

import com.delivery.trabalhoDelivery.model.Produto;
import com.delivery.trabalhoDelivery.repositories.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutoController {
    @Autowired
    ProdutoRepositorio repositorio;

    @PostMapping("/produto/cadastrar")
    public Produto cadastrar(@RequestBody Produto produto){
        return this.repositorio.save(produto);
    }
}
