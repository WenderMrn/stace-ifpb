package br.edu.ifpb.stace.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.ifpb.inheritance.Pessoa;
import br.edu.ifpb.stace.dao.EmpresaDAO;
import br.edu.ifpb.stace.dao.PersistenceUtil;
import br.edu.ifpb.stace.dao.PessoaDAO;
import br.edu.ifpb.stace.entity.Empresa;
import br.edu.ifpb.stace.util.PasswordUtil;

@ManagedBean
@ViewScoped
public class EmpresaBean extends GenericBean{
	private EmpresaDAO empresaDao;
	private Empresa empresa;
	private String confSenha;
	
	@PostConstruct
	public void init(){
		this.empresaDao = new EmpresaDAO(PersistenceUtil.getCurrentEntityManager());
		this.empresa = new Empresa();
		this.confSenha = "";
	}
		
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public String getConfSenha() {
		return confSenha;
	}

	public void setConfSenha(String confSenha) {
		this.confSenha = confSenha;
	}

	public String aprovar(Empresa empresa){
		this.empresaDao.beginTransaction();
		empresa.setAprovado(true);
		this.empresaDao.update(empresa);
		this.empresaDao.commit();
		return null;
	}
	
	public List<Empresa> getEmpresas() {
		
		PessoaDAO dao = new PessoaDAO(PersistenceUtil.getCurrentEntityManager());
		List<Pessoa> pessoas = dao.findAll();
		List<Empresa> empresas = new ArrayList<Empresa>();
		for(Pessoa p: pessoas){
			System.out.println(p.getClass().getSimpleName());
			if(p instanceof Empresa)
				empresas.add((Empresa) p);
		}
		System.out.println(pessoas.size());
		return empresas;
	}
	
	public String registarEmpresa(){
		String resultado = null;
		if(!this.empresa.getSenha().equals(this.confSenha)){
			this.addErrorMessage("As senhas não correspondem.");
		}else{
			this.empresaDao.beginTransaction();
			this.empresa.setSenha(PasswordUtil.encryptMD5(this.empresa.getSenha()));
			this.empresaDao.insert(this.empresa);
			this.empresaDao.commit();
			this.addSuccessMessage("Empresa cadastrada com sucesso!Aguarde a liberação  da sua conta.");
			resultado = "/pages/login/login?faces-redict=true";
		}
		
		return resultado;
	}

	
}
