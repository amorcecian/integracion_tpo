<%@page import="java.util.Calendar"%>
<%@page import="org.jboss.resteasy.util.DateUtil"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="dto.PaqueteDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<% 
List<PaqueteDTO> paquetes = (List<PaqueteDTO>) request.getAttribute("paquetes");
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
              <p>Europa Clásica</p>
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
	
      <h1 class="my-4">Oferta de Paquetes</h1>    


      <!-- Marketing Icons Section -->
      <div class="row">
      
	      <table class="table table-striped">
		  <thead>
		    <tr>
		      <th scope="col">Nombre</th>
		      <th scope="col">Destino</th>
		      <th scope="col">Fecha de Salida</th>
		      <th scope="col">Fecha de Regreso</th>
		      <th scope="col">Cupo</th>
   		      <th scope="col">Estado</th>
		    </tr>
		  </thead>
		  <tbody>
  			<%
			if(paquetes != null ){	
				for (PaqueteDTO p : paquetes) {
					String sfs = p.getFechaSalida().toString();
					String sfsf= sfs.substring(0,10);
					
					String sfr = p.getFechaIngreso().toString();
					String sfrf= sfr.substring(0,10);

					Gson gson = new Gson();
					String json = gson.toJson(p);
			%>
		    <tr data-toggle="modal" data-target="#exampleModal" class="open-Dialog" data-button='<%=json %>'>
		      <td><%= p.getNombre() %></td>
		      <td><%= p.getDestino().getNombre() %></td>
		      <td><%= sfsf %></td>
		      <td><%= sfrf %></td>
		      <td><%= p.getCupo() %></td>
   		      <td><%= p.getEstado() %></td>
		    </tr>
		    		    <%
					};
				};
		    %>

		  </tbody>
		</table>        
      </div>
      <!-- /.row -->
      
      <!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" >
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
    
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Paquete</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      
      <div class="modal-body">
      		<h5 class="modal-title" id="tituloModal" align="center"></h5>
      		<br>
     	 	<b>Agencia</b><p id="agencia"></p>
     	 	<b>Destino</b><p id="destino"></p>
     	 	<b>Fecha de Salida</b><p id="fechaSalida"></p>
     	 	<b>Fecha de Regreso</b><p id="fechaRegreso"></p>
     	 	<b>Cupo</b><p id="cupo"></p>
     	 	<b>Cantidad de Personas</b><p id="cantidadPersonas"></p>
     	 	<b>Descripción del paquete</b><p id="descripcion"></p>
     	 	<b>Servicios</b><p id="servicios"></p>
     	 	<b>Precio por persona</b><p id="precioPersona"></p>
     	 	<b>Políticas de cancelación</b><p id="politicas"></p>
     	 	<b>Medios de pago</b><p id="mediosPago"></p>
     	 	<div align="center">
     	 		<img id="imagen" class="img-thumbnail">
     	 	</div>
     	 	
     	 	
        
      </div>
      
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
      
    </div>
  </div>
</div>
      <!--End Modal -->
      
   		<div align="right">
			<a href="index.jsp" class="btn btn-secondary" role="button" aria-disabled="true">Volver</a>
	    	<a href="Controlador?action=AddPaquete" class="btn btn-secondary" role="button" aria-disabled="true">Nuevo Paquete</a>
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
    
    <script type="text/javascript">


	    $(document).ready(function () 
		{
	    	
	    	$(document).on("click", ".open-Dialog", function () {	    		
	    		var obj = JSON.parse($(this).attr('data-button'));
	    		$("#tituloModal").text("Nombre del paquete: " + obj.nombre);
	    		$("#agencia").text(obj.agencia.Nombre);	
				$("#destino").text(obj.destino.nombre);				
	    		$("#fechaSalida").text(obj.fechaSalida.substring(0,12));	    		
	    		$("#fechaRegreso").text(obj.fechaIngreso.substring(0,12));
	    		$("#cupo").text(obj.cupo);
	    		$("#cantidadPersonas").text(obj.cantPersonas);
	    		$("#descripcion").text(obj.descripcion);

	    		var serv = $.map(obj.servicios, function(v){
	    		    return v.nombre;
	    		}).join(', ');
	    		$("#servicios").text(serv);

	    		$("#precioPersona").text("$ " + obj.precioPersona);
	    		$("#politicas").text(obj.politicasDeCancelacion);


	    		var medios = $.map(obj.formPagos, function(v){
	    		    return v.descripcion;
	    		}).join(', ');
	    		$("#mediosPago").text(medios);

	    		var url = 'data:image/png;base64,' + obj.foto;
	    		$("#imagen").attr("src",url);

	    	});
	    	
	    	
	    });
   
    </script>

  </body>

</html>