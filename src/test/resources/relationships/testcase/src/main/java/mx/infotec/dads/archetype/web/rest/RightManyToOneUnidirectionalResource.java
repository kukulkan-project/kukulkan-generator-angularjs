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

import mx.infotec.dads.archetype.domain.RightManyToOneUnidirectional;
import mx.infotec.dads.archetype.service.RightManyToOneUnidirectionalService;

/**
 * 
 * @author kukulkan
 * @kukulkanGenerated 20180101000000
 */
@RestController
@RequestMapping("/api")
public class RightManyToOneUnidirectionalResource {

    private static final Logger log = LoggerFactory.getLogger(RightManyToOneUnidirectionalResource.class);
    
    private static final String ENTITY_NAME = "rightManyToOneUnidirectional";

    @Autowired
    private RightManyToOneUnidirectionalService service;
    
    /**
     * GET  /rightManyToOneUnidirectional : recupera todos los rightManyToOneUnidirectional.
     *
     * @param pageable información de paginación
     * @return El objeto ResponseEntity con estado de 200 (OK) y la lista de rightManyToOneUnidirectional en el cuerpo del mensaje
     */
    @GetMapping("/rightManyToOneUnidirectional")
    @Timed
    public ResponseEntity<List<RightManyToOneUnidirectional>> getAllRightManyToOneUnidirectional(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of RightManyToOneUnidirectional");
        Page<RightManyToOneUnidirectional> page = service.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/rightManyToOneUnidirectional");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /rightManyToOneUnidirectional/:id : recupera por "id" de RightManyToOneUnidirectional.
     *
     * @param id el id del RightManyToOneUnidirectional que se desea recuperar
     * @return El objeto ResponseEntity con el estado de 200 (OK) y dentro del cuerpo del mensaje el RightManyToOneUnidirectional, o con estado de 404 (Not Found)
     */
    @GetMapping("/rightManyToOneUnidirectional/{id}")
    @Timed
    public ResponseEntity<RightManyToOneUnidirectional> getRightManyToOneUnidirectional(@PathVariable Long id) {
        log.debug("REST request to get RightManyToOneUnidirectional : {}", id);
        RightManyToOneUnidirectional rightManyToOneUnidirectional = service.findById(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(rightManyToOneUnidirectional));
    }

    /**
     * POST  /rightManyToOneUnidirectional : Create a new usuario.
     *
     * @param rightManyToOneUnidirectional el rightManyToOneUnidirectional que se desea crear
     * @return El objeto ResponseEntity con estado 201 (Created) y en el cuerpo un nuevo rightManyToOneUnidirectional, o con estado 400 (Bad Request) si el usuario ya tiene un ID
     * @throws URISyntaxException Si la sintaxis de la URI no es correcta
     */
    @PostMapping("/rightManyToOneUnidirectional")
    @Timed
    public ResponseEntity<RightManyToOneUnidirectional> createRightManyToOneUnidirectional(@Valid @RequestBody RightManyToOneUnidirectional rightManyToOneUnidirectional) throws URISyntaxException {
        log.debug("REST request to save RightManyToOneUnidirectional : {}", rightManyToOneUnidirectional);
        if (rightManyToOneUnidirectional.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new rightManyToOneUnidirectional cannot already have an ID")).body(null);
        }
        RightManyToOneUnidirectional result = service.save(rightManyToOneUnidirectional);
        return ResponseEntity.created(new URI("/api/rightManyToOneUnidirectional/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }
    
    /**
     * PUT  /rightManyToOneUnidirectional : Actualiza un RightManyToOneUnidirectional existente.
     *
     * @param rightManyToOneUnidirectional el rightManyToOneUnidirectional que se desea actualizar
     * @return el objeto ResponseEntity con estado de 200 (OK) y en el cuerpo de la respuesta el RightManyToOneUnidirectional actualizado,
     * o con estatus de 400 (Bad Request) si el rightManyToOneUnidirectional no es valido,
     * o con estatus de 500 (Internal Server Error) si el rightManyToOneUnidirectional no se puede actualizar
     * @throws URISyntaxException si la sintaxis de la URI no es correcta
     */
    @PutMapping("/rightManyToOneUnidirectional")
    @Timed
    public ResponseEntity<RightManyToOneUnidirectional> updateRightManyToOneUnidirectional(@Valid @RequestBody RightManyToOneUnidirectional rightManyToOneUnidirectional) throws URISyntaxException {
        log.debug("REST request to update RightManyToOneUnidirectional : {}", rightManyToOneUnidirectional);
        if (rightManyToOneUnidirectional.getId() == null) {
            return createRightManyToOneUnidirectional(rightManyToOneUnidirectional);
        }
        RightManyToOneUnidirectional result = service.save(rightManyToOneUnidirectional);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, rightManyToOneUnidirectional.getId().toString()))
            .body(result);
    }


    /**
     * DELETE  /rightManyToOneUnidirectional/:id : borrar el RightManyToOneUnidirectional con "id".
     *
     * @param id el id del RightManyToOneUnidirectional que se desea borrar
     * @return el objeto ResponseEntity con estatus 200 (OK)
     */
    @DeleteMapping("/rightManyToOneUnidirectional/{id}")
    @Timed
    public ResponseEntity<Void> deleteRightManyToOneUnidirectional(@PathVariable Long id) {
        log.debug("REST request to delete RightManyToOneUnidirectional : {}", id);
        service.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/rightManyToOneUnidirectional?query=:query : buscar por el rightManyToOneUnidirectional correspondiente
     * to the query.
     *
     * @param query el query para el rightManyToOneUnidirectional que se desea buscar
     * @param pageable información de la paginación
     * @return el resultado de la busqueda
     */
    @GetMapping("/_search/rightManyToOneUnidirectional")
    @Timed
    public ResponseEntity<List<RightManyToOneUnidirectional>> searchRightManyToOneUnidirectional(@RequestParam String query, @ApiParam Pageable pageable) {
        log.debug("REST request to search for a page of RightManyToOneUnidirectional for query {}", query);
        Page<RightManyToOneUnidirectional> page = service.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/rightManyToOneUnidirectional");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }
    
}