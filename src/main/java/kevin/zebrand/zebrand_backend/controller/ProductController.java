package kevin.zebrand.zebrand_backend.controller;

import kevin.zebrand.zebrand_backend.dao.ProductDao;
import kevin.zebrand.zebrand_backend.dao.UserDao;
import kevin.zebrand.zebrand_backend.model.Product;
import kevin.zebrand.zebrand_backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/",produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

    @Autowired
    ProductDao productDao;

    @GetMapping(path = "/product")
    public List<Product> get() throws Exception {
        return productDao.findAll();
    }
    @GetMapping(path = "/product/{id}")
    public Optional<Product> getSpecificProduct(@PathVariable (value = "id")Integer id) throws Exception {
        return productDao.findById(id);
    }
    @PostMapping(path = "/product/add",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Product create(@RequestBody Product product) throws Exception {
        return productDao.save(product);
    }
    @DeleteMapping(value="/product/delete/{id}")
    public String deleteById(@PathVariable (value="id")Integer id) throws Exception {
//        User user=new User();
//        userDao.delete(userDao.findById(id));
        productDao.deleteById(id);
        return "Delete by Id"+id;
    }
}
