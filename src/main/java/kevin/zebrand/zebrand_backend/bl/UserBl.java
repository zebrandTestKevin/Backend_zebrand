package kevin.zebrand.zebrand_backend.bl;

import kevin.zebrand.zebrand_backend.dao.UserDao;
import kevin.zebrand.zebrand_backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBl {

    @Autowired
    UserDao userDao;
//    private final ProductDao productDao;

    public List<User> getAdmins(){
        return userDao.findAll();
    }
}
