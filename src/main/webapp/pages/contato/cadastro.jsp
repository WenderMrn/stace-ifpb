<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tt" tagdir="/WEB-INF/tags/templating"%>
<%@ taglib prefix="mm" tagdir="/WEB-INF/tags/messages"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<tt:template title="Consulta a contatos">
	<jsp:attribute name="tscript">   <script>
		function showDeleteIcon(box) {
			var chboxs = document.getElementsByName("delids");
			var vis = "none";
			for (var i = 0; i < chboxs.length; i++) {
				if (chboxs[i].checked) {
					vis = "block";
					break;
				}
			}
			document.getElementById(box).style.display = vis;
		}
	</script>   <script
			src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>   <script
			src="${pageContext.request.contextPath}/assets/bootstrap/js/bootstrap.min.js"></script>  </jsp:attribute>
	<jsp:body>  
	<div class="container">
		<div class="jumbotron">
			<h2>
				Memori<i class="glyphicon glyphicon-phone"></i>m
			</h2>
			<h3>Dados do Contato</h3>
			<mm:messages value="${request.msgs}" erroStyle="color:red" infoStyle="color:blue"/> 
			<form action="${pageContext.request.contextPath}/controller.do"
				method="POST" class="form-horizontal">
				<input type="hidden" name="op" value="cadctt">
				<input id="id" value="${contato.id}" name="id" type="hidden" placeholder="id" />
				 <input
					id="nome" value="${contato.nome}" name="nome" type="text"
					class="form-control" placeholder="Nome" /> <input id="fone"
					value="${contato.fone}" name="fone" class="form-control"
					type="text" placeholder="Fone" />
				<fmt:formatDate var="dataAniv" value="${contato.dataAniversario}"
					pattern="dd/MM/yyyy" />
				<input id="dataaniv" value="${dataAniv}" name="dataaniv"
					class="form-control" type="date"
					placeholder="Data de criação (dd/mm/aaaa)" /> 
					
				<select	class="form-control" id="operadora" name="operadora">
					<option value="${null}" label="Selecione a operadora">
						Selecione a operadora</option>
					<c:forEach var="operadora" items="${utilBean.operadoras}">
						<c:if test="${operadora.id eq contato.operadora.id}">
							<option value="${operadora.id}" label="${operadora.nome}"
								selected>${operadora.nome}</option>
						</c:if>
						<c:if test="${operadora.id ne contato.operadora.id}">
							<option value="${operadora.id}" label="${operadora.nome}">
								${operadora.nome}</option>
							</c:if>
						</c:forEach>
					</select>
				 <input type="submit" class="form-control btn btn-primary"
					value="Salvar">
			</form>

		</div>
	</div>

	<c:set var="endofconversation" value="true" scope="request" />

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js" />
	<script
		src="${pageContext.request.contextPath}/assets/bootstrap/js/bootstrap.min.js" />
<c:remove var="msgs" scope="application" />
					     </jsp:body>
</tt:template>