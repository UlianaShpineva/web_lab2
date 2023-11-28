package data;

import java.io.Serializable;

public class UserData implements Serializable {
    double x, y, r;
    String currentTime;
    String executionTime;
    boolean success;
    double lastR;

    public UserData(double x, double y, double r) { //boolean res) {//String currentTime, String executionTime, boolean res) {
        this.x = x;
        this.y = y;
        this.r = r;
//        this.currentTime = currentTime;
//        this.executionTime = executionTime;
//        success = res;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }

//    public String getSuccess()

    public String getCurrentTime() {
        return currentTime;
    }

    public String getExecutionTime() {
        return executionTime;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public void setExecutionTime(String executionTime) {
        this.executionTime = executionTime;
    }

    public double getLastR() {
        return lastR;
    }

    public void setLastR(double lastR) {
        this.lastR = lastR;
    }
}
