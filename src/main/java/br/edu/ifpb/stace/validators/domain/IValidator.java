package br.edu.ifpb.stace.validators.domain;

import java.util.Map;

import br.edu.ifpb.stace.facade.Resultado;

public interface IValidator {
	public Resultado getResultado();
	public void setResultado(Resultado r);
	public boolean isValidParameters(Map<String, String[]> parameters);
}
