package br.edu.ifpb.sace.validators;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.edu.ifpb.sace.dao.CursoDAO;
import br.edu.ifpb.sace.dao.OfertaEstagioDAO;
import br.edu.ifpb.sace.dao.PersistenceUtil;
import br.edu.ifpb.sace.entity.Aluno;
import br.edu.ifpb.sace.entity.Curso;
import br.edu.ifpb.sace.entity.OfertaEstagio;
import br.edu.ifpb.sace.facade.Resultado;
import br.edu.ifpb.sace.validators.domain.IValidator;

public class VInscAlunoOfertaEstagio implements IValidator{
	
	private Resultado resultado;
	
	public VInscAlunoOfertaEstagio(){
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

	public boolean isValidParameters(Map<String, String[]> parameters) {
		
		List<String> mensagensErro =  new ArrayList<String>();
		OfertaEstagio ofertaEstagio = null;
		
		String[] oferta_estagio = parameters.get("oferta_estagio");
		
		OfertaEstagioDAO dao = new OfertaEstagioDAO(PersistenceUtil.getCurrentEntityManager());
		dao.beginTransaction();
		ofertaEstagio = dao.find(Integer.parseInt(oferta_estagio[0]));
		dao.commit();
		
		if(ofertaEstagio == null){
			mensagensErro.add("Oferta não encontrada");
		}
		
		this.resultado.setEntidade(ofertaEstagio);
		return mensagensErro.isEmpty();
		
	}

}
