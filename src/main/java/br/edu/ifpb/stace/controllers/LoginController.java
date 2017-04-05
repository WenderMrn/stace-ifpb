package br.edu.ifpb.stace.controllers;

import br.edu.ifpb.inheritance.Pessoa;
import br.edu.ifpb.stace.dao.PessoaDAO;
import br.edu.ifpb.stace.util.PasswordUtil;
import br.edu.ifpb.stace.util.StaceException;

public class LoginController {

	public Pessoa autenticar(Pessoa pessoa) throws Exception {
	
		String login = pessoa.getEmail();
		String passwd = pessoa.getSenha();
		
		PessoaDAO pessoadao = new PessoaDAO();
		Pessoa p = pessoadao.findByLogin(login);
		
		if (p != null) {
			if (p.getSenha().equals(PasswordUtil.encryptMD5(passwd))) {
				if(!p.isAprovado()){
					throw new StaceException("Usuário aguardando aprovação!");
				}
			} else {
				throw new StaceException("Usuário ou senha inválido(a).");
			}
		} else {
			throw new StaceException("Usuário ou senha inválido(a).");
		}
		return p;
	}
}
