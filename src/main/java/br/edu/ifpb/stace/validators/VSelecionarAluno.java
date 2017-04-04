package br.edu.ifpb.stace.validators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import br.edu.ifpb.stace.dao.AlunoDAO;
import br.edu.ifpb.stace.dao.CursoDAO;
import br.edu.ifpb.stace.dao.OfertaEstagioDAO;
import br.edu.ifpb.stace.dao.PersistenceUtil;
import br.edu.ifpb.stace.entity.Aluno;
import br.edu.ifpb.stace.entity.Curso;
import br.edu.ifpb.stace.entity.OfertaEstagio;
import br.edu.ifpb.stace.facade.Categoria;
import br.edu.ifpb.stace.facade.Resultado;
import br.edu.ifpb.stace.util.PasswordUtil;
import br.edu.ifpb.stace.validators.domain.IValidator;

public class VSelecionarAluno implements IValidator {

	private Resultado resultado;
	
	public VSelecionarAluno(){
		this.resultado = new Resultado();
	}
	
	@Override
	public Resultado getResultado() {
		return resultado;
	}

	@Override
	public void setResultado(Resultado r) {
		this.resultado = r;
	}

	@Override
	public boolean isValidParameters(Map<String, String[]> parametros) {

		String[] p_candidato = parametros.get("candidato");
		String[] p_oferta = parametros.get("oferta");

		List<String> mensagensErro =  new ArrayList<String>();
		Aluno aluno = null;
		OfertaEstagio oferta = null;
		

		AlunoDAO alunodao = new AlunoDAO(PersistenceUtil.getCurrentEntityManager());
		//alunodao.beginTransaction();
		aluno = alunodao.find(Integer.parseInt(p_candidato[0]));
		//alunodao.commit();
		
		OfertaEstagioDAO ofertadao = new OfertaEstagioDAO(PersistenceUtil.getCurrentEntityManager());
		//ofertadao.beginTransaction();
		oferta = ofertadao.find(Integer.parseInt(p_oferta[0]));
		//ofertadao.commit();
		
		/*Prepara a oferta para o controller*/
		try {
			oferta.addSelecionado(aluno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			mensagensErro.add(e.getMessage());
		}
		resultado.addMensagens(mensagensErro,Categoria.ERRO);
		resultado.setEntidade(oferta);
		
		return mensagensErro.isEmpty();
	}
	
}
