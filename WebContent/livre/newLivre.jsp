<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajouter livre</title>
</head>
<body>
<form method="POST" action='/biblio/LivreHandler' name="formAddLivre">
<input type="hidden" name="action" value="insert" />
<p><b>Ajouter un nouveau livre</b></p>
<table>
	<tr>
		<td>titre</td>
		<td><input type="text" name="titre" /></td>
	</tr>
	<tr>
		<td>numero_edition</td>
		<td><input type="text" name="numero_edition" /></td>
	</tr>
	<tr>
		<td>date_apparition</td>
		<td><input type="date" name="date_apparition" /></td>
	</tr>
	<tr>
		<td>stock</td>
		<td><input type="text" name="stock" /></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="Submit" /></td>
	</tr>
</table>
</form>
<p><a href="/biblio/LivreHandler?action=listLivre">Liste des livres</a></p>
</body>
</html>