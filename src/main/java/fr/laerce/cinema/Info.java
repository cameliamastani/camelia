package fr.laerce.cinema;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet(name = "info")
public class Info extends HttpServlet {

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String name = request.getParameter("name");
            PrintWriter out = response.getWriter();
            FilmsDonnees fd = new FilmsDonnees();
            out.print("<body>");
            out.print("<ul>");
            for (Film film:fd.lesFilms) {
                if (film.titre.toLowerCase().contains(name.toLowerCase())){
                    out.print("<li><a href='/Info?id="+film.id+"'>"+film.titre+"</a></li>");
                }
            }
            out.print("</ul>");
            out.print("</body>");
        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {
            Integer id = Integer.parseInt( request.getParameter("id"));
            FilmsDonnees fd = new FilmsDonnees();
            Film film = fd.getById(id);
            PrintWriter out = response.getWriter();
//                ServletContext cntx= getServletContext();
//                String filename = cntx.getRealPath("WEB-INF/datas/affiches/"+film.afficheNom);
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Info de "+film.titre+"</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>"+film.titre+"<h1>");
                out.println("<img height='150' width='150' src='/affiche?id="+id+"'></img>");
                out.println("<h2>la note de ce film est "+film.note+"<h2>");
                out.println("</html>");

        }
        }


