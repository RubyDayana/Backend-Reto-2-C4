/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.hipercalorico.service;

import com.usa.hipercalorico.model.Supplement;
import com.usa.hipercalorico.repository.SupplementRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author rubyd
 */
@Service
public class SupplementService {
    
    @Autowired
    private SupplementRepository supplementRepository;
    
    public List<Supplement> listAll() {
        return supplementRepository.listAll();
    }

    public Optional<Supplement> getSupplement(String reference) {
        return supplementRepository.getSupplement(reference);
    }

    public Supplement create(Supplement supplement) {
        if (supplement.getReference() == null) {
            return supplement;
        } else {
            return supplementRepository.create(supplement);
        }
    }

    public Supplement update(Supplement supplement) {

        if (supplement.getReference() != null) {
            Optional<Supplement> supplementDb = supplementRepository.getSupplement(supplement.getReference());
            if (!supplementDb.isEmpty()) {
                if (supplement.getBrand() != null) {
                    supplementDb.get().setBrand(supplement.getBrand());
                }
                if (supplement.getCategory() != null) {
                    supplementDb.get().setCategory(supplement.getCategory());
                }

                if (supplement.getDescription() != null) {
                    supplementDb.get().setDescription(supplement.getDescription());
                }
                if (supplement.getPrice() != 0.0) {
                    supplementDb.get().setPrice(supplement.getPrice());
                }
                if (supplement.getQuantity() != 0) {
                    supplementDb.get().setQuantity(supplement.getQuantity());
                }
                if (supplement.getPhotography() != null) {
                    supplementDb.get().setPhotography(supplement.getPhotography());
                }
                supplementDb.get().setAvailability(supplement.isAvailability());
                supplementRepository.update(supplementDb.get());
                return supplementDb.get();
            } else {
                return supplement;
            }
        } else {
            return supplement;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getSupplement(reference).map(supplement -> {
            supplementRepository.delete(supplement);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
