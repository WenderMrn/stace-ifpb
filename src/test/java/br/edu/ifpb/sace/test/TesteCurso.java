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
import br.edu.ifpb.sace.dao.CursoDAO;
import br.edu.ifpb.sace.dao.PersistenceUtil;
import br.edu.ifpb.sace.entity.Curso;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TesteCurso {
	
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
	public void TesteA_insertCurso() throws ParseException{
			Curso c1 = new Curso();
			c1.setCodigo(37);
			c1.setDescricao("Curso de Sistemas para Inernet");
			c1.setMatrizc(002);
			
			CursoDAO cursodao = new CursoDAO(PersistenceUtil.getCurrentEntityManager());
			cursodao.beginTransaction();
			cursodao.insert(c1);
			cursodao.commit();
			
	}
	
	@Test
	public void TesteB_findCurso() throws ParseException{
			
			CursoDAO cursodao = new CursoDAO(PersistenceUtil.getCurrentEntityManager());
			cursodao.beginTransaction();
			Curso c1 = cursodao.findByCodigo(37);
			System.out.println("CURSO: "+c1);
			cursodao.commit();
	}
	
	@Test
	public void TesteC_updateCurso() throws ParseException{
			
			CursoDAO cursodao = new CursoDAO(PersistenceUtil.getCurrentEntityManager());
			cursodao.beginTransaction();
			Curso c1 = cursodao.findByCodigo(37);
			c1.setDescricao("Matemática");
			c1.setCodigo(85);
			cursodao.update(c1);
			cursodao.commit();
	}
	
	/*@Test
	public void TesteD_deleteCurso() throws ParseException{
			
			CursoDAO cursodao = new CursoDAO(PersistenceUtil.getCurrentEntityManager());
			cursodao.beginTransaction();
			Curso c1 = cursodao.findByCodigo(85);
			cursodao.delete(c1);
			cursodao.commit();
	}
*/
}
