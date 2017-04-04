package br.edu.ifpb.stace.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.edu.ifpb.stace.abstractentity.AbstractEstagio;

@Entity
public class Estagio extends AbstractEstagio {
	
	@ManyToOne
	private Empresa empresa;
	
	@OneToOne
	@JoinColumn(name="PESSOA_ID")
	private Aluno Aluno;
	
	@Column(name="SETOR")
	private String Setor;
	
	@Column(name="HORARIO")
	private String Horario;
	
	@OneToOne
	@JoinColumn(name="SEGURO_ID")
	private Seguro Seguro;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DATA_INICIO")
	private Date DInicio;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DATA_FIM")
	private Date DFim;
	
	@ManyToOne
	private OfertaEstagio Oferta;
	
	@Column(name="SUPERVISOR")
	private String Supervisor;
	
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Aluno getAluno() {
		return Aluno;
	}

	public void setAluno(Aluno aluno) {
		Aluno = aluno;
	}

	public String getSetor() {
		return Setor;
	}

	public void setSetor(String setor) {
		Setor = setor;
	}

	public String getHorario() {
		return Horario;
	}

	public void setHorario(String horario) {
		Horario = horario;
	}

	public Seguro getSeguro() {
		return Seguro;
	}

	public void setSeguro(Seguro seguro) {
		Seguro = seguro;
	}

	public Date getDInicio() {
		return DInicio;
	}

	public void setDInicio(Date dInicio) {
		DInicio = dInicio;
	}

	public Date getDFim() {
		return DFim;
	}

	public void setDFim(Date dFim) {
		DFim = dFim;
	}

	public OfertaEstagio getOferta() {
		return Oferta;
	}

	public void setOferta(OfertaEstagio oferta) {
		Oferta = oferta;
	}

	public String getSupervisor() {
		return Supervisor;
	}

	public void setSupervisor(String supervisor) {
		Supervisor = supervisor;
	}
	
}
