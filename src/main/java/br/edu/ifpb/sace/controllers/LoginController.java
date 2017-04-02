package br.edu.ifpb.sace.controllers;

import java.util.Map;

import br.edu.ifpb.inheritance.Pessoa;
import br.edu.ifpb.sace.dao.PessoaDAO;
import br.edu.ifpb.sace.facade.Categoria;
import br.edu.ifpb.sace.facade.Mensagem;
import br.edu.ifpb.sace.facade.Resultado;
import br.edu.ifpb.sace.util.PasswordUtil;

public class LoginController {

	public Resultado isValido(Map<String, String[]> parametros) {
		Resultado resultado = new Resultado();
		resultado.setErro(false);
		String login = parametros.get("login")[0];
		String passwd = parametros.get("senha")[0];
		String [] perfil = parametros.get("perfil");
		
		System.out.println(perfil[0]);
		
		PessoaDAO pessoadao = new PessoaDAO();
		Pessoa pessoa = pessoadao.findByLogin(login);
		
		if (pessoa != null) {
			if (pessoa.getSenha().equals(PasswordUtil.encryptMD5(passwd))) {
				if(pessoa.isAprovado()){
				resultado.setEntidade(pessoa);
				resultado.addMensagem(new Mensagem("Logado com sucesso!(só direcionar o individuo)", Categoria.INFO));
				}else{
					resultado.setErro(true);
					resultado.addMensagem(new Mensagem("Usu�rio n�o aprovado ainda!", Categoria.ERRO));}
			} else {
				resultado.setErro(true);
				resultado.addMensagem(new Mensagem("Usuário ou senha inválido(a).", Categoria.ERRO));
			}
		} else {
			resultado.setErro(true);
			resultado.addMensagem(new Mensagem("Usuário ou senha inválido(a).", Categoria.ERRO));
		}
		return resultado;
	}
}
