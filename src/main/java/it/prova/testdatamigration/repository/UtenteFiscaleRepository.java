package it.prova.testdatamigration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.prova.testdatamigration.model.UtenteFiscale;

public interface UtenteFiscaleRepository extends CrudRepository<UtenteFiscale, Long>{
	
	@Query("from UtenteFiscale uf left join fetch uf.utenteAnagrafico ua left join fetch ua.sinistri s")
	List<UtenteFiscale> listAllEager();
	

	@Query("select count(da.id) from UtenteFiscale uf left join fetch uf.utenteAnagrafico ua left join fetch ua.sinistri s where da.id = ?1")
	Integer countSinistri(Long id);
}