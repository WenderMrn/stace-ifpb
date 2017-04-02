<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="mm" tagdir="/WEB-INF/tags/messages"%>
<%@taglib prefix="tt" tagdir="/WEB-INF/tags/templating"%>     
<head>
<link href='http://fonts.googleapis.com/css?family=Open+Sans+Condensed:300' rel='stylesheet' type='text/css'>
<style type="text/css">


.form-style-8{
    font-family: 'Open Sans Condensed', arial, sans;
    width: 900px;
    padding: 30px;
    background: #FFFFFF;
    margin: 50px auto;
    box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.22);
    -moz-box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.22);
    -webkit-box-shadow:  0px 0px 15px rgba(0, 0, 0, 0.22);
    

}
.form-style-8 h2{
    background: #4D4D4D;
    text-transform: uppercase;
    font-family: 'Open Sans Condensed', sans-serif;
    color: #797979;
    font-size: 25px;
    font-weight: 100;
    padding: 20px;
    margin: -30px -30px 30px -30px;
}
.form-style-8 input[type="text"],
.form-style-8 input[type="date"],
.form-style-8 input[type="datetime"],
.form-style-8 input[type="email"],
.form-style-8 input[type="number"],
.form-style-8 input[type="search"],
.form-style-8 input[type="time"],
.form-style-8 input[type="url"],
.form-style-8 input[type="password"],
.form-style-8 textarea,
.form-style-8 select 
{
    box-sizing: border-box;
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    outline: none;
    display: block;
    width: 100%;
    padding: 7px;
    border: none;
    border-bottom: 1px solid #ddd;
    background: transparent;
    margin-bottom: 10px;
    font: 16px Arial, Helvetica, sans-serif;
    height: 45px;
}
.form-style-8 textarea{
    resize:none;
    overflow: hidden;
}
.form-style-8 input[type="button"], 
.form-style-8 input[type="submit"]{
    -moz-box-shadow: inset 0px 1px 0px 0px #45D6D6;
    -webkit-box-shadow: inset 0px 1px 0px 0px #45D6D6;
    box-shadow: inset 0px 1px 0px 0px #45D6D6;
    background-color: #2CBBBB;
    border: 1px solid #27A0A0;
    display: inline-block;
    cursor: pointer;
    color: #FFFFFF;
    font-family: 'Open Sans Condensed', sans-serif;
    font-size: 18px;
    padding: 8px 18px;
    text-decoration: none;
    text-transform: uppercase;
}
.form-style-8 input[type="button"]:hover, 
.form-style-8 input[type="submit"]:hover {
    background:linear-gradient(to bottom, #34CACA 5%, #30C9C9 100%);
    background-color:#34CACA;
}
</style></head>
<tt:template title="Cadastro Empresa">
	<jsp:attribute name="tscript">

	</jsp:attribute>
	<jsp:body>	
		<div class="container ">
			<div class="form-style-8">
				<div class="row ">
					<div class="col-sm-offset-3 col-md-6">
						<h3>Dados da empresa</h3>
					</div>	
				</div>
				<div class="row">
					<div class="form-group col-sm-offset-3 col-md-6">
						<mm:messages value="${msgs}" erroStyle="color:red" infoStyle="color:blue"/>
					</div>	
				</div>		
				<div class="row">	
				<form action="${pageContext.request.contextPath}/controller.do" method="POST" >
					<input type="hidden"name="op" value="cademp">
					<div class="row">
						<div class="col-sm-offset-3 col-md-6">
							<span>Dados de Acesso</span>	
						</div>
					</div>
					<div class="row">	
					  <div class="form-group col-sm-offset-3 col-md-6">
					    <label for="email">Email</label>
					    <input type="email" name="email" class="form-control" id="email" placeholder="Email">
					  </div>
					 </div>
					 <div class="row">	
					  <div class="form-group col-sm-offset-3 col-md-6">
					    <label for="senha">Senha</label>
					    <input type="password" name="senha" class="form-control" id="senha" placeholder="Senha">
					  </div>
					 </div>
					 <div class="row">
						<div class="col-sm-offset-3 col-md-6">
							<span>Dados da Empresa</span>	
						</div>
					</div> 
					<div class="row">	
					  <div class="form-group col-sm-offset-3 col-md-6">
					    <label for="nome">Nome Empresarial</label>
					    <input type="text" name="nomeemp" class="form-control" id="nome" placeholder="Nome">
					  </div>
					 </div> 
					<div class="row">
					  <div class="form-group col-sm-offset-3 col-md-6">
					    <label for="nomefan">Nome fantasia</label>
					    <input type="text" name="nomefan"  class="form-control" id="nomefan" placeholder="Nome fantasia">
					  </div>
				  	</div>
				  	<div class="row">
					  <div class="form-group col-sm-offset-3 col-md-6">
					    <label for="cnpj">CNPJ</label>
					    <input type="text" name="cnpj"  class="form-control" id="cnpj" placeholder="CNPJ">
					  </div>
				  	</div>
				  	<div class="row">
					  <div class="form-group col-sm-offset-3 col-md-6">
					    <label for="reponsavel">Reponsável</label>
					    <input type="text" name="responsavel"  class="form-control" id="reponsavel" placeholder="Reponsável">
					  </div>
				  	</div>
				  	<div class="row">
					  <div class="form-group col-sm-offset-3 col-md-6">
					    <label for="codecoprincipal">Cód. Ativ. Econômica Principal</label>
					    <input type="text" name="codecoprincipal"  class="form-control" id="codecoprincipal" placeholder="Cód. Ativ. Econômica Principal">
					  </div>
				  	</div>
				  	<div class="row">
					  <div class="form-group col-sm-offset-3 col-md-6">
					    <label for="descecoprincipal">Atividade Econômica Principal</label>
					    <textarea  placeholder="Atividade Econômica Principal" name="descecoprincipal" class="form-control" rows="3" id="descecoprincipal"></textarea>
					  </div>
				  	</div>
				  	<div class="row">
					  <div class="form-group col-sm-offset-3 col-md-6">
					    <label for="codnatjuridica">Cód.natureza jurídica</label>
					 	 <input type="text" name="codnatjuridica"  class="form-control" id="codnatjuridica" placeholder="Cód. natureza jurídica">
					  </div>
					</div>
					<div class="row">
					  <div class="form-group col-sm-offset-3 col-md-6">
					    <label for="descnatjuridica">Descriçaõ natureza jurídica</label>
						<textarea  placeholder="Descriçaõ natureza jurídica" name="descnatjuridica" class="form-control" rows="3" id="descnatjuridica"></textarea>	
					  </div>
					</div>
					<div class="row">
					  <div class="form-group col-sm-offset-3 col-md-6">
					    <label for="endereco">Endereço</label>
					 	 <input type="text" name="endereco"  class="form-control" id="endereco" placeholder="Endereço">
					  </div>
					</div>
					<div class="row">
					  <div class="form-group col-sm-offset-3 col-md-6">
					    <label for="telefone">Telefone</label>
					 	 <input type="text" name="telefone"  class="form-control" id="telefone" placeholder="Telefone">
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