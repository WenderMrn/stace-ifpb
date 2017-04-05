package br.edu.ifpb.stace.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import br.edu.ifpb.stace.dao.AlunoDAO;
import br.edu.ifpb.stace.dao.EstagioDAO;
import br.edu.ifpb.stace.dao.OfertaEstagioDAO;
import br.edu.ifpb.stace.dao.PersistenceUtil;
import br.edu.ifpb.stace.entity.Aluno;
import br.edu.ifpb.stace.entity.Empresa;
import br.edu.ifpb.stace.entity.Estagio;
import br.edu.ifpb.stace.entity.OfertaEstagio;
import br.edu.ifpb.stace.util.StaceException;

public class EstagioController {
	
	public Estagio cadastrar(Estagio estagio){
		
			EstagioDAO estagioDao = new EstagioDAO(PersistenceUtil.getCurrentEntityManager());
			estagioDao.beginTransaction();
			
			if(estagio != null) {
				estagioDao.insert(estagio);
			} else{
				estagioDao.update(estagio);
			}
			estagioDao.commit();
		return estagio;
	}
	
	public Estagio cadastrar(Estagio contexto,OfertaEstagio ofertaEstagio, Aluno candidato,Empresa empresa) throws StaceException{
		OfertaEstagioDAO ofertaDao = new OfertaEstagioDAO();
		Estagio estagio = contexto != null?contexto:new Estagio();
		List<OfertaEstagio> listaOfertasEstaio = null; 
		if(ofertaEstagio == null || candidato == null || empresa == null)
				throw new StaceException("Oferta de Estágio, Candidatos e Empresa são obrigatórios.");
		
		OfertaEstagioDAO ofertaEstagioDAO = new OfertaEstagioDAO();
		listaOfertasEstaio = ofertaEstagioDAO.findAll();
		
		for (OfertaEstagio oferta : listaOfertasEstaio) {
			if(!oferta.equals(ofertaEstagio)){
				
				oferta.removeCanditato(candidato);
				oferta.removerSelecionado(candidato);
				
				ofertaDao.beginTransaction();
				ofertaDao.update(oferta);
				ofertaDao.commit();
				
			}
		}
		
		candidato.setEstagiando(true);
		
		estagio.setAluno(candidato);
		estagio.setCHSemanais(ofertaEstagio.getCHSemanais());
		estagio.setDetalheFuncao(ofertaEstagio.getDetalheFuncao());
		estagio.setEmpresa(empresa);
		estagio.setInfoAdicionais(ofertaEstagio.getInfoAdicionais());
		estagio.setOferta(ofertaEstagio);
		estagio.setTitulo(ofertaEstagio.getTitulo());
		estagio.setValorBolsa(estagio.getValorBolsa());
		estagio.setValorBenef(ofertaEstagio.getValorBenef());
		
		return cadastrar(estagio);
	}
}
