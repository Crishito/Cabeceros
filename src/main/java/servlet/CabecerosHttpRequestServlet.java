package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;


//Conotacion nuestra llave
@WebServlet("/cabecero-request")
public class CabecerosHttpRequestServlet extends HttpServlet {

    //Metodo
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // me va devolver el tipo de contenido y manejar cualquier tipo de caracter
        resp.setContentType("text/html;charset=UTF-8");
        // me devuelve el metodo que yo estoy trabajando
        String metodoHttp= req.getMethod();
        //Obtener un objeto de tipo vector y castearlo a string
        String requestURI = req.getRequestURI().toString();
        //Variable para solicitar toda la URL donde estoy solicitando la peticion
        String requestURL = req.getRequestURL().toString();
        //Contexpath todo el contenido de
        String contextPath = req.getContextPath();
        //Nombre del server
        String servletPath = req.getServletPath();
        //Metodo para optener la ip de donde se esta realizando la petición
        String ip = req.getRemoteAddr();
        //Port de donde se realiza la petición
        int port = req.getLocalPort();

        //Escribimos en HTML
        try (PrintWriter out = resp.getWriter()) {
            ;
            //generar plantilla
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Manejo de cabeceros 2025-2026</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Manejo de cabeceros</h1>");
            out.println("<ul>");
            out.println("<li>Obteniendo el método de petición: " + metodoHttp + "</li>");
            out.println("<li>Obteniendo la URI: " + requestURI + "</li>");
            out.println("<li>Obteniendo la URL: " + requestURL + "</li>");
            out.println("<li>Obteniendo el contexto: " + contextPath + "</li>");
            out.println("<li>Obteniendo el servlet: " + servletPath + "</li>");
            out.println("<li>Obteniendo la ip: " + ip + "</li>");
            out.println("<li>Obteniendo la porta: " + port + "</li>");
            Enumeration<String> headerNames = req.getHeaderNames();
            //Mientras hay elementos dentro de la variable hadersname
            //lo que hace es imprimir
            //

            while (headerNames.hasMoreElements()) {
                //Mostrarme cada uno de ellos
                String cabecera = headerNames.nextElement();
                // imprimimos en una lista mandamos a imprimir los cabeceros
                out.println("<li>" + cabecera + " : " + req.getHeader(cabecera) + "</li>");
            }

            out.println("</ul>");
            out.println("</body>");
            out.println("</html>");

        }
    }
}
