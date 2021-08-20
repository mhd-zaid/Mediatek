package services;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import document.Document;
import mediatek2021.Mediatek;
import mediatek2021.NewDocException;
import mediatek2021.SuppressException;
import mediatek2021.Utilisateur;

/**
 * Servlet implementation class Servet_Document
 */
@WebServlet("/document")
public class Servlet_Document extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Mediatek media = Mediatek.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_Document() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
       	request.getSession().getAttribute("name");
       	request.getServletContext().getRequestDispatcher("/WEB-INF/Welcome.jsp").forward(request, response);
       	
       	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {       	
		response.sendRedirect("document");
        HttpSession session = request.getSession(true);
       	
        
       	if(request.getParameter("btn_ajouter")!=null) {
       		String type = request.getParameter("type");
    		int numDoc = Integer.parseInt(type);
           	String titre = request.getParameter("titre");
      
           	Object tab = null ;
           	tab = titre;

       		try {
				media.newDocument(numDoc, tab);
       			
			} catch (NewDocException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       	}
       	
       	if(request.getParameter("btn_delete")!=null) {
       		String numeroDoc = request.getParameter("idDoc");
    		int idDoc = Integer.parseInt(numeroDoc);
       		try {
       			System.out.println(idDoc);
				media.suppressDoc(idDoc);
			} catch (SuppressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       	}
       	
       	if(request.getParameter("btn_chercher")!=null) {
       		String type = request.getParameter("type");
    		int numDoc = Integer.parseInt(type);
    		String catalogue = media.catalogue(numDoc).toString();
    		session.setAttribute("catalogue", catalogue);
       	}
       	
       	if(request.getParameter("btn_deco")!=null) {
       		session.invalidate();
       		response.sendRedirect("login");
       	}
       	
   	}

}
