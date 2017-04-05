package br.edu.ifpb.stace.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.edu.ifpb.stace.abstractentity.AbstractEstagio;
import br.edu.ifpb.stace.util.StatusOfertaEstagio;

@Entity
public class OfertaEstagio extends AbstractEstagio {
	
	@Column(name="REQUISITOS")
	private String requisitos;
	
	@Column(name="QTDE_VAGAS")
	private int qtdeVaga;
	
	@OneToMany(cascade=CascadeType.ALL)
	@Column(name="CURSOS")
	private List<Curso> cursos;
	
	@Column(name="TELEFONE_CONTATO")
	private String telefoneContato;

	@Column(name="EMAIL_CONTATO")	
	private String emailContato;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "SELECIONDADO_OFT_ESTAGIO",
	joinColumns = { @JoinColumn(name = "ESTAGIO_ID") }, 
	inverseJoinColumns = { @JoinColumn(name = "PESSOA_ID") })
	@Column(name="CONDIDATOS")
	private List<Aluno> candidatos;
	
	@OneToMany(cascade=CascadeType.ALL)
	@Column(name="SELECIONADOS")
	private List<Aluno> selecionados;
	
	@Column(name="STATUS")
	private StatusOfertaEstagio status;

	@Temporal(TemporalType.DATE)
	@Column(name="VIGENCIA")
	private Date vigencia;
	
	@OneToMany
	@Column(name="ESTAGIOS")
	private List<Estagio> estagios;
		
	public OfertaEstagio(){
		this.candidatos = new ArrayList<Aluno>();
		this.selecionados = new ArrayList<Aluno>();
		this.status = StatusOfertaEstagio.AGUARDANDO;
	}

	public String getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}
	

	public int getQtdeVaga() {
		return qtdeVaga;
	}

	public void setQtdeVaga(int qtdeVaga) {
		this.qtdeVaga = qtdeVaga;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public String getTelefoneContato() {
		return telefoneContato;
	}

	public void setTelefoneContato(String telefoneContato) {
		this.telefoneContato = telefoneContato;
	}

	public String getEmailContato() {
		return emailContato;
	}

	public void setEmailContato(String emailContato) {
		this.emailContato = emailContato;
	}
	
	public List<Aluno> getSelecionados() {
		return selecionados;
	}

	public void setSelecionados(List<Aluno> selecionados) {
		this.selecionados = selecionados;
	}
	
	public void addSelecionado(Aluno selecionado) throws Exception {
		if(this.selecionados.size() >= this.qtdeVaga)
			throw new Exception("Não há mais vagas na oferta de estágio!");
		
		this.selecionados.add(selecionado);
	}
	
	public void removerSelecionado(Aluno selecionado) {
		this.selecionados.remove(selecionado);
	}
	
	public boolean checkSelecionado(Object obj) {
		
		if(!(obj instanceof Aluno)) return false;
		
		for (Aluno aluno : selecionados) {
			
			if(aluno == (Aluno)obj){
				return true;
			}
		}
		
		return false;	
	}

	public List<Aluno> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(List<Aluno> candidatos) {
		this.candidatos = candidatos;
	}
	
	public void addRmCondidato(Aluno candidato){
		if(checkInscrito(String.valueOf(candidato.getId()))){
			this.removeCanditato(candidato);
		}else{
			this.addCandidato(candidato);
		}
	}
	
	public void addCandidato(Aluno candidato) {
		this.candidatos.add(candidato);
	}
	
	public void removeCanditato(Aluno candidato) {
		this.candidatos.remove(candidato);
	}
	
	public int totalCandidatos() {
		return this.candidatos.size();
	}

	public StatusOfertaEstagio getStatus() {
		return status;
	}

	public void setStatus(StatusOfertaEstagio status) {
		this.status = status;
	}

	public Date getVigencia() {
		return vigencia;
	}

	public void setVigencia(Date vigencia) {
		this.vigencia = vigencia;
	}

	public List<Estagio>  getEstagios() {
		return estagios;
	}

	public void setEstagios(List<Estagio> estagios) {
		this.estagios = estagios;
	}
	
	public boolean checkInscrito(String id){
		Integer idNumerico= null;
		try{
			idNumerico = Integer.parseInt(id);
		}catch(NumberFormatException e){
			System.out.println("verifcar formato numérico");
			return false;
		}catch (Exception e) {
			System.out.println("verifcar formato numérico");
			return false;
		}
		
		for (Aluno aluno : candidatos) {
			
			if(aluno.getId() == idNumerico){
				return true;
			}
		}
		
		return false;
	}
}
