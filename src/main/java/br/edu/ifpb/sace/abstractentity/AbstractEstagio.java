package br.edu.ifpb.sace.abstractentity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEstagio {
	
	@Id
	@Column(name="ESTAGIO_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="TITULO")
	private String titulo;
	
	@Column(name="DET_FUNCAO")
	private String detalheFuncao;
	
	@Column(name="CH_SEMANAIS")
	private double CHSemanais;
	
	@Column(name="VALOR_BOLSA")
	private double valorBolsa;
	
	@Column(name="VALOR_BENEFICIO")
	private double valorBenef;
	
	@Column(name="INFOADS")
	private String infoAdicionais;
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDetalheFuncao() {
		return detalheFuncao;
	}

	public void setDetalheFuncao(String detalheFuncao) {
		this.detalheFuncao = detalheFuncao;
	}

	public double getCHSemanais() {
		return CHSemanais;
	}

	public void setCHSemanais(double cHSemanais) {
		CHSemanais = cHSemanais;
	}

	public double getValorBolsa() {
		return valorBolsa;
	}

	public void setValorBolsa(double valorBolsa) {
		this.valorBolsa = valorBolsa;
	}

	public double getValorBenef() {
		return valorBenef;
	}

	public void setValorBenef(double valorBenef) {
		this.valorBenef = valorBenef;
	}

	public String getInfoAdicionais() {
		return infoAdicionais;
	}

	public void setInfoAdicionais(String infoAdicionais) {
		this.infoAdicionais = infoAdicionais;
	}
	
}
