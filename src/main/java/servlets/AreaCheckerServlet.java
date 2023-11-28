package servlets;

import com.google.gson.Gson;
import data.UserData;
import data.UserSessionBean;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.AreaValidator;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@WebServlet(name = "areaCheckerServlet", urlPatterns = "/checker", value = "/checker")
public class AreaCheckerServlet extends HttpServlet {

//    @Inject
//    UserSessionBean userSessionBean;


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        double x, y, r;
        try {
            x = Double.parseDouble(request.getParameter("x"));
            y = Double.parseDouble(request.getParameter("y"));
            r = Double.parseDouble(request.getParameter("r"));

            UserData data = new UserData(x, y, r);
            data.setLastR(r);
            makeResponsePage(data, request, response);
        } catch (Exception e) {
            request.getSession().setAttribute("error", "400 Bad Request");
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }

    private void makeResponsePage(UserData data, HttpServletRequest request, HttpServletResponse response) throws IOException {
        boolean check = AreaValidator.checkArea(data);
        data.setSuccess(check);
        data.setCurrentTime((String) request.getAttribute("currentTime"));
        long requestStarted = (Long) request.getAttribute("execTime");
        data.setExecutionTime(String.valueOf(String.format("%.2f", ((System.nanoTime() - requestStarted) * 0.000001))));
        UserSessionBean userSessionBean = (UserSessionBean) request.getSession().getAttribute("userSessionBean");
        userSessionBean.addResult(data);
//        System.out.println(userSessionBean.getRequests().toString());
//        UserSessionBean sessionBean = (UserSessionBean) request.getSession().getAttribute("sessionBean");
//        if (sessionBean == null) {
//            sessionBean = new UserSessionBean();
//            request.getSession().setAttribute("sessionBean", sessionBean);
//        }
//        sessionBean.addResult(data);
//        request.getSession().setAttribute("sessionBean", sessionBean);
        Gson gson = new Gson();
        Map<String, Object> json = new HashMap<>();
        json.put("x", data.getX());
        json.put("y", data.getY());
        json.put("r", data.getR());
        json.put("success", data.isSuccess());
        json.put("currentTime", data.getCurrentTime());
        json.put("execTime", data.getExecutionTime());
        json.put("lastR", data.getLastR());

        String msg = gson.toJson(json);
        response.getWriter().write(msg);
        response.getWriter().flush();
    }
}
