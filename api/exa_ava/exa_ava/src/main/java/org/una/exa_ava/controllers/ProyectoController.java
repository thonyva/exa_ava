/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.una.exa_ava.controllers;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.una.exa_ava.dto.ProyectoDTO;
import org.una.exa_ava.services.IProyectoService;

/**
 *
 * @author thony
 */

@RestController
@RequestMapping("/proyectos")

public class ProyectoController {
    @Autowired
    private IProyectoService proyectoService;

    @GetMapping()
    @ResponseBody
    public ResponseEntity<?> findAll() {
        try {
            return new ResponseEntity<>(proyectoService.findAll(), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {
            return new ResponseEntity(proyectoService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody ProyectoDTO proyectoDTO) {
        try {
            return new ResponseEntity(proyectoService.create(proyectoDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody ProyectoDTO proyectoDTO) {
        try {
            Optional<ProyectoDTO> proyectoUpdated = proyectoService.update(proyectoDTO, id);
            if (proyectoUpdated.isPresent()) {
                return new ResponseEntity(proyectoUpdated, HttpStatus.OK);
            } else {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long id) {
        try {
            proyectoService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}