package init;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(value="/initializeResources", loadOnStartup=1)
public class Injection extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		System.out.println("OUHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
		try {
			//Class.forName(config.getInitParameter("data"));
			Class.forName("persistantdata.MediatekData");
		}catch(Throwable e) {
			e.printStackTrace();
		}
		System.out.println("YESSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
	}
}
