
package br.edu.ifpb.sace.dao;

import javax.persistence.EntityManager;

import br.edu.ifpb.sace.entity.Estagio;

public class EstagioDAO extends GenericDAO<Estagio, Integer>{
	
	public EstagioDAO() {
		this(PersistenceUtil.getCurrentEntityManager());
	}

	public EstagioDAO(EntityManager em) {
		super(em);
	}
}
