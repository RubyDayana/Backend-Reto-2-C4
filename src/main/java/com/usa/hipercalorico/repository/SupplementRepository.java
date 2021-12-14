/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.hipercalorico.repository;

import com.usa.hipercalorico.model.Supplement;
import com.usa.hipercalorico.repository.crud.SupplementCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rubyd
 */
@Repository
public class SupplementRepository {
    
    @Autowired
    SupplementCrudRepository supplementCrudRepository;
    
    public List<Supplement> listAll(){
       return supplementCrudRepository.findAll();
   }
    
    public Optional<Supplement> getSupplement(String reference) {
        return supplementCrudRepository.findById(reference);
    }

    public Supplement create(Supplement supplement) {
        return supplementCrudRepository.save(supplement);
    }

    public void update(Supplement supplement) {
        supplementCrudRepository.save(supplement);
    }

    public void delete(Supplement supplement) {
        supplementCrudRepository.delete(supplement);
    }
}
