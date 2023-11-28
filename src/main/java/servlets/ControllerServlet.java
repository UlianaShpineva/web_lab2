package servlets;

import com.google.gson.Gson;
import data.UserData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.InputValidator;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "controllerServlet", urlPatterns = "/controller", value = "/controller")
public class ControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("error", "404 Page was not found");
        response.sendRedirect(request.getContextPath() + "/error.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InputValidator validator = new InputValidator(request);

        long startTime = System.nanoTime();
        if (!validator.checkFormat() || !validator.getStatus()) {
            request.getSession().setAttribute("error", "400 Bad Request");
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        } else {
            String requestTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
            request.setAttribute("execTime", startTime);
            request.setAttribute("currentTime", requestTime);
            getServletContext().getRequestDispatcher("/checker"). forward(request, response);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/cleaner").forward(request, response);
    }
}