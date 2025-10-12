package com.jarv.myservlet;

import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/TableServlet")
public class TableServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String title = request.getParameter("title");
        int rows = Integer.parseInt(request.getParameter("rows"));
        int cols = Integer.parseInt(request.getParameter("cols"));
        String color = request.getParameter("color");

        response.setContentType("text/html;charset=UTF-8");

        StringBuilder tableBuilder = new StringBuilder();
        tableBuilder.append("<table>");
        for (int i = 0; i < rows; i++) {
            tableBuilder.append("<tr>");
            for (int j = 0; j < cols; j++) {
                tableBuilder.append("<td style='background-color:")
                            .append((color == null || color.isEmpty()) ? "white" : color)
                            .append("'></td>");
            }
            tableBuilder.append("</tr>");
        }
        tableBuilder.append("</table>");

        response.getWriter().write(tableBuilder.toString());
    }
}