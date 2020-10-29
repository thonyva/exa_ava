/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.una.exa_ava.services;

import java.util.List;
import java.util.Optional;
import org.una.exa_ava.dto.TareaDTO;

/**
 *
 * @author thony
 */

public interface ITareaService {
    public TareaDTO create(TareaDTO tarea);
    public Optional<TareaDTO> update(TareaDTO tarea, Long id);
    public void delete(Long id);
    public void deleteAll();
    public Optional<TareaDTO> findById(Long id);
    public Optional<List<TareaDTO>> findByProyectoId(Long id);
    public Optional<List<TareaDTO>> findAll();
}