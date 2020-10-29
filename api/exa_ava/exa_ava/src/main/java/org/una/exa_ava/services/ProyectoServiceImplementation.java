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
import org.una.exa_ava.dto.ProyectoDTO;
import org.una.exa_ava.entities.Proyecto;
import org.una.exa_ava.repositories.IProyectoRepository;
import org.una.exa_ava.utils.MapperUtils;
import org.una.exa_ava.utils.ServiceConvertionHelper;

/**
 *
 * @author thony
 */

@Service
public class ProyectoServiceImplementation implements IProyectoService {
    @Autowired
    private IProyectoRepository proyectoRepository;
    
    @Override
    @Transactional
    public ProyectoDTO create(ProyectoDTO proyecto) {
        Proyecto proyectoCrear = MapperUtils.EntityFromDto(proyecto, Proyecto.class);
        proyectoCrear = proyectoRepository.save(proyectoCrear);
        return MapperUtils.DtoFromEntity(proyectoCrear, ProyectoDTO.class);
    }
    
    @Override
    @Transactional
    public Optional<ProyectoDTO> update(ProyectoDTO proyecto, Long id) {
        if (proyectoRepository.findById(id).isPresent()) {
            Proyecto proyectoEditar = MapperUtils.EntityFromDto(proyecto, Proyecto.class);
            proyectoEditar = proyectoRepository.save(proyectoEditar);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(proyectoEditar, ProyectoDTO.class));
        } else {
            return null;
        }
    }
    
    @Override
    @Transactional
    public void delete(Long id) {
        proyectoRepository.deleteById(id);
    }
    
    @Override
    @Transactional
    public void deleteAll() {
        proyectoRepository.deleteAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ProyectoDTO> findById(Long id) {
        return ServiceConvertionHelper.oneToOptionalDto(proyectoRepository.findById(id), ProyectoDTO.class);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<List<ProyectoDTO>> findAll() {
        return ServiceConvertionHelper.findList(proyectoRepository.findAll(), ProyectoDTO.class);
    }
}