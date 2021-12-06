package com.asdetiro.reto2.repository.crud;

import com.asdetiro.reto2.model.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author andre
 */
public interface UserCrudRepository extends MongoRepository<User, Integer> {
    
    /** M e t o d o s    a d i c i o n a l e s 
     * 
     * Metodos que no estan predeterminados en la interfaz MongoRepository
     * @param email
     * @return 
     */
    
    //Recuperar Datos usuario asociados a un Email
    public Optional<User> findByEmail(String email);
    //Recuperar Datos de usuario asociados a un Email y un Password
    public Optional<User> findByEmailAndPassword(String email, String password);
    //Determina el numero de ID mas alto
    Optional<User> findTopByOrderByIdDesc();  
}
