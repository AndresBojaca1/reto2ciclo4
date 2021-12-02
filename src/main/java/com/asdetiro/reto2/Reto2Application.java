package com.asdetiro.reto2;

import com.asdetiro.reto2.model.Accessory;
import com.asdetiro.reto2.model.User;
import com.asdetiro.reto2.repository.UserRepository;
import com.asdetiro.reto2.repository.crud.AccessoryCrudRepository;
import com.asdetiro.reto2.repository.crud.UserCrudRepository;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Reto2Application implements CommandLineRunner {

    //PRUEBAS ESTO NO ES MANDATORIO
    @Autowired
    private UserCrudRepository userCrudRepository;
    @Autowired
    private AccessoryCrudRepository accessoryCrudRepository;
    
    
    public static void main(String[] args) {
        SpringApplication.run(Reto2Application.class, args);
    }
    
    @Override
    public void run(String... args) throws Exception {
        
        //PRUEBA
        userCrudRepository.deleteAll();
        accessoryCrudRepository.deleteAll();
        
//        System.out.println("Aqui se ejecutara la creacion de documentos de MONGO ... ");
//        //CREACION DE CONJUNTO DE USUARIOS MANUALMENTE
//        userCrudRepository.saveAll(List.of(
//                new User(1, "1136", "Andres Bojaca","Cll31sur1", "313890", "anedru1@", "Lasraf1", "Zona 1", "ADM"),
//                new User(2, "79460", "Luis Bojaca", "Cll31sur2", "311292", "esiul@", "Lasraf2", "Zona 2", "COORD"),
//                new User(3, "20774", "Clau Matiz", "Cll31sur3", "311", "clau@", "Lasraf3", "Zona 3", "ASE"),
//                new User(4, "43535", "Pepe", "Cll31sur4", "3112", "claasdu@", "Lasraf4", "Zona 1", "ASE")
//        ));
//        
//        accessoryCrudRepository.saveAll(List.of(
//                new Accessory("AP-123", "ACME", "MATERIAL1", "PRESENTACION1", "DESCRIPCIONXAD", true, 123, 1234, "link"),
//                new Accessory("AP-456", "ACME", "MATERIAL1", "PRESENTACION1", "DESCRIPCIONXAD", true, 123, 1234, "link")
//        ));
//        System.out.println("LISTADO DE USUARIOS");
//        userCrudRepository.findAll().forEach(System.out::println);
//        
//        System.out.println("LISTADO DE ACCESORIOS");
//        accessoryCrudRepository.findAll().forEach(System.out::println);
//        
//        Optional<User> usuario = userCrudRepository.findByEmail("esiulnoex@");
//        
//        if (!usuario.isEmpty()) { //Si el usuario retorna algo o existe entonces ...
//            System.out.println("Datos del usuario esiul@" + usuario.get());
//        } else {
//            System.out.println("Este email NO EXISTE");
//        }
//        
//        Optional<User> usuario2 = userCrudRepository.findByEmailAndPassword("esiul@","Lasraf2");
//        
//        if (!usuario2.isEmpty()) { //Si el usuario retorna algo o existe entonces ...
//            System.out.println("Datos del usuario esiul@ con contraseña LasRaf2" + usuario2.get());
//        } else {
//            System.out.println("La combinacion Email - Password es incorrecta");
//        }
    }
    
}
