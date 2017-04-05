package br.edu.ifpb.stace.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.edu.ifpb.inheritance.Pessoa;
import br.edu.ifpb.stace.dao.CoordenadorDAO;
import br.edu.ifpb.stace.dao.CursoDAO;
import br.edu.ifpb.stace.dao.PersistenceUtil;
import br.edu.ifpb.stace.dao.PessoaDAO;
import br.edu.ifpb.stace.entity.Coordenador;
import br.edu.ifpb.stace.entity.Curso;
import br.edu.ifpb.stace.entity.Empresa;
import br.edu.ifpb.stace.entity.Regime;

@ManagedBean
@SessionScoped
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
	
	public static boolean instanceOf(Object obj, String className) {
		return (obj.getClass().getSimpleName().equals(className))?true:false;
	}

}
