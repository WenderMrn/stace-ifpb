<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="mm" tagdir="/WEB-INF/tags/messages"%>
<%@taglib prefix="tt" tagdir="/WEB-INF/tags/templating"%>     

<tt:template title="Cadastro Oferta de Estágio">
	<jsp:attribute name="tscript">
	</jsp:attribute>
	<jsp:body>	
		<div class="container">
			<div class="jumbotron">
				<div class="row">
					<div class="col-md-12 text-center">
						<h3>Ofertas de Estágio</h3>
						<hr/>
						<h6>Veja os candidatos as vagas de estágios listados abaixo</h6>
					</div>	
				</div>
				<mm:messages value="${msgs}"/>
				<div class="row">
					<div class="panel-group" id="accordion">
					<c:forEach var="oferta" items="${ofertaEstagioBean.getOfertasEstagio(sessionScope.usuario)}">
						  <div class="panel panel-default}">
						    <div class="panel-heading">
						    	<div class="row">
						    		<div class="col-md-10">
						    		<h4 class="panel-title">
								        <a data-toggle="collapse" data-parent="#accordion" href="#accordion${oferta.id}">
								        	${oferta.titulo}
								        </a>
								      </h4>
						    		</div>
						    		<c:if test="${oferta.status eq 'AGUARDANDO'}">
								    	<div class="col-md-2">
								    		<a class="btn btn-warning btn-xs disabled"><i class="glyphicon glyphicon-time"></i> Em Análise</a>
								    	</div>
							    	</c:if>
							    	<c:if test="${oferta.status eq 'NEGADO'}">
								    	<div class="col-md-2">
								    		<a class="btn btn-danger btn-xs disabled">Negado</a>
								    	</div>
							    	</c:if>		
							    	<c:if test="${oferta.status eq 'APROVADO'}">
							    		<div class="col-md-2">
							    			 <a class="btn btn-success btn-xs">
							    			 	<i class="glyphicon glyphicon-pencil"></i> Inscritos ${fn:length(oferta.candidatos)}
							    			 </a>
							    		</div>
						    		</c:if>
						    	</div>
						    </div>
						    <div id="accordion${oferta.id}" class="panel-collapse collapse in">
						      <div class="panel-body">
						      	<div class="row">
						      		<div class="col-md-11">
						      			<b>Função:</b> ${oferta.detalheFuncao}
						      		</div>
						      	</div>
						      	<div class="row">
						      		<div class="col-md-11">
						      			<b>Requisitos:</b> ${oferta.requisitos}
						      		</div>
						      	</div>
						      	<div class="row">
						      		<div class="col-md-2">
						      			<b>Valor da bolsa:</b> ${oferta.valorBolsa}
						      		</div>
						      		<div class="col-md-2">
						      			<b>Valor Benefício:</b> ${oferta.valorBenef}
						      		</div>
						      		<div class="col-md-2">
						      			<b>CH Semanais:</b> ${oferta.CHSemanais}
						      		</div>
						      		<div class="col-md-2">
						      			<b>Vagas:</b> ${oferta.qtdeVaga}
						      		</div>
						      		<div class="col-md-2">
						      			<b>Email Conato:</b> ${oferta.emailContato}
						      		</div>
						      	</div>
						      	<br>
						      	<c:if test="${fn:length(oferta.candidatos) gt 0}">
							      	<div class="row">
							      		<div class="col-md-12">
							      			<b>Condidatos Inscritos</b>
							      		</div>
							      		<hr />
							      	</div>
						      	</c:if> 
						      	<c:forEach var="candidato" items="${oferta.candidatos}">
								      <div class="row">
									      <div class="col-md-3">
										      <b>Nome:</b> ${candidato.nome}
									      </div>
									      <div class="col-md-3">
										      <b>Matrícula:</b> ${candidato.matricula}
									      </div>
									       <div class="col-md-offset-2 col-md-4">
									       	<div class="col-md-3">
										      	<button type="submit" class="btn btn-info btn-xs"><i class="glyphicon glyphicon-user"></i> Ver</button>
										      </div>
										      <c:if test="${not oferta.checkSelecionado(candidato)}">	
											      <div class="col-md-5">
												      <form action="${pageContext.request.contextPath}/controller.do" method="POST" >
												      	<input type="hidden" name="op" value="selalu"/>
												      	<input type="hidden" name="candidato" value="${candidato.id}"/>
												      	<input type="hidden" name="oferta" value="${oferta.id}"/>
												      	<button type="submit" class="btn btn-info btn-xs"><i class="glyphicon glyphicon-plus-sign"></i> selecionar</button>
												     </form>
											      </div>
										      </c:if>
										      <c:if test="${oferta.checkSelecionado(candidato)}">
											      <div class="col-md-2">
												      	<button type="button" class="btn btn-success btn-xs"><i class="glyphicon glyphicon-ok-sign"></i> selecionado</button>
											      </div>
											      <div class="col-md-offset-2 col-md-2">
											      	<form action="${pageContext.request.contextPath}/controller.do" method="POST" >
											      		<input type="hidden" name="op" value="novoest">
											      		<input type="hidden" name="candidato" value="${candidato.id}"/>
												      	<input type="hidden" name="oferta" value="${oferta.id}"/>
												      	<button type="submit" class="btn btn-warning btn-xs"><i class="glyphicon glyphicon-lock"></i> Novo Estágio</button>
											      	</form>
											      </div>
											 </c:if>
									       </div>
								      	</div>
						      		<hr />
						      	</c:forEach>
						      </div>
						    </div>
						  </div>
					</c:forEach>
					</div>	
				</div>
			</div>
		</div>	
	</jsp:body>
</tt:template>