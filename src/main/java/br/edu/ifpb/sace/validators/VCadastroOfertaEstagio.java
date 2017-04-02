package br.edu.ifpb.sace.validators;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.codec.binary.StringUtils;

import br.edu.ifpb.sace.dao.CursoDAO;
import br.edu.ifpb.sace.dao.PersistenceUtil;
import br.edu.ifpb.sace.entity.Curso;
import br.edu.ifpb.sace.entity.OfertaEstagio;
import br.edu.ifpb.sace.facade.Categoria;
import br.edu.ifpb.sace.facade.Resultado;
import br.edu.ifpb.sace.validators.domain.IValidator;

public class VCadastroOfertaEstagio implements IValidator{
	
	private Resultado resultado;
	
	public VCadastroOfertaEstagio(){
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
	public boolean isValidParameters(Map<String, String[]> parameters) {
		
		String[] id = parameters.get("id");
		String[] titulo = parameters.get("titulo");
		String[] requisitos = parameters.get("requisitos");
		String[] numvagas = parameters.get("numvagas");
		//String[] telefone = parameters.get("telefone");
		String[] email = parameters.get("email");
		String[] cursos = parameters.get("cursos[]");
		String[] bolsa = parameters.get("bolsa");
		
		List<String> mensagensErro =  new ArrayList<String>();
		OfertaEstagio ofertaEstagio = new OfertaEstagio();
		
		//Validar variavel titulo
		if (titulo.equals(null) || titulo.length == 0 || titulo[0].replaceAll("\\s+","").length() < 4) {
			mensagensErro.add("Titulo inv�lido!");
		}
		
		//Validar variavel requisitos OPCIONAL
		/*if (requisitos.equals(null) || requisitos.length == 0) {
			mensagensErro.add("Requisito inv�lido!");
		}*/
		
		//Validar variavel numvagas
		if (numvagas.equals(null) || numvagas.length == 0 || !isInteger(numvagas[0])) {
			mensagensErro.add("Numero de vagas inv�lido!");
		}
		
		//Valida a variavel email
		String emailregex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		
		if (email.equals(null) || email[0].length() < 6 || email.length == 0 || email[0].isEmpty() || !email[0].matches(emailregex)) {
			mensagensErro.add("Email inv�lido!");
		}
		//bolsa

			ofertaEstagio.setValorBolsa(Double.parseDouble(bolsa[0]));
			ofertaEstagio.setValorBenef(Double.parseDouble(bolsa[0]));

		
		//Validar variavel numvagas
		if (cursos.equals(null) || cursos.length == 0) {
			mensagensErro.add("Numero de vagas inv�lido!");
		}
		
		if (mensagensErro.isEmpty()){
			ofertaEstagio.setTitulo(titulo[0]);
			ofertaEstagio.setRequisitos(requisitos[0]);
			ofertaEstagio.setQtdeVaga(Integer.parseInt(numvagas[0]));
			//ofertaEstagio.setTelefoneContato(telefone[0]);
			ofertaEstagio.setEmailContato(email[0]);
			
			if(cursos != null && cursos.length > 0 && !cursos[0].isEmpty()) {
				CursoDAO dao = new CursoDAO(PersistenceUtil.getCurrentEntityManager());
				
				List<Curso> cs = new ArrayList<Curso>();
				
				dao.beginTransaction();
				for (String id_curso : cursos) {
					Curso c = dao.find(Integer.parseInt(id_curso));
					if(c!=null){
						cs.add(c);
					}
				}
				dao.commit();
				
				if(cs.size() > 0){
					ofertaEstagio.setCursos(cs);
				}
			}
			
		}
		this.resultado.setEntidade(ofertaEstagio);
		this.resultado.addMensagens(mensagensErro,Categoria.ERRO);
		
		return mensagensErro.isEmpty();
		
	}
	
	public boolean isInteger(String str) {
        int size = str.length();

        for (int i = 0; i < size; i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }

        return size > 0;
    }
}
