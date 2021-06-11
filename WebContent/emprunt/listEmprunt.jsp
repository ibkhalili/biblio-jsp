<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="ma.ensak.beans.Emprunt"%>
<%@ page import="ma.ensak.dao.EmpruntDao"%>
<%@ page import="java.util.List"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des emprunts</title>
<link rel="stylesheet" href="/biblio/resources/css/styles.css">
</head>
<body>
<h3><a href="/biblio/index.jsp">&#8592; Accueil</a></h3>
	<%
	EmpruntDao dao = new EmpruntDao();
	List<Emprunt> empruntList = dao.Lister();
	%>
	<table class="table-template">
		<tr>
			<th>Numero</th>
			<th>numero_livre</th>
			<th>cin_etudiant</th>
			<th>date</th>
			<th>remis le</th>
		</tr>
		<tr>
			<%
			for (Emprunt emprunt : empruntList) {
				if (emprunt.getRemis_le() == null) {
			%>
			<td><%=emprunt.getNumero()%></td>
			<td><%=emprunt.getNumero_livre()%></td>
			<td><%=emprunt.getCin_etudiant()%></td>
			<td><%=emprunt.getDate()%></td>
			<form method="POST" action='/biblio/EmpruntHandler' name="formRemis">
			<td  style="display: block; overflow: hidden; padding: 0 0 0 0">
				<input style="width: 100%; outline: none; border: 0; height: 35px" type="text" name="remis_le" />
			<input type="hidden" name="numero" value="<%=emprunt.getNumero()%>" />
			<input type="hidden" name="action" value="remis" />
			</td>
			<td><a
				href="/biblio/EmpruntHandler?action=editform&numero=<%=emprunt.getNumero()%>">Update</a></td>
			<td><input type="submit" value="Remis" /></td>
			</form>
		</tr>
		<%
		}
		}
		%>
	</table>
<h3><a href="/biblio/emprunt/newEmprunt.jsp">&#8594; Emprunter</a></h3>
</body>
</html>