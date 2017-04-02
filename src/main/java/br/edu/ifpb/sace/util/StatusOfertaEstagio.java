package br.edu.ifpb.sace.util;

public enum StatusOfertaEstagio {
	
	AGUARDANDO("AGUARDANDO"),
	APROVADO("APROVADO"),
	NEGADO("NEGADO");
	
	private String nome;
	
	StatusOfertaEstagio(String nome) {
		this.nome = nome;
	}

	public String getType() {
		return nome;
	}
}
