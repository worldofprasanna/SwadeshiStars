package org.swadeshi.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.RepositoryDefinition;
import org.swadeshi.entities.Appreciation;

@RepositoryDefinition(domainClass = Appreciation.class, idClass = Long.class)
public interface AppreciationDao extends CrudRepository<Appreciation, Long> {

	Page<Appreciation> findAll(Pageable p);
}
