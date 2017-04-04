package br.edu.ifpb.stace.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.edu.ifpb.stace.entity.Aluno;

public class AlunoDAO extends GenericDAO<Aluno, Integer>{

	public AlunoDAO() {
		this(PersistenceUtil.getCurrentEntityManager());
	}

	public AlunoDAO(EntityManager em) {
		super(em);
	}
	
	public Aluno findByMatricula(String matricula) {
		Query q = this.getEntityManager().createQuery("from Aluno u where u.matricula = :matricula");
        q.setParameter("matricula", matricula);
        Aluno u = null;
        try {
            u = (Aluno) q.getSingleResult();
        }catch (NoResultException e) {        
        }
        return u; 
	}
	
}
