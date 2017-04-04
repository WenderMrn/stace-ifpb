package br.edu.ifpb.stace.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.edu.ifpb.inheritance.Pessoa;

public class PessoaDAO extends GenericDAO<Pessoa, Integer>{

	public PessoaDAO() {
		this(PersistenceUtil.getCurrentEntityManager());
	}

	public PessoaDAO(EntityManager em) {
		super(em);
	}
	
	public Pessoa findByLogin(String login) {
		Query q = this.getEntityManager().createQuery("select p from Pessoa p where p.email = :login");
		q.setParameter("login", login);
		Pessoa usuario = null;
		try {
			usuario = (Pessoa) q.getSingleResult();
		} catch (NoResultException e) {
		}
		return usuario;
	}

}
