/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.DAO.IAvistamientosDAO;
import es.albarregas.DAOFactory.DAOFactory;
import es.albarregas.beans.Avistamiento;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jesus
 */
@WebServlet(name = "Operacion", urlPatterns = {"/Operacion"})
public class Operacion extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        URL uri = getClass().getClassLoader().getResource("fuenteDatos.properties");
//
//        Properties prop = new Properties();
//        prop.load(new FileInputStream(uri.getFile()));
//        int fuente = Integer.parseInt(prop.getProperty("fuente"));
        int fuente = Integer.parseInt(request.getParameter("bd"));

//        DAOFactory daof = DAOFactory.getDAOFactory(fuente);
//        request.setAttribute("fuente", prop.getProperty("fuente"));
            request.getSession().setAttribute("fuente", fuente);
//        IAvistamientosDAO adao = daof.getAvistamientosDAO();
//        List<Avistamiento> listado = null;
//        
//        if (request.getParameter("anilla").length() != 0) {
//            listado = adao.getById(request.getParameter("anilla"));
//        } else {
//            listado = adao.getAll();
//        }
//        String url = null;
//        if (listado.isEmpty()) {
//            url = "error.jsp";
//            request.setAttribute("error", "La anilla no se ha encontrado en la base de datos");
//        } else {
//            url = (request.getParameter("anilla").length() != 0)?"salida.jsp":"salidaTotal.jsp";
//            
//            request.setAttribute("listado", listado);

//        }

        request.getRequestDispatcher("entrada.html").forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int fuente = (Integer)request.getSession().getAttribute("fuente");
        DAOFactory daof = DAOFactory.getDAOFactory((fuente));

            
        IAvistamientosDAO adao = daof.getAvistamientosDAO();
        List<Avistamiento> listado = null;
        
        if (request.getParameter("anilla").length() != 0) {
            listado = adao.getById(request.getParameter("anilla"));
        } else {
            listado = adao.getAll();
        }
        String url = null;
        if (listado.isEmpty()) {
            url = "error.jsp";
            request.setAttribute("error", "La anilla no se ha encontrado en la base de datos");
        } else {
            url = (request.getParameter("anilla").length() != 0)?"salida.jsp":"salidaTotal.jsp";
            
            request.setAttribute("listado", listado);

        }
        request.getRequestDispatcher(url).forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
