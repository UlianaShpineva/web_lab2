package utils;

import data.UserData;

public class AreaValidator {
    public static boolean checkArea(UserData data) {
        double x = data.getX();
        double y = data.getY();
        double r = data.getR();
        if (x < 0 && y < 0 && (x * x + y * y > r * r / 4)) return false;
        if (x < 0 && y > 0 && (y > x * 2 + r)) return false;
        if (x > 0 && y > 0 && (x > r || y > r / 2)) return false;
        if (x > 0 && y < 0) return false;
        if (x == 0 && (y > r || y < -r / 2)) return false;
        if (y == 0 && (x > r || x < -r / 2)) return false;
        return true;
    }
}
