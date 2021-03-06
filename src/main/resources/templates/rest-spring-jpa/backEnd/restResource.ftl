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

import java.util.List;
import java.util.Optional;

import com.codahale.metrics.annotation.Timed;
import io.swagger.annotations.ApiParam;
<#if entity.features.sheetable>
import mx.infotec.dads.kukulkan.tables.handsontable.Handsontable;
import mx.infotec.dads.kukulkan.tables.handsontable.HandsontableSlice;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.data.domain.Sort;
</#if>
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
import ${packageSimpleFormat}.util.HeaderUtil;
import ${packageSimpleFormat}.util.PaginationUtil;

${importModel}
<#if importPrimaryKey??>
${importPrimaryKey}
</#if>
${importService}

/**
 * 
 * @author ${author}
 * @kukulkanGenerated ${timestamp}
 */
@RestController
@RequestMapping("/api")
public class ${entity.name}Resource {

    private static final Logger log = LoggerFactory.getLogger(${entity.name}Resource.class);
    
    private static final String ENTITY_NAME = "${entityCamelCase}";

    @Autowired
    private ${entity.name}Service service;
    
    /**
     * GET  /${entityCamelCasePlural} : recupera todos los ${entityCamelCasePlural}.
     *
     * @param pageable información de paginación
     * @return El objeto ResponseEntity con estado de 200 (OK) y la lista de ${entityCamelCasePlural} en el cuerpo del mensaje
     */
    @GetMapping("/${entityCamelCasePlural}")
    @Timed
    public ResponseEntity<List<${entity.name}>> getAll${entity.name}(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of ${entity.name}");
        Page<${entity.name}> page = service.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/${entityCamelCasePlural}");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /${entityCamelCasePlural}/:id : recupera por "id" de ${entity.name}.
     *
     * @param id el id del ${entity.name} que se desea recuperar
     * @return El objeto ResponseEntity con el estado de 200 (OK) y dentro del cuerpo del mensaje el ${entity.name}, o con estado de 404 (Not Found)
     */
    @GetMapping("/${entityCamelCasePlural}/{id}")
    @Timed
    public ResponseEntity<${entity.name}> get${entity.name}(@PathVariable ${id} id) {
        log.debug("REST request to get ${entity.name} : {}", id);
        ${entity.name} ${entityCamelCase} = service.findById(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(${entityCamelCase}));
    }

    /**
     * POST  /${entityCamelCasePlural} : Create a new usuario.
     *
     * @param ${entityCamelCase} el ${entityCamelCase} que se desea crear
     * @return El objeto ResponseEntity con estado 201 (Created) y en el cuerpo un nuevo ${entityCamelCase}, o con estado 400 (Bad Request) si el usuario ya tiene un ID
     * @throws URISyntaxException Si la sintaxis de la URI no es correcta
     */
    @PostMapping("/${entityCamelCasePlural}")
    @Timed
    public ResponseEntity<${entity.name}> create${entity.name}(@Valid @RequestBody ${entity.name} ${entityCamelCase}) throws URISyntaxException {
        log.debug("REST request to save ${entity.name} : {}", ${entityCamelCase});
        if (${entityCamelCase}.get${primaryKey.name?cap_first}() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new ${entityCamelCase} cannot already have an ID")).body(null);
        }
        ${entity.name} result = service.save(${entityCamelCase});
        return ResponseEntity.created(new URI("/api/${entityCamelCasePlural}/" + result.get${primaryKey.name?cap_first}()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.get${primaryKey.name?cap_first}().toString()))
            .body(result);
    }
    
    /**
     * PUT  /${entityCamelCasePlural} : Actualiza un ${entity.name} existente.
     *
     * @param ${entityCamelCase} el ${entityCamelCase} que se desea actualizar
     * @return el objeto ResponseEntity con estado de 200 (OK) y en el cuerpo de la respuesta el ${entity.name} actualizado,
     * o con estatus de 400 (Bad Request) si el ${entityCamelCase} no es valido,
     * o con estatus de 500 (Internal Server Error) si el ${entityCamelCase} no se puede actualizar
     * @throws URISyntaxException si la sintaxis de la URI no es correcta
     */
    @PutMapping("/${entityCamelCasePlural}")
    @Timed
    public ResponseEntity<${entity.name}> update${entity.name}(@Valid @RequestBody ${entity.name} ${entityCamelCase}) throws URISyntaxException {
        log.debug("REST request to update ${entity.name} : {}", ${entityCamelCase});
        if (${entityCamelCase}.get${primaryKey.name?cap_first}() == null) {
            return create${entity.name}(${entityCamelCase});
        }
        ${entity.name} result = service.save(${entityCamelCase});
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, ${entityCamelCase}.get${primaryKey.name?cap_first}().toString()))
            .body(result);
    }


    /**
     * DELETE  /${entityCamelCasePlural}/:id : borrar el ${entity.name} con "id".
     *
     * @param id el id del ${entity.name} que se desea borrar
     * @return el objeto ResponseEntity con estatus 200 (OK)
     */
    @DeleteMapping("/${entityCamelCasePlural}/{id}")
    @Timed
    public ResponseEntity<Void> delete${entity.name}(@PathVariable ${id} id) {
        log.debug("REST request to delete ${entity.name} : {}", id);
        service.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/${entityCamelCasePlural}?query=:query : buscar por el ${entityCamelCase} correspondiente
     * to the query.
     *
     * @param query el query para el ${entityCamelCase} que se desea buscar
     * @param pageable información de la paginación
     * @return el resultado de la busqueda
     */
    @GetMapping("/_search/${entityCamelCasePlural}")
    @Timed
    public ResponseEntity<List<${entity.name}>> search${entity.name}(@RequestParam String query, @ApiParam Pageable pageable) {
        log.debug("REST request to search for a page of ${entity.name} for query {}", query);
        Page<${entity.name}> page = service.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/${entityCamelCasePlural}");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }
    
    <#if entity.features.sheetable>
    /**
     * GET /${entityCamelCasePlural}/workbook : recupera un workbook de ${entityCamelCasePlural}.
     * 
     * @return Un archivo workbook con extensión xlsx de ${entityCamelCasePlural}.
     */
    @GetMapping(produces = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet.main+xml", path = "/${entityCamelCasePlural}/workbook")
    @Timed
    public ResponseEntity<StreamingResponseBody> get${entityCamelCase}Workbook(@ApiParam Sort sort) {
        log.debug("REST request to get ${entityCamelCase} Workbook");
        SXSSFWorkbook wb = service.getWorkbook(sort);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + "${entityCamelCasePlural}.xlsx" + "\"")
                .body((os) -> {
                    wb.write(os);
                });
    }
    </#if>
    
}