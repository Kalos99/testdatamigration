package it.prova.testdatamigration.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.boot.context.properties.ConfigurationProperties;

@Entity
@Table(name = "datifiscali")
@ConfigurationProperties(prefix="spring.datasource")
public class UtenteFiscale {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "codiceFiscale", length = 16)
	private String codiceFiscale;
	
	@OneToOne(mappedBy = "utenteFiscale")
	private UtenteAnagrafico anagrafica;

	public UtenteFiscale() {
	}

	public UtenteFiscale(Long id) {
		this.id = id;
	}

	public UtenteFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public UtenteFiscale(Long id, String codiceFiscale) {
		this.id = id;
		this.codiceFiscale = codiceFiscale;
	}
	
	public UtenteFiscale(String codiceFiscale, UtenteAnagrafico anagrafica) {
		this.codiceFiscale = codiceFiscale;
		this.anagrafica = anagrafica;
	}

	public UtenteFiscale(Long id, String codiceFiscale, UtenteAnagrafico anagrafica) {
		this.id = id;
		this.codiceFiscale = codiceFiscale;
		this.anagrafica = anagrafica;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public UtenteAnagrafico getAnagrafica() {
		return anagrafica;
	}

	public void setAnagrafica(UtenteAnagrafico anagrafica) {
		this.anagrafica = anagrafica;
	}
}