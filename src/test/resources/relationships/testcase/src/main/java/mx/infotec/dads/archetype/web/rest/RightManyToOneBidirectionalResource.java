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

import mx.infotec.dads.archetype.domain.RightManyToOneBidirectional;
import mx.infotec.dads.archetype.service.RightManyToOneBidirectionalService;

/**
 * 
 * @author kukulkan
 * @kukulkanGenerated 20180101000000
 */
@RestController
@RequestMapping("/api")
public class RightManyToOneBidirectionalResource {

    private static final Logger log = LoggerFactory.getLogger(RightManyToOneBidirectionalResource.class);
    
    private static final String ENTITY_NAME = "rightManyToOneBidirectional";

    @Autowired
    private RightManyToOneBidirectionalService service;
    
    /**
     * GET  /rightManyToOneBidirectional : recupera todos los rightManyToOneBidirectional.
     *
     * @param pageable información de paginación
     * @return El objeto ResponseEntity con estado de 200 (OK) y la lista de rightManyToOneBidirectional en el cuerpo del mensaje
     */
    @GetMapping("/rightManyToOneBidirectional")
    @Timed
    public ResponseEntity<List<RightManyToOneBidirectional>> getAllRightManyToOneBidirectional(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of RightManyToOneBidirectional");
        Page<RightManyToOneBidirectional> page = service.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/rightManyToOneBidirectional");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /rightManyToOneBidirectional/:id : recupera por "id" de RightManyToOneBidirectional.
     *
     * @param id el id del RightManyToOneBidirectional que se desea recuperar
     * @return El objeto ResponseEntity con el estado de 200 (OK) y dentro del cuerpo del mensaje el RightManyToOneBidirectional, o con estado de 404 (Not Found)
     */
    @GetMapping("/rightManyToOneBidirectional/{id}")
    @Timed
    public ResponseEntity<RightManyToOneBidirectional> getRightManyToOneBidirectional(@PathVariable Long id) {
        log.debug("REST request to get RightManyToOneBidirectional : {}", id);
        RightManyToOneBidirectional rightManyToOneBidirectional = service.findById(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(rightManyToOneBidirectional));
    }

    /**
     * POST  /rightManyToOneBidirectional : Create a new usuario.
     *
     * @param rightManyToOneBidirectional el rightManyToOneBidirectional que se desea crear
     * @return El objeto ResponseEntity con estado 201 (Created) y en el cuerpo un nuevo rightManyToOneBidirectional, o con estado 400 (Bad Request) si el usuario ya tiene un ID
     * @throws URISyntaxException Si la sintaxis de la URI no es correcta
     */
    @PostMapping("/rightManyToOneBidirectional")
    @Timed
    public ResponseEntity<RightManyToOneBidirectional> createRightManyToOneBidirectional(@Valid @RequestBody RightManyToOneBidirectional rightManyToOneBidirectional) throws URISyntaxException {
        log.debug("REST request to save RightManyToOneBidirectional : {}", rightManyToOneBidirectional);
        if (rightManyToOneBidirectional.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new rightManyToOneBidirectional cannot already have an ID")).body(null);
        }
        RightManyToOneBidirectional result = service.save(rightManyToOneBidirectional);
        return ResponseEntity.created(new URI("/api/rightManyToOneBidirectional/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }
    
    /**
     * PUT  /rightManyToOneBidirectional : Actualiza un RightManyToOneBidirectional existente.
     *
     * @param rightManyToOneBidirectional el rightManyToOneBidirectional que se desea actualizar
     * @return el objeto ResponseEntity con estado de 200 (OK) y en el cuerpo de la respuesta el RightManyToOneBidirectional actualizado,
     * o con estatus de 400 (Bad Request) si el rightManyToOneBidirectional no es valido,
     * o con estatus de 500 (Internal Server Error) si el rightManyToOneBidirectional no se puede actualizar
     * @throws URISyntaxException si la sintaxis de la URI no es correcta
     */
    @PutMapping("/rightManyToOneBidirectional")
    @Timed
    public ResponseEntity<RightManyToOneBidirectional> updateRightManyToOneBidirectional(@Valid @RequestBody RightManyToOneBidirectional rightManyToOneBidirectional) throws URISyntaxException {
        log.debug("REST request to update RightManyToOneBidirectional : {}", rightManyToOneBidirectional);
        if (rightManyToOneBidirectional.getId() == null) {
            return createRightManyToOneBidirectional(rightManyToOneBidirectional);
        }
        RightManyToOneBidirectional result = service.save(rightManyToOneBidirectional);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, rightManyToOneBidirectional.getId().toString()))
            .body(result);
    }


    /**
     * DELETE  /rightManyToOneBidirectional/:id : borrar el RightManyToOneBidirectional con "id".
     *
     * @param id el id del RightManyToOneBidirectional que se desea borrar
     * @return el objeto ResponseEntity con estatus 200 (OK)
     */
    @DeleteMapping("/rightManyToOneBidirectional/{id}")
    @Timed
    public ResponseEntity<Void> deleteRightManyToOneBidirectional(@PathVariable Long id) {
        log.debug("REST request to delete RightManyToOneBidirectional : {}", id);
        service.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/rightManyToOneBidirectional?query=:query : buscar por el rightManyToOneBidirectional correspondiente
     * to the query.
     *
     * @param query el query para el rightManyToOneBidirectional que se desea buscar
     * @param pageable información de la paginación
     * @return el resultado de la busqueda
     */
    @GetMapping("/_search/rightManyToOneBidirectional")
    @Timed
    public ResponseEntity<List<RightManyToOneBidirectional>> searchRightManyToOneBidirectional(@RequestParam String query, @ApiParam Pageable pageable) {
        log.debug("REST request to search for a page of RightManyToOneBidirectional for query {}", query);
        Page<RightManyToOneBidirectional> page = service.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/rightManyToOneBidirectional");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }
    
}