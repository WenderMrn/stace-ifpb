package br.edu.ifpb.stace.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.edu.ifpb.stace.controllers.OfertaEstagioController;
import br.edu.ifpb.stace.dao.EmpresaDAO;
import br.edu.ifpb.stace.dao.OfertaEstagioDAO;
import br.edu.ifpb.stace.dao.PersistenceUtil;
import br.edu.ifpb.stace.entity.Aluno;
import br.edu.ifpb.stace.entity.Empresa;
import br.edu.ifpb.stace.entity.OfertaEstagio;
import br.edu.ifpb.stace.util.StaceException;
import br.edu.ifpb.stace.util.StatusOfertaEstagio;

@ManagedBean
@ViewScoped
public class OfertaEstagioBean extends GenericBean{
	
	@ManagedProperty(value="#{loginBean}")
	private LoginBean loginBean;
	
	private OfertaEstagioController  ofertaEstagioCtrl;
	
	@PostConstruct
	public void init(){
		this.ofertaEstagioCtrl = new OfertaEstagioController();
	}
	
	
	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public List<OfertaEstagio> getOfertasEstagio() {
		OfertaEstagioDAO dao = new OfertaEstagioDAO(PersistenceUtil.getCurrentEntityManager());
		List<OfertaEstagio> ofertas = dao.findAll();
		return ofertas;
	}
	
	public List<OfertaEstagio> getOfertasEstagio(String id) {
		
		Empresa empresa = new Empresa();
		empresa.setId(Integer.parseInt(id));
		
		return getOfertasEstagio(empresa);
	}
	
	public List<OfertaEstagio> getOfertasEstagio(Object obj) {
		
		if(!(obj instanceof Empresa)) return null;
		
		EmpresaDAO dao = new EmpresaDAO(PersistenceUtil.getCurrentEntityManager());
		Empresa empresa = dao.find(((Empresa)obj).getId());
		
		return empresa.getOfertadasEstagio();
	}
	
	public String aprovarOfertaEstagio(OfertaEstagio ofestagio){		
		try {
			this.ofertaEstagioCtrl.statusOfertaEstagio(ofestagio,StatusOfertaEstagio.APROVADO);
		} catch (Exception e) {
			this.addErrorMessage(e.getMessage());
		}
		
		return null;
	}
	
	public String negarOfertaEstagio(OfertaEstagio ofestagio){
		try {
			this.ofertaEstagioCtrl.statusOfertaEstagio(ofestagio,StatusOfertaEstagio.NEGADO);
		} catch (Exception e) {
			this.addErrorMessage(e.getMessage());
		}
		
		return null;
	}
	
	public String canceInscreverAluno(OfertaEstagio ofestagio){
		try {
			this.ofertaEstagioCtrl.canceInscreverAluno(ofestagio,(Aluno)loginBean.getUsuario());
		} catch (Exception e) {
			this.addErrorMessage(e.getMessage());
		}
		return null;
	}
	
	public String selecionarAluno(OfertaEstagio ofertaEstagio,Aluno aluno){
		try {
			this.ofertaEstagioCtrl.selecionarAluno(ofertaEstagio,aluno);
		} catch (Exception e) {
			this.addErrorMessage(e.getMessage());
		}
		return null;
	}
	
	public String novoEstagio(OfertaEstagio ofertaEstagio, Aluno candidato){
		this.setFlash("OfertaEstagio", ofertaEstagio);
		this.setFlash("Candidato", candidato);
		return "/pages/estagio/cadastro?faces-redirect=true";
	}
	
}
