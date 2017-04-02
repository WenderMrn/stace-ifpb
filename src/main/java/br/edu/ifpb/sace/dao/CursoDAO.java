
package br.edu.ifpb.sace.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.edu.ifpb.sace.entity.Curso;

public class CursoDAO extends GenericDAO<Curso, Integer>{
	
	public CursoDAO() {
		this(PersistenceUtil.getCurrentEntityManager());
	}

	public CursoDAO(EntityManager em) {
		super(em);
	}

	public Curso findByCodigo(int codigo) {
		Query q = this.getEntityManager().createQuery("from Curso u where u.id = :codigo");
        q.setParameter("codigo", codigo);
        Curso c = (Curso) q.getSingleResult();
  
        return c; 
	}
}
