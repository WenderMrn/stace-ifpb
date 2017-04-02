
<%@ tag description="Tag apra exibir mensagens diversas"
	pageEncoding="UTF-8"%>
<%@ tag import="br.edu.ifpb.sace.facade.Categoria"%>
<%@ tag import="br.edu.ifpb.sace.facade.Mensagem"%>
<%@ attribute name="value" required="true" rtexprvalue="true"
	type="java.util.List"%>
<%@ attribute name="erroStyle" required="false" rtexprvalue="true"%>
<%@ attribute name="infoStyle" required="false" rtexprvalue="true"%>
<%@ attribute name="avisoStyle" required="false" rtexprvalue="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${not empty value}">
	<c:forEach var="msg" items="${value}">
			<div class="row">
				<div class="form-group col-sm-offset-3 col-md-6">
					<c:if test="${msg.categoria eq 'INFO'}">
						<c:set var="estilo" value="alert-info" />
					</c:if>
					<c:if test="${msg.categoria eq 'ERRO'}">
						<c:set var="estilo" value="alert-danger"  />
					</c:if>
					<c:if test="${msg.categoria eq 'AVISO'}">
						<c:set var="estilo" value="alert-info" />
					</c:if>
					<div class="alert  ${estilo} alert-dismissable">
						<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
						  <strong>${msg.mensagem}</strong>
						  
					</div>
				</div>
		</div>
	</c:forEach>		
</c:if>	
