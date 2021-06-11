<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Emprunter un livre</title>
<link rel="stylesheet" href="/biblio/resources/css/styles.css">
</head>
<body>
<h3><a href="/biblio/EmpruntHandler?action=listEmprunt">&#8592; Liste des emprunts</a></h3>
	<div class="container">
		<div class="content">
			<h2 style="color: blue">Emprunter un livre</h2>
			<form method="POST" action='/biblio/EmpruntHandler'
				name="formAddEmprunt">
				<input type="hidden" name="action" value="insert" />
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
					<!-- <tr>
						<td></td>
						<td><a href="/biblio/EmpruntHandler?action=listEmprunt">&#8592;Liste des emprunts</a></td>
					</tr> -->
				</table>
			</form>
		</div>
	</div>
</body>
</html>