package br.edu.ifpb.sace.entity;

public enum Regime {
	
	MENSAL("Mensal"),
	BIMESTRAL("Bimestral"),
	TRIMESTRAL("Trimestral"),
	SEMESTRAL("Semestral"),
	ANUAL("Anual");
	
	private String nome;
	
	Regime(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
}
