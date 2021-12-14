/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.hipercalorico.repository.crud;

import com.usa.hipercalorico.model.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author rubyd
 */
public interface UserCrudRepository extends  MongoRepository<User, Integer>{
    /**
     * Validar existncia del correo electrónico
     * se usa durante el registro
     * @param email
     * @return 
     */
    public Optional<User> findByEmail(String email);
    
    /**
     * Validar que el correo electrónico y la contraseña exista 
     * se usa durante l inicio de sesión
     * @param email
     * @param password
     * @return 
     */
    public Optional<User> findByEmailAndPassword(String email,String password);
}
