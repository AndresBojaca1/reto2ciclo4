package com.asdetiro.reto2.controller;

import com.asdetiro.reto2.model.User;
import com.asdetiro.reto2.service.UserService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author andre
 */
@RestController
@RequestMapping("/api/user") //punto de entrada al servicio
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UserController {

    //Controlador asociado con un servicio
    @Autowired
    private UserService userService;

    //S E R V I C I O S
    
       
    //Servicio para obtener todo
    @GetMapping("/all")
    public List<User> listAll() {
        return userService.listAll();
    }

    //Servicio para obtener booleano y saber si un email existe
    @GetMapping("/emailexist/{email}")
    public boolean emailExist(@PathVariable("email") String email) {
        return userService.emailExist(email);
    }
    
    //Servicio para validar autenticacion Usuario + Contraseña existe
    @GetMapping("/{email}/{password}")
    public User authenticateUser(@PathVariable("email") String email, @PathVariable("password") String password){
        return userService.authenticateUser(email,password);
    }
    
    //Creacion de nuevo usuario
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        return userService.create(user);
    }
    
    //Actualizacion
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user) {
        return userService.update(user);
    }
    
    //Borrado de info
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return userService.delete(id);
    }
    
    //Verificar si ID existe -- CREADO 01/12/2021 
    
    public boolean idVerification(@PathVariable("id") int id){
       return userService.idVerification(id);
    }
    
    //Generar un JSON unicamente con los datos de una Id en particular  -- CREADO 01/12/2021 
    @GetMapping("/all/{id}")
    public Optional<User> getUser(@PathVariable("id") int id) {
        return userService.getUser(id); 
    }
    

}
