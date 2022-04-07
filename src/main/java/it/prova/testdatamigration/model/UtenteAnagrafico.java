package it.prova.testdatamigration.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.boot.context.properties.ConfigurationProperties;

@Entity
@Table(name = "datianagrafici")
@ConfigurationProperties(prefix="spring.datasource")
public class UtenteAnagrafico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome", length = 45)
	private String nome;
	
	@Column(name = "cognome", length = 45)
	private String cognome;
	
	@Column(name = "dataNascita")
	private Date dataNascita;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	private UtenteFiscale utenteFiscale;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "utenteAnagrafico")
	private Set<Sinistro> sinistri = new HashSet<Sinistro>(0);
	

	public UtenteAnagrafico() {
	}

	public UtenteAnagrafico(Long id) {
		this.id = id;
	}

	public UtenteAnagrafico(Long id, String nome, String cognome, Date dataNascita, UtenteFiscale utenteFiscale, Set<Sinistro> sinistri) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.utenteFiscale = utenteFiscale;
		this.sinistri = sinistri;
	}

	public UtenteAnagrafico(Long id, String nome, String cognome, Date dataNascita, UtenteFiscale utenteFiscale) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.utenteFiscale = utenteFiscale;
	}
	
	

	public UtenteAnagrafico(String nome, String cognome, Date dataNascita, UtenteFiscale utenteFiscale, Set<Sinistro> sinistri) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.utenteFiscale = utenteFiscale;
		this.sinistri = sinistri;
	}

	public UtenteAnagrafico(String nome, String cognome, Date dataNascita, UtenteFiscale utenteFiscale) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.utenteFiscale = utenteFiscale;
	}

	public UtenteAnagrafico(Long id, String nome, String cognome, Date dataNascita) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
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

	public UtenteFiscale getUtenteFiscale() {
		return utenteFiscale;
	}

	public void setIdFiscale(UtenteFiscale utenteFiscale) {
		this.utenteFiscale = utenteFiscale;
	}

	public Set<Sinistro> getSinistri() {
		return sinistri;
	}

	public void setSinistri(Set<Sinistro> sinistri) {
		this.sinistri = sinistri;
	}
}