package servlets;

import data.UserSessionBean;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.ArrayList;

@WebServlet(name = "ClearTableServlet", value = "/cleaner")
public class ClearTableServlet extends HttpServlet {
    private UserSessionBean dots = new UserSessionBean();
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException {
        if (request.getSession().getAttribute("userSessionBean") != null) {
            request.getSession().setAttribute("userSessionBean", null);
        }
    }
}
