package br.edu.ifpb.stace.facade;

import java.util.ArrayList;
import java.util.List;

public class Resultado {
	private List<Object> entidades;
	private boolean erro;
	private List<Mensagem> mensagens;
	
	public Resultado() {
		this.mensagens = new ArrayList<Mensagem>();
		this.entidades = new ArrayList<Object>();
	}

	public void addMensagem(Mensagem m) {
		this.mensagens.add(m);
	}

	public boolean isErro() {
		return erro;
	}

	public void setErro(boolean erro) {
		this.erro = erro;
	}

	public Object getEntidade() {
		return this.entidades.size()>0?this.entidades.get(0):null;
	}
	
	public void setEntidades(List<Object> entidades) {
		this.entidades = entidades;
	}
	
	public List<Object> getEntidades() {
		return entidades;
	}
	
	public void setEntidade(Object entidade) {
		this.entidades.add(entidade);
	}

	public List<Mensagem> getMensagens() {
		return mensagens;
	}

	public void setMensagens(List<Mensagem> mensagens) {
		this.mensagens = mensagens;
	}

	public void addMensagens(List<String> mensagensErro, Categoria categoria) {
		List<Mensagem> mensagens = new ArrayList<Mensagem>();
		for (String s : mensagensErro) {
			mensagens.add(new Mensagem(s, categoria));
		}
		this.mensagens.addAll(mensagens);
		
	}

}
