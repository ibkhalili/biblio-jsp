<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="ma.ensak.beans.Livre"%>
<%@ page import="ma.ensak.dao.LivreDao"%>
<%@ page import="java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des livres</title>
</head>
<body>
<%
	LivreDao dao = new LivreDao();
	List<Livre> livreList = dao.Lister();
%>
<table border="1">
	<tr>
		<th>Numero</th>
		<th>titre</th>
		<th>numero_edition</th>
		<th>date_apparition</th>
		<th>stock</th>
	</tr>
	<tr>
		<%
			for (Livre livre : livreList) {
		%>
		<td><%=livre.getNumero() %></td>
		<td><%=livre.getTitre() %></td>
		<td><%=livre.getNumero_edition() %></td>
		<td><%=livre.getDate_apparition() %></td>
		<td><%=livre.getStock() %></td>
		<td><a
			href="LivreHandler?action=editform&numero=<%=livre.getNumero()%>">Update</a></td>
		<td><a
			href="LivreHandler?action=delete&numero=<%=livre.getNumero()%>">Delete</a></td>

	</tr>
	<%
		}
	%>
</table>
<p><a href="LivreHandler?action=insert">Ajouter Livre</a></p>
</body>
</html>