package br.edu.ifpb.sace.dao;

import javax.persistence.EntityManager;

import br.edu.ifpb.sace.entity.Seguro;

public class SeguroDAO extends GenericDAO<Seguro, Integer>{

	public SeguroDAO() {
		this(PersistenceUtil.getCurrentEntityManager());
	}

	public SeguroDAO(EntityManager em) {
		super(em);
	}
	
}
