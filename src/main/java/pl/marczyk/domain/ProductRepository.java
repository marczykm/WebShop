package pl.marczyk.domain;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.marczyk.model.Product;

/**
 * Created by marcin on 07.09.15.
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
