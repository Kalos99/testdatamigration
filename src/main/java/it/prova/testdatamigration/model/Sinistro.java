package it.prova.testdatamigration.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.boot.context.properties.ConfigurationProperties;

@Entity
@Table(name = "sinistri")
@ConfigurationProperties(prefix="spring.datasource")
public class Sinistro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "tipo")
	private String tipo;
	
	@Column(name = "data")
	private Date data;
	
	@Column(name = "luogo")
	private String luogo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_anagrafica", nullable = false)
	private UtenteAnagrafico utenteAnagrafico;

	public Sinistro() {
	}

	public Sinistro(Long id) {
		this.id = id;
	}

	public Sinistro(Long id, String tipo, Date data, String luogo, UtenteAnagrafico utenteAnagrafico) {
		this.id = id;
		this.tipo = tipo;
		this.data = data;
		this.luogo = luogo;
		this.utenteAnagrafico = utenteAnagrafico;
	}

	public Sinistro(String tipo, Date data, String luogo, UtenteAnagrafico utenteAnagrafico) {
		this.tipo = tipo;
		this.data = data;
		this.luogo = luogo;
		this.utenteAnagrafico = utenteAnagrafico;
	}

	public Sinistro(Long id, String tipo, Date data, String luogo) {
		this.id = id;
		this.tipo = tipo;
		this.data = data;
		this.luogo = luogo;
	}

	public Sinistro(String tipo, Date data, String luogo) {
		this.tipo = tipo;
		this.data = data;
		this.luogo = luogo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getLuogo() {
		return luogo;
	}

	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}

	public UtenteAnagrafico getUtenteAnagrafico() {
		return utenteAnagrafico;
	}

	public void setIdAnagrafica(UtenteAnagrafico utenteAnagrafico) {
		this.utenteAnagrafico = utenteAnagrafico;
	}
}