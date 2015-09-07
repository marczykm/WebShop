package pl.marczyk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.marczyk.domain.ProductRepository;

/**
 * Created by marcin on 07.09.15.
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
}
