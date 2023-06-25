package estructura;

public class UserReport {
    private String username;
    private int tweetsCount;
    private boolean isVerified;

    public UserReport(String username, boolean isVerified) {
        this.username = username;
        this.isVerified = isVerified;
        this.tweetsCount = 0;
    }

    public String getUsername() {
        return username;
    }

    public int getTweetsCount() {
        return tweetsCount;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void incrementTweetsCount() {
        this.tweetsCount++;
    }
}
