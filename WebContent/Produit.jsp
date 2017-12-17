<%@page import = "web.ProduitBeans" %>
<%@page import = "metier.Produit" %>
<%@page import = "metier.Operation" %>
<%@page import = "java.util.Iterator" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gestion de Produits</title>
<style>
      body 
       {
          background: url("Blue.jpg");
       }
</style>
</head>
<body>
 <script type="text/javascript" src = "jquery-1.11.2.min.js"></script>
 <script type = "text/javascript" >
 $(document).ready(function(){
	 $("#lien").slideDown(2000).delay(4000).fadeOut(3000);
 });
 </script>
  <%
    ProduitBeans produits;
    if(request.getAttribute("modele") == null)
    {
    	Operation o = new Operation();
    	produits = new ProduitBeans();
    	produits.setListe(o.getAll());
    }
    else
    {
    	produits = (ProduitBeans) request.getAttribute("modele");	
    }
  %>
     <h3 align = "center">   ---Gestion Des Produits--- </h3>
     <h5 align = "center"> Ajouter un nouveau produit :</h5>
     <form  action="prodserv" method="post">
     <table align = "center" border = "1" width = "30%">
     <tr>
       <td>Nom </td>
       <td> <input type="text" name="Nom" > </td>
     </tr>
     <tr>
       <td>Description </td>
       <td> <input type="text" name="Description" >  </td>
     </tr>
     <tr>
       <td>Prix </td>
       <td> <input type="text" name="Price" >  </td>
     </tr>
     <tr>
       <td>Etat </td>
       <td>  <input type="text" name="State" > </td>
     </tr>
     <tr>
       <td colspan="2"> <input type="submit" value="Valider" /> </td>      
     </tr>
     </table>
     </form>
     <table align = "center" border = "1" width = 60% >
      <tr> 
        <th> ID </th>
        <th> Nom </th>
        <th> Description </th>
        <th> Price </th>
        <th> State </th>
        <th> Option</th>
      </tr>
      <%
        Iterator<Produit> list = produits.getListe().iterator();
        while(list.hasNext())
		{
			Produit pr = list.next();
	  %>
	   <tr>
        <td> <%=pr.getId() %> </td>
        <td> <%=pr.getNom() %></td>
        <td><%=pr.getDesc() %> </td>
        <td><%=pr.getPrice() %> </td>
        <td> <%=pr.getEtat() %></td>
        <td>
         <form action = "prodserv" method = "post">
           <input type = "hidden" name = "id" value = "<%=pr.getId() %>" />
           <input type = "hidden" name = "action" value = "Supprimer>" />
           <input type = "submit" value = "Supprimer" />
         </form>
        </td>
      </tr>
	  <% 	
		}
        
      %>
     
     </table>
     <a href="http://jquery.com/" id = "lien"> Aller au site officiel de jQuery</a> <br />
</body>
</html>