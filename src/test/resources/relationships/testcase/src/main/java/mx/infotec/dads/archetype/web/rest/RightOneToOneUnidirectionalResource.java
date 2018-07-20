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

import mx.infotec.dads.archetype.domain.RightOneToOneUnidirectional;
import mx.infotec.dads.archetype.service.RightOneToOneUnidirectionalService;

/**
 * 
 * @author kukulkan
 * @kukulkanGenerated 20180101000000
 */
@RestController
@RequestMapping("/api")
public class RightOneToOneUnidirectionalResource {

    private static final Logger log = LoggerFactory.getLogger(RightOneToOneUnidirectionalResource.class);
    
    private static final String ENTITY_NAME = "rightOneToOneUnidirectional";

    @Autowired
    private RightOneToOneUnidirectionalService service;
    
    /**
     * GET  /rightOneToOneUnidirectional : recupera todos los rightOneToOneUnidirectional.
     *
     * @param pageable información de paginación
     * @return El objeto ResponseEntity con estado de 200 (OK) y la lista de rightOneToOneUnidirectional en el cuerpo del mensaje
     */
    @GetMapping("/rightOneToOneUnidirectional")
    @Timed
    public ResponseEntity<List<RightOneToOneUnidirectional>> getAllRightOneToOneUnidirectional(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of RightOneToOneUnidirectional");
        Page<RightOneToOneUnidirectional> page = service.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/rightOneToOneUnidirectional");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /rightOneToOneUnidirectional/:id : recupera por "id" de RightOneToOneUnidirectional.
     *
     * @param id el id del RightOneToOneUnidirectional que se desea recuperar
     * @return El objeto ResponseEntity con el estado de 200 (OK) y dentro del cuerpo del mensaje el RightOneToOneUnidirectional, o con estado de 404 (Not Found)
     */
    @GetMapping("/rightOneToOneUnidirectional/{id}")
    @Timed
    public ResponseEntity<RightOneToOneUnidirectional> getRightOneToOneUnidirectional(@PathVariable Long id) {
        log.debug("REST request to get RightOneToOneUnidirectional : {}", id);
        RightOneToOneUnidirectional rightOneToOneUnidirectional = service.findById(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(rightOneToOneUnidirectional));
    }

    /**
     * POST  /rightOneToOneUnidirectional : Create a new usuario.
     *
     * @param rightOneToOneUnidirectional el rightOneToOneUnidirectional que se desea crear
     * @return El objeto ResponseEntity con estado 201 (Created) y en el cuerpo un nuevo rightOneToOneUnidirectional, o con estado 400 (Bad Request) si el usuario ya tiene un ID
     * @throws URISyntaxException Si la sintaxis de la URI no es correcta
     */
    @PostMapping("/rightOneToOneUnidirectional")
    @Timed
    public ResponseEntity<RightOneToOneUnidirectional> createRightOneToOneUnidirectional(@Valid @RequestBody RightOneToOneUnidirectional rightOneToOneUnidirectional) throws URISyntaxException {
        log.debug("REST request to save RightOneToOneUnidirectional : {}", rightOneToOneUnidirectional);
        if (rightOneToOneUnidirectional.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new rightOneToOneUnidirectional cannot already have an ID")).body(null);
        }
        RightOneToOneUnidirectional result = service.save(rightOneToOneUnidirectional);
        return ResponseEntity.created(new URI("/api/rightOneToOneUnidirectional/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }
    
    /**
     * PUT  /rightOneToOneUnidirectional : Actualiza un RightOneToOneUnidirectional existente.
     *
     * @param rightOneToOneUnidirectional el rightOneToOneUnidirectional que se desea actualizar
     * @return el objeto ResponseEntity con estado de 200 (OK) y en el cuerpo de la respuesta el RightOneToOneUnidirectional actualizado,
     * o con estatus de 400 (Bad Request) si el rightOneToOneUnidirectional no es valido,
     * o con estatus de 500 (Internal Server Error) si el rightOneToOneUnidirectional no se puede actualizar
     * @throws URISyntaxException si la sintaxis de la URI no es correcta
     */
    @PutMapping("/rightOneToOneUnidirectional")
    @Timed
    public ResponseEntity<RightOneToOneUnidirectional> updateRightOneToOneUnidirectional(@Valid @RequestBody RightOneToOneUnidirectional rightOneToOneUnidirectional) throws URISyntaxException {
        log.debug("REST request to update RightOneToOneUnidirectional : {}", rightOneToOneUnidirectional);
        if (rightOneToOneUnidirectional.getId() == null) {
            return createRightOneToOneUnidirectional(rightOneToOneUnidirectional);
        }
        RightOneToOneUnidirectional result = service.save(rightOneToOneUnidirectional);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, rightOneToOneUnidirectional.getId().toString()))
            .body(result);
    }


    /**
     * DELETE  /rightOneToOneUnidirectional/:id : borrar el RightOneToOneUnidirectional con "id".
     *
     * @param id el id del RightOneToOneUnidirectional que se desea borrar
     * @return el objeto ResponseEntity con estatus 200 (OK)
     */
    @DeleteMapping("/rightOneToOneUnidirectional/{id}")
    @Timed
    public ResponseEntity<Void> deleteRightOneToOneUnidirectional(@PathVariable Long id) {
        log.debug("REST request to delete RightOneToOneUnidirectional : {}", id);
        service.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/rightOneToOneUnidirectional?query=:query : buscar por el rightOneToOneUnidirectional correspondiente
     * to the query.
     *
     * @param query el query para el rightOneToOneUnidirectional que se desea buscar
     * @param pageable información de la paginación
     * @return el resultado de la busqueda
     */
    @GetMapping("/_search/rightOneToOneUnidirectional")
    @Timed
    public ResponseEntity<List<RightOneToOneUnidirectional>> searchRightOneToOneUnidirectional(@RequestParam String query, @ApiParam Pageable pageable) {
        log.debug("REST request to search for a page of RightOneToOneUnidirectional for query {}", query);
        Page<RightOneToOneUnidirectional> page = service.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/rightOneToOneUnidirectional");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }
    
}