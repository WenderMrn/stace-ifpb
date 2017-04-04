package br.edu.ifpb.stace.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.edu.ifpb.inheritance.PessoaFisica;

@Entity
@Table(name="ALUNO")
public class Aluno extends PessoaFisica {
	
	@Column(name="MATRICULA",unique=true)
	private String matricula;
	
	@OneToOne
	@JoinColumn(name="CURSO_ID")
	private Curso curso;
	
	@ElementCollection
	@Column(name="COMPETENCIAS")
	private List<String> competencia;
	
	@Column(name="ESTAGIANDO")
	private boolean estagiando;

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "ALUNO_OFT_ESTAGIO", 
    joinColumns = { @JoinColumn(name = "CURSO_ID") }, 
    inverseJoinColumns = { @JoinColumn(name = "ESTAGIO_ID") })
	private List<OfertaEstagio> ofertasEstagio;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<String> getCompetencia() {
		return competencia;
	}

	public void setCompetencia(List<String> competencia) {
		this.competencia = competencia;
	}

	public boolean isEstagiando() {
		return estagiando;
	}

	public void setEstagiando(boolean estagiando) {
		this.estagiando = estagiando;
	}

	public List<OfertaEstagio> getInterOfertaEstagio() {
		return ofertasEstagio;
	}

	public void setInterOfertaEstagio(List<OfertaEstagio> interOfertaEstagio) {
		ofertasEstagio = interOfertaEstagio;
	}
	
}
