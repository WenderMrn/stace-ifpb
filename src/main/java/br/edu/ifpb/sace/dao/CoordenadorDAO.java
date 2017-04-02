
package br.edu.ifpb.sace.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.edu.ifpb.sace.entity.Coordenador;

public class CoordenadorDAO extends GenericDAO<Coordenador, Integer>{
	
	public CoordenadorDAO() {
		this(PersistenceUtil.getCurrentEntityManager());
	}

	public CoordenadorDAO(EntityManager em) {
		super(em);
	}
	
}
