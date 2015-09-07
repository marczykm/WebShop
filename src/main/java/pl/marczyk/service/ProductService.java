package pl.marczyk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.marczyk.domain.ProductRepository;
import pl.marczyk.model.Product;

/**
 * Created by marcin on 07.09.15.
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Iterable<Product> findAll(){
        return productRepository.findAll();
    }
}
