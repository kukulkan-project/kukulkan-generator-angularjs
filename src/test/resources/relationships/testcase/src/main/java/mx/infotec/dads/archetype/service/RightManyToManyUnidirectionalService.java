/*
 *  
 * The MIT License (MIT)
 * Copyright (c) 2018 kukulkan
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package mx.infotec.dads.archetype.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import mx.infotec.dads.archetype.domain.RightManyToManyUnidirectional;

/**
 * RightManyToManyUnidirectionalService
 * 
 * @author kukulkan
 * @kukulkanGenerated 20180101000000
 */
public interface RightManyToManyUnidirectionalService {

    /**
     * regresa una lista con todos los elementos RightManyToManyUnidirectional
     * 
     * @return Page<RightManyToManyUnidirectional>
     */
    Page<RightManyToManyUnidirectional> findAll(Pageable pageable);

    /**
     * Consulta un RightManyToManyUnidirectional por su llave primaria
     * 
     * @param id
     * @return RightManyToManyUnidirectional
     */
    RightManyToManyUnidirectional findById(Long id);

    /**
     * Guarda o actualiza un RightManyToManyUnidirectional
     * 
     * @param rightManyToManyUnidirectional
     * @return boolean
     */
    RightManyToManyUnidirectional save(RightManyToManyUnidirectional rightManyToManyUnidirectional);

    /**
     * Regresa true o false si existe un RightManyToManyUnidirectional almacenado
     * 
     * @param id
     * @return boolean
     */
    boolean exists(Long id);

    /**
     * Borrar un RightManyToManyUnidirectional por su llave primaria
     * 
     * @param id
     */
    void delete(Long id);

    /**
     * Borrar todos los elementos RightManyToManyUnidirectional almacenados
     * 
     * @param id
     */
    void deleteAll();
    
    /**
     * Buscar RightManyToManyUnidirectional con el correspondiente al query.
     *
     *  @param query El query de la busqueda
     *  
     *  @param pageable la información de paginación
     *  @return Page de todas las entidades
     */
    Page<RightManyToManyUnidirectional> search(String query, Pageable pageable);
}
