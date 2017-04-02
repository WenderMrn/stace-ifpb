<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="mm" tagdir="/WEB-INF/tags/messages"%>
<html>
<head>
<title>S.I.C.L.E.</title>
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

<link href="${pageContext.request.contextPath}/assets/css/login.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'> 
<link href='//fonts.googleapis.com/css?family=Athiti:400,200,300,500,600,700' rel='stylesheet' type='text/css'>


</head>
<body>
	<center><mm:messages value="${msgs}"/></center>
	<div id="choosing">
		<h3 id="apresentacao">Selecione seu perfil</h3><br>
		<br>
		<br>	
		<table>
		<tr>
   		 	<td><div class="imgWrap" id="coord" onclick="escolher('1')"><img class="choose" src="${pageContext.request.contextPath}/assets/images/icon-coord.png" ><p class="imgDescription">Coordenador</p></div></td>  		
    		<td><div class="imgWrap" id="empresa" onclick="escolher('2')"><img class="choose" src="${pageContext.request.contextPath}/assets/images/icon-empresa.png"><p class="imgDescription">Empresa</p></div></td>
    		<td><div class="imgWrap" id="aluno" onclick="escolher('3')"><img class="choose" src="${pageContext.request.contextPath}/assets/images/icon-aluno.png"><p class="imgDescription">Aluno</p></div></td>
  		</tr>
		</table>
	</div>

	<!-- main -->
	<div class="main" id="main">
	<div class="login-form login-form-three"> 
			<div class="agile-row">
				<h3>= SICLE =</h3> 
				<div class="login-agileits-top"> 	
					<form action="${pageContext.request.contextPath}/controller.do" method="POST">
						<input type="hidden" name="op" value="login" />
						<input id="perfil" type="hidden" name="perfil" value="" />
						<div class="input-row"> 
							<input type="text" class="email" name="login" placeholder="Email" required/>
							<input type="password" class="password" name="senha" placeholder="Senha" required/>	
						</div> 
						<br>
						<input type="submit" value="ENTRAR">
					</form> 	
				</div>
				<div class="login-agileits-bottom"> 
					<p><a href="#">Lembrar senha?</a></p>   
					<p class="w3ls-line" id="w3ls-line">Não possui cadastro? <a id=linkCad href="#">Clique aqui.</a></p>
				</div> 
			</div>  
		</div> 
		<div class="clearfix"> </div>
	</div>	
	
<script type="text/javascript">
function escolher(elemento){
	 $('#choosing').fadeOut('slow', function(){
		 $('#main').fadeIn('slow');
		     });
     switch (elemento){
    case "1" : 
	document.body.style.backgroundColor = "b38fb3";
	document.getElementById("w3ls-line").style.display = "none";
      break;
    case "2" : 
     document.getElementById("perfil").value = "Empresa";	
     document.body.style.backgroundColor = "6ebdc4";
     document.getElementById("linkCad").href = "${pageContext.request.contextPath}/pages/empresa/cadastro.jsp";
      break;
    case "3" : 
        document.body.style.backgroundColor = "f77872";
        document.getElementById("linkCad").href = "${pageContext.request.contextPath}/pages/aluno/cadastro.jsp";
         break;
     	 
  	}
  }	


</script>
		
</body>
</html>
