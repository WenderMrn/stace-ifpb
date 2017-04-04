package br.edu.ifpb.stace.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import br.edu.ifpb.stace.dao.AlunoDAO;
import br.edu.ifpb.stace.dao.EstagioDAO;
import br.edu.ifpb.stace.dao.OfertaEstagioDAO;
import br.edu.ifpb.stace.dao.PersistenceUtil;
import br.edu.ifpb.stace.entity.Aluno;
import br.edu.ifpb.stace.entity.Estagio;
import br.edu.ifpb.stace.entity.OfertaEstagio;
import br.edu.ifpb.stace.facade.Categoria;
import br.edu.ifpb.stace.facade.Resultado;
import br.edu.ifpb.stace.util.DataHelper;

public class EstagioController {
	
	private Estagio estagio;
	private OfertaEstagio oferta;
	private Aluno canditato;
	private List<String> mensagensErro;
	
	public Resultado cadastrar(Map<String, String[]> parametros){
		Resultado resultado= new Resultado();
		
		if(isParametrosValidos(parametros)){
			EstagioDAO dao = new EstagioDAO(PersistenceUtil.getCurrentEntityManager());
			dao.beginTransaction();
			
			if(this.estagio.getId() == null) {
				dao.insert(this.estagio);
			} else{
				dao.update(this.estagio);
			}
			dao.commit();
			
			resultado.setErro(false);
			resultado.addMensagens(Collections.singletonList("Estágio criado com sucesso"),Categoria.INFO);
			resultado.setEntidade(this.estagio);
		}else{
			resultado.setEntidade(this.estagio);
			resultado.setErro(true);
			resultado.addMensagens(this.mensagensErro,Categoria.ERRO);
			
		}
		return resultado;
	}
	
	public Resultado cadastrarByOferta(Map<String, String[]> parametros){
		Resultado resultado= new Resultado();
		
		if(isParametrosValidos2(parametros)){
			
			resultado.setErro(false);
			resultado.setEntidade(this.oferta);
			resultado.setEntidade(this.canditato);
			
		}else{
			resultado.setErro(true);
			resultado.addMensagens(this.mensagensErro,Categoria.ERRO);
			
		}
		return resultado;
	}
	
	public boolean isParametrosValidos2(Map<String, String[]> parametros){
		String[] p_candidato = parametros.get("candidato");
		String[] p_oferta = parametros.get("oferta");

		List<String> mensagensErro =  new ArrayList<String>();
		Aluno aluno = null;
		OfertaEstagio oferta = null;
		

		AlunoDAO alunodao = new AlunoDAO(PersistenceUtil.getCurrentEntityManager());
		aluno = alunodao.find(Integer.parseInt(p_candidato[0]));
		
		OfertaEstagioDAO ofertadao = new OfertaEstagioDAO(PersistenceUtil.getCurrentEntityManager());
		oferta = ofertadao.find(Integer.parseInt(p_oferta[0]));
		
		this.oferta = oferta;
		this.canditato = aluno;
		
		if(this.oferta == null || this.canditato == null){
			mensagensErro.add("Oferta de Estagio e/ou aluno não podem ser nulos");
		}
		
		return mensagensErro.isEmpty();
	}
	
	public boolean isParametrosValidos(Map<String, String[]> parametros){
		
		String[] id = parametros.get("id");
		String[] titulo = parametros.get("titulo");
		String[] cargosetor = parametros.get("cargosetor");
		String[] detalhefuncao = parametros.get("detalhefuncao");
		String[] chsemanais = parametros.get("chsemanais");
		String[] valorbolsa = parametros.get("valorbolsa");
		String[] valorbene = parametros.get("valorbene");
		String[] datainicio = parametros.get("inicioestagio");
		String[] fimestagio = parametros.get("fimestagio");
		String[] supervisor = parametros.get("supervisor");
		String[] infoadicionais = parametros.get("infoadicionais");
		String[] horario = parametros.get("horario");
		String[] id_aluno = parametros.get("aluno");
		
		AlunoDAO alunodao = new AlunoDAO(PersistenceUtil.getCurrentEntityManager());
		this.canditato = alunodao.find(Integer.parseInt(id_aluno[0]));
		
		ArrayList<String> mensagensErro = new ArrayList<String>();
		
		if (parametros.containsKey(titulo) && titulo.equals("") || titulo.equals(null)) {
			mensagensErro.add("T�tulo inv�lido!");
		}
		
		if (parametros.containsKey(cargosetor) && cargosetor.equals("") || cargosetor.equals(null) || cargosetor[0].length() < 3 ) {
			mensagensErro.add("Cargo inv�lido!");;
		}
		
		if (parametros.containsKey(detalhefuncao) && detalhefuncao.equals("") || detalhefuncao.equals(null) || detalhefuncao[0].length() < 6) {
			mensagensErro.add("Detalhe da funcao inv�lido!");
		}
		
		if (parametros.containsKey(chsemanais) && chsemanais.equals("") && chsemanais.equals(null)) {
			mensagensErro.add("Carga hor�ria inv�lida!");
		}
		
		if (parametros.containsKey(valorbolsa) && valorbolsa.equals("") || valorbolsa.equals(null) || valorbolsa[0].length() < 3) {
			mensagensErro.add("Valor da bolsa inv�lido!");
		}
		
		if (parametros.containsKey(valorbene) && valorbene.equals("") || valorbene.equals(null) || valorbene[0].length() < 3 ) {
			mensagensErro.add("Valor benef�cio inv�lido!");;
		}
		
		if (parametros.containsKey(datainicio) && datainicio.equals("") || datainicio.equals(null) || datainicio[0].length() < 6) {
			mensagensErro.add("Data de inicio inv�lido!");
		}
		
		if (parametros.containsKey(fimestagio) && fimestagio.equals("") && fimestagio.equals(null) || datainicio[0].length() < 6) {
			mensagensErro.add("Data de fim inv�lida!");
		}
		
		if (parametros.containsKey(supervisor) && supervisor.equals("") || supervisor.equals(null) || supervisor[0].length() < 3 ) {
			mensagensErro.add("Supervisor inv�lido!");;
		}
		
		if (parametros.containsKey(infoadicionais) && infoadicionais.equals("") || infoadicionais.equals(null) || infoadicionais[0].length() < 3) {
			mensagensErro.add("Informacoes adicionais inv�lidas!");
		}
		
		if (parametros.containsKey(horario) && horario.equals("") && horario.equals(null) || horario[0].length() < 4) {
			mensagensErro.add("Horario inv�lido!");
		}
		
		this.estagio = new Estagio();
		this.estagio.setTitulo(titulo[0]);
		this.estagio.setSetor(cargosetor[0]);
		this.estagio.setDetalheFuncao(detalhefuncao[0]);
		this.estagio.setCHSemanais(Double.parseDouble(chsemanais[0]));
		this.estagio.setValorBolsa(Double.parseDouble(valorbolsa[0]));
		this.estagio.setValorBenef(Double.parseDouble(valorbene[0]));
		this.estagio.setHorario(horario[0]);
		try{
			this.estagio.setDInicio((DataHelper.stringToDate(datainicio[0])));
			this.estagio.setDFim((DataHelper.stringToDate(fimestagio[0])));
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		this.estagio.setInfoAdicionais(infoadicionais[0]);
		this.estagio.setSupervisor(supervisor[0]);
		this.estagio.setAluno(this.canditato);
		
		return mensagensErro.isEmpty();
	}

}
