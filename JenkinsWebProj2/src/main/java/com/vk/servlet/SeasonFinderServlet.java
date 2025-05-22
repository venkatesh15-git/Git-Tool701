package com.vk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/seasonurl")
public class SeasonFinderServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Get PrintWriter
        PrintWriter pw = resp.getWriter();
        // Set response content type
        resp.setContentType("text/html");

        // Get current date and time
        LocalDateTime ldt = LocalDateTime.now();
        int month = ldt.getMonthValue();

        // Determine season
        String seasonName;
        if (month >= 3 && month <= 6) {
            seasonName = "Summer Season";
        } else if (month >= 7 && month <= 10) {
            seasonName = "Rainy Season";
        } else {
            seasonName = "Winter Season";
        }

        // Display output
        pw.println("<!DOCTYPE html>");
        pw.println("<html><head><title>Season Result</title></head><body>");
        pw.println("<h1 style='color:pink;text-align:center'>" + seasonName + "</h1>");
        pw.println("<div style='text-align:center;'>");
        pw.println("<a href='index.jsp'>Home <img src='images/home.jpg' width='50' height='50'></a>");
        pw.println("</div>");
        pw.println("</body></html>");

        pw.close();
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
