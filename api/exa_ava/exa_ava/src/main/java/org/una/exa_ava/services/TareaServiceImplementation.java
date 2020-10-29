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
import org.una.exa_ava.dto.TareaDTO;
import org.una.exa_ava.entities.Tarea;
import org.una.exa_ava.repositories.ITareaRepository;
import org.una.exa_ava.utils.MapperUtils;
import org.una.exa_ava.utils.ServiceConvertionHelper;

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
    public TareaDTO create(TareaDTO tarea) {
        Tarea tareaCrear = MapperUtils.EntityFromDto(tarea, Tarea.class);
        tareaCrear = tareaRepository.save(tareaCrear);
        return MapperUtils.DtoFromEntity(tareaCrear, TareaDTO.class);
    }

    @Override
    @Transactional
    public Optional<TareaDTO> update(TareaDTO tarea, Long id) {
        if (tareaRepository.findById(id).isPresent()) {
            Tarea tareaEditar = MapperUtils.EntityFromDto(tarea, Tarea.class);
            tareaEditar = tareaRepository.save(tareaEditar);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(tareaEditar, TareaDTO.class));
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
    public Optional<TareaDTO> findById(Long id) {
        return tareaRepository.findById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<List<TareaDTO>> findAll() {
        return ServiceConvertionHelper.findList(tareaRepository.findAll(), TareaDTO.class);
    }
}