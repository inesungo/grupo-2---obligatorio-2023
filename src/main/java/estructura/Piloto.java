package estructura;


import um.prog2.tad.hash.MyHash;

public class Piloto {
    private String nombre;
    private MyHash<Integer, Total> totalTweet;

    public Piloto(String nombre, MyHash<Integer, Total> totalTweet) {
        this.nombre = nombre;
        this.totalTweet = totalTweet;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public MyHash<Integer, Total> getTotalTweet() {
        return totalTweet;
    }

    public void setTotalTweet(MyHash<Integer, Total> totalTweet) {
        this.totalTweet = totalTweet;
    }
}
