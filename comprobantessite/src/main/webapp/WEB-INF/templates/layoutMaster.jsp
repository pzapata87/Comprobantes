<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!-- Esta linea sirve por que a veces no renderiza el contenido de script, css-->
<%@ page  isELIgnored="false" %>

<!DOCTYPE html>
<html lang="es">
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Comprobantes</title>
	
	<meta name="description" content="" />
	<meta name="viewport"
		content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	
	<spring:url value="/resources/images/favicon.ico" var="faviconIco" />
	<link rel="shortcut icon" type="image/x-icon" href="${faviconIco}" />
	
	<!-- bootstrap & fontawesome -->
	<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
	<link rel="stylesheet" href="${bootstrapCss}" />
	<spring:url value="/resources/css/font-awesome.css" var="fontAwesomeCss" />
	<link rel="stylesheet" href="${fontAwesomeCss}" />
	
	<!-- text fonts -->
	<spring:url value="/resources/css/ace-fonts.css" var="aceFontsCss" />
	<link rel="stylesheet" href="${aceFontsCss}" />
	
	<!-- ace styles -->
	<spring:url value="/resources/css/ace.css" var="aceCss" />
	<link rel="stylesheet" href="${aceCss}" class="ace-main-stylesheet"	id="main-ace-style" />
	
	<spring:url value="/resources/css/jquery.gritter.css" var="jqueryGritterCss" />
	<link rel="stylesheet" href="${jqueryGritterCss}" />
	
	<spring:url value="/resources/css/custom.css" var="customCss" />
	<link rel="stylesheet" href="${customCss}" />
</head>

<body class="login-layout">
	<div class="main-container">
		<div class="main-content">
			<div class="row">
				<div class="col-sm-10 col-sm-offset-1">					
					<!-- PAGE CONTENT BEGINS -->							
					<tiles:insertAttribute name="content"/>							
					<!-- PAGE CONTENT ENDS -->						
				</div><!-- /.col -->
			</div><!-- /.row -->
		</div><!-- /.main-content -->		
	</div><!-- /.main-container -->
	
	<spring:url value="/resources/js/jquery.js" var="jqueryJs" />
	<spring:url value="/resources/js/jquery.mobile.custom.js" var="jqueryMobileCustomJs" />
	<spring:url value="/resources/js/jquery.gritter.js"	var="jqueryGritterJs" />
	<spring:url value="/resources/js/jquery.blockUI.js" var="jqueryBlockUIJs" />
	<spring:url value="/resources/js/bootstrap.js" var="bootstrapJs" />
	
	<spring:url value="/resources/js/ace/elements.scroller.js" var="scrollerJs" />
	<spring:url value="/resources/js/ace/ace.js" var="aceJs" />
	
	<spring:url value="/resources/js/webApp.js" var="webAppJs" />
	<spring:url value="/resources/js/viewsJs/comprobante.js" var="comprobanteJs" />		
	
	<!--[if !IE]> -->
	<script type="text/javascript">
		window.jQuery || document.write("<script src='${jqueryJs}'>" + "<"+"/script>");
	</script>	
	<!-- <![endif]-->
	
	<script type="text/javascript">
		if ('ontouchstart' in document.documentElement)
			document.write("<script src='${jqueryMobileCustomJs}'>"
					+ "<"+"/script>");
	</script>
	
	<script src="${bootstrapJs}"></script>
	<script src="${jqueryGritterJs}"></script>
	<script src="${jqueryBlockUIJs}"></script>
		
	<script src="${scrollerJs}"></script>
	<script src="${aceJs}"></script>
	<script type="text/javascript"> ace.vars['base'] = '..'; </script>
	
	<script src="${webAppJs}"></script>
	<script src="${comprobanteJs}"></script>
    <script type="text/javascript">
	    $(function () {	        
	    	comprobanteJs.init();
	    });
	</script>
</body>
</html>    