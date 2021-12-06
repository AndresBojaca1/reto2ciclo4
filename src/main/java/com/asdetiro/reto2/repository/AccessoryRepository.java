package com.asdetiro.reto2.repository;

import com.asdetiro.reto2.model.Accessory;
import com.asdetiro.reto2.repository.crud.AccessoryCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author andre
 */
@Repository
public class AccessoryRepository {
    
    @Autowired
    private AccessoryCrudRepository accessoryCrudRepository;
    
    public List<Accessory> listAll() {
        return accessoryCrudRepository.findAll();
    }
    
    public Optional<Accessory> getAccessory(String reference) {
        return accessoryCrudRepository.findById(reference);
    }
    
    public Accessory create(Accessory accessory) {
        return accessoryCrudRepository.save(accessory);
    }
    
    public void update(Accessory accessory) {
        accessoryCrudRepository.save(accessory);
    }
    
    public void delete(Accessory accessory) {
        accessoryCrudRepository.delete(accessory);
    }
    
    public boolean referenceVerification(String reference) {
        Optional<Accessory> accessory = accessoryCrudRepository.findById(reference);
        return !accessory.isEmpty();
    }
}
