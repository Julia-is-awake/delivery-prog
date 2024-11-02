package com.delivery.trabalhoDelivery.repositories;

import com.delivery.trabalhoDelivery.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepositorio extends JpaRepository<Produto, Long> {

}
