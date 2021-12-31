package AntiPatterns;

public class Admins {
    String id;
    String email;
    String locationid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public Admins(String email) {
        this.email = email;
    }

    public Admins() {
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocationid() {
        return locationid;
    }

    public void setLocationid(String locationid) {
        this.locationid = locationid;
    }
}
