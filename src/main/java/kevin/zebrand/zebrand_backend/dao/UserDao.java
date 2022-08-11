package kevin.zebrand.zebrand_backend.dao;

import kevin.zebrand.zebrand_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {
}
