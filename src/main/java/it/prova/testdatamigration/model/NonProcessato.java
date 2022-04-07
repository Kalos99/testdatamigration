package it.prova.testdatamigration.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.context.properties.ConfigurationProperties;

@Entity
@Table(name = "not_processed")
@ConfigurationProperties(prefix="spring.secondDatasource")
public class NonProcessato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "codiceFiscale", length = 16)
	private String codiceFiscale;
	
	@Column(name = "id_oldDB")
	private Long oldDB_id;

	public NonProcessato() {
	}

	public NonProcessato(Long id) {
		this.id = id;
	}

	public NonProcessato(Long id, String codiceFiscale, Long oldDB_id) {
		this.id = id;
		this.codiceFiscale = codiceFiscale;
		this.oldDB_id = oldDB_id;
	}

	public NonProcessato(String codiceFiscale, Long oldDB_id) {
		this.codiceFiscale = codiceFiscale;
		this.oldDB_id = oldDB_id;
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

	public Long getOldDB_id() {
		return oldDB_id;
	}

	public void setOldDB_id(Long oldDB_id) {
		this.oldDB_id = oldDB_id;
	}
}