package br.edu.ifpb.stace.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Curso {
	
	@Id
	@Column(name="CURSO_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="CODIGO")
	private int codigo;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="DESCRICACAO")
	private String descricao;
	
	@Column(name="MATRIZ_CODIGO")
	private int matrizc;
	
	@Column(name="REGIME")
	private Enum regime;
	
	@OneToOne
	@JoinColumn(name="PESSOA_ID")
	private Coordenador Coordenador;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getMatrizc() {
		return matrizc;
	}

	public void setMatrizc(int matrizc) {
		this.matrizc = matrizc;
	}

	public Enum getRegime() {
		return regime;
	}

	public void setRegime(Enum regime) {
		this.regime = regime;
	}

	public Coordenador getCoordenador() {
		return Coordenador;
	}

	public void setCoordenador(Coordenador coordenador) {
		Coordenador = coordenador;
	}
	
}
