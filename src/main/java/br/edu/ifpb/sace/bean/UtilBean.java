package br.edu.ifpb.sace.bean;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.inheritance.Pessoa;
import br.edu.ifpb.sace.dao.CoordenadorDAO;
import br.edu.ifpb.sace.dao.CursoDAO;
import br.edu.ifpb.sace.dao.PersistenceUtil;
import br.edu.ifpb.sace.dao.PessoaDAO;
import br.edu.ifpb.sace.entity.Coordenador;
import br.edu.ifpb.sace.entity.Curso;
import br.edu.ifpb.sace.entity.Empresa;
import br.edu.ifpb.sace.entity.Regime;

public class UtilBean {
	
	public List<Regime> getRegime() {
		List<Regime> regime = new ArrayList<Regime>();
		regime.add(Regime.ANUAL);
		regime.add(Regime.BIMESTRAL);
		regime.add(Regime.SEMESTRAL);
		regime.add(Regime.MENSAL);
		regime.add(Regime.TRIMESTRAL);
		return regime;
	}
	
	public List<Coordenador> getCoordenadores() {
		CoordenadorDAO dao = new CoordenadorDAO(PersistenceUtil.getCurrentEntityManager());
		List<Coordenador> operadoras = dao.findAll();
		return operadoras;
	}
	
	public List<Curso> getCursos() {
		CursoDAO dao = new CursoDAO(PersistenceUtil.getCurrentEntityManager());
		List<Curso> cursos = dao.findAll();
		return cursos;
	}
	public List<Empresa> getEmpresas() {
	
		PessoaDAO dao = new PessoaDAO(PersistenceUtil.getCurrentEntityManager());
		List<Pessoa> pessoas = dao.findAll();
		List<Empresa> empresas = new ArrayList<Empresa>();
		for(Pessoa p: pessoas){
			System.out.println(p.getClass().getSimpleName());
			if(p.getClass().getSimpleName().equals("Empresa"))
				empresas.add((Empresa) p);
		}
		System.out.println(pessoas.size());
		return empresas;
	}


	public static boolean instanceOf(Object obj, String className) {
		return (obj.getClass().getSimpleName().equals(className))?true:false;
	}

}
