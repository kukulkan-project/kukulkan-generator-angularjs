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

import mx.infotec.dads.archetype.domain.LeftUnidirectional;
import mx.infotec.dads.archetype.service.LeftUnidirectionalService;

/**
 * 
 * @author kukulkan
 * @kukulkanGenerated 20180101000000
 */
@RestController
@RequestMapping("/api")
public class LeftUnidirectionalResource {

    private static final Logger log = LoggerFactory.getLogger(LeftUnidirectionalResource.class);
    
    private static final String ENTITY_NAME = "leftUnidirectional";

    @Autowired
    private LeftUnidirectionalService service;
    
    /**
     * GET  /leftUnidirectional : recupera todos los leftUnidirectional.
     *
     * @param pageable información de paginación
     * @return El objeto ResponseEntity con estado de 200 (OK) y la lista de leftUnidirectional en el cuerpo del mensaje
     */
    @GetMapping("/leftUnidirectional")
    @Timed
    public ResponseEntity<List<LeftUnidirectional>> getAllLeftUnidirectional(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of LeftUnidirectional");
        Page<LeftUnidirectional> page = service.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/leftUnidirectional");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /leftUnidirectional/:id : recupera por "id" de LeftUnidirectional.
     *
     * @param id el id del LeftUnidirectional que se desea recuperar
     * @return El objeto ResponseEntity con el estado de 200 (OK) y dentro del cuerpo del mensaje el LeftUnidirectional, o con estado de 404 (Not Found)
     */
    @GetMapping("/leftUnidirectional/{id}")
    @Timed
    public ResponseEntity<LeftUnidirectional> getLeftUnidirectional(@PathVariable Long id) {
        log.debug("REST request to get LeftUnidirectional : {}", id);
        LeftUnidirectional leftUnidirectional = service.findById(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(leftUnidirectional));
    }

    /**
     * POST  /leftUnidirectional : Create a new usuario.
     *
     * @param leftUnidirectional el leftUnidirectional que se desea crear
     * @return El objeto ResponseEntity con estado 201 (Created) y en el cuerpo un nuevo leftUnidirectional, o con estado 400 (Bad Request) si el usuario ya tiene un ID
     * @throws URISyntaxException Si la sintaxis de la URI no es correcta
     */
    @PostMapping("/leftUnidirectional")
    @Timed
    public ResponseEntity<LeftUnidirectional> createLeftUnidirectional(@Valid @RequestBody LeftUnidirectional leftUnidirectional) throws URISyntaxException {
        log.debug("REST request to save LeftUnidirectional : {}", leftUnidirectional);
        if (leftUnidirectional.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new leftUnidirectional cannot already have an ID")).body(null);
        }
        LeftUnidirectional result = service.save(leftUnidirectional);
        return ResponseEntity.created(new URI("/api/leftUnidirectional/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }
    
    /**
     * PUT  /leftUnidirectional : Actualiza un LeftUnidirectional existente.
     *
     * @param leftUnidirectional el leftUnidirectional que se desea actualizar
     * @return el objeto ResponseEntity con estado de 200 (OK) y en el cuerpo de la respuesta el LeftUnidirectional actualizado,
     * o con estatus de 400 (Bad Request) si el leftUnidirectional no es valido,
     * o con estatus de 500 (Internal Server Error) si el leftUnidirectional no se puede actualizar
     * @throws URISyntaxException si la sintaxis de la URI no es correcta
     */
    @PutMapping("/leftUnidirectional")
    @Timed
    public ResponseEntity<LeftUnidirectional> updateLeftUnidirectional(@Valid @RequestBody LeftUnidirectional leftUnidirectional) throws URISyntaxException {
        log.debug("REST request to update LeftUnidirectional : {}", leftUnidirectional);
        if (leftUnidirectional.getId() == null) {
            return createLeftUnidirectional(leftUnidirectional);
        }
        LeftUnidirectional result = service.save(leftUnidirectional);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, leftUnidirectional.getId().toString()))
            .body(result);
    }


    /**
     * DELETE  /leftUnidirectional/:id : borrar el LeftUnidirectional con "id".
     *
     * @param id el id del LeftUnidirectional que se desea borrar
     * @return el objeto ResponseEntity con estatus 200 (OK)
     */
    @DeleteMapping("/leftUnidirectional/{id}")
    @Timed
    public ResponseEntity<Void> deleteLeftUnidirectional(@PathVariable Long id) {
        log.debug("REST request to delete LeftUnidirectional : {}", id);
        service.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/leftUnidirectional?query=:query : buscar por el leftUnidirectional correspondiente
     * to the query.
     *
     * @param query el query para el leftUnidirectional que se desea buscar
     * @param pageable información de la paginación
     * @return el resultado de la busqueda
     */
    @GetMapping("/_search/leftUnidirectional")
    @Timed
    public ResponseEntity<List<LeftUnidirectional>> searchLeftUnidirectional(@RequestParam String query, @ApiParam Pageable pageable) {
        log.debug("REST request to search for a page of LeftUnidirectional for query {}", query);
        Page<LeftUnidirectional> page = service.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/leftUnidirectional");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }
    
}