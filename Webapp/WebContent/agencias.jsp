<%@page import="dto.AgenciaDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% 
List<AgenciaDTO> agencias = (List<AgenciaDTO>) request.getAttribute("agencias");
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>tuvago - Oferta Paquetes</title>

    <!-- Bootstrap core CSS -->
	<link href="vendor/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
	
    <!-- Custom styles for this template -->
	<link href="css/modern-business.css" rel="stylesheet" type="text/css"/>
  </head>

  <body>

    <!-- Navigation -->
    <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="index.jsp">tuvago - Oferta Paquetes</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link" href="Controlador?action=ListarAgencias">Agencias</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="Controlador?action=ListarPaquetes">Oferta de Paquetes</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <header>
      <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
          <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
          <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
          <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner" role="listbox">
          <!-- Slide One - Set the background image for this slide in the line below -->
          <div class="carousel-item active" style="background-image: url('images/londres.jpg')">
            <div class="carousel-caption d-none d-md-block">
              <h3>Londres</h3>
              <p>Europa Cl�sica</p>
            </div>
          </div>
          <!-- Slide Two - Set the background image for this slide in the line below -->
          <div class="carousel-item" style="background-image: url('images/tulum.jpg')">
            <div class="carousel-caption d-none d-md-block">
              <h3>Tulum</h3>
              <p>Caribe</p>
            </div>
          </div>
          <!-- Slide Three - Set the background image for this slide in the line below -->
          <div class="carousel-item" style="background-image: url('images/newyork.jpg')">
            <div class="carousel-caption d-none d-md-block">
              <h3>Nueva York</h3>
              <p></p>
            </div>
          </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
      </div>
    </header>

    
        <!-- Page Content -->
    <div class="container">
	
      <h1 class="my-4">Agencias</h1>    


      <!-- Marketing Icons Section -->
      <div class="row">
      
	      <table class="table table-striped">
		  <thead>
		    <tr>
		      <th scope="col">Nombre</th>
		      <th scope="col">Direcci�n</th>
		      <th scope="col">Estado</th>
		    </tr>
		  </thead>
		  <tbody>
			<%
			if(agencias != null ){	
				for (AgenciaDTO a : agencias) {
			%>
		    <tr>
		      <td><%= a.getNombre() %></td>
		      <td><%= a.getDireccion() %></td>
		      <td><%= a.getEstado() %></td>
		    </tr>
		    <%
					};
				};
		    %>
		  </tbody>
		</table>        
      </div>
      <!-- /.row -->
      
   		<div align="right">
			<a href="index.jsp" class="btn btn-secondary" role="button" aria-disabled="true">Volver</a>
	    	<a href="altaAgencia.jsp" class="btn btn-secondary" role="button" aria-disabled="true">Nueva Agencia</a>
	    </div>




      <hr>

    </div>
    <!-- /.container -->

    <!-- Footer -->
    <footer class="py-5 bg-dark">
      <div class="container">
      </div>
      <!-- /.container -->
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  </body>

</html>