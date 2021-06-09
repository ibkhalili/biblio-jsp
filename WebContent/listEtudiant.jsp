<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="ma.ensak.beans.Etudiant"%>
<%@ page import="ma.ensak.dao.EtudiantDao"%>
<%@ page import="java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des Eudiants</title>
</head>
<body>
<%
    EtudiantDao dao = new EtudiantDao();
	Etudiant<Etudiant> etudiantList = dao.Lister();
%>
<table border="1">
	<tr>
		<th>nom</th>
		<th>prenom</th>
		<th>filiere</th>
		<th>cin</th>
	</tr>
	<tr>
		<%
			for (Etudiant etudiant : etudiantList) {
		%>
		<td><%=etudiant.getNom() %></td>
		<td><%=etudiant.getPrenom() %></td>
		<td><%=etudiant.getFiliere() %></td>
		<td><%=etudiant.getCin() %></td>
		<td><a
			href="EtudiantHandler?action=editform&cin=<%=etudiant.getCin()%>">Modifier</a></td>
		<td><a
			href="EtudiantHandler?action=delete&cin=<%=etudiant.getCin()%>">Supprimer</a></td>

	</tr>
	<%
		}
	%>
</table>
<p><a href="EtudiantHandler?action=insert">Ajouter Etudiant</a></p>
</body>
</html>