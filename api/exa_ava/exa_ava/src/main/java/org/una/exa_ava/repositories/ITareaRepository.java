/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.una.exa_ava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.exa_ava.entities.Tarea;

/**
 *
 * @author thony
 */

public interface ITareaRepository extends JpaRepository<Tarea, Long> {
    
}