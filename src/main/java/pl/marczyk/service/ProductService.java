package pl.marczyk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.marczyk.domain.ProductRepository;
import pl.marczyk.model.Product;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcin on 07.09.15.
 */
@Service
public class ProductService {
    private int pageSize = 10;

    @Autowired
    private ProductRepository productRepository;

    public Iterable<Product> findAll(){
        return productRepository.findAll();
    }

    public Page<Product> findAll(int pageNumber) {
        if (pageNumber < 0)
            pageNumber = 0;
        else if (pageNumber >= getTotalPages())
            pageNumber = getTotalPages()-1;
        return productRepository.findAll(new PageRequest(pageNumber, pageSize));
    }

    public Product findOneBy(Long id) {
        return productRepository.findOne(id);
    }

    public int getTotalPages(){
        return productRepository.findAll(new PageRequest(0, pageSize)).getTotalPages();
    }

    public List<Integer> getListOfPagesNumber(){
        List<Integer> pages = new ArrayList<Integer>();
        for (int i = 1; i <= getTotalPages(); i++){
            pages.add(i);
        }
        return pages;
    }

    public Page<Product> getRecommendedProducts() {
        return productRepository.findAll(new PageRequest(0, 3));
    }
}
