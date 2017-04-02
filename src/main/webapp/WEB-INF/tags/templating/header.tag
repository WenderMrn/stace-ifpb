<%@ tag description="Barra de navegação comum às páginas"
	body-content="empty"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${not empty sessionScope.usuario}">
	<c:if test="${utilBean.instanceOf(sessionScope.usuario,'Empresa')}">
		<c:set var="nome" value="${sessionScope.usuario.nomeFantasia}" />
	</c:if>
	<c:if test="${not utilBean.instanceOf(sessionScope.usuario,'Empresa')}">
		<c:set var="nome" value="${sessionScope.usuario.nome}" />
	</c:if>
</c:if>
<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<c:if test="${not empty sessionScope.usuario}">
		<c:if test="${utilBean.instanceOf(sessionScope.usuario,'Coordenador')}">
	<style type="text/css">
	body{
		background-color: #b38fb3 !important;
	}
	
</style>	
				   			
</c:if>

<c:if test="${utilBean.instanceOf(sessionScope.usuario,'Empresa')}"> 
	<style type="text/css">
	body{
		background-color: #6ebdc4 !important;
	}
	</style>
</c:if>

<c:if test="${utilBean.instanceOf(sessionScope.usuario,'Aluno')}"> 
	<style type="text/css">
	body{
		background-color: f77872 !important;
	}
	</style>
</c:if>
			<div id="navbar">
				<ul class="nav navbar-nav">
					<li role="presentation" class="dropdown">
						<c:if test="${not utilBean.instanceOf(sessionScope.usuario,'Aluno')}">
						    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
						      Cadastro <span class="caret"></span>
						    </a>
						    <ul class="dropdown-menu">
						    	<c:if test="${not utilBean.instanceOf(sessionScope.usuario,'Empresa') and utilBean.instanceOf(sessionScope.usuario,'Coordenador')}">
						   			<li><a href="${pageContext.request.contextPath}/pages/aluno/cadastro.jsp">Aluno</a></li>
						   			<li><a href="${pageContext.request.contextPath}/pages/curso/cadastro.jsp">Curso</a></li> 
					   			<li><a href="${pageContext.request.contextPath}/pages/estagio/cadastro.jsp">Estágio</a></li>
					    	</c:if>
					    	
					    	<li><a href="${pageContext.request.contextPath}/pages/ofertaestagio/cadastro.jsp">Oportunidade</a></li>
					   		
					    </ul>
					    </c:if>
					</li>
					<c:if test="${not utilBean.instanceOf(sessionScope.usuario,'Empresa')}">
						<li><a href="${pageContext.request.contextPath}/pages/ofertaestagio/listagem.jsp">Ofertas de Estágio</a></li> 
					</c:if>
					<c:if test="${utilBean.instanceOf(sessionScope.usuario,'Empresa')}"> 
						<li><a href="${pageContext.request.contextPath}/pages/ofertaestagio/gerencia.jsp">Minhas Ofertas de Estágio</a></li> 
					</c:if>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown">
						<a href="#" class="dropdown-toggle"	data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> ${nome}<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#" id="link-submit"> <i class="glyphicon glyphicon-log-out"></i> Sair</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</c:if>
	</div>
</nav>
<form id="logout-form"
	action="${pageContext.request.contextPath}/controller.do" method="POST">
	<input type="hidden" name="op" value="logout" />
</form>



<script type="text/javascript">
	var form = document.getElementById("logout-form");
	document.getElementById("link-submit").addEventListener("click",
			function() {
				form.submit();
			});
</script>
