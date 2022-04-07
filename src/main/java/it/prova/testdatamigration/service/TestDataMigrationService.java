package it.prova.testdatamigration.service;

import java.util.List;

import it.prova.testdatamigration.model.UtenteFiscale;

public interface TestDataMigrationService {
	
	public List<UtenteFiscale> listAllUtenti();

	public UtenteFiscale caricaSingoloUtente(Long id);
	
	public UtenteFiscale caricaSingoloUtenteEager(Long id);

	public void aggiorna(UtenteFiscale utenteInstance);

	public void inserisciNuovo(UtenteFiscale utenteInstance);

	public void rimuovi(UtenteFiscale utenteInstance);
}