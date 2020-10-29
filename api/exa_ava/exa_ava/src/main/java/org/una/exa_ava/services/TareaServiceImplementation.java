/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.una.exa_ava.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.exa_ava.repositories.ITareaRepository;

/**
 *
 * @author thony
 */

@Service
public class TareaServiceImplementation implements ITareaService {
    @Autowired
    private ITareaRepository tareaRepository;
    
    @Override
    @Transactional
    public Tarea create(Tarea tarea) {
        return tareaRepository.save(tarea);
    }
    
    @Override
    @Transactional
    public Optional<Tarea> update(Tarea tarea, Long id) {
        if (tareaRepository.findById(id).isPresent()) {
            return Optional.ofNullable(tareaRepository.save(tarea));
        } else {
            return null;
        }
    }
    
    @Override
    @Transactional
    public void delete(Long id) {
        tareaRepository.deleteById(id);
    }
    
    @Override
    @Transactional
    public void deleteAll() {
        tareaRepository.deleteAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Tarea> findById(Long id) {
        return tareaRepository.findById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<List<Tarea>> findAll() {
        return Optional.ofNullable(tareaRepository.findAll());
    }
}