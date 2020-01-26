package com.mg.survey.service.service.port;

import com.mg.survey.service.domain.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    Optional<Product> findByProductId(int productId);
}
