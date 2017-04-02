package br.edu.ifpb.inheritance;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class PessoaJuridica extends Pessoa{
	
	@Column(name="CPNJ")
	private String cnpj;
	
	@Column(name="NUM_INSCRICAO")
	private int numInscricao;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DATA_FIM")
	private Date dataAbertura;
	
	@Column(name="NOME_EMPRESARIAL")
	private String nomeEmpresarial;
	
	@Column(name="NOME_FANTASIA")
	private String nomeFantasia;
	
	@Column(name="COD_ATIVIDADE_ENCO_PRINCIPAL")
	private String codAtividadeEcoPric;
	
	@Column(name="DESC_ATIVIDADE_ENCO_PRINCIPAL")
	private String descAtividadeEcoPric;
	
	@Column(name="COD_NATUREZA_JURIDICA")
	private String codNaturezaJuridica;
	
	@Column(name="DESC_NATUREZA_JURIDICA")
	private String desNaturezaJuridica;
	
	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public int getNumInscricao() {
		return numInscricao;
	}

	public void setNumInscricao(int numInscricao) {
		this.numInscricao = numInscricao;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public String getNomeEmpresarial() {
		return nomeEmpresarial;
	}

	public void setNomeEmpresarial(String nomeEmpresarial) {
		this.nomeEmpresarial = nomeEmpresarial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCodAtividadeEcoPric() {
		return codAtividadeEcoPric;
	}

	public void setCodAtividadeEcoPric(String codAtividadeEcoPric) {
		this.codAtividadeEcoPric = codAtividadeEcoPric;
	}

	public String getDescAtividadeEcoPric() {
		return descAtividadeEcoPric;
	}

	public void setDescAtividadeEcoPric(String descAtividadeEcoPric) {
		this.descAtividadeEcoPric = descAtividadeEcoPric;
	}

	public String getCodNaturezaJuridica() {
		return codNaturezaJuridica;
	}

	public void setCodNaturezaJuridica(String codNaturezaJuridica) {
		this.codNaturezaJuridica = codNaturezaJuridica;
	}

	public String getDesNaturezaJuridica() {
		return desNaturezaJuridica;
	}

	public void setDesNaturezaJuridica(String desNaturezaJuridica) {
		this.desNaturezaJuridica = desNaturezaJuridica;
	}
	
}
