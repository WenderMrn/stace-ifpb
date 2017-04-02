package br.edu.ifpb.sace.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ifpb.inheritance.Pessoa;
import br.edu.ifpb.sace.controllers.AlunoController;
import br.edu.ifpb.sace.controllers.CursoController;
import br.edu.ifpb.sace.controllers.EmpresaController;
import br.edu.ifpb.sace.controllers.EstagioController;
import br.edu.ifpb.sace.controllers.LoginController;
import br.edu.ifpb.sace.controllers.OfertaEstagioController;
import br.edu.ifpb.sace.entity.Aluno;
import br.edu.ifpb.sace.entity.Coordenador;
import br.edu.ifpb.sace.entity.Curso;
import br.edu.ifpb.sace.entity.Empresa;
import br.edu.ifpb.sace.entity.Estagio;
import br.edu.ifpb.sace.entity.OfertaEstagio;
import br.edu.ifpb.sace.facade.Resultado;
import br.edu.ifpb.sace.util.InsereDadosBanco;
import br.edu.ifpb.sace.util.StatusOfertaEstagio;

@WebServlet("/controller.do")
public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FrontControllerServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().removeAttribute("msgs");
		String operacao = request.getParameter("op");
		if (operacao == null) {
			this.getServletContext().setAttribute("msgs",
					new String[] { "Operação (op) não especificada na requisição!" });
			response.sendRedirect(request.getHeader("Referer"));
			return;
		}

		LoginController loginCtrl = new LoginController();
		CursoController cursoCtrl = new CursoController();
		AlunoController alunoCtrl = new AlunoController();
		OfertaEstagioController ofertaEstagioCtrl = new OfertaEstagioController();
		EstagioController estagioCtrl = new EstagioController();
		EmpresaController empresaCtrl = new EmpresaController();
		
		Resultado resultado = null;
		String paginaSucesso = "controller.do?op=conctt";
		String paginaErro = "contato/cadastro.jsp";
		String proxPagina = null;
		Boolean redirect = true;
		
		HttpSession session = request.getSession(); 
		Pessoa usuario = (Pessoa) session.getAttribute("usuario"); 

		switch (operacao) {
		case "cadaluno":
				redirect = false;
			try {
				resultado= alunoCtrl.cadastrar(request.getParameterMap());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				if(!resultado.isErro()) {
					proxPagina = "pages/login/login.jsp";
					request.setAttribute("msgs", resultado.getMensagens());
					resultado.setErro(false);
				} else{
					request.setAttribute("curso", (Curso) resultado.getEntidade());
					request.setAttribute("msgs", resultado.getMensagens());
					proxPagina= "pages/aluno/cadastro.jsp";
					resultado.setErro(true);
				}
			break;	
		case "login" :
			redirect = false;
			paginaSucesso = "pages/dashboard/dashboard.jsp";
			paginaErro = "pages/login/login.jsp";
			resultado = loginCtrl.isValido(request.getParameterMap());
			if (resultado.isErro()) {
				
				request.setAttribute("msgs", resultado.getMensagens());
				proxPagina = paginaErro;
			} else { 
					redirect = true;
					request.setAttribute("msgs", resultado.getMensagens());
					session.setAttribute("usuario", (Pessoa) resultado.getEntidade());
					proxPagina = paginaSucesso; 
					String lembrar = request.getParameter("lembrar");
					if (lembrar != null) { 
						Cookie c = new Cookie("loginCookie", usuario.getEmail()); 
						c.setMaxAge(-1); 
						response.addCookie(c); 
						} else { 
							for (Cookie cookie : request.getCookies()) {  
								if (cookie.getName().equals("loginCookie")) {
									cookie.setValue(null);  
									cookie.setMaxAge(0);   
									response.addCookie(cookie);  
									    
							}
						}
					}
				 } 
			 break; 
		case "logout" :  
				proxPagina = "pages/login/login.jsp";
				redirect = true;
				request.getSession().invalidate(); 
				resultado = new Resultado();
				resultado.setErro(false);
		break;
		case "cadcur":
			redirect = false;
			try {
				resultado= cursoCtrl.cadastrar(request.getParameterMap());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(!resultado.isErro()) {
				proxPagina = "pages/curso/cadastro.jsp";
				request.setAttribute("msgs", resultado.getMensagens());
				resultado.setErro(false);
			} else{
				request.setAttribute("curso", (Curso) resultado.getEntidade());
				request.setAttribute("msgs", resultado.getMensagens());
				proxPagina= "pages/curso/cadastro.jsp";
				resultado.setErro(true);
			}
		break;		
		case "cadoftest":
			
			if(!(usuario instanceof Empresa)) break;
			
			redirect = false;
			
			try {
				resultado = ofertaEstagioCtrl.cadastrar(request.getParameterMap(),(Empresa)usuario);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(!resultado.isErro()) {
				proxPagina = "pages/ofertaestagio/cadastro.jsp";
				request.setAttribute("msgs", resultado.getMensagens());
				resultado.setErro(false);
			} else{
				request.setAttribute("ofertaEstagio", (OfertaEstagio) resultado.getEntidade());
				request.setAttribute("msgs", resultado.getMensagens());
				proxPagina= "pages/ofertaestagio/cadastro.jsp";
				resultado.setErro(true);
			}
		break;
		case "cadest":
			redirect = false;
			resultado= estagioCtrl.cadastrar(request.getParameterMap());
			if(!resultado.isErro()) {
				proxPagina = "pages/estagio/cadastro.jsp";
				request.setAttribute("msgs", resultado.getMensagens());
				resultado.setErro(false);
			} else{
				request.setAttribute("estagio", (Estagio) resultado.getEntidade());
				request.setAttribute("msgs", resultado.getMensagens());
				proxPagina= "pages/estagio/cadastro.jsp";
				resultado.setErro(true);
			}
		break;
		case "cademp":
			redirect = false;
					
			resultado= empresaCtrl.cadastrar(request.getParameterMap());
			if(!resultado.isErro()) {
				proxPagina = "pages/login/login.jsp";
				request.setAttribute("msgs", resultado.getMensagens());
				resultado.setErro(false);
			} else{
				request.setAttribute("Empresa", (Empresa) resultado.getEntidade());
				request.setAttribute("msgs", resultado.getMensagens());
				proxPagina= "pages/empresa/cadastro.jsp";
				resultado.setErro(true);
			}
		break;
		case "inscanccalu":
			
			if(!(usuario instanceof Aluno)) break;
			
			redirect = true;
			proxPagina = "pages/ofertaestagio/listagem.jsp";
			Aluno aluno = (Aluno) usuario;
			resultado =  new Resultado();
			try {
				resultado = ofertaEstagioCtrl.canceInscreverAluno(request.getParameterMap(),aluno);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(!resultado.isErro()) {
				request.setAttribute("msgs", resultado.getMensagens());
				resultado.setErro(false);
			} else{
				request.setAttribute("msgs", resultado.getMensagens());
				redirect = false;
				proxPagina= "pages/ofertaestagio/listagem.jsp";
				resultado.setErro(true);
			}
		break;
		case "selalu":
			
			if(!(usuario instanceof Empresa)) break;
			
			redirect = true;
			proxPagina = "pages/ofertaestagio/gerencia.jsp";
			resultado =  new Resultado();
			try {
				resultado = ofertaEstagioCtrl.selecionarAluno(request.getParameterMap());
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			proxPagina= "pages/ofertaestagio/gerencia.jsp";
			redirect = false;
			if(!resultado.isErro()) {
				request.setAttribute("msgs", resultado.getMensagens());
				resultado.setErro(false);
			} else{
				request.setAttribute("msgs", resultado.getMensagens());
				resultado.setErro(true);
			}
		break;
		case "novoest":
			
			if(!(usuario instanceof Empresa)) break;
			
			redirect = true;
			proxPagina = "pages/estagio/cadastro.jsp";
			resultado =  new Resultado();
			try {
				resultado = estagioCtrl.cadastrarByOferta(request.getParameterMap());
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			redirect = false;
			if(!resultado.isErro()) {
				
				for (Object obj :resultado.getEntidades()) {
					if(obj instanceof Aluno){
						request.setAttribute("aluno",(Aluno)obj);
					}else if(obj instanceof OfertaEstagio){
						request.setAttribute("ofertaEstagio",(OfertaEstagio)obj);
					}
				}
				
				request.setAttribute("msgs", resultado.getMensagens());
				resultado.setErro(false);
			} else{
				request.setAttribute("msgs", resultado.getMensagens());
				resultado.setErro(true);
			}
		break;
		case "aproortu":
			
			if(!(usuario instanceof Coordenador)) break;
			
			redirect = true;
			proxPagina = "pages/ofertaestagio/listagem.jsp";
			resultado =  new Resultado();
			try {
				resultado = ofertaEstagioCtrl.statusOfertaEstagio(request.getParameterMap(),StatusOfertaEstagio.APROVADO);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(!resultado.isErro()) {
				request.setAttribute("msgs", resultado.getMensagens());
				resultado.setErro(false);
			} else{
				request.setAttribute("msgs", resultado.getMensagens());
				resultado.setErro(true);
			}
		break;
		case "negoportu":
			
			if(!(usuario instanceof Coordenador)) break;
			
			redirect = true;
			proxPagina = "pages/ofertaestagio/listagem.jsp";
			resultado =  new Resultado();
			try {
				resultado = ofertaEstagioCtrl.statusOfertaEstagio(request.getParameterMap(),StatusOfertaEstagio.NEGADO);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(!resultado.isErro()) {
				request.setAttribute("msgs", resultado.getMensagens());
				resultado.setErro(false);
			} else{
				request.setAttribute("msgs", resultado.getMensagens());
				redirect = false;
				proxPagina= "pages/ofertaestagio/listagem.jsp";
				resultado.setErro(true);
			}
		break;
		case "actemp":
					System.out.println("entrou");	
			redirect = true;
			proxPagina = "pages/dashboard/dashboard.jsp";
			resultado =  new Resultado();
			try {
				resultado = empresaCtrl.actEmpresas(request.getParameterMap());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(!resultado.isErro()) {
				request.setAttribute("msgs", resultado.getMensagens());
				resultado.setErro(false);
			} else{
				request.setAttribute("msgs", resultado.getMensagens());
				redirect = false;
				proxPagina= "pages/dashboard/dashboard.jsp";
				resultado.setErro(true);
			}
		break;
		default:
			redirect = true;
			request.setAttribute("erro", "Operação não especificada no servlet!");
			proxPagina = "../erro/erro.jsp";
		}
		
		if(!redirect){
			RequestDispatcher dispatcher = request.getRequestDispatcher(proxPagina);
			dispatcher.forward(request, response);
		}else{
			response.sendRedirect(proxPagina);
		}
	}

}
