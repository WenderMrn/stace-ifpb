
package br.edu.ifpb.stace.dao;

import javax.persistence.EntityManager;

import br.edu.ifpb.stace.entity.Estagio;

public class EstagioDAO extends GenericDAO<Estagio, Integer>{
	
	public EstagioDAO() {
		this(PersistenceUtil.getCurrentEntityManager());
	}

	public EstagioDAO(EntityManager em) {
		super(em);
	}
}
