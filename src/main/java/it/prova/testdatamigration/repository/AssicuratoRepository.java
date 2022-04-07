package it.prova.testdatamigration.repository;

import org.springframework.data.repository.CrudRepository;

import it.prova.testdatamigration.model.Assicurato;

public interface AssicuratoRepository extends CrudRepository<Assicurato, Long> {

}