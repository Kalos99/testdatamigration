package it.prova.testdatamigration.utility;

import it.prova.testdatamigration.model.UtenteFiscale;

public class UtilityForm {
	
	public static boolean validateUtenteBean(UtenteFiscale utenteToBeValidated) {
		// prima controlliamo che non siano vuoti i parametri
		if (utenteToBeValidated.getAnagrafica().getNome().isBlank() || utenteToBeValidated.getAnagrafica().getNome().matches(".*[0-9].*") 
			|| utenteToBeValidated.getAnagrafica().getCognome().isBlank() || utenteToBeValidated.getAnagrafica().getCognome().matches(".*[0-9].*")
			|| utenteToBeValidated.getCodiceFiscale().isBlank() || utenteToBeValidated.getCodiceFiscale().length() != 16
			|| utenteToBeValidated.getAnagrafica().getDataNascita() == null) {
			return false;
		}
		return true;
	}

}