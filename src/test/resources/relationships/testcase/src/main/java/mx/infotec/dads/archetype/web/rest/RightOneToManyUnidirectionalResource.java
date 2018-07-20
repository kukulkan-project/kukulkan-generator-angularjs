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
package mx.infotec.dads.archetype.web.rest;

import java.util.List;
import java.util.Optional;

import com.codahale.metrics.annotation.Timed;
import io.swagger.annotations.ApiParam;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import mx.infotec.dads.archetype.web.rest.util.HeaderUtil;
import mx.infotec.dads.archetype.web.rest.util.PaginationUtil;

import mx.infotec.dads.archetype.domain.RightOneToManyUnidirectional;
import mx.infotec.dads.archetype.service.RightOneToManyUnidirectionalService;

/**
 * 
 * @author kukulkan
 * @kukulkanGenerated 20180101000000
 */
@RestController
@RequestMapping("/api")
public class RightOneToManyUnidirectionalResource {

    private static final Logger log = LoggerFactory.getLogger(RightOneToManyUnidirectionalResource.class);
    
    private static final String ENTITY_NAME = "rightOneToManyUnidirectional";

    @Autowired
    private RightOneToManyUnidirectionalService service;
    
    /**
     * GET  /rightOneToManyUnidirectional : recupera todos los rightOneToManyUnidirectional.
     *
     * @param pageable información de paginación
     * @return El objeto ResponseEntity con estado de 200 (OK) y la lista de rightOneToManyUnidirectional en el cuerpo del mensaje
     */
    @GetMapping("/rightOneToManyUnidirectional")
    @Timed
    public ResponseEntity<List<RightOneToManyUnidirectional>> getAllRightOneToManyUnidirectional(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of RightOneToManyUnidirectional");
        Page<RightOneToManyUnidirectional> page = service.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/rightOneToManyUnidirectional");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /rightOneToManyUnidirectional/:id : recupera por "id" de RightOneToManyUnidirectional.
     *
     * @param id el id del RightOneToManyUnidirectional que se desea recuperar
     * @return El objeto ResponseEntity con el estado de 200 (OK) y dentro del cuerpo del mensaje el RightOneToManyUnidirectional, o con estado de 404 (Not Found)
     */
    @GetMapping("/rightOneToManyUnidirectional/{id}")
    @Timed
    public ResponseEntity<RightOneToManyUnidirectional> getRightOneToManyUnidirectional(@PathVariable Long id) {
        log.debug("REST request to get RightOneToManyUnidirectional : {}", id);
        RightOneToManyUnidirectional rightOneToManyUnidirectional = service.findById(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(rightOneToManyUnidirectional));
    }

    /**
     * POST  /rightOneToManyUnidirectional : Create a new usuario.
     *
     * @param rightOneToManyUnidirectional el rightOneToManyUnidirectional que se desea crear
     * @return El objeto ResponseEntity con estado 201 (Created) y en el cuerpo un nuevo rightOneToManyUnidirectional, o con estado 400 (Bad Request) si el usuario ya tiene un ID
     * @throws URISyntaxException Si la sintaxis de la URI no es correcta
     */
    @PostMapping("/rightOneToManyUnidirectional")
    @Timed
    public ResponseEntity<RightOneToManyUnidirectional> createRightOneToManyUnidirectional(@Valid @RequestBody RightOneToManyUnidirectional rightOneToManyUnidirectional) throws URISyntaxException {
        log.debug("REST request to save RightOneToManyUnidirectional : {}", rightOneToManyUnidirectional);
        if (rightOneToManyUnidirectional.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new rightOneToManyUnidirectional cannot already have an ID")).body(null);
        }
        RightOneToManyUnidirectional result = service.save(rightOneToManyUnidirectional);
        return ResponseEntity.created(new URI("/api/rightOneToManyUnidirectional/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }
    
    /**
     * PUT  /rightOneToManyUnidirectional : Actualiza un RightOneToManyUnidirectional existente.
     *
     * @param rightOneToManyUnidirectional el rightOneToManyUnidirectional que se desea actualizar
     * @return el objeto ResponseEntity con estado de 200 (OK) y en el cuerpo de la respuesta el RightOneToManyUnidirectional actualizado,
     * o con estatus de 400 (Bad Request) si el rightOneToManyUnidirectional no es valido,
     * o con estatus de 500 (Internal Server Error) si el rightOneToManyUnidirectional no se puede actualizar
     * @throws URISyntaxException si la sintaxis de la URI no es correcta
     */
    @PutMapping("/rightOneToManyUnidirectional")
    @Timed
    public ResponseEntity<RightOneToManyUnidirectional> updateRightOneToManyUnidirectional(@Valid @RequestBody RightOneToManyUnidirectional rightOneToManyUnidirectional) throws URISyntaxException {
        log.debug("REST request to update RightOneToManyUnidirectional : {}", rightOneToManyUnidirectional);
        if (rightOneToManyUnidirectional.getId() == null) {
            return createRightOneToManyUnidirectional(rightOneToManyUnidirectional);
        }
        RightOneToManyUnidirectional result = service.save(rightOneToManyUnidirectional);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, rightOneToManyUnidirectional.getId().toString()))
            .body(result);
    }


    /**
     * DELETE  /rightOneToManyUnidirectional/:id : borrar el RightOneToManyUnidirectional con "id".
     *
     * @param id el id del RightOneToManyUnidirectional que se desea borrar
     * @return el objeto ResponseEntity con estatus 200 (OK)
     */
    @DeleteMapping("/rightOneToManyUnidirectional/{id}")
    @Timed
    public ResponseEntity<Void> deleteRightOneToManyUnidirectional(@PathVariable Long id) {
        log.debug("REST request to delete RightOneToManyUnidirectional : {}", id);
        service.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/rightOneToManyUnidirectional?query=:query : buscar por el rightOneToManyUnidirectional correspondiente
     * to the query.
     *
     * @param query el query para el rightOneToManyUnidirectional que se desea buscar
     * @param pageable información de la paginación
     * @return el resultado de la busqueda
     */
    @GetMapping("/_search/rightOneToManyUnidirectional")
    @Timed
    public ResponseEntity<List<RightOneToManyUnidirectional>> searchRightOneToManyUnidirectional(@RequestParam String query, @ApiParam Pageable pageable) {
        log.debug("REST request to search for a page of RightOneToManyUnidirectional for query {}", query);
        Page<RightOneToManyUnidirectional> page = service.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/rightOneToManyUnidirectional");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }
    
}