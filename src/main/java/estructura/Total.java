package estructura;

public class Total implements Comparable<Total>{
    private int total;
    private User user;

    public Total(int total, User user) {
        this.total = total;
        this.user = user;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void aumentar() {
        total++;
    }

    @Override
    public int compareTo(Total o) {
        return this.user.compareTo(o.getUser());
    }
}
