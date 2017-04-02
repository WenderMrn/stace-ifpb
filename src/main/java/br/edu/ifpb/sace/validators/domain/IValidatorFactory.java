package br.edu.ifpb.sace.validators.domain;

import br.edu.ifpb.sace.util.ValidatorType;

public abstract class IValidatorFactory {

	public abstract IValidator getValidatorType(ValidatorType type) throws Exception;
}
