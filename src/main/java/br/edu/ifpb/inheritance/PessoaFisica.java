package br.edu.ifpb.inheritance;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class PessoaFisica extends Pessoa{
	
	@Temporal(TemporalType.DATE)
	@Column(name="NASCIMENTO")
	private Date nascimento;
	
	@Column(name="NOME")
	private String nome;

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
