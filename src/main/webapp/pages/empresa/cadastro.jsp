<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="mm" tagdir="/WEB-INF/tags/messages"%>
<%@taglib prefix="tt" tagdir="/WEB-INF/tags/templating"%>     

<tt:template title="Cadastro Empresa">
	<jsp:attribute name="tscript">

	</jsp:attribute>
	<jsp:body>	
		<div class="container ">
			<div class="jumbotron">
				<div class="row ">
					<div class="col-sm-offset-3 col-md-6">
						<h3><img class="choose" src="${pageContext.request.contextPath}/assets/images/icon-empresa.png" >   Dados da Empresa</h3>
					
					</div>	
				</div>
				<div class="row">
					<div class="form-group col-sm-offset-3 col-md-6">
						<mm:messages value="${msgs}" erroStyle="color:red" infoStyle="color:blue"/>
					</div>	
				</div>		
				<div class="row">	
				<form action="${pageContext.request.contextPath}/controller.do" method="POST" >
					<input required type="hidden"name="op" value="cademp">
					<div class="row">
						<div class="col-sm-offset-3 col-md-6">
							<span>Dados de Acesso</span>	
						</div>
					</div>
					<div class="row">	
					  <div class="form-group col-sm-offset-3 col-md-6">
					        <input required type="email" name="email" class="form-control" id="email" placeholder="Email">
					  </div>
					 </div>
					 <div class="row">	
					  <div class="form-group col-sm-offset-3 col-md-6">
					        <input required type="password" name="senha" class="form-control" id="senha" placeholder="Senha">
					  </div>
					 </div>
					 <div class="row">
						<div class="col-sm-offset-3 col-md-6">
							<span>Dados da Empresa</span>	
						</div>
					</div> 
					<div class="row">	
					  <div class="form-group col-sm-offset-3 col-md-6">
				
					    <input required type="text" name="nomeemp" class="form-control" id="nome" placeholder="Nome">
					  </div>
					 </div> 
					<div class="row">
					  <div class="form-group col-sm-offset-3 col-md-6">
					  
					    <input required type="text" name="nomefan"  class="form-control" id="nomefan" placeholder="Nome fantasia">
					  </div>
				  	</div>
				  	<div class="row">
					  <div class="form-group col-sm-offset-3 col-md-6">
					      <input required type="text" name="cnpj"  class="form-control" id="cnpj" placeholder="CNPJ">
					  </div>
				  	</div>
				  	<div class="row">
					  <div class="form-group col-sm-offset-3 col-md-6">
				
					    <input required type="text" name="responsavel"  class="form-control" id="reponsavel" placeholder="Reponsável">
					  </div>
				  	</div>
				  	<div class="row">
					  <div class="form-group col-sm-offset-3 col-md-6">
					    
					    <input required type="text" name="codecoprincipal"  class="form-control" id="codecoprincipal" placeholder="Cód. Ativ. Econômica Principal">
					  </div>
				  	</div>
				  	<div class="row">
					  <div class="form-group col-sm-offset-3 col-md-6">
					   
					    <textarea  placeholder="Atividade Econômica Principal" name="descecoprincipal" class="form-control" rows="3" id="descecoprincipal"></textarea>
					  </div>
				  	</div>
				  	<div class="row">
					  <div class="form-group col-sm-offset-3 col-md-6">
					    
					 	 <input required type="text" name="codnatjuridica"  class="form-control" id="codnatjuridica" placeholder="Cód. natureza jurídica">
					  </div>
					</div>
					<div class="row">
					  <div class="form-group col-sm-offset-3 col-md-6">
					    
						<textarea  placeholder="Descriçaõ natureza jurídica" name="descnatjuridica" class="form-control" rows="3" id="descnatjuridica"></textarea>	
					  </div>
					</div>
					<div class="row">
					  <div class="form-group col-sm-offset-3 col-md-6">
					    
					 	 <input required type="text" name="endereco"  class="form-control" id="endereco" placeholder="Endereço">
					  </div>
					</div>
					<div class="row">
					  <div class="form-group col-sm-offset-3 col-md-6">
					    
					 	 <input required type="text" name="telefone"  class="form-control" id="telefone" placeholder="Telefone">
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
	<script type="text/javascript">
//auto expand textarea
function adjust_textarea(h) {
    h.style.height = "20px";
    h.style.height = (h.scrollHeight)+"px";
}
</script>	

	</jsp:body>
</tt:template>