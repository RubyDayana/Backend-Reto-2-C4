/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.hipercalorico.repository.crud;

import com.usa.hipercalorico.model.Supplement;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author rubyd
 */
public interface SupplementCrudRepository extends MongoRepository<Supplement, String>{
    
}
