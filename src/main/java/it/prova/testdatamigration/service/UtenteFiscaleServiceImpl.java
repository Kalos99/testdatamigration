package it.prova.testdatamigration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.prova.testdatamigration.model.Assicurato;
import it.prova.testdatamigration.model.NonProcessato;
import it.prova.testdatamigration.model.UtenteFiscale;
import it.prova.testdatamigration.repository.AssicuratoRepository;
import it.prova.testdatamigration.repository.NonProcessatoRepository;
import it.prova.testdatamigration.repository.UtenteFiscaleRepository;
import it.prova.testdatamigration.utility.UtilityForm;

@Service
public class UtenteFiscaleServiceImpl implements UtenteFiscaleService{
	
	@Autowired
	private UtenteFiscaleRepository repository;
	
	@Autowired 
	private AssicuratoRepository assicuratoRepository;
	
	@Autowired 
	private NonProcessatoRepository nonProcessatoRepository;

	@Override
	public void migrate() {
		List<UtenteFiscale> elencoRecordDatabaseCompleto = repository.listAllEager();
		if(elencoRecordDatabaseCompleto == null || elencoRecordDatabaseCompleto.isEmpty()) {
			throw new NullPointerException("Database vuoto");
		}
		for(UtenteFiscale utenteFiscaleItem:elencoRecordDatabaseCompleto) {
			if(UtilityForm.validateUtenteBean(utenteFiscaleItem)) {
				Integer numeroIncidenti = repository.countSinistri(utenteFiscaleItem.getId());
				Assicurato nuovoRecord = new Assicurato(utenteFiscaleItem.getAnagrafica().getNome(), utenteFiscaleItem.getAnagrafica().getCognome(), utenteFiscaleItem.getAnagrafica().getDataNascita(), utenteFiscaleItem.getCodiceFiscale(), numeroIncidenti);
				assicuratoRepository.save(nuovoRecord);
			}
			else {
				NonProcessato erroreDiMigrazione = new NonProcessato(utenteFiscaleItem.getCodiceFiscale(), utenteFiscaleItem.getId());
				nonProcessatoRepository.save(erroreDiMigrazione);
			}
		}
	}
}