<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="mm" tagdir="/WEB-INF/tags/messages"%>
<%@taglib prefix="tt" tagdir="/WEB-INF/tags/templating"%>     

<tt:template title="Cadastro Estágio">
	<jsp:attribute name="tscript">
	</jsp:attribute>
	<jsp:body>	
		<div class="container">
			<div class="jumbotron">
				<div class="row">
					<div class="col-md-12 text-center">
						<h3>Dados do Estágio</h3>
					</div>	
				</div>
				<mm:messages value="${msgs}"/>	
				</div>
				<c:if test="${not empty aluno}">
					<div class="row">
						<div class="row">
							<div class="col-md-12 text-center">
								<h5>Informações do Aluno</h5>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-offset-3 col-md-4"><b>Nome: </b> ${aluno.nome}</div>
							<div class="col-sm-offset-3 col-md-4"><b>Matrícula: </b> ${aluno.matricula}</div>
						</div>
						<div class="row">
							<div class=" col-sm-offset-3 col-md-4"><b>Email: </b> ${aluno.email}</div>
							<div class=" col-sm-offset-3 col-md-4"><b>Telefone: </b> ${aluno.telefone}</div>
						</div>
					</div>
					<hr />
				</c:if>		
				<div class="row">	
					<form action="${pageContext.request.contextPath}/controller.do" method="POST" >
						<input type="hidden"name="op" value="cadest">
						<input type="hidden"name="aluno" value="${aluno.id}">
						<div class="row">	
						  <div class="form-group col-sm-offset-3 col-md-6">
						    <label for="titulo">Título</label>
						    <input type="text" name="titulo" value="${ofertaEstagio.titulo}" class="form-control" id="titulo" placeholder="Título">
						  </div>
						 </div> 
						<div class="row">
						  <div class="form-group col-sm-offset-3 col-md-6">
						    <label for="cargosetor">Cargo ou Setor</label>
						    <input type="text" name="cargosetor" class="form-control" id="cargosetor" placeholder="Cargo ou Setor">
						  </div>
					  	</div>
					  	<div class="row">
						  <div class="form-group col-sm-offset-3 col-md-6">
						    <label for="detalhefuncao">Detalhe Função</label>
						   <textarea  placeholder="Detalhe função" name="detalhefuncao" class="form-control" rows="3" id="detalhefuncao">${ofertaEstagio.detalheFuncao}</textarea>
						  </div>
					  	</div>
					  	<div class="row">
						  <div class="form-group col-sm-offset-3 col-md-6">
						    <label for="chsemanais">Carga Horária Semanais(em horas)</label>
						  	<input type="number" name="chsemanais" value="${ofertaEstagio.CHSemanais}" class="form-control" id="chsemanais" placeholder="Carga Horária Semanais">
						  </div>
					  	</div>
					  	<div class="row">
						  <div class="form-group col-sm-offset-3 col-md-6">
						    <label for="horario">Horário do estágio</label>
						  	<input type="text" name="horario" class="form-control" id="horario" placeholder="Horário do estágio">
						  </div>
					  	</div>
					  	<div class="row">
						  <div class="form-group col-sm-offset-3 col-md-6">
						    <label for="valorbolsa">Valor da Bolsa</label>
						  	<input type="number" name="valorbolsa" value="${ofertaEstagio.valorBolsa}" class="form-control" id="valorbolsa" placeholder="Valor da Bolsa">
						  </div>
					  	</div>
					  	<div class="row">
						  <div class="form-group col-sm-offset-3 col-md-6">
						    <label for="valorbene">Valor do Benefício</label>
						  	<input type="number" name="valorbene" value="${ofertaEstagio.valorBenef}" class="form-control" id="valorbene" placeholder="Valor do benefício">
						  </div>
					  	</div>
					  	<div class="row">
						  <div class="form-group col-sm-offset-3 col-md-6">
						    <label for="inicioestagio">Início do Estágio</label>
						    <input type="date" name="inicioestagio"  class="form-control" id="inicioestagio" placeholder="Início do Estágio">
						  </div>
					  	</div>
					  	<div class="row">
						  <div class="form-group col-sm-offset-3 col-md-6">
						    <label for="fimestagio">Término do Estágio</label>
						    <input type="date" name="fimestagio"  class="form-control" id="fimestagio" placeholder="Término do Estágio">
						  </div>
					  	</div>
					  	<div class="row">
						  <div class="form-group col-sm-offset-3 col-md-6">
						    <label for="supervisor">Supevisor</label>
						    <input type="text" name="supervisor" class="form-control" id="supervisor" placeholder="Supervisor">
						  </div>
					  	</div>
					  	<div class="row">
						  <div class="form-group col-sm-offset-3 col-md-6">
						    <label for="infoadicionais">Informações Adicionais</label>
						   <textarea  placeholder="Informações Adicionais" value="${ofertaEstagio.infoAdicionais}" name="infoadicionais" class="form-control" rows="3" id="infoadicionais"></textarea>
						  </div>
					  	</div>
					  	<div class="row">
				  		<div class="col-sm-offset-3">
				  			<button type="submit" class="btn btn-default">Salvar</button>
				  		</div>
				  	</div>
				</form>
				</div>	
			</div>
		</div>
	</jsp:body>
</tt:template>