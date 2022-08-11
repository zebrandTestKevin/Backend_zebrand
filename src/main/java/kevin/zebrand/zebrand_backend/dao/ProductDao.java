package kevin.zebrand.zebrand_backend.dao;

import kevin.zebrand.zebrand_backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends JpaRepository<Product,Integer>{
}