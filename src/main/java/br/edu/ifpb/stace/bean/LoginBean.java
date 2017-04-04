package br.edu.ifpb.stace.bean;

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
public class LoginBean extends GenericBean{	
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
			Pessoa p = loginCtrl.autenticar(this.usuario);
			
			if(p instanceof Aluno){
				this.perfil = "ALUNO";
			}else if(p instanceof Empresa){
				this.perfil = "EMPRESA";
			}else if(p instanceof Coordenador){
				this.perfil = "COORDENADOR";
			}
			
			resultado = "/pages/ofertaestagio/listagem.jsf?faces-redirect=true";
			
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
