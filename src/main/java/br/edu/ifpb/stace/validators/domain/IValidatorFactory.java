package br.edu.ifpb.stace.validators.domain;

import br.edu.ifpb.stace.util.ValidatorType;

public abstract class IValidatorFactory {

	public abstract IValidator getValidatorType(ValidatorType type) throws Exception;
}
