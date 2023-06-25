package estructura;

import um.prog2.tad.lista.MyLinkedListImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Tweet {

    private int favorites;

    private long id;
    private String content;
    private LocalDate date;
    private String source;
    private boolean isRetweet;
    private User user;
    private MyLinkedListImpl<Hashtag> hashtags;

    public Tweet(long id, String content, String source, boolean isRetweet, LocalDate date, int favorites, User user, MyLinkedListImpl<Hashtag> hashtags) {
        this.id = id;
        this.content = content;
        this.source = source;
        this.isRetweet = isRetweet;
        this.date = date;
        this.favorites = favorites;
        this.user = user;
        this.hashtags = hashtags;
    }

    public int getFavorites() {
        return favorites;
    }

    public void setFavorites(int favorites) {
        this.favorites = favorites;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public boolean isRetweet() {
        return isRetweet;
    }

    public void setRetweet(boolean retweet) {
        isRetweet = retweet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Hashtag> getHashtagsList() {
        List<Hashtag> list = new ArrayList<>();
        // Aquí deberías iterar sobre los elementos de tu `MyLinkedListImpl<Hashtag>`
        // y agregar cada elemento a `list`.
        return list;
    }


    public MyLinkedListImpl<Hashtag> getHashtags() {
        return hashtags;
    }


    public void setHashtags(MyLinkedListImpl<Hashtag> hashtags) {
        this.hashtags = hashtags;
    }
}
