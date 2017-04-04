package br.edu.ifpb.stace.controllers;

import java.util.Collections;
import java.util.Map;

import br.edu.ifpb.stace.dao.EmpresaDAO;
import br.edu.ifpb.stace.dao.OfertaEstagioDAO;
import br.edu.ifpb.stace.dao.PersistenceUtil;
import br.edu.ifpb.stace.entity.Aluno;
import br.edu.ifpb.stace.entity.Empresa;
import br.edu.ifpb.stace.entity.OfertaEstagio;
import br.edu.ifpb.stace.facade.Categoria;
import br.edu.ifpb.stace.facade.Resultado;
import br.edu.ifpb.stace.util.StaceException;
import br.edu.ifpb.stace.util.StatusOfertaEstagio;
import br.edu.ifpb.stace.util.ValidatorType;
import br.edu.ifpb.stace.validators.domain.ConcretValidatorFactory;
import br.edu.ifpb.stace.validators.domain.IValidator;
import br.edu.ifpb.stace.validators.domain.IValidatorFactory;

public class OfertaEstagioController {
	
	public Resultado cadastrar(Map<String, String[]> parametros,Empresa empresa) throws Exception{
		Resultado resultado= new Resultado();
		OfertaEstagio ofertaEstagio;
		
		IValidatorFactory vf = new ConcretValidatorFactory(); 
		IValidator validador = vf.getValidatorType(ValidatorType.CADASTRO_OFERTA_ESTAGIO);
		
		if(validador.isValidParameters(parametros)){
			
			ofertaEstagio = (OfertaEstagio)validador.getResultado().getEntidade();
			empresa.addOfertaEstagio(ofertaEstagio);
			
			EmpresaDAO dao = new EmpresaDAO(PersistenceUtil.getCurrentEntityManager());
			dao.beginTransaction();
			
			if(ofertaEstagio.getId() == null) {
				dao.insert(empresa);
			} else{
				dao.update(empresa);
			}
			dao.commit();
			
			resultado.setErro(false);
			resultado.addMensagens(Collections.singletonList("Oferta criada com sucesso"),Categoria.INFO);
			resultado.setEntidade(ofertaEstagio);
		}else{
			resultado.setEntidade((OfertaEstagio)validador.getResultado().getEntidade());
			resultado.setErro(true);
			resultado.setMensagens(validador.getResultado().getMensagens());
			
		}
		return resultado;
	}
	
	public Resultado canceInscreverAluno(Map<String, String[]> parametros,Aluno aluno) throws Exception{
		
		Resultado resultado= new Resultado();
		OfertaEstagio ofertaEstagio;
		
		IValidatorFactory vf = new ConcretValidatorFactory(); 
		IValidator validador = vf.getValidatorType(ValidatorType.INS_CANC_ALUNO_OFERTA);
		
		if(validador.isValidParameters(parametros)){
			
			ofertaEstagio = (OfertaEstagio)validador.getResultado().getEntidade();

			if(ofertaEstagio == null){
				resultado.setErro(true);
				resultado.setMensagens(validador.getResultado().getMensagens());
			}else{
				ofertaEstagio.addRmCondidato(aluno);
				OfertaEstagioDAO dao = new OfertaEstagioDAO(PersistenceUtil.getCurrentEntityManager());
				dao.beginTransaction();
				dao.update(ofertaEstagio);
				dao.commit();
			}
		}
		
		return resultado;
		
	}
	
	public void statusOfertaEstagio(OfertaEstagio ofertaEstagio,StatusOfertaEstagio status) throws Exception{
				
		if(ofertaEstagio != null){
				ofertaEstagio.setStatus(status);
				OfertaEstagioDAO dao = new OfertaEstagioDAO(PersistenceUtil.getCurrentEntityManager());
				dao.beginTransaction();
				dao.update(ofertaEstagio);
				dao.commit();
		}else{
			throw new StaceException("Oferta de Estágio não informada!");
		}
		
	}
	
public Resultado selecionarAluno(Map<String, String[]> parametros){
		
		Resultado resultado= new Resultado();
		OfertaEstagio ofertaEstagio = null;
		
		IValidatorFactory vf = new ConcretValidatorFactory(); 
		
		IValidator validador = null;
		try {
			validador = vf.getValidatorType(ValidatorType.SELECIONAR_ALUNO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
		
		if(validador.isValidParameters(parametros)){
			
			ofertaEstagio = (OfertaEstagio)validador.getResultado().getEntidade();
		}
		
		if(ofertaEstagio == null){
			resultado.setErro(true);
			resultado.setMensagens(validador.getResultado().getMensagens());
		}else{
			resultado.setMensagens(validador.getResultado().getMensagens());
			OfertaEstagioDAO dao = new OfertaEstagioDAO(PersistenceUtil.getCurrentEntityManager());
			dao.beginTransaction();
			dao.update(ofertaEstagio);
			dao.commit();
		}
		
		return resultado;
		
	}
}