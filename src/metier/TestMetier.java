package metier;

import java.util.Iterator;

public class TestMetier {

	public static void main(String[] args) 
	{
		Operation op = new Operation();
		//Produit p = new Produit();
		op.add(new Produit(new Long (1),"PC","LapTop TOSHIBA",7460,1));
		op.add(new Produit(2L,"Téléphone","SAMSUNG E250",780,1));
		op.add(new Produit(3L,"TV","SONY",3200,1));
		op.add(new Produit(4L,"Voiture","Volkswagen Touran",248000,0));
		op.add(new Produit(5L,"Caméra","Canon Powershot",950,1));
		
		//op.remove(2L);
		
		Iterator<Produit> prds = op.getAll().iterator();
		while(prds.hasNext())
		{
			Produit pr = prds.next();
			pr.show();
		}
		

	}

}
