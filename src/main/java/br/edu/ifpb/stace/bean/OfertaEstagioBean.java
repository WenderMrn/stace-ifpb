package br.edu.ifpb.stace.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.ifpb.stace.controllers.OfertaEstagioController;
import br.edu.ifpb.stace.dao.EmpresaDAO;
import br.edu.ifpb.stace.dao.OfertaEstagioDAO;
import br.edu.ifpb.stace.dao.PersistenceUtil;
import br.edu.ifpb.stace.entity.Empresa;
import br.edu.ifpb.stace.entity.OfertaEstagio;
import br.edu.ifpb.stace.util.StatusOfertaEstagio;

@ManagedBean
@ViewScoped
public class OfertaEstagioBean extends GenericBean{
	
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
		OfertaEstagioController  ofertaEstagioCtrl = new OfertaEstagioController();		
		try {
			ofertaEstagioCtrl.statusOfertaEstagio(ofestagio,StatusOfertaEstagio.APROVADO);
		} catch (Exception e) {
			this.addErrorMessage(e.getMessage());
		}
		
		return null;
	}
	
	public String negarOfertaEstagio(OfertaEstagio ofestagio){
		OfertaEstagioController  ofertaEstagioCtrl = new OfertaEstagioController();		
		try {
			ofertaEstagioCtrl.statusOfertaEstagio(ofestagio,StatusOfertaEstagio.NEGADO);
		} catch (Exception e) {
			this.addErrorMessage(e.getMessage());
		}
		
		return null;
	}
	
}
