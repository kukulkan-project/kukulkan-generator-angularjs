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
package mx.infotec.dads.archetype.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import mx.infotec.dads.archetype.domain.RightOneToManyUnidirectional;
import mx.infotec.dads.archetype.repository.RightOneToManyUnidirectionalRepository;
import mx.infotec.dads.archetype.service.RightOneToManyUnidirectionalService;

/**
 * RightOneToManyUnidirectionalServiceImpl
 * 
 * @author kukulkan
 * @kukulkanGenerated 20180101000000
 */
@Service
@Transactional
public class RightOneToManyUnidirectionalServiceImpl implements RightOneToManyUnidirectionalService {

    private final Logger log = LoggerFactory.getLogger(RightOneToManyUnidirectionalServiceImpl.class);

    @Autowired
    private RightOneToManyUnidirectionalRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Page<RightOneToManyUnidirectional> findAll(Pageable pageable) {
        log.debug("Request to get all RightOneToManyUnidirectional");
        return repository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public RightOneToManyUnidirectional findById(Long id) {
        log.debug("Request to get RightOneToManyUnidirectional : {}", id);
        return repository.findOne(id);
    }

    @Override
    public RightOneToManyUnidirectional save(RightOneToManyUnidirectional rightOneToManyUnidirectional) {
        return repository.save(rightOneToManyUnidirectional);
    }

    @Override
    public boolean exists(Long id) {
        return repository.exists(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete RightOneToManyUnidirectional : {}", id);
        repository.delete(id);
    }

    @Override
    public void deleteAll() {
        log.debug("Request to delete All RightOneToManyUnidirectional");
        repository.deleteAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Page<RightOneToManyUnidirectional> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of RightOneToManyUnidirectional ");
        return repository.findAll(pageable);
    }
}
