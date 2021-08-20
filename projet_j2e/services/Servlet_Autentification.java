package services;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mediatek2021.Mediatek;
import mediatek2021.Utilisateur;

/**
 * Servlet implementation class Servlet_Autentification
 */
@WebServlet("/login")
public class Servlet_Autentification extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Mediatek media = Mediatek.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_Autentification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub   
			response.setContentType("text/html");
	       	
	       	request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
	       	
	       	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
       	String password = request.getParameter("password");
       	Utilisateur name = media.getUser(username, password);
       	
        HttpSession session = request.getSession(true);
       	
       	session.setAttribute("username", username);
       	if(request.getParameter("btn")!=null) {
       		if(username.contentEquals(name.login())) {
           		session.setAttribute("name", name.login());
           		response.sendRedirect("document");
           	}
       	}
       	
       	
	}

}
