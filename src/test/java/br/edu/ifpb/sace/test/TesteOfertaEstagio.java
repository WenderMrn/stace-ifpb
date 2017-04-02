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
import br.edu.ifpb.sace.dao.OfertaEstagioDAO;
import br.edu.ifpb.sace.dao.PersistenceUtil;
import br.edu.ifpb.sace.entity.OfertaEstagio;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TesteOfertaEstagio {
	
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
	public void TesteA_insertOferta() throws ParseException{
			
			OfertaEstagio ofertaestagio = new OfertaEstagio();
			ofertaestagio.setTitulo("Desenvolvedor BACK-END");
			ofertaestagio.setCHSemanais(30);
			ofertaestagio.setDetalheFuncao("Desenvolvedor");
			ofertaestagio.setEmailContato("suporte.empresa.@email.com");
			ofertaestagio.setQtdeVaga(4);
			
			OfertaEstagioDAO ofertadao = new OfertaEstagioDAO(PersistenceUtil.getCurrentEntityManager());
			ofertadao.beginTransaction();
			ofertadao.insert(ofertaestagio);
			ofertadao.commit();
			
	}
	
	@Test
	public void TesteB_findOferta() throws ParseException{
			
			OfertaEstagioDAO ofertadao = new OfertaEstagioDAO(PersistenceUtil.getCurrentEntityManager());
			ofertadao.beginTransaction();
			OfertaEstagio oe = ofertadao.findByTitulo("Desenvolvedor BACK-END");
			System.out.println("OFERTA ESTÁGIO: "+oe.getTitulo());
			ofertadao.commit();
	}
	
	@Test
	public void TesteC_updateCurso() throws ParseException{
			
			OfertaEstagioDAO ofertadao = new OfertaEstagioDAO(PersistenceUtil.getCurrentEntityManager());
			ofertadao.beginTransaction();
			
			OfertaEstagio oe = ofertadao.findByTitulo("Desenvolvedor BACK-END");
			
			oe.setCHSemanais(20);
			oe.setDetalheFuncao("Desenvolvedor, testador e suporte");
			oe.setEmailContato("exemplo@email.com");
			oe.setQtdeVaga(3);
			
			ofertadao.update(oe);
			ofertadao.commit();
	}
	
	@Test
	public void TesteD_deleteCurso() throws ParseException{
			
		OfertaEstagioDAO ofertadao = new OfertaEstagioDAO(PersistenceUtil.getCurrentEntityManager());
		ofertadao.beginTransaction();
		
		OfertaEstagio oe = ofertadao.findByTitulo("Desenvolvedor BACK-END");

		ofertadao.delete(oe);
		ofertadao.commit();
	}

}
