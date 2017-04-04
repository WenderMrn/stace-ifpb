package br.edu.ifpb.stace.entity;

public enum Perfil {
	BASIC("Básico"),
	ADMIN("Administrador");
	
	private String nome;
	
	Perfil(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

}
