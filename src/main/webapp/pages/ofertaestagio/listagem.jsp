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
						<h3><img class="choose" src="${pageContext.request.contextPath}/assets/images/lista.png" >   Ofertas de Estágio</h3>
						<hr/>
						<h6>Você pode inscrever-se nos estágios listados abaixo</h6>
					</div>	
				</div>
				<mm:messages value="${msgs}"/>	
				<div class="row">
					<div class="panel-group" id="accordion">
					<c:forEach var="oferta" items="${ofertaEstagioBean.ofertasEstagio}">
						<c:if test="${oferta.status eq 'APROVADO' or utilBean.instanceOf(sessionScope.usuario,'Coordenador')}">
						  <div class="panel panel-default ${oferta.checkSelecionado(sessionScope.usuario)?'candidato-selecionado':''}">
						    <div class="panel-heading">
						    	<div class="row">
						    		<div class="col-md-9">
						    		<h4 class="panel-title">
								        <a data-toggle="collapse" data-parent="#accordion" href="#accordion${oferta.id}">
								        	${oferta.titulo}
								        </a>
								      </h4>
						    		</div>
						    		<c:if test="${utilBean.instanceOf(sessionScope.usuario,'Aluno')}">
						    			<!-- ALUNO -->
						    			<div class="col-md-offset-1 col-md-1">
							    			<c:if test="${not oferta.checkInscrito(sessionScope.usuario.id)}">
							    				<form action="${pageContext.request.contextPath}/controller.do" method="POST">
							    					<input type="hidden"name="op" value="inscanccalu">
							    					<input type="hidden" name="oferta_estagio" value="${oferta.id}" />
							    					<button type="submit" class="btn btn-primary  btn-xs">Inscreva-se</button>
							    				</form>	
							    			</c:if>
							    		</div>
							    		<!-- ALUNO -->
							    		<div class="col-md-offset-1 col-md-2">	
							    			<c:if test="${oferta.checkInscrito(sessionScope.usuario.id) and not oferta.checkSelecionado(sessionScope.usuario)}">
							    				<form action="${pageContext.request.contextPath}/controller.do" method="POST">
							    					<input type="hidden"name="op" value="inscanccalu">
							    					<input type="hidden" name="oferta_estagio" value="${oferta.id}" />
							    					<button type="submit" class="btn btn-success btn-xs">Cancelar Inscrição</button>
							    				</form>	
							    			</c:if>	
						    			</div>
						    		</c:if>
						    		<!-- COORDENADOR -->
						    		<c:if test="${utilBean.instanceOf(sessionScope.usuario,'Coordenador') and oferta.status eq 'AGUARDANDO'}">
						    		<div class="col-md-offset-1 col-md-1">
						    			<form action="${pageContext.request.contextPath}/controller.do" method="POST">
							    			<input type="hidden"name="op" value="aproortu">
							    			<input type="hidden" name="oferta_estagio" value="${oferta.id}" />
							    			<button type="submit" class="btn btn-primary btn-xs">Aprovar</button>
							    		</form>
							    	</div>
							    	<div class="col-md-1">
							    		<form action="${pageContext.request.contextPath}/controller.do" method="POST">
							    			<input type="hidden"name="op" value="negoportu">
							    			<input type="hidden" name="oferta_estagio" value="${oferta.id}" />
							    			<button type="submit" class="btn btn-warning btn-xs">&nbsp;Negar&nbsp;</button>
							    		</form>	
						    		</div>
						    		</c:if>
						    		<!-- COORDENADOR -->
						    		<c:if test="${utilBean.instanceOf(sessionScope.usuario,'Coordenador')}">
						    			<c:if test="${oferta.status eq 'APROVADO'}">
							    			<div class="col-md-offset-1 col-md-1">
							    				<button type="button" class="btn btn-success btn-xs">Aprovado</button>
							    			</div>
						    			</c:if>
						    			<c:if test="${oferta.status eq 'NEGADO'}">
							    			<div class="col-md-offset-1 col-md-1">
							    				<button type="button" class="btn btn-warning btn-xs">&nbsp;Negado&nbsp;</button>
							    			</div>
						    			</c:if>
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
						      	<div class="row">
						      		<br />
						      		<br />						
						      		<!-- ALUNO -->
							    	<div class="col-md-12">	
							    		<c:if test="${oferta.checkSelecionado(sessionScope.usuario)}">
							    			<div class="alert alert-success"><i class="glyphicon glyphicon-thumbs-up"></i> Parabéns você foi selecionado!</div>
							    		</c:if>	
						    		</div>
						      	</div>
						      </div>
						    </div>
						  </div>
						</c:if>
					</c:forEach>
					</div>	
				</div>
			</div>
		</div>	
	</jsp:body>
</tt:template>