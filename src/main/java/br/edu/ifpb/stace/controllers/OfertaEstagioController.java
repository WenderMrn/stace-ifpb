package br.edu.ifpb.stace.controllers;

import br.edu.ifpb.stace.dao.EmpresaDAO;
import br.edu.ifpb.stace.dao.OfertaEstagioDAO;
import br.edu.ifpb.stace.dao.PersistenceUtil;
import br.edu.ifpb.stace.entity.Aluno;
import br.edu.ifpb.stace.entity.Empresa;
import br.edu.ifpb.stace.entity.OfertaEstagio;
import br.edu.ifpb.stace.util.StaceException;
import br.edu.ifpb.stace.util.StatusOfertaEstagio;

public class OfertaEstagioController {
	
	public OfertaEstagio cadastrar(OfertaEstagio ofertaEstagio ,Empresa empresa) throws Exception{
		
			EmpresaDAO dao = new EmpresaDAO(PersistenceUtil.getCurrentEntityManager());
			dao.beginTransaction();
			
			if(empresa != null && ofertaEstagio != null){
				empresa.addOfertaEstagio(ofertaEstagio);
				if(ofertaEstagio.getId() == null) {
					dao.insert(empresa);
				} else{
					dao.update(empresa);
				}
				dao.commit();
				
			}else{
				throw new StaceException("Oferta de Estágio e Empresa são obrigatórios.");
			}
			
		return ofertaEstagio;
	}
	
	public void canceInscreverAluno(OfertaEstagio ofertaEstagio,Aluno aluno) throws Exception{
		
			if(ofertaEstagio != null && aluno != null){
				
					ofertaEstagio.addRmCondidato((Aluno)aluno);
					OfertaEstagioDAO dao = new OfertaEstagioDAO(PersistenceUtil.getCurrentEntityManager());
					dao.beginTransaction();
					dao.update(ofertaEstagio);
					dao.commit();
				
			}else{
				throw new StaceException("Oferta de Estágio e/ou Aluno devem ser informado(s).");
			}
		
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
	
public void selecionarAluno(OfertaEstagio ofertaEstagio,Aluno aluno) throws Exception{
		
		if(ofertaEstagio != null && aluno != null){
			ofertaEstagio.addSelecionado(aluno);
			OfertaEstagioDAO dao = new OfertaEstagioDAO(PersistenceUtil.getCurrentEntityManager());
			dao.beginTransaction();
			dao.update(ofertaEstagio);
			dao.commit();
		}else{
			throw new StaceException("Oferta de Estágio e/ou Aluno não informada(os)!");
		}
		
	}
}