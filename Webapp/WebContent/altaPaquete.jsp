<%@page import="dto.ServicioDTO"%>
<%@page import="dto.TipoServicioDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% 
List<TipoServicioDTO> TipoServicios = (List<TipoServicioDTO>) request.getAttribute("TipoServicios");
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
	
      <h1 class="my-4">Alta de Oferta</h1>    


      <!-- Marketing Icons Section -->
     <div id="page-wrapper">
      
      	<form action="Controlador?action=AltaPaquete" method="post">
		  <div class="form-group">
		    <label for="formGroupExampleInput">Nombre</label>
		    <input type="text" class="form-control" id="formGroupExampleInput" placeholder="Nombre" name="nombre">
		  </div>
		  
  		  <div class="form-group">
		    <label for="formGroupExampleInput">Fecha de salida</label>
		    <input type="text" class="form-control" id="formGroupExampleInput" placeholder="Fecha de salida" name="fechaSalida">
		  </div>
		  
   		  <div class="form-group">
		    <label for="formGroupExampleInput">Fecha de regreso</label>
		    <input type="text" class="form-control" id="formGroupExampleInput" placeholder="Fecha de regreso" name="fechaRegreso">
		  </div>
		  
   		  <div class="form-group">
		    <label for="formGroupExampleInput">Cupo</label>
		    <input type="text" class="form-control" id="formGroupExampleInput" placeholder="Cupo">
		  </div>

		    <div class="form-group">
			    <label for="exampleFormControlSelect1">Destino</label>
			    <select class="form-control" id="exampleFormControlSelect1">
			      <option disabled="disabled" selected="selected"></option>
			      <option>1</option>
			      <option>2</option>
			      <option>3</option>
			      <option>4</option>
			      <option>5</option>
			    </select>
		  	</div>
		  	
		  	
	  	  <div class="form-group">
		    <label for="exampleFormControlTextarea1">Descripción</label>
		    <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
		  </div>
		  
   		    <div class="form-group">
			    <label for="exampleFormControlSelect1">Tipo Servicio</label>
			    <select class="form-control" id="exampleFormControlSelect1" name="tipoServicio">
			      <option disabled="disabled" selected="selected"></option>
      			<%
				if(TipoServicios != null ){	
					for (TipoServicioDTO tsdto : TipoServicios) {
				%>
			      <option><%= tsdto.getNombre() %></option>
			      <%
						};
					};
			      %>

			    </select>
		  	</div>
		  
  		    <div class="form-group">
			    <label for="exampleFormControlSelect1">Servicios</label>
			    <select multiple class="form-control" id="exampleFormControlSelect1" name="servicio">
			      <option disabled="disabled" selected="selected"></option>
			    </select>
		  	</div>
		  	

		  <div class="form-group">
		    <label for="exampleFormControlFile1">Cargar imagen</label>
		    <input type="file" class="form-control-file" id="exampleFormControlFile1">
		  </div>

		  	
   		  <div class="form-group">
		    <label for="formGroupExampleInput">Precio por persona</label>
		    <input type="text" class="form-control" id="formGroupExampleInput" placeholder="Precio por persona">
		  </div>
		  
   		    <div class="form-group">
			    <label for="exampleFormControlSelect1">Medios de pago</label>
			    <select class="form-control" id="exampleFormControlSelect1">
			      <option disabled="disabled" selected="selected"></option>
			      <option>Efectivo</option>
			      <option>Tarjeta</option>
			    </select>
		  	</div>
		  	
		  	
	  	  <div class="form-group">
		    <label for="exampleFormControlTextarea1">Políticas de cancelación</label>
		    <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
		  </div>

		    <div class="form-group">
			    <label for="exampleFormControlSelect1">Estado</label>
			    <select class="form-control" id="exampleFormControlSelect1">
			      <option disabled="disabled" selected="selected"></option>
			      <option>Acivo</option>
			      <option>Inactivo</option>
			    </select>
		  	</div>


		  
		  
		</form>
      
 
		
		
		      
      </div>
      <!-- /.row -->
      
   		<div align="right">
   			 <a href="paquetes.jsp" class="btn btn-secondary" role="button" aria-disabled="true">Cancelar</a>
	    	 <button type="button" class="btn btn-secondary">Grabar</button>
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

		("#tipoServicio").change(function(){
				alert("Hola");
			});
			
	
   	</script>

  </body>

</html>