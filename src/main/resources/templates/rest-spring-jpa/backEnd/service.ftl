/*
 *  
 * The MIT License (MIT)
 * Copyright (c) ${year} ${author}
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
${package}

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

${importModel}
<#if importPrimaryKey??>
${importPrimaryKey}
</#if>

/**
 * ${entity.name}Service
 * 
 * @author ${author}
 * @kukulkanGenerated ${timestamp}
 */
public interface ${entity.name}Service {

    /**
     * regresa una lista con todos los elementos ${entity.name}
     * 
     * @return Page<${entity.name}>
     */
    Page<${entity.name}> findAll(Pageable pageable);

    /**
     * Consulta un ${entity.name} por su llave primaria
     * 
     * @param id
     * @return ${entity.name}
     */
    ${entity.name} findById(${id} id);

    /**
     * Guarda o actualiza un ${entity.name}
     * 
     * @param ${entityCamelCase}
     * @return boolean
     */
    ${entity.name} save(${entity.name} ${entityCamelCase});

    /**
     * Regresa true o false si existe un ${entity.name} almacenado
     * 
     * @param id
     * @return boolean
     */
    boolean exists(${id} id);

    /**
     * Borrar un ${entity.name} por su llave primaria
     * 
     * @param id
     */
    void delete(${id} id);

    /**
     * Borrar todos los elementos ${entity.name} almacenados
     * 
     * @param id
     */
    void deleteAll();
    
    /**
     * Buscar ${entity.name} con el correspondiente al query.
     *
     *  @param query El query de la busqueda
     *  
     *  @param pageable la información de paginación
     *  @return Page de todas las entidades
     */
    Page<${entity.name}> search(String query, Pageable pageable);
    
    <#if entity.features.sheetable>
 	/**
     * Regresa una HandsontableSlice de ${entity.name}
     * @param pageable la información de paginación
     * @return HandsontableSlice de todas las entidades
     */
    HandsontableSlice<${entity.name}> getHandsontable(Pageable pageable);
 	</#if>
}
