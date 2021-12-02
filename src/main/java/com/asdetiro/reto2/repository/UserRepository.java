package com.asdetiro.reto2.repository;

import com.asdetiro.reto2.model.User;
import com.asdetiro.reto2.repository.crud.UserCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 *
 * @author andre
 */
@Repository
public class UserRepository {
    
    //Repositorio asociado con el CRUD (de mongo)
    @Autowired
    private UserCrudRepository userCrudRepository;
    
    //Devuelvame todos los usuarios
    public List<User> listAll(){
       return userCrudRepository.findAll();
    }
    
    //Booleano para saber si existe o no un email
    public boolean emailExist(String email) {
        Optional<User> user = userCrudRepository.findByEmail(email);
        return !user.isEmpty();
    }
    
    public Optional<User> authenticateUser(String email, String password){
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
    
    public Optional<User> getUser(int id) {
        return userCrudRepository.findById(id);
    }
    
    public User create(User user) {
        return userCrudRepository.save(user);
    }
    
    public void update(User user) {
        userCrudRepository.save(user);
    }
    
    public void delete(User user) {
        userCrudRepository.delete(user);
    }
}
