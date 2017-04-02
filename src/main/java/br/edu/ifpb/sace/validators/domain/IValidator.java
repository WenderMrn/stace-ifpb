package br.edu.ifpb.sace.validators.domain;

import java.util.Map;

import br.edu.ifpb.sace.facade.Resultado;

public interface IValidator {
	public Resultado getResultado();
	public void setResultado(Resultado r);
	public boolean isValidParameters(Map<String, String[]> parameters);
}
