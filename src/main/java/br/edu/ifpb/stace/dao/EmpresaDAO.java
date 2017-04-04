package br.edu.ifpb.stace.dao;

import javax.persistence.EntityManager;

import br.edu.ifpb.stace.entity.Empresa;

public class EmpresaDAO extends GenericDAO<Empresa, Integer>{

	public EmpresaDAO() {
		this(PersistenceUtil.getCurrentEntityManager());
	}

	public EmpresaDAO(EntityManager em) {
		super(em);
	}
	
}
