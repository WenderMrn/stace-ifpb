package br.edu.ifpb.stace.dao;

import javax.persistence.EntityManager;

import br.edu.ifpb.stace.entity.Seguro;

public class SeguroDAO extends GenericDAO<Seguro, Integer>{

	public SeguroDAO() {
		this(PersistenceUtil.getCurrentEntityManager());
	}

	public SeguroDAO(EntityManager em) {
		super(em);
	}
	
}
