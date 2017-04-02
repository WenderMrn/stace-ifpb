package br.edu.ifpb.sace.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.edu.ifpb.sace.entity.OfertaEstagio;

public class OfertaEstagioDAO extends GenericDAO<OfertaEstagio, Integer>{

	public OfertaEstagioDAO() {
		this(PersistenceUtil.getCurrentEntityManager());
	}

	public OfertaEstagioDAO(EntityManager em) {
		super(em);
	}
	
	public OfertaEstagio findByTitulo(String titulo) {
		Query q = this.getEntityManager().createQuery("from OfertaEstagio oe where oe.titulo = :titulo");
        q.setParameter("titulo", titulo);
        OfertaEstagio oe = null;
        try {
            oe = (OfertaEstagio) q.getSingleResult();
        }catch (NoResultException e) {        
        }
        return oe; 
	}
	
}
