package br.edu.ifpb.sace.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import br.edu.ifpb.inheritance.Pessoa;
import br.edu.ifpb.sace.dao.EmpresaDAO;
import br.edu.ifpb.sace.dao.PersistenceUtil;
import br.edu.ifpb.sace.dao.PessoaDAO;
import br.edu.ifpb.sace.entity.Empresa;
import br.edu.ifpb.sace.facade.Categoria;
import br.edu.ifpb.sace.facade.Resultado;
import br.edu.ifpb.sace.util.PasswordUtil;
import br.edu.ifpb.sace.util.StatusOfertaEstagio;

public class EmpresaController {
	private Empresa empresa;
	private List<String> mensagensErro;
	
	public Resultado cadastrar(Map<String, String[]> parametros){
		Resultado resultado= new Resultado();
		
		if(isParametrosValidos(parametros)){
			EmpresaDAO dao = new EmpresaDAO(PersistenceUtil.getCurrentEntityManager());
			dao.beginTransaction();
			
			if(this.empresa.getId() == null) {
				dao.insert(this.empresa);
			} else{
				dao.update(this.empresa);
			}
			dao.commit();
			
			resultado.setErro(false);
			resultado.addMensagens(Collections.singletonList("Sucesso! Aguarde confirmação da coordenação."),Categoria.INFO);
			resultado.setEntidade(this.empresa);
		}else{
			resultado.setEntidade(this.empresa);
			resultado.setErro(true);
			resultado.addMensagens(this.mensagensErro,Categoria.ERRO);
			
		}
		return resultado;
	}
	
	public boolean isParametrosValidos(Map<String, String[]> parametros){
		
		String[] email = parametros.get("email");
		String[] senha = parametros.get("senha");
	
		String[] nomeempresarial = parametros.get("nomeemp");
		String[] nomeFantasia = parametros.get("nomefan");
		String[] responsavel = parametros.get("responsavel");
		String[] cnpj = parametros.get("cnpj");
		String[] endereco = parametros.get("endereco");
		String[] codAtividadeEcoPric = parametros.get("codecoprincipal");
		String[] descAtividadeEcoPric = parametros.get("descecoprincipal");
		String[] codNaturezaJuridica = parametros.get("codnatjuridica");
		String[] desNaturezaJuridica = parametros.get("descnatjuridica");
		
		String[] telefone = parametros.get("telefone");
		
		this.mensagensErro= new ArrayList<String>();
		
		this.empresa = new Empresa();
		
		this.empresa.setEmail(email[0]);
		this.empresa.setSenha(PasswordUtil.encryptMD5(senha[0]));
		
		this.empresa.setNomeEmpresarial(nomeempresarial[0]);
		this.empresa.setNomeFantasia(nomeFantasia[0]);
		this.empresa.setCnpj(cnpj[0]);
		this.empresa.setResponsavel(responsavel[0]);
		this.empresa.setCodAtividadeEcoPric(codAtividadeEcoPric[0]);
		this.empresa.setDescAtividadeEcoPric(descAtividadeEcoPric[0]);
		this.empresa.setCodNaturezaJuridica(codNaturezaJuridica[0]);
		this.empresa.setDesNaturezaJuridica(desNaturezaJuridica[0]);
		this.empresa.setEndereco(endereco[0]);
		this.empresa.setTelefone(telefone[0]);
		this.empresa.setAprovado(false);
		
		
		return this.mensagensErro.isEmpty();
	}

	public Resultado actEmpresas(Map<String, String[]> parameterMap) {
		Resultado resultado = new Resultado();
		String[] empresas = parameterMap.get("empresas");
		
		Empresa e;
		EmpresaDAO dao = new EmpresaDAO(PersistenceUtil.getCurrentEntityManager());
		dao.beginTransaction();
		
		for(String emp: empresas){
			e = dao.find(Integer.parseInt(emp));
			e.setAprovado(true);
			dao.update(e);
			
		}
		dao.commit();
		System.out.println();
		resultado.setErro(false);
		resultado.addMensagens(Collections.singletonList("Sucesso! Confirmados."),Categoria.INFO);
		resultado.setEntidade(this.empresa);
		
		return resultado;
	}
}
