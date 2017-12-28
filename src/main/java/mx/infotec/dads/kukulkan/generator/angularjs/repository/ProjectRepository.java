package mx.infotec.dads.kukulkan.generator.angularjs.repository;

import org.springframework.stereotype.Repository;

import mx.infotec.dads.kukulkan.generator.angularjs.domain.Project;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Spring Data MongoDB repository for the Project entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProjectRepository extends MongoRepository<Project, String> {

}