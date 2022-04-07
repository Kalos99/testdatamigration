package it.prova.testdatamigration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.prova.testdatamigration.model.UtenteFiscale;
import it.prova.testdatamigration.repository.TestDataMigrationRepository;


@Service
public class TestDataMigrationServiceImpl implements TestDataMigrationService{
	
	@Autowired
	private TestDataMigrationRepository repository;

	@Override
	public List<UtenteFiscale> listAllUtenti() {
		return repository.listAllEager();
	}

	@Override
	public UtenteFiscale caricaSingoloUtente(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	@Override
	public UtenteFiscale caricaSingoloUtenteEager(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public void aggiorna(UtenteFiscale utenteInstance) {
		repository.save(utenteInstance);
	}

	@Override
	public void inserisciNuovo(UtenteFiscale utenteInstance) {
		repository.save(utenteInstance);
	}

	@Override
	public void rimuovi(UtenteFiscale utenteInstance) {
		repository.delete(utenteInstance);
	}
}