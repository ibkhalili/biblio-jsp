<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Emprunter un livre</title>
</head>
<body>
<form method="POST" action='/biblio/EmpruntHandler' name="formAddEmprunt">
<input type="hidden" name="action" value="insert" />
<p><b>Emprunter un livre</b></p>
<table>
	<tr>
		<td>Numero de livre</td>
		<td><input type="text" name="numero_livre" /></td>
	</tr>
	<tr>
		<td>CIN d'etudiant</td>
		<td><input type="text" name="cin_etudiant" /></td>
	</tr>
	<tr>
		<td>Date</td>
		<td><input type="text" name="date" /></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="Submit" /></td>
	</tr>
</table>
</form>
<p><a href="/biblio/EmpruntHandler?action=listEmprunt">Liste des emprunts</a></p>
</body>
</html>