package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;


@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public login() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("enviar")!=null) {
			
			String usuario=request.getParameter("usuario");
			String password=request.getParameter("pass");
			////////////////////////////////////////////////////////////////////
			/////////	admininicial
			////////	admin123456
			if(usuario.equals("1234")&& password.equals("1234")) {
				//JOptionPane.showMessageDialog(null, "Bienvenido");
				response.sendRedirect("Menu.jsp");
			}else {
				JOptionPane.showMessageDialog(null, "Usuario o contraseña errados,\r\n"
						+ "intente de nuevo.\r\n");
				response.sendRedirect("login.jsp");
			}
		}
	}

}
