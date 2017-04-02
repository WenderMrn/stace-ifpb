<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="mm" tagdir="/WEB-INF/tags/messages"%>
<%@taglib prefix="tt" tagdir="/WEB-INF/tags/templating"%>     

<tt:template title="Cadastro Oferta de Estágio">
	<jsp:attribute name="tscript">
	</jsp:attribute>
	<jsp:body>	
		<div class="container">
			<div class="jumbotron">
				<div class="row">
					<div class="col-sm-offset-3 col-md-6">
						<h3><img class="choose" src="${pageContext.request.contextPath}/assets/images/cadastro-estagio.png" >   Oportunidade de Estágio</h3>
					</div>	
				</div>
				<mm:messages value="${msgs}" erroStyle="color:red" infoStyle="color:blue"/>		
				<div class="row">	
					<form action="${pageContext.request.contextPath}/controller.do" method="POST" >
						<input type="hidden"name="op" value="cadoftest">
						<div class="row">	
						  <div class="form-group col-sm-offset-3 col-md-6">
						    <label for="titulo">Título</label>
						    <input type="text" name="titulo" value="${requestScope.ofertaEstagio.titulo}" class="form-control" id="nome" placeholder="Título">
						  </div>
						 </div> 
						<div class="row">
						  <div class="form-group col-sm-offset-3 col-md-6">
						    <label for="requisitos">Requisito</label>
						    <textarea  placeholder="Requisitos" name="requisitos" value="${requestScope.ofertaEstagio.requisito}" class="form-control" rows="3" id="requisito"></textarea>
						  </div>
					  	</div>
					  	<div class="row">
						  <div class="form-group col-sm-offset-3 col-md-6">
						    <label for="numvagas">Vagas disponíveis</label>
						    <input type="number" name="numvagas" value="${requestScope.ofertaEstagio.qtdeVaga}"  class="form-control" id="numvagas" placeholder="Vagas disponíveis">
						  </div>
					  	</div>
					  	<div class="row">
						  <div class="form-group col-sm-offset-3 col-md-6">
						    <label for="email">E-mail pra contato</label>
						    <input type="email" name="email" value="${requestScope.ofertaEstagio.emailContato}"  class="form-control" id="matrizcodigo" placeholder="E-mail pra contato">
						  </div>
					  	</div>
					  	<div class="row">
						  <div class="form-group col-sm-offset-3 col-md-6">
						    <label for="email">Bolsa</label>
						    <input name="bolsa" type="number" class="currency" max="2500.00" value="500.00" />
						  </div>
					  	</div>
					  	<div class="row">
						  <div class="form-group col-sm-offset-3 col-md-6">
						    <label for="cursos">Para os cursos</label>
						  	<select  multiple class="form-control" id="cursos" name="cursos[]">
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
		<script>
		(function($) {
			  $.fn.currencyInput = function() {
			    this.each(function() {
			      var wrapper = $("<div class='currency-input' />");
			      $(this).wrap(wrapper);
			      $(this).before("<span class='currency-symbol'>$</span>");
			      $(this).change(function() {
			        var min = parseFloat($(this).attr("min"));
			        var max = parseFloat($(this).attr("max"));
			        var value = this.valueAsNumber;
			        if(value < min)
			          value = min;
			        else if(value > max)
			          value = max;
			        $(this).val(value.toFixed(2)); 
			      });
			    });
			  };
			})(jQuery);

			$(document).ready(function() {
			  $('input.currency').currencyInput();
			});
		</script>
	</jsp:body>
</tt:template>