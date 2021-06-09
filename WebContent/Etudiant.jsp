<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajouter Etudiant</title>
</head>
<body>
<form method="POST" action='EtudiantHandler' name="formAddLivre">
<input type="hidden" name="action" value="insert" />
<p><b>Ajouter un nouveau Etudiant</b></p>
<table>
	<tr>
		<td>nom</td>
		<td><input type="text" name="nom" /></td>
	</tr>
	<tr>
		<td>prenom</td>
		<td><input type="text" name="prenom" /></td>
	</tr>
	<tr>
		<td>filiere</td>
		<td><input type="text" name="filiere" /></td>
	</tr>
	<tr>
		<td>cin</td>
		<td><input type="text" name="cin" /></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="Submit" /></td>
	</tr>
</table>
</form>
<p><a href="EtudiantHandler?action=listEtudiant">Liste des Etudiants</a></p>
</body>
</html>