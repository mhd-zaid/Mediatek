<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>

	<h1 class="name">Bienvenue dans votre espace ${name}</h1>
	<form name="ajouter" action="document" method="post" onsubmit="return validate()">
        <!-- Do not use table to format fields. As a good practice use CSS -->
        <table align="center">
         <tr>
         <td>Type de document</td>
         <td><select name="type" id="pet-select">
    		 <option value="">--Please choose an option--</option>
		     <option value="1">Livre</option>
		     <option value="2">CD</option>
      		 <option value="3">image</option>
			</select></td>
         </tr>
         <tr>
         <td>Titre du document</td>
         <td><input type="text" name="titre" /></td>
         </tr>
         <tr> <!-- refer to the video to understand request.getAttribute() -->
         <td><span style="color:red"><%=(request.getAttribute("errMessage") == null) ? ""
         : request.getAttribute("errMessage")%></span></td>
         </tr>
         <tr>
         <td></td>
         <td><input name="btn_ajouter" type="submit" value="Ajouter"></input><input
         type="reset" value="Reset"></input></td>
         </tr>
        </table>
    </form>
    	<form name="supprimer" action="document" method="post" onsubmit="return validate()">
        	<span>Id du documents à supprimer</span><br>
        	<input type="number" name="idDoc" id="idDoc"/>
	    	<input name="btn_delete" type="submit" value="Supprimer le document"></input>
    	</form>
    	<br><br>
    	<form name="chercher" action="document" method="post" onsubmit="return validate()">
        	<span>Type du documents à voir</span><br>
     		<select name="type" id="pet-select">
		     <option value="1">Livre</option>
		     <option value="2">CD</option>
      		 <option value="3">image</option>
			</select>
        	
	    	<input name="btn_chercher" type="submit" value="Voir les documents"></input>
    	</form>
    	<br><br>
    	<div><h1 class="catalogue"> ${catalogue}</h1></div>
    	
    	<center>
	    	<form name="deco" action="login" method="get" onsubmit="return validate()">
		    	<input name="btn_deco" type="submit" value="Se déconnecter"></input>
	    	</form>
    	</center>
    	
</body>
</html>