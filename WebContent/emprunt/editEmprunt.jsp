<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="ma.ensak.beans.Emprunt"%>
<%@ page import="ma.ensak.dao.EmpruntDao"%>
<%@ page import="java.text.SimpleDateFormat"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifier Emprunt</title>
</head>
<body>
<%
	Emprunt emprunt = new Emprunt();
	EmpruntDao dao = new EmpruntDao();
%>
<form method="POST" action='EmpruntHandler' name="formEditEmprunt">
<input type="hidden" name="action" value="edit" />
<%
 	String numero = request.getParameter("numero");
 	if (!((numero) == null)) {
 		int id = Integer.parseInt(numero);
 		emprunt = dao.getEmpruntById(id);
 %>
<table>
	<tr>
		<td>numero</td>
		<td><input type="text" name="numero" readonly="readonly"
			value="<%=emprunt.getNumero()%>"></td>
	</tr>
	<tr>
		<td>numero_livre</td>
		<td><input type="text" name="numero_livre" readonly="readonly" value="<%=emprunt.getNumero_livre()%>" /></td>
	</tr>
	<tr>
		<td>cin_etudiant</td>
		<td><input type="text" name="cin_etudiant" readonly="readonly" value="<%=emprunt.getCin_etudiant()%>" /></td>
	</tr>
	<tr>
		<td>date</td>
		<td><input type="text" name="date" value="<%=new SimpleDateFormat("dd/MM/yyyy").format(emprunt.getDate())%>" /></td>
	</tr>
	<tr>
		<td>remis_le</td>
		<td><input type="text" name="remis_le" value="<%=new SimpleDateFormat("dd/MM/yyyy").format(emprunt.getRemis_le())%>" /></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="Update" /></td>
	</tr>
</table>
<%
	} else
		out.println("Numero Not Found");
%>
</form>
</body>
</html>