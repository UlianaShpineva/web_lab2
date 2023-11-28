package data;


import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;



@SessionScoped
public class UserSessionBean implements Serializable {
    private List<UserData> requests;

    public UserSessionBean() {
        requests = new ArrayList<>();
    }

    public void addResult(UserData data) {
        requests.add(0, data);
    }

    public List<UserData> getRequests() {
        return requests;
    }

    public void setRequests(List<UserData> requests) {
        this.requests = requests;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserSessionBean that = (UserSessionBean) o;

        return Objects.equals(requests, that.requests);
    }

    @Override
    public int hashCode() {
        return requests != null ? requests.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "UserSessionBean{" +
                "requests=" + requests +
                '}';
    }
}
