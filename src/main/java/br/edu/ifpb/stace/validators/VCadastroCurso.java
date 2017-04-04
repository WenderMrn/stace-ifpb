package br.edu.ifpb.stace.validators;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.edu.ifpb.stace.dao.CoordenadorDAO;
import br.edu.ifpb.stace.dao.PersistenceUtil;
import br.edu.ifpb.stace.entity.Aluno;
import br.edu.ifpb.stace.entity.Coordenador;
import br.edu.ifpb.stace.entity.Curso;
import br.edu.ifpb.stace.entity.Regime;
import br.edu.ifpb.stace.facade.Resultado;
import br.edu.ifpb.stace.validators.domain.IValidator;

public class VCadastroCurso implements IValidator{
	
	private Resultado resultado;
	
	public VCadastroCurso(){
		this.resultado = new Resultado();
	}
	
	@Override
	public Resultado getResultado() {
		return resultado;
	}

	@Override
	public void setResultado(Resultado r) {
		this.resultado = r;
	}

	@Override
	public boolean isValidParameters(Map<String, String[]> parametros) {
		String[] id = parametros.get("id");
		String[] nome = parametros.get("nome");
		String[] codigo = parametros.get("codigo");
		String[] matrizcodigo = parametros.get("matrizcodigo");
		String[] descricao = parametros.get("descricao");
		String[] regime = parametros.get("regime");
		String[] coordenador = parametros.get("coordenador");
		
		List<String> mensagensErro =  new ArrayList<String>();
		Curso curso = new Curso();
		
		//Valida a variavel nome
		if (nome.equals(null) || nome.length == 0 || nome[0].replaceAll("\\s+","").length() < 4) {
			mensagensErro.add("Nome inv�lido!");
		} 
		
		//Valida a variavel codigo
		if (codigo.equals(null) || codigo.length == 0) {
			mensagensErro.add("Codigo inv�lida!");
		}
		
		//Valida a variavel matrizc
		if (matrizcodigo.equals(null) || matrizcodigo.length == 0) {
			mensagensErro.add("Matriz inv�lida!");
		}
		
		//Valida a variavel descricao
		if (descricao.equals(null) || descricao.length == 0) {
			mensagensErro.add("Codigo inv�lida!");
		}
		
		//Valida a variavel descricao
		if (descricao.equals(null) || descricao.length == 0) {
			mensagensErro.add("Descricao inv�lida!");
		}
		
		//Valida a variavel descricao
		if (regime.equals(null) || regime.length == 0) {
			mensagensErro.add("Regime inv�lido!");
		}

		//Valida a variavel descricao
		if (coordenador.equals(null) || coordenador.length == 0) {
			mensagensErro.add("Coordenador inv�lida!");
		}
		
		if (mensagensErro.isEmpty()){
			curso = new Curso();
			curso.setCodigo(Integer.parseInt(codigo[0]));
			curso.setMatrizc(Integer.parseInt(matrizcodigo[0]));
			curso.setDescricao(descricao[0]);
			curso.setNome(nome[0]);
			curso.setRegime(Regime.valueOf(regime[0]));
			
			CoordenadorDAO dao = new CoordenadorDAO(PersistenceUtil.getCurrentEntityManager());
			dao.beginTransaction();
			Coordenador coord = dao.find(Integer.parseInt(coordenador[0]));
			dao.commit();
			
			curso.setCoordenador(coord);
		}
		
		this.resultado = (Resultado) mensagensErro;
/*		this.resultado.setEntidade(entidade);*/
		
		return mensagensErro.isEmpty();
	}
	
}
