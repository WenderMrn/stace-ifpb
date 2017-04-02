package br.edu.ifpb.sace.bean;

import java.util.List;

import br.edu.ifpb.sace.dao.EmpresaDAO;
import br.edu.ifpb.sace.dao.OfertaEstagioDAO;
import br.edu.ifpb.sace.dao.PersistenceUtil;
import br.edu.ifpb.sace.entity.Empresa;
import br.edu.ifpb.sace.entity.OfertaEstagio;

public class OfertaEstagioBean {
	
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
	
}
