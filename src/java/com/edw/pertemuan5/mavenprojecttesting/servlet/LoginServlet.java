/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edw.pertemuan5.mavenprojecttesting.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *  class untuk mem-proses login
 *  disini dilakukan validasi login, misalkan menggunakan database.
 * 
 * @author edwin < edwinkun at gmail dot com >
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        
        PrintWriter out = response.getWriter();

        // ini gagal login
        if(!request.getParameter("username").equals("admin") || !request.getParameter("password").equals("123")) {
            out.println("{\"status\":0, \"keterangan\":\"Username atau Password Salah\"}");
        } else { 
            // ini berhasil login
            out.println("{\"status\":1, \"keterangan\":\"Welcome Admin\"}");
            
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("username", request.getParameter("username"));
        }
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
