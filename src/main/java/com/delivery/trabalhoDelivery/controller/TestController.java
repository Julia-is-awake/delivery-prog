package com.delivery.trabalhoDelivery.controller;

import com.delivery.trabalhoDelivery.enums.Categoria;
import com.delivery.trabalhoDelivery.model.Produto;
import com.delivery.trabalhoDelivery.repositories.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class TestController {

    @Autowired
    private ProdutoRepositorio produtoRepositorio;

    @RequestMapping
    public String helloWorld() {
        Optional<Produto> prod = this.produtoRepositorio.findById(52L);
        return prod.get().getNome();
    }

    @RequestMapping("/goodbye")
    public String goodbye(){
        Produto produto = new Produto();
        produto.setNome("Pizza de Peperonni");
        produto.setPreco(15.30);
        produto.setDescricao("Pizza de Peperonni com 10.5 pedaços\nPS: A caixa não vem junto.");
        produto.setCategoria(Categoria.BEBIDA);
        this.produtoRepositorio.save(produto);
        return "Goodbye World";
    }


}
