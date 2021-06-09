<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="ma.ensak.beans.Etudiant"%>
<%@ page import="ma.ensak.dao.EtudiantDao"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifier Etudiant</title>
</head>
<body>
<%
	Etudiant etudiant = new Etudiant();
	EtudiantDao dao = new EtudiantDao();
%>
<form method="POST" action='EtudiantHandler' name="formEditEtudiant">
<input type="hidden" name="action" value="edit" />
<%
 	String cin = request.getParameter("cin");
 	if (!((cin) == null)) {
 		etudiant = dao.getEtudiantById(cin);
 %>
<table>
	<tr>
		<td>cin</td>
		<td><input type="text" name="cin" readonly="readonly"
			value="<%=etudiant.getCin() %>"></td>
	</tr>
	<tr>
		<td>nom</td>
		<td><input type="text" name="nom" value="<%=etudiant.getNom()%>" /></td>
	</tr>
	<tr>
		<td>prenom</td>
		<td><input type="text" name="prenom" value="<%=etudiant.getPrenom()%>" /></td>
	</tr>
	<tr>
		<td>filiere</td>
		<td><input type="text" name="filiere" value="<%=etudiant.getFiliere()%>" /></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="Update" /></td>
	</tr>
</table>
<%
	} else
		out.println("Cin Not Found");
%>
</form>
</body>
</html>