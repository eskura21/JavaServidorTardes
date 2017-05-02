package com.ipartek.ejemplos.javierlete.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.ejemplos.javierlete.dal.UsuariosDAL;
import com.ipartek.ejemplos.javierlete.dal.UsuariosDALFijo;
import com.ipartek.ejemplos.javierlete.tipos.Usuario;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recoger datos de vistas
		String nombre = request.getParameter("nombre");
		String pass = request.getParameter("pass");

		// Crear modelos en base a los datos
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setPass(pass);

		// Llamada a l�gica de negocio
		UsuariosDAL usuarioDAL = new UsuariosDALFijo();

		// S�lo para crear una base de datos falsa con el
		// contenido de un usuario "javi", "lete"
		usuarioDAL.alta(new Usuario("javi", "lete"));

		boolean esValido = usuarioDAL.validar(usuario);

		// Redirigir a una nueva vista
		if (esValido) {
			request.getSession().setAttribute("usuario", usuario);
			// response.sendRedirect("principal.jsp");
			request.getRequestDispatcher("/WEB-INF/principal.jsp").forward(request, response);
		} else {
			usuario.setErrores("El usuario y contrase�a introducidos no son v�lidos");
			request.setAttribute("usuario", usuario);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
