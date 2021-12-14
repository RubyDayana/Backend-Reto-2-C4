/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.hipercalorico.controller;

import com.usa.hipercalorico.model.Supplement;
import com.usa.hipercalorico.service.SupplementService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rubyd
 */
@RestController
@RequestMapping("/supplements")
@CrossOrigin("*")
public class SupplementController {
    
    @Autowired
    private SupplementService supplementService;
    
    @GetMapping("/all")
    public List<Supplement> listAll() {
        return supplementService.listAll();
    }

    @GetMapping("/{reference}")
    public Optional<Supplement> getSupplement(@PathVariable("reference") String reference) {
        return supplementService.getSupplement(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Supplement create(@RequestBody Supplement gadget) {
        return supplementService.create(gadget);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Supplement update(@RequestBody Supplement gadget) {
        return supplementService.update(gadget);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return supplementService.delete(reference);
    }
}
