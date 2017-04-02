package br.edu.ifpb.sace.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Seguro {
	
	@Id
	@Column(name="SEGURO_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="NOME_EMPRESA")
	private String nomeDaEmpresa;

	@Column(name="NUM_APOLICE")	
	private int numApolice;
	
	@Temporal(TemporalType.DATE)
	@Column(name="VALIDO_DE")
	private Date validoDe;
	
	@Temporal(TemporalType.DATE)
	@Column(name="VALIDO_ATE")
	private Date validoAte;
	
	@Column(name="CORRETOR")
	private String corretor;
	
	@Column(name="TELEFONE")
	private String telefone;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getValidoDe() {
		return validoDe;
	}

	public void setValidoDe(Date validoDe) {
		this.validoDe = validoDe;
	}

	public Date getValidoAte() {
		return validoAte;
	}

	public void setValidoAte(Date validoAte) {
		this.validoAte = validoAte;
	}

	public String getCorretor() {
		return corretor;
	}

	public void setCorretor(String corretor) {
		this.corretor = corretor;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNomeDaEmpresa() {
		return nomeDaEmpresa;
	}

	public void setNomeDaEmpresa(String nomeDaEmpresa) {
		this.nomeDaEmpresa = nomeDaEmpresa;
	}

	public int getNumApolice() {
		return numApolice;
	}

	public void setNumApolice(int numApolice) {
		this.numApolice = numApolice;
	}
	
}
