package br.edu.ifpb.sace.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.edu.ifpb.sace.dao.ManagedEMContext;
import br.edu.ifpb.inheritance.Pessoa;
import br.edu.ifpb.sace.dao.AlunoDAO;
import br.edu.ifpb.sace.dao.PersistenceUtil;
import br.edu.ifpb.sace.dao.PessoaDAO;
import br.edu.ifpb.sace.entity.Aluno;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestePessoa {
	
	private static EntityManagerFactory emf;
	private static SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
	private EntityManager em;

	@BeforeClass
	public static void init() {
		PersistenceUtil.createEntityManagerFactory("sace");
		emf = PersistenceUtil.getEntityManagerFactory();
		ManagedEMContext.bind(emf, emf.createEntityManager());
		System.out.println("init()");
	}

	@AfterClass
	public static void destroy() {
		if (emf != null) {
			emf.close();
			System.out.println("destroy()");
		}
	}

	@Before
	public void initEM() {
		em = emf.createEntityManager();
	};
	
	@Test
	public void TesteA_insertPessoa() throws ParseException{
			Aluno a1 = new Aluno();
			a1.setMatricula("20131370001");
			a1.setNome("João Pedro da Silva");
			a1.setEmail("joao@gmail.com");
			a1.setEstagiando(false);
			a1.setTelefone("9999-9999");
			//a1.setNascimento((java.util.Date)fmt.parse("01/29/1993"));
			AlunoDAO alunodao = new AlunoDAO(PersistenceUtil.getCurrentEntityManager());
			alunodao.beginTransaction();
			alunodao.insert(a1);
			alunodao.commit();
			
	}
	
	@Test
	public void TesteB_findPessoa() throws ParseException{
			
			PessoaDAO pessoadao = new PessoaDAO(PersistenceUtil.getCurrentEntityManager());
			pessoadao.beginTransaction();
			Pessoa p1 = pessoadao.findByLogin("joao@gmail.com");
			System.out.println("PESSOA: "+p1.getClass());
			pessoadao.commit();
	}
	
	@Test
	public void TesteC_updatePessoa() throws ParseException{
			
			AlunoDAO alunodao = new AlunoDAO(PersistenceUtil.getCurrentEntityManager());
			alunodao.beginTransaction();
			Aluno a1 = alunodao.findByMatricula("20131370001");
			a1.setNome("João Marcos da Silva");
			a1.setTelefone("8888-8888");
			a1.setEstagiando(true);
			alunodao.update(a1);
			alunodao.commit();
	}
	
	@Test
	public void TesteD_deletePessoa() throws ParseException{
			
			AlunoDAO alunodao = new AlunoDAO(PersistenceUtil.getCurrentEntityManager());
			alunodao.beginTransaction();
			Aluno a1 = alunodao.findByMatricula("20131370001");
			alunodao.delete(a1);
			alunodao.commit();
	}

}
