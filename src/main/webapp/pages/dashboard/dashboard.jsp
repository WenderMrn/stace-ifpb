<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="mm" tagdir="/WEB-INF/tags/messages"%>
<%@taglib prefix="tt" tagdir="/WEB-INF/tags/templating"%>     

<tt:template title="">
	<jsp:attribute name="tscript">   
	<script>
		function showDeleteIcon(box) {
			var chboxs = document.getElementsByName("empresas");
			var vis = "none";
			for (var i = 0; i < chboxs.length; i++) {
				if (chboxs[i].checked) {
					vis = "block";
					break;
				}
			}
			document.getElementById(box).style.display = vis;
		}
	</script> 
	 </jsp:attribute>
	<jsp:body>	
		<div class="container">
			<div class="jumbotron">
				<div class="row">
					<div class="col-md-12 text-center">
 						<h3><img class="choose" src="${pageContext.request.contextPath}/assets/images/dashboard.png" >   Dashboard</h3>
						<c:if test="${utilBean.instanceOf(sessionScope.usuario,'Coordenador')}">
						<br>
						<h4>Essa empresas solicitaram aprovação do cadastro</h4> 
						<form action="${pageContext.request.contextPath}/controller.do" method="POST"> 
						<input type="hidden" name="op" value="actemp">
						         <table class="table">  
						             <tr align="left">  
						                  <th></th>  
						                  <th	style="width: 30%">Empresa</th> 
						                    
						            </tr>     
						             <c:forEach var="empresa" items="${utilBean.empresas}"> 
						             <c:if test="${not empresa.aprovado}">
						                 <tr align="left">        
						                 	<td>  <input type="checkbox"	name="empresas" value="${empresa.id}" 	onclick="showDeleteIcon('div1')" />        </td>   
						                 	<td>  <a href="controller.do?op=edtctt&id=${empresa.id}">   ${empresa.email}  </a>        </td> 
						                 </tr>    
						                </c:if>
						              </c:forEach>   
						           </table>     
						  <div	id="div1" style="display: none">      <input type="submit"	value="Aprovar" class="form-control btn"
						  	onclick="return confirm('Aprovar esses cadastros?');" />  
						  	   </div>    
					 </form> 
					</c:if>  
					</div>	
				</div>
			</div>	
		</div>
	</jsp:body>
</tt:template>