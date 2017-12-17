package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Operation;
import metier.Produit;


@WebServlet(asyncSupported = true, description = "it does the work of a Servlet !", urlPatterns = { "/Serflate" })
public class ServletProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //private Operation op;
   // private long ordre = 0;
    /**
     * Default constructor. 
     */
    public ServletProduit() {
        
    }
    /*public void init() throws ServletException {
    	op = new Operation();    	
    }      */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		Operation op = new Operation();
		if (request.getParameter("action") != null){
			op.remove(Long.parseLong(request.getParameter("id")));
			System.out.println(" Action = Supprimer " + request.getParameter("id"));
		}else{
			
			//ordre = ordre + 1;  // pour rendre l' id incrémental.
			System.out.println(" Action = Valider");
		       // Récupérer les informations
		String nom = request.getParameter("Nom");
		String  desc = request.getParameter("Description");
		String price = request.getParameter("Price");
		String etat = request.getParameter("State");
		op.add(new Produit(1L,nom, desc, Integer.parseInt(price), Integer.parseInt(etat)));
		}
		ProduitBeans pb = new ProduitBeans();		
		pb.setListe(op.getAll());
		request.setAttribute("modele", pb);
		request.getRequestDispatcher("Produit.jsp").forward(request, response);
		
		
		       // Aficher les informations
		/*PrintWriter pr = response.getWriter();
		pr.println("<html><head><tiltle> Essai </tiltle> </head><body>");
		pr.println(" - "+nom+" - "+desc+" - "+price+" - "+etat+" .");
		pr.println("</body></html>"); */
		
			
	}

}
