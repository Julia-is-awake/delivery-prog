package com.delivery.trabalhoDelivery.repositories;

import com.delivery.trabalhoDelivery.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositorio extends JpaRepository<User, Long> {
}
