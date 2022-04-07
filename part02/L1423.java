import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class L1423Song implements Comparable<L1423Song> {
    private int id;
    private int playCount;
    private String genre;

    public L1423Song(int id, int playCount, String genre) {
        this.id = id;
        this.playCount = playCount;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public int getPlayCount() {
        return playCount;
    }

    public String getGenre() {
        return genre;
    }

    public int compareTo(L1423Song s) {
        return this.playCount - s.getPlayCount();
    }
}

class L1423Billboard {
    private HashMap<String, ArrayList<L1423Song>> songsByGenre;
    private HashMap<String, Integer> playCountByGenre;

    public L1423Billboard() {
        songsByGenre = new HashMap<>();
        playCountByGenre = new HashMap<>();
    }

    public void addSong(L1423Song song) {
        String genre = song.getGenre();
        if (!songsByGenre.containsKey(genre)) {
            songsByGenre.put(genre, new ArrayList<>());
            playCountByGenre.put(genre, 0);
        }
        songsByGenre.get(genre).add(song);
        playCountByGenre.put(genre, playCountByGenre.get(genre) + song.getPlayCount());
    }

    public ArrayList<String> getGenresByPlayCount() {
        return playCountByGenre.keySet().stream()
                               .sorted((a, b) -> playCountByGenre.get(b) - playCountByGenre.get(a))
                               .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public ArrayList<L1423Song> getSongsInGenreByPlayCount(String genre) {
        ArrayList<L1423Song> songs = songsByGenre.get(genre);
        Collections.sort(songs, Collections.reverseOrder());
        return songs;
    }
}

public class L1423 {
    public static void solution(String[] genres, int[] plays) {
        L1423Billboard chart = new L1423Billboard();
        for (int i = 0; i < genres.length; i++)
            chart.addSong(new L1423Song(i, plays[i], genres[i]));

        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (String genre : chart.getGenresByPlayCount()) {
            ArrayList<L1423Song> songs = chart.getSongsInGenreByPlayCount(genre);
            for (int i = 0; i < Math.min(2, songs.size()); i++)
                ans.add(songs.get(i).getId());
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        // Test code
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        solution(genres, plays);

    }
}
