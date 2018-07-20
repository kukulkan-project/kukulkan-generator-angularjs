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

import mx.infotec.dads.archetype.domain.RightManyToManyBidirectional;
import mx.infotec.dads.archetype.service.RightManyToManyBidirectionalService;

/**
 * 
 * @author kukulkan
 * @kukulkanGenerated 20180101000000
 */
@RestController
@RequestMapping("/api")
public class RightManyToManyBidirectionalResource {

    private static final Logger log = LoggerFactory.getLogger(RightManyToManyBidirectionalResource.class);
    
    private static final String ENTITY_NAME = "rightManyToManyBidirectional";

    @Autowired
    private RightManyToManyBidirectionalService service;
    
    /**
     * GET  /rightManyToManyBidirectional : recupera todos los rightManyToManyBidirectional.
     *
     * @param pageable información de paginación
     * @return El objeto ResponseEntity con estado de 200 (OK) y la lista de rightManyToManyBidirectional en el cuerpo del mensaje
     */
    @GetMapping("/rightManyToManyBidirectional")
    @Timed
    public ResponseEntity<List<RightManyToManyBidirectional>> getAllRightManyToManyBidirectional(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of RightManyToManyBidirectional");
        Page<RightManyToManyBidirectional> page = service.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/rightManyToManyBidirectional");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /rightManyToManyBidirectional/:id : recupera por "id" de RightManyToManyBidirectional.
     *
     * @param id el id del RightManyToManyBidirectional que se desea recuperar
     * @return El objeto ResponseEntity con el estado de 200 (OK) y dentro del cuerpo del mensaje el RightManyToManyBidirectional, o con estado de 404 (Not Found)
     */
    @GetMapping("/rightManyToManyBidirectional/{id}")
    @Timed
    public ResponseEntity<RightManyToManyBidirectional> getRightManyToManyBidirectional(@PathVariable Long id) {
        log.debug("REST request to get RightManyToManyBidirectional : {}", id);
        RightManyToManyBidirectional rightManyToManyBidirectional = service.findById(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(rightManyToManyBidirectional));
    }

    /**
     * POST  /rightManyToManyBidirectional : Create a new usuario.
     *
     * @param rightManyToManyBidirectional el rightManyToManyBidirectional que se desea crear
     * @return El objeto ResponseEntity con estado 201 (Created) y en el cuerpo un nuevo rightManyToManyBidirectional, o con estado 400 (Bad Request) si el usuario ya tiene un ID
     * @throws URISyntaxException Si la sintaxis de la URI no es correcta
     */
    @PostMapping("/rightManyToManyBidirectional")
    @Timed
    public ResponseEntity<RightManyToManyBidirectional> createRightManyToManyBidirectional(@Valid @RequestBody RightManyToManyBidirectional rightManyToManyBidirectional) throws URISyntaxException {
        log.debug("REST request to save RightManyToManyBidirectional : {}", rightManyToManyBidirectional);
        if (rightManyToManyBidirectional.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new rightManyToManyBidirectional cannot already have an ID")).body(null);
        }
        RightManyToManyBidirectional result = service.save(rightManyToManyBidirectional);
        return ResponseEntity.created(new URI("/api/rightManyToManyBidirectional/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }
    
    /**
     * PUT  /rightManyToManyBidirectional : Actualiza un RightManyToManyBidirectional existente.
     *
     * @param rightManyToManyBidirectional el rightManyToManyBidirectional que se desea actualizar
     * @return el objeto ResponseEntity con estado de 200 (OK) y en el cuerpo de la respuesta el RightManyToManyBidirectional actualizado,
     * o con estatus de 400 (Bad Request) si el rightManyToManyBidirectional no es valido,
     * o con estatus de 500 (Internal Server Error) si el rightManyToManyBidirectional no se puede actualizar
     * @throws URISyntaxException si la sintaxis de la URI no es correcta
     */
    @PutMapping("/rightManyToManyBidirectional")
    @Timed
    public ResponseEntity<RightManyToManyBidirectional> updateRightManyToManyBidirectional(@Valid @RequestBody RightManyToManyBidirectional rightManyToManyBidirectional) throws URISyntaxException {
        log.debug("REST request to update RightManyToManyBidirectional : {}", rightManyToManyBidirectional);
        if (rightManyToManyBidirectional.getId() == null) {
            return createRightManyToManyBidirectional(rightManyToManyBidirectional);
        }
        RightManyToManyBidirectional result = service.save(rightManyToManyBidirectional);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, rightManyToManyBidirectional.getId().toString()))
            .body(result);
    }


    /**
     * DELETE  /rightManyToManyBidirectional/:id : borrar el RightManyToManyBidirectional con "id".
     *
     * @param id el id del RightManyToManyBidirectional que se desea borrar
     * @return el objeto ResponseEntity con estatus 200 (OK)
     */
    @DeleteMapping("/rightManyToManyBidirectional/{id}")
    @Timed
    public ResponseEntity<Void> deleteRightManyToManyBidirectional(@PathVariable Long id) {
        log.debug("REST request to delete RightManyToManyBidirectional : {}", id);
        service.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/rightManyToManyBidirectional?query=:query : buscar por el rightManyToManyBidirectional correspondiente
     * to the query.
     *
     * @param query el query para el rightManyToManyBidirectional que se desea buscar
     * @param pageable información de la paginación
     * @return el resultado de la busqueda
     */
    @GetMapping("/_search/rightManyToManyBidirectional")
    @Timed
    public ResponseEntity<List<RightManyToManyBidirectional>> searchRightManyToManyBidirectional(@RequestParam String query, @ApiParam Pageable pageable) {
        log.debug("REST request to search for a page of RightManyToManyBidirectional for query {}", query);
        Page<RightManyToManyBidirectional> page = service.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/rightManyToManyBidirectional");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }
    
}