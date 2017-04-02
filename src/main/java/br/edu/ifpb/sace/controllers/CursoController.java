package br.edu.ifpb.sace.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import br.edu.ifpb.sace.dao.CursoDAO;
import br.edu.ifpb.sace.dao.PersistenceUtil;
import br.edu.ifpb.sace.entity.Curso;
import br.edu.ifpb.sace.facade.Categoria;
import br.edu.ifpb.sace.facade.Resultado;
import br.edu.ifpb.sace.util.ValidatorType;
import br.edu.ifpb.sace.validators.domain.ConcretValidatorFactory;
import br.edu.ifpb.sace.validators.domain.IValidator;
import br.edu.ifpb.sace.validators.domain.IValidatorFactory;

public class CursoController {
	
	private Curso curso;
	private List<String> mensagensErro;
	
	@SuppressWarnings("unchecked")
	public Resultado cadastrar(Map<String, String[]> parametros) throws Exception{
		Resultado resultado= new Resultado();
		
		IValidatorFactory vf = new ConcretValidatorFactory(); 
		IValidator validador = vf.getValidatorType(ValidatorType.CADASTRO_CURSO);
		
		this.mensagensErro = new ArrayList<String>();
		
		if(validador.isValidParameters(parametros)){
			CursoDAO dao = new CursoDAO(PersistenceUtil.getCurrentEntityManager());
			dao.beginTransaction();
			
			if(this.curso.getId() == null) {
				dao.insert(this.curso);
			} else{
				dao.update(this.curso);
			}
			dao.commit();
			
			resultado.setErro(false);
			resultado.addMensagens(Collections.singletonList("Curso criado com sucesso"),Categoria.INFO);
			resultado.setEntidade(this.curso);
		}else{
			resultado.setEntidade(this.curso);
			resultado.setErro(true);
			
			this.mensagensErro = (List<String>) validador.getResultado();
			
			resultado.addMensagens(this.mensagensErro,Categoria.ERRO);
			
		}
		return resultado;
	}
	
}
