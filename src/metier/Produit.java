package metier;

public class Produit 
{
	private Long id;
	private String nom, desc;
	private int price, etat;
	
	public Produit(Long id, String nom, String desc, int price, int etat) {
		//super();
		this.id = id;
		this.nom = nom;
		this.desc = desc;
		this.price = price;
		this.etat = etat;
	}
	public Produit(String nom, String desc, int price, int etat) {
		//super();
		this.nom = nom;
		this.desc = desc;
		this.price = price;
		this.etat = etat;
	}
	public Produit() {
		//super();
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getEtat() {
		return etat;
	}
	public void setEtat(int etat) {
		this.etat = etat;
	}
	public String toString()
	{
		return id + " - "+nom + " - " +desc +" - "+ price + " - "+ etat + ".";
	}
	public void show()
	{
		System.out.println(toString());		
	}

}
