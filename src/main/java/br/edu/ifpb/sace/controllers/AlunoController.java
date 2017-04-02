package br.edu.ifpb.sace.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import br.edu.ifpb.sace.dao.AlunoDAO;
import br.edu.ifpb.sace.dao.PersistenceUtil;
import br.edu.ifpb.sace.entity.Aluno;
import br.edu.ifpb.sace.facade.Categoria;
import br.edu.ifpb.sace.facade.Resultado;
import br.edu.ifpb.sace.util.ValidatorType;
import br.edu.ifpb.sace.validators.domain.ConcretValidatorFactory;
import br.edu.ifpb.sace.validators.domain.IValidator;
import br.edu.ifpb.sace.validators.domain.IValidatorFactory;

public class AlunoController {
	private Aluno aluno = new Aluno();
	private List<String> mensagensErro;

	public Resultado cadastrar(Map<String, String[]> parametros) throws Exception{
		Resultado resultado = new Resultado();

		
		IValidatorFactory vf = new ConcretValidatorFactory(); 
		IValidator validador = vf.getValidatorType(ValidatorType.CADASTRO_ALUNO);
		
		this.mensagensErro = new ArrayList<String>();
		
		if (validador.isValidParameters(parametros)) {
			
			this.aluno = (Aluno)validador.getResultado().getEntidade();
			System.out.println("nome:"+ this.aluno.getNome());
			System.out.println("nome:"+ this.aluno.getId());
			
			AlunoDAO dao = new AlunoDAO(PersistenceUtil.getCurrentEntityManager());
			dao.beginTransaction();

			if (this.aluno.getNome() == null) {
				dao.insert(this.aluno);
			} else {
				dao.update(this.aluno);
			}
			dao.commit();
			resultado.setErro(false);
			resultado.addMensagens(Collections.singletonList("Aluno criado com sucesso"), Categoria.INFO);
			resultado.setEntidade(this.aluno);
		} else {
			resultado = validador.getResultado();
			resultado.setErro(true);
						
			resultado.addMensagens(this.mensagensErro, Categoria.ERRO);

		}
		return resultado;
	}

}
