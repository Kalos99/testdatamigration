package it.prova.testdatamigration.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.prova.testdatamigration.model.UtenteFiscale;

public interface TestDataMigrationRepository extends CrudRepository<UtenteFiscale, Long>, JpaSpecificationExecutor<UtenteFiscale>{
	
	@Query("from UtenteFiscale uf left join fetch uf.utenteAnagrafico ua left join fetch ua.sinistri s")
	List<UtenteFiscale> listAllEager();
	
	@Query("from UtenteFiscale uf left join fetch uf.utenteAnagrafico ua left join fetch ua.sinistri s where uf.id = ?1")
	Optional<UtenteFiscale>findByIdEager(Long id);

}