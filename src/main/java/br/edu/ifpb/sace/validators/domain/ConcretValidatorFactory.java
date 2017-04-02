package br.edu.ifpb.sace.validators.domain;

import br.edu.ifpb.sace.util.ValidatorType;
import br.edu.ifpb.sace.validators.VCadastroAluno;
import br.edu.ifpb.sace.validators.VCadastroCurso;
import br.edu.ifpb.sace.validators.VCadastroOfertaEstagio;
import br.edu.ifpb.sace.validators.VInscAlunoOfertaEstagio;
import br.edu.ifpb.sace.validators.VSelecionarAluno;

public class ConcretValidatorFactory extends IValidatorFactory{

	@Override
	public IValidator getValidatorType(ValidatorType type) throws Exception {
		switch (type) {
			case CADASTRO_OFERTA_ESTAGIO:
				return new VCadastroOfertaEstagio();
			case INS_CANC_ALUNO_OFERTA:
				return new VInscAlunoOfertaEstagio();
			case CADASTRO_ALUNO:
				return new VCadastroAluno();
			case SELECIONAR_ALUNO:
				return new VSelecionarAluno();
			case CADASTRO_CURSO:
				return new VCadastroCurso();
			default:
				System.out.println("Nenhum Objeto de validação encontrado");
			break;
		}
		return null;
	}
	
}
