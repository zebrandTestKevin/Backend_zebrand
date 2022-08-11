package kevin.zebrand.zebrand_backend.controller;

import kevin.zebrand.zebrand_backend.dao.UserDao;
import kevin.zebrand.zebrand_backend.model.Product;
import kevin.zebrand.zebrand_backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/",produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    UserDao userDao;

    @GetMapping(path = "/user")
    public List<User> get() throws Exception {
        return userDao.findAll();
    }
    @GetMapping(path = "/user/{id}")
    public Optional<User> getSpecificUser(@PathVariable (value = "id")Integer id) throws Exception {
        return userDao.findById(id);
    }
    @PostMapping(path = "/user/add",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public User create(@RequestBody User user) throws Exception {
        return userDao.save(user);
    }
    @DeleteMapping(value="/user/delete/{id}")
    public String deleteById(@PathVariable (value="id")Integer id) throws Exception {
//        User user=new User();
//        userDao.delete(userDao.findById(id));
        userDao.deleteById(id);
        return "Delete by Id"+id;
    }

}
