package br.edu.ifpb.sace.dao;

import javax.persistence.EntityManager;

import br.edu.ifpb.sace.entity.Empresa;

public class EmpresaDAO extends GenericDAO<Empresa, Integer>{

	public EmpresaDAO() {
		this(PersistenceUtil.getCurrentEntityManager());
	}

	public EmpresaDAO(EntityManager em) {
		super(em);
	}
	
}
