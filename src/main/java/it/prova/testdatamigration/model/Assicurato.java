package it.prova.testdatamigration.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.context.properties.ConfigurationProperties;

@Entity
@Table(name = "assicurato")
@ConfigurationProperties(prefix="spring.secondDatasource")
public class Assicurato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome", length = 45)
	private String nome;
	
	@Column(name = "nome", length = 45)
	private String cognome;
	
	@Column(name = "dataNascita")
	private Date dataNascita;
	
	@Column(name = "codiceFiscale", length = 16)
	private String codiceFiscale;
	
	@Column(name = "numSinistri")
	private Integer numSinistri;

	public Assicurato() {
	}

	public Assicurato(Long id) {
		this.id = id;
	}

	public Assicurato(Long id, String nome, String cognome, Date dataNascita, String codiceFiscale, Integer numSinistri) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.codiceFiscale = codiceFiscale;
		this.numSinistri = numSinistri;
	}

	public Assicurato(String nome, String cognome, Date dataNascita, String codiceFiscale, Integer numSinistri) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.codiceFiscale = codiceFiscale;
		this.numSinistri = numSinistri;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public Integer getNumSinistri() {
		return numSinistri;
	}

	public void setNumSinistri(Integer numSinistri) {
		this.numSinistri = numSinistri;
	}
}