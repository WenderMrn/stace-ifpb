package br.edu.ifpb.stace.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.edu.ifpb.inheritance.PessoaJuridica;

@Entity
@Table(name="EMPRESA")
public class Empresa extends PessoaJuridica{

	@Column(name="SITE")
	private String site;
	
	@Column(name="ENDERECO")
	private String endereco;
	
	@OneToMany(cascade=CascadeType.ALL)
	@Column(name="OFT_ESTAGIO")
	private List<OfertaEstagio> ofertadasEstagio;
	
	@Column(name="STATUS")
	private String status;

	
	@JoinColumn(name="RESPONSAVEL")
	private String responsavel;
	
	
	public Empresa(){
		this.ofertadasEstagio = new ArrayList<OfertaEstagio>(); 
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<OfertaEstagio> getOfertadasEstagio() {
		return ofertadasEstagio;
	}
	
	public void setOfertadasEstagio(List<OfertaEstagio> ofertadasEstagio) {
		this.ofertadasEstagio = ofertadasEstagio;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public void addOfertaEstagio(OfertaEstagio of){
		this.ofertadasEstagio.add(of);
	}
	
	public void removerOfertaEstagio(OfertaEstagio of){
		this.ofertadasEstagio.remove(of);
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	
}
