/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edw.pertemuan5.mavenprojecttesting.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *  disini dilakukan validasi session untuk mengakses folder admin
 *  jika belum login (session == null) maka redirect ke halaman login
 * 
 * @author edwin < edwinkun at gmail dot com >
 */
@WebFilter(filterName = "SessionFilter", urlPatterns = {"/admin/*"})
public class SessionFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        
        HttpSession session = httpServletRequest.getSession();
        if(session.getAttribute("username") == null) {
            httpServletResponse.sendRedirect("../index.jsp");
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
    
    
}
