<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="login-container">
	<div class="center">
		<img src="<c:url value="/resources/images/banco-falabella.png"/>" alt="" class="img-responsive" width="200">
	</div>
	<div class="space-6 espacio"></div>
	<div class="position-relative">
		<div id="login-box"
			class="login-box visible widget-box no-border">
			<div class="widget-body">
				<div class="widget-main">
					<div class="space-6"></div>
					<form action="login" method="POST" id="frmLogin">
						<fieldset>
							<div class="inputs-login">
								<label class="block clearfix"> 
									<span class="block input-icon input-icon-right"> 
										<input id="Usuario" name="Usuario" type="text" class="form-control" placeholder="Usuario" required="required" value="${username}"/> 
										<i class="ace-icon fa fa-user"></i>
									</span>
								</label> 
								<label class="block clearfix"> 
									<span class="block input-icon input-icon-right">										 
										<input id="Clave" name="Clave" type="password" class="form-control" placeholder="Clave" required="required" />
										<i class="ace-icon fa fa-lock"></i>
									</span>
								</label>
							</div>
						 	<c:if test="${not empty mensajeError}">
                                <div class="space"></div>
                                <div class="field-validation-error">${mensajeError}</div>
                            </c:if>
							<div class="space"></div>
							<div class="clearfix">
								<label class="inline"> 
									<input type="checkbox" class="ace" /> 
									<span class="lbl"> Recordarme</span>
								</label>
								<button id="btnLogin" type="submit" class="width-100 btn btn-sm btn-success">
									<i class="ace-icon fa fa-key"></i> 
									<span class="bigger-110"> Acceder</span>
								</button>
							</div>
							<div class="space-4"></div>
						</fieldset>
					</form>
					<div class="center">
						<span class="sigcomt"> Copyright &copy; 2017 Sigcomt SAC. Todos los derechos reservados</span>
					</div>
					<div class="space-6"></div>
				</div>
				<!-- /.widget-main -->
			</div>
			<!-- /.widget-body -->
		</div>
		<!-- /.login-box -->
	</div>
</div>
<!-- login-Container -->