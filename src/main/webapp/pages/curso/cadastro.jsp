<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="mm" tagdir="/WEB-INF/tags/messages"%>
<%@taglib prefix="tt" tagdir="/WEB-INF/tags/templating"%>     

<tt:template title="Cadastro Curso">
	<jsp:attribute name="tscript">
	</jsp:attribute>
	<jsp:body>	
		<div class="container">
			<div class="jumbotron">
				<div class="row">
					<div class="col-sm-offset-3 col-md-6">
						<h3>Dados do Curso</h3>
					</div>	
				</div>
				<div class="row">
					<div class="form-group col-sm-offset-3 col-md-6">
						<mm:messages value="${msgs}" erroStyle="color:red" infoStyle="color:blue"/>
					</div>	
				</div>		
				<div class="row">	
				<form action="${pageContext.request.contextPath}/controller.do" method="POST" >
					<input type="hidden"name="op" value="cadcur">
					<div class="row">	
					  <div class="form-group col-sm-offset-3 col-md-6">
					    <label for="nome">Nome</label>
					    <input type="text" name="nome" value="${requestScope.curso.nome}" class="form-control" id="nome" placeholder="Nome">
					  </div>
					 </div> 
					<div class="row">
					  <div class="form-group col-sm-offset-3 col-md-6">
					    <label for="codigo">Código</label>
					    <input type="text" name="codigo" value="${requestScope.curso.codigo}" class="form-control" id="codigo" placeholder="Código">
					  </div>
				  	</div>
				  	<div class="row">
					  <div class="form-group col-sm-offset-3 col-md-6">
					    <label for="matrizcodigo">Código Matriz</label>
					    <input type="text" name="matrizc" value="${requestScope.curso.matrizc}"  class="form-control" id="matrizcodigo" placeholder="Código Matriz">
					  </div>
				  	</div>
				  	<div class="row">
					  <div class="form-group col-sm-offset-3 col-md-6">
					    <label for="regime">Regime</label>
					  	<select class="form-control" id="regime" name="regime">
							<option value="${null}" label="Selecione o Regime">Selecione o Regime</option>
							<c:forEach var="regime" items="${utilBean.regime}">
								<option value="${regime}" label="${regime}">${regime}</option>
							</c:forEach>
						</select>
					  </div>
				  	</div>
				  		<div class="row">
					  <div class="form-group col-sm-offset-3 col-md-6">
					    <label for="coordenador">Coordenador(a)</label>
					   	<!--<select class="form-control" id="coordenador"></select>-->
					  	<select class="form-control" id="coordenador" name="coordenador">
							<option value="${null}" label="Selecione o Coordenador">Selecione o Coordenador</option>
							<c:forEach var="coordenador" items="${utilBean.coordenadores}">
								<option value="${coordenador.id}" label="${coordenador.nome}">${coordenador.nome}</option>
							</c:forEach>
						</select>
					  </div>
				  	</div>
				  	<div class="row">
					  <div class="form-group col-sm-offset-3 col-md-6">
					    <label for="descricao">Descrição</label>
					   	<textarea  name="descricao" value="${requestScope.curso.descricao}" class="form-control" rows="3" id="descricao"></textarea>
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