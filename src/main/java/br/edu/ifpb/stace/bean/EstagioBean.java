package br.edu.ifpb.stace.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.edu.ifpb.stace.controllers.EstagioController;
import br.edu.ifpb.stace.entity.Aluno;
import br.edu.ifpb.stace.entity.Empresa;
import br.edu.ifpb.stace.entity.Estagio;
import br.edu.ifpb.stace.entity.OfertaEstagio;
import br.edu.ifpb.stace.util.StaceException;

@ManagedBean
@ViewScoped
public class EstagioBean extends GenericBean{
	@ManagedProperty(value="#{loginBean}")
	private LoginBean loginBean;
	
	private EstagioController estagioCtrl;
	private Estagio estagio;
	private OfertaEstagio ofertaEstagio;
	private Aluno candidatoEstagio;
	
	@PostConstruct
	public void init(){
		this.estagioCtrl =  new EstagioController();
		this.estagio = new Estagio();
		this.candidatoEstagio = (Aluno)this.getFlash("Candidato");
		this.ofertaEstagio = (OfertaEstagio)this.getFlash("OfertaEstagio");
		
		if(candidatoEstagio == null){
			this.candidatoEstagio = new Aluno();
		}
		
		if(this.ofertaEstagio == null){
			this.ofertaEstagio = new OfertaEstagio();
		}
	}
	
	
	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public OfertaEstagio getOfertaEstagio() {
		return ofertaEstagio;
	}

	public void setOfertaEstagio(OfertaEstagio ofertaEstagio) {
		this.ofertaEstagio = ofertaEstagio;
	}
	
	public Aluno getCandidatoEstagio() {
		return candidatoEstagio;
	}

	public void setCandidatoEstagio(Aluno candidatoEstagio) {
		this.candidatoEstagio = candidatoEstagio;
	}
	
	public Estagio getEstagio() {
		return estagio;
	}

	public void setEstagio(Estagio estagio) {
		this.estagio = estagio;
	}

	public String salvarEstagio(){
		String resultado = null;
		try {
			Estagio e = this.estagioCtrl.cadastrar(this.estagio,this.ofertaEstagio,this.candidatoEstagio,(Empresa)this.loginBean.getUsuario());
			this.addSuccessMessage("Estágio cadastrado com sucesso!");
			this.init();
		} catch (StaceException e) {
			this.addErrorMessage(e.getMessage());
		}
		
		return resultado;
	}
	
}
