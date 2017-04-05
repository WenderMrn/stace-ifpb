package br.edu.ifpb.stace.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.edu.ifpb.inheritance.Pessoa;
import br.edu.ifpb.stace.controllers.LoginController;
import br.edu.ifpb.stace.entity.Aluno;
import br.edu.ifpb.stace.entity.Coordenador;
import br.edu.ifpb.stace.entity.Empresa;
import br.edu.ifpb.stace.util.StaceException;

@ManagedBean
@SessionScoped
public class LoginBean extends GenericBean implements Serializable{	
	private static final long serialVersionUID = 1L;
	private Pessoa usuario;
	private String perfil;
	
	@PostConstruct
	public void init(){
		this.usuario = new Pessoa();
	}

	public Pessoa getUsuario() {
		return usuario;
	}

	public void setUsuario(Pessoa usuario) {
		this.usuario = usuario;
	}
	
	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String autenticar() throws Exception{
		String resultado = null;
		
		try {
			
			LoginController loginCtrl = new LoginController();	
			this.usuario = loginCtrl.autenticar(this.usuario);
			
			resultado = "/pages/ofertaestagio/listagem.jsf?faces-redirect=true";
			if(this.usuario instanceof Aluno){
				this.perfil = "ALUNO";
			}else if(this.usuario instanceof Empresa){
				this.perfil = "EMPRESA";
				resultado = "/pages/ofertaestagio/gerenciar.jsf?faces-redirect=true";
			}else if(this.usuario instanceof Coordenador){
				this.perfil = "COORDENADOR";
			}
			
		} catch (StaceException e) {
			this.addErrorMessage(e.getMessage());
		}
		return resultado;
	}
	
	public String logout() {
		this.invalidateSession();
		return "/pages/login/login?faces-redirect=true";
	}
}
