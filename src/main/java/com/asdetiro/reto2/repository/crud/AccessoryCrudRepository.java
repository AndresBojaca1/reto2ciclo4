package com.asdetiro.reto2.repository.crud;

import com.asdetiro.reto2.model.Accessory;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author andre
 */
public interface AccessoryCrudRepository extends MongoRepository<Accessory, String>{
    
    }
