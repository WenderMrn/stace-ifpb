package br.edu.ifpb.stace.util;

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

import br.edu.ifpb.stace.dao.AlunoDAO;
import br.edu.ifpb.stace.dao.CoordenadorDAO;
import br.edu.ifpb.stace.dao.CursoDAO;
import br.edu.ifpb.stace.dao.EmpresaDAO;
import br.edu.ifpb.stace.dao.ManagedEMContext;
import br.edu.ifpb.stace.dao.OfertaEstagioDAO;
import br.edu.ifpb.stace.dao.PersistenceUtil;
import br.edu.ifpb.stace.entity.Aluno;
import br.edu.ifpb.stace.entity.Coordenador;
import br.edu.ifpb.stace.entity.Curso;
import br.edu.ifpb.stace.entity.Empresa;
import br.edu.ifpb.stace.entity.OfertaEstagio;
import br.edu.ifpb.stace.entity.Regime;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InsereDadosBanco {

	private static EntityManagerFactory emf;
	private static SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
	private EntityManager em;

	@BeforeClass
	public static void init() {
		PersistenceUtil.createEntityManagerFactory("stace");
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
	public void insereAluno() throws ParseException {

		Aluno a1 = new Aluno();
		a1.setMatricula("20131370001");
		a1.setNome("João Pedro da Silva");
		a1.setEmail("aluno1@email.com");
		a1.setSenha(PasswordUtil.encryptMD5("123"));
		a1.setEstagiando(false);
		a1.setTelefone("9999-9999");

		Aluno a2 = new Aluno();
		a2.setMatricula("20131370002");
		a2.setNome("Aluno Fulano de Tal");
		a2.setEmail("aluno2@email.com");
		a2.setSenha(PasswordUtil.encryptMD5("123"));
		a2.setEstagiando(false);
		a2.setTelefone("9999-9999");

		Aluno a3 = new Aluno();
		a3.setMatricula("20131370003");
		a3.setNome("Maria Adelaide");
		a3.setEmail("aluno3@email.com");
		a3.setSenha(PasswordUtil.encryptMD5("123"));
		a3.setEstagiando(false);
		a3.setTelefone("9999-9999");

		AlunoDAO alunodao = new AlunoDAO(PersistenceUtil.getCurrentEntityManager());
		alunodao.beginTransaction();
		alunodao.insert(a1);
		alunodao.insert(a2);
		alunodao.insert(a3);
		alunodao.commit();
	}

	@Test
	public void insereCoordenador() throws ParseException {
		
		Coordenador c1 = new Coordenador();
		c1.setNome("Marcelo Santos");
		c1.setEmail("coordenador@email.com");
		c1.setTelefone("9999-9999");
		c1.setSenha(PasswordUtil.encryptMD5("123"));

		Coordenador c2 = new Coordenador();
		c2.setNome("Maria silva");
		c2.setEmail("coordenadora@email.com");
		c2.setTelefone("9999-9999");
		c2.setSenha(PasswordUtil.encryptMD5("123"));

		CoordenadorDAO coordao = new CoordenadorDAO(PersistenceUtil.getCurrentEntityManager());
		coordao.beginTransaction();
		coordao.insert(c1);
		coordao.insert(c2);
		coordao.commit();
	}

	@Test
	public void insereCursos() throws ParseException {

		Curso c1 = new Curso();
		c1.setNome("Sistema para Internet");
		c1.setRegime(Regime.SEMESTRAL);
		c1.setMatrizc(6);

		Curso c2 = new Curso();
		c2.setNome("Geoprocessamento");
		c2.setRegime(Regime.SEMESTRAL);
		c2.setMatrizc(5);

		Curso c3 = new Curso();
		c3.setNome("Egenharia Eletrica");
		c3.setRegime(Regime.SEMESTRAL);
		c3.setMatrizc(12);

		Curso c4 = new Curso();
		c4.setNome("Automação Industrial");
		c4.setRegime(Regime.BIMESTRAL);
		c4.setMatrizc(12);

		CursoDAO cursodao = new CursoDAO(PersistenceUtil.getCurrentEntityManager());
		cursodao.beginTransaction();
		cursodao.insert(c1);
		cursodao.insert(c2);
		cursodao.insert(c3);
		cursodao.insert(c4);
		cursodao.commit();
	}

	@Test
	public void insereOfertaEstagio() throws ParseException {

		/* Empresa */
		Empresa emp1 = new Empresa();
		emp1.setCnpj("12346546456");
		emp1.setCodAtividadeEcoPric("213213");
		emp1.setDescAtividadeEcoPric("Consultoria em ADM");
		emp1.setEmail("empresa1@email.com");
		emp1.setSenha(PasswordUtil.encryptMD5("123"));
		emp1.setNomeEmpresarial("Severino Silva Souza");
		emp1.setNomeFantasia("ADM & CIA");
		emp1.setAprovado(false);

		Empresa emp2 = new Empresa();
		emp2.setCnpj("1234612121");
		emp2.setCodAtividadeEcoPric("213212");
		emp2.setDescAtividadeEcoPric("Construção Civil");
		emp2.setEmail("empresa2@email.com");
		emp2.setSenha(PasswordUtil.encryptMD5("123"));
		emp2.setNomeEmpresarial("Maria Aparecida");
		emp2.setNomeFantasia("Block & CIA");
		emp2.setAprovado(false);
		
		Empresa emp3 = new Empresa();
		emp3.setCnpj("1234612121");
		emp3.setCodAtividadeEcoPric("213212");
		emp3.setDescAtividadeEcoPric("Construção Civil");
		emp3.setEmail("empresa3@email.com");
		emp3.setSenha(PasswordUtil.encryptMD5("123"));
		emp3.setNomeEmpresarial("Maria Aparecida");
		emp3.setNomeFantasia("Block & CIA");
		emp3.setAprovado(false);

		/* Oferta de Estágio */
		OfertaEstagio ofest1 = new OfertaEstagio();
		ofest1.setTitulo("Manutenção em Redes");
		ofest1.setDetalheFuncao("Fazer manutenção de redes");
		ofest1.setEmailContato("vamostrabalhar@email.com");
		ofest1.setInfoAdicionais("é só isso!");
		ofest1.setQtdeVaga(1);
		ofest1.setRequisitos("Já ter montado uma rede. Conhecer toda a topologia de cabo a rabo");
		ofest1.setCHSemanais(30);
		ofest1.setValorBolsa(500);
		ofest1.setStatus(StatusOfertaEstagio.APROVADO);

		OfertaEstagio ofest2 = new OfertaEstagio();
		ofest2.setTitulo("Estágio em Desenvolvimento BACK-END");
		ofest2.setDetalheFuncao(
				"Programar, fazer café para o chefe e as vezes para o genrente, atender o telefone e etc.");
		ofest2.setEmailContato("vamostrabalhar@email.com");
		ofest2.setInfoAdicionais("é só isso!");
		ofest2.setQtdeVaga(3);
		ofest2.setRequisitos("Tem que programar sem fazer corpo mole");
		ofest2.setCHSemanais(20);
		ofest2.setValorBolsa(500);
		ofest2.setStatus(StatusOfertaEstagio.APROVADO);

		OfertaEstagio ofest3 = new OfertaEstagio();
		ofest3.setTitulo("Estágio em ADM");
		ofest3.setDetalheFuncao("planejar, organizar e controlar");
		ofest3.setEmailContato("vamostrabalhar@email.com");
		ofest3.setInfoAdicionais("é só isso!");
		ofest3.setQtdeVaga(3);
		ofest3.setRequisitos("Tem que programar sem fazer corpo mole");
		ofest3.setCHSemanais(20);
		ofest3.setValorBolsa(500);

		OfertaEstagio ofest4 = new OfertaEstagio();
		ofest4.setTitulo("C sabe C? Vem com a gente");
		ofest4.setDetalheFuncao(
				"Proagramar, fazer café para o chefe as vezes para o genrente, atender o telefone e etc.");
		ofest4.setEmailContato("vamostrabalhar@email.com");
		ofest4.setInfoAdicionais("é só isso!");
		ofest4.setQtdeVaga(3);
		ofest4.setRequisitos("Tem que programar sem fazer corpo mole");
		ofest4.setCHSemanais(20);
		ofest4.setValorBolsa(500);

		OfertaEstagio ofest5 = new OfertaEstagio();
		ofest5.setTitulo("Estágio em geoprocessamento");
		ofest5.setDetalheFuncao(
				"Realizar coleta de informações geoespaciais e processamento de dados cartográficos para elaboração de mapas georreferenciados, cartas topográficas e plantas e entendimento de fenômenos urbanos e ambientais.");
		ofest5.setEmailContato("vamostrabalhar@email.com");
		ofest5.setInfoAdicionais("é só isso!");
		ofest5.setQtdeVaga(3);
		ofest5.setRequisitos("Tem que geoprocessar sem fazer corpo mole");
		ofest5.setCHSemanais(20);
		ofest5.setValorBolsa(500);
		ofest5.setStatus(StatusOfertaEstagio.APROVADO);
		
		OfertaEstagio ofest6 = new OfertaEstagio();
		ofest6.setTitulo("Trabalho escravo");
		ofest6.setDetalheFuncao(
				"Fazer todo o tipo de trabalho desde pequenos consertos de encanamento até levantar prédios");
		ofest6.setInfoAdicionais("é só isso!");
		ofest6.setQtdeVaga(3);
		ofest6.setRequisitos("Não gostar de dinheiro e amar o trabalho como ama a sua vida!:D");
		ofest6.setCHSemanais(20);
		ofest6.setValorBolsa(500);
		ofest6.setStatus(StatusOfertaEstagio.NEGADO);

		/* Empresa 1 */
		emp1.addOfertaEstagio(ofest1);
		emp1.addOfertaEstagio(ofest2);
		emp1.addOfertaEstagio(ofest3);

		/* Empresa 2 */
		emp2.addOfertaEstagio(ofest4);
		emp2.addOfertaEstagio(ofest5);
		
		emp3.addOfertaEstagio(ofest6);

		EmpresaDAO empresadao = new EmpresaDAO(PersistenceUtil.getCurrentEntityManager());
		empresadao.beginTransaction();
		empresadao.insert(emp1);
		empresadao.insert(emp2);
		empresadao.insert(emp3);
		empresadao.commit();

	}

}
