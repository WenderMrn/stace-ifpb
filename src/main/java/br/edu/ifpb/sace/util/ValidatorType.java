package br.edu.ifpb.sace.util;

public enum ValidatorType {
	
	CADASTRO_OFERTA_ESTAGIO("cadoftest"),
	INS_CANC_ALUNO_OFERTA("insaluoft"),
	SELECIONAR_ALUNO("SlecionarAluno"),
	CADASTRO_ALUNO("cadaluno"),
	CADASTRO_CURSO("cadcurso");
	
	private String type;
	
	ValidatorType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
