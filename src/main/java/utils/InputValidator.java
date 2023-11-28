package utils;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Objects;


public class InputValidator {
    Double x, y, r;
    private HttpServletRequest request;

    public InputValidator(HttpServletRequest request) {
        this.request = request;
    }

    public boolean checkFormat(){
        return !request.getParameter("x").isEmpty() && !request.getParameter("y").isEmpty() && !request.getParameter("r").isEmpty();
    }

    public boolean getStatus(){
        if(!validateX(request.getParameter("x")) || !validateY(request.getParameter("y")) || !validateR(request.getParameter("r"))){
            return false;
        }
        return true;
    }

    public boolean validateX(String xString) {
        if (Objects.isNull(xString) || xString.isEmpty()) return false;
        try {
            this.x = Double.parseDouble(xString);
            return x >= -5 && x <= 3;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean validateY(String yString) {
        if (Objects.isNull(yString) || yString.isEmpty()) return false;
        try {
            this.y = Double.parseDouble(yString);
            return y >= -5 && y <= 5;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean validateR(String rString) {
        if (Objects.isNull(rString) || rString.isEmpty()) return false;
        try {
            this.r = Double.parseDouble(rString);
            return r >= 1 && r <= 3;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
