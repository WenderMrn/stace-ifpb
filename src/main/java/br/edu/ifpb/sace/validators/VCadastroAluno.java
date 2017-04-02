package br.edu.ifpb.sace.validators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import br.edu.ifpb.sace.dao.CursoDAO;
import br.edu.ifpb.sace.dao.PersistenceUtil;
import br.edu.ifpb.sace.entity.Aluno;
import br.edu.ifpb.sace.entity.Curso;
import br.edu.ifpb.sace.facade.Categoria;
import br.edu.ifpb.sace.facade.Resultado;
import br.edu.ifpb.sace.util.PasswordUtil;
import br.edu.ifpb.sace.validators.domain.IValidator;

public class VCadastroAluno implements IValidator {
	Aluno aluno = new Aluno();
	private Resultado resultado;
	
	public VCadastroAluno(){
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

		// Reavaliar os parametros
		String[] nome = parametros.get("nome");
		String[] matricula = parametros.get("matricula");
		String[] competencias = parametros.get("competencias");
		String[] telefone = parametros.get("telefone");
		String[] curso_codigo = parametros.get("curso");
		String[] senha = parametros.get("senha");
		String[] email = parametros.get("email");

		List<String> mensagensErro =  new ArrayList<String>();
		
		//Valida a variavel nome
		if (nome.equals(null) || nome.length == 0 || nome[0].replaceAll("\\s+","").length() < 4) {
			mensagensErro.add("Nome inválido!");
			System.out.println("entrou1");
		} 
		
		//Valida a variavel matricula
		if (nome.equals(null) || matricula.length == 0 || !validarMatricula(matricula[0])) {
			mensagensErro.add("Matrícula inválida!");System.out.println("entrou2");
		} 
		
		//Valida a variavel telefone
		//String phoneregex = "^(?:(?([0-9]{2}))?[-. ]?)?([0-9]{4,5})[-. ]?([0-9]{4})$";
		/*|| !telefone[0].matches(phoneregex)*/
		if (nome.equals(null) || telefone.length == 0)  {
			mensagensErro.add("Telefone inválido!");System.out.println("entrou3");
		} 
		
		//Valida a variavel competencia
		if (competencias.equals(null) || competencias.length == 0 || competencias[0].isEmpty()) {
			mensagensErro.add("Competência inválido!");System.out.println("entrou4");
		} 
		
		//Valida a variavel curso_codigo
		if (curso_codigo.equals(null) || curso_codigo.length == 0 || curso_codigo[0].isEmpty()) {
			mensagensErro.add("Curso inválido!");System.out.println("entrou5");
		}
		
		//Valida a variavel senha
		if (senha.equals(null) || senha[0].length() < 6 || senha.length == 0 || senha[0].isEmpty()) {
			mensagensErro.add("Senha inválida!");System.out.println("entrou6");
		}
		
		//Valida a variavel email
		String emailregex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		
		if (email.equals(null) || email[0].length() < 6 || email.length == 0 || email[0].isEmpty() || !email[0].matches(emailregex)) {
			mensagensErro.add("Email inválido!");System.out.println("entrou7");
		}

		//Se nao foi encontrado nenhum erro na validacao dos dados
		if (mensagensErro.isEmpty()){
			aluno.setNome(nome[0]);
			aluno.setMatricula(matricula[0]);
			aluno.setTelefone(telefone[0]);
			aluno.setEmail(email[0]);
			aluno.setCompetencia(Arrays.asList(competencias));

            String senhaMD5 = PasswordUtil.encryptMD5(senha[0]);
            aluno.setSenha(senhaMD5);

			CursoDAO dao = new CursoDAO(PersistenceUtil.getCurrentEntityManager());
			dao.beginTransaction();
			System.out.println(curso_codigo[0]);
			Curso curso = dao.find(Integer.parseInt(curso_codigo[0]));
			dao.commit();

			aluno.setCurso(curso);
		}
		this.resultado.addMensagens(mensagensErro, Categoria.ERRO);
		this.resultado.setEntidade(aluno);
		return mensagensErro.isEmpty();
	}
	
	//Investiga se ha alguma letra dentro da string.
	public static boolean validarMatricula(String s) {
	    if (s != null && !s.isEmpty()) {
	        for (char c : s.toCharArray()) {
	            if (Character.isLetter(c)) {
	                return false;
	            }
	        }
	        //Caso nao exista nenhuma letra na matricula
	        return true;
	    }
	    return false;
	}
}
