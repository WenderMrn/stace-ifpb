<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="mm" tagdir="/WEB-INF/tags/messages"%>
<%@taglib prefix="tt" tagdir="/WEB-INF/tags/templating"%>     

<tt:template title="Cadastro Aluno">
	<jsp:attribute name="tscript">
	</jsp:attribute>
	<jsp:body>	
		<div class="container">
		<center><mm:messages value="${msgs}"/></center>
			<div class="jumbotron">
				<div class="row">
					<div class="col-sm-offset-3 col-md-6">
						<h3><img class="choose" src="${pageContext.request.contextPath}/assets/images/icon-aluno.png" >   Dados do Aluno</h3>
					</div>	
				</div>
				<div class="row">
					<div class="form-group col-sm-offset-3 col-md-6">
						<mm:messages value="${msgs}" erroStyle="color:red" infoStyle="color:blue"/>
					</div>	
				</div>		
				<div class="row">	
				<form action="${pageContext.request.contextPath}/controller.do" method="POST" >
					<input required type="hidden"name="op" value="cadaluno">
					<span>Dados de Acesso</span>	
					<div class="row">
					  <div class="form-group col-sm-offset-3 col-md-6">
					    <label for="email">Email</label>
					    <input required type="text" name="email" value="${requestScope.aluno.email}"  class="form-control" id="email" placeholder="Email">
					  </div>
				  	</div>
				  	<div class="row">
					  <div class="form-group col-sm-offset-3 col-md-6">
					    <label for="senha">Senha</label>
					   <input required type="password" name="senha" value="${requestScope.aluno.senha}"  class="form-control" id="senha" placeholder="Senha">
					  </div>
					</div>  
				  	<span>Dados Pessoais</span>
				  	 <div class="row">
					  <div class="form-group col-sm-offset-3 col-md-6">
					    <label for="nome">Nome</label>
					   <input required type="text" name="nome" value="${requestScope.aluno.nome}"  class="form-control" id="nome" placeholder="nome">
					  </div>
					</div>	 
					<div class="row">	
					  <div class="form-group col-sm-offset-3 col-md-6">
					    <label for="matricula">Matricula</label>
					    <input required type="text" name="matricula" value="${requestScope.aluno.matricula}" class="form-control" id="matricula" placeholder="Matricula">
					  </div>
					</div> 
					<div class="row">	
					  <div class="form-group col-sm-offset-3 col-md-6">
					    <label for="matricula">Telefone</label>
					    <input required type="text" name="telefone" value="${requestScope.aluno.telefone}" class="form-control" id="telefone" placeholder="Telefone">
					  </div>
					</div>
					<div class="row">
					  <div class="form-group col-sm-offset-3 col-md-6">
					    <label for="competencia">Competencia</label>
					    <input required type="text" name="competencias" value="${requestScope.aluno.competencia}" class="form-control" id="competencia" placeholder="Competencia">
					  </div>
				  	</div>
				  	<div class="row">
				  	 <div class="form-group col-sm-offset-3 col-md-6">
					    <label for="curso">Curso</label>
					  	<select class="form-control" id="curso" name="curso" required>
							<c:forEach var="curso" items="${utilBean.cursos}">
								<option value="${curso.id}" label="${curso.nome}">${curso.nome}</option>
							</c:forEach>
						</select>
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