package metier;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;




public class Operation 
{
	 // Un seul attribut = Une liste d'objets produits
   private ArrayList<Produit> produits = new ArrayList<Produit> ();

   public ArrayList<Produit> getProduits()  // le getter de l'attribut  ;)
   {
	    return produits;
   }

   public void setProduits(ArrayList<Produit> produits) // le setter de l'attribut 
   {
	   this.produits = produits;
   }
   
   public void add (Produit p)
   {
	   try {
		     // 1     Ajout à la base de donnée du "Produit" envoyé en paramètre
		     Class.forName("com.mysql.jdbc.Driver");
		     //2		    
			 Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/gestionprodutto?user=root&password=maat123alla");
			 // 3 Objet commande	
			 PreparedStatement pr = cn.prepareStatement("INSERT INTO produit VALUES(NULL,?,?,?,?)");
			 pr.setString(1, p.getNom());
			 pr.setString(2, p.getDesc());
			 pr.setInt(3, p.getPrice());
			 pr.setInt(4, p.getEtat());
			 // 4 Executer la commande !
			 pr.execute();     // Execution de la requête SQL préparée !
	       } catch (Exception e) {
		
		             e.printStackTrace();
	       }
	 //   produits.add(p);   // On ajoute à notre liste "produits" ( cas où on ne travaille pas avec une DB )
   }
   public void remove(Long id )
   {
	   try {     // Suppression de la base de donnée du "Produit" dont le ID est envoyé en paramètre
		     // 1
		     Class.forName("com.mysql.jdbc.Driver");
		     //2		    
			 Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/gestionprodutto?user=root&password=maat123alla");
			 // 3 Objet commande	
			 PreparedStatement pr = cn.prepareStatement("DELETE FROM produit WHERE id = ?");
			 pr.setLong(1, id);
			 // 4 Executer la commande !
			 pr.execute();
	       } catch (Exception e) {
		
		             e.printStackTrace();
	       } 
	/*   for ( Produit p: produits)      // On supprime de notre liste "produits" ( cas où on ne travaille pas avec une DB )
	   {
		   if (p.getId() == id )
		   {
			   produits.remove(p);
			   break;
		   }
	   }  */
	   System.out.println(" l' ID supprimé est : " + id);
   }
   public ArrayList<Produit> getAll()  // Affichage destiné à la servlet
   {
	   ArrayList<Produit> ListP = new ArrayList<Produit>();
	   try {
		     // 1
		     Class.forName("com.mysql.jdbc.Driver");
		     //2		    
			 Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/gestionprodutto?user=root&password=maat123alla");
			 // 3 Objet commande	
			 PreparedStatement pr = cn.prepareStatement("SELECT * FROM produit");
			 // 4 Executer la commande !
			 ResultSet rs = pr.executeQuery();
			 // 5 Extraction des données en une liste de produits
			 while(rs.next()){
				Produit p = new Produit();
				p.setId(rs.getLong("id")); 
				p.setNom(rs.getString("nom"));
				p.setDesc(rs.getString("description"));
				p.setPrice(rs.getInt("price"));
				p.setEtat(rs.getInt("etat"));
				ListP.add(p);
			 }
	       } catch (Exception e) {
		
		             e.printStackTrace();
	       } 
	       return ListP; 
   }
	
}
