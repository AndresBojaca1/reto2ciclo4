package com.asdetiro.reto2.service;

import com.asdetiro.reto2.model.User;
import com.asdetiro.reto2.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author andre
 */
@Service
public class UserService {

    //Servicio asociado a un repositorio
    @Autowired
    private UserRepository userRepository;

    //METODOS PARA DIFERENTES OPERACIONES
    public Optional<User> getUser(int id) {
        return userRepository.getUser(id);
    }

    public List<User> listAll() {
        return userRepository.listAll();
    }

    public boolean emailExist(String email) {
        return userRepository.emailExist(email);
    }

    public User authenticateUser(String email, String password) {
        Optional<User> user = userRepository.authenticateUser(email, password);
        if (user.isEmpty()) {
            return new User();
        } else {
            return user.get();
        }
    }

    
        public User create(User user) {
        //obtiene el maximo id existente en la coleccion
        Optional<User> userIdMaximo = userRepository.lastUserId();
        
        //si el id del Usaurio que se recibe como parametro es nulo, entonces valida el maximo id existente en base de datos
        if (user.getId() == null) {
            //valida el maximo id generado, si no hay ninguno aun el primer id sera 1
            if (userIdMaximo.isEmpty()){
            user.setId(1);
            }else{
                //si retorna informacion suma 1 al maximo id existente y lo asigna como el codigo del usuario
                 user.setId(userIdMaximo.get().getId() + 1);
            }            
        }
        
        Optional<User> usuario = userRepository.getUser(user.getId());
        if (usuario.isEmpty()) {
            if (emailExist(user.getEmail())==false){
                return userRepository.create(user);
            }else{
                return user;
            }
        }else{
            return user;
        }
    }

    public User update(User user) {
        if (user.getId() != null) {
            Optional<User> userDb = userRepository.getUser(user.getId());
            if (!userDb.isEmpty()) {
                // VALIDAR CADA ITEM son 7 validaciones 
                if (user.getIdentification() != null) {
                    userDb.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    userDb.get().setName(user.getName());
                }
                if (user.getAddress() != null) {
                    userDb.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    userDb.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    userDb.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    userDb.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    userDb.get().setZone(user.getZone());
                }

                userRepository.update(userDb.get());
                return userDb.get();
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    public boolean delete(int id) {
        Boolean aBoolean = getUser(id).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    public boolean idVerification(int id) {
        return userRepository.idVerification(id);
    }
}
