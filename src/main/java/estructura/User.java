package estructura;

public class User {

    private long id;
    private String name;

    private String username;
    private boolean isVerified;

    public User(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int compareTo(User o) {
        return (int)id-(int)o.getId();
    }

    public String getUsername() {
        return username;
    }

    public boolean isVerified() {
        return isVerified;
    }
}