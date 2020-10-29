/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.una.exa_ava.services;

import java.util.List;
import java.util.Optional;
import org.una.exa_ava.dto.ProyectoDTO;

/**
 *
 * @author thony
 */

public interface IProyectoService {
    public ProyectoDTO create(ProyectoDTO proyecto);
    public Optional<ProyectoDTO> update(ProyectoDTO proyecto, Long id);
    public void delete(Long id);
    public Optional<ProyectoDTO> findById(Long id);
    public Optional<List<ProyectoDTO>> findAll();
}