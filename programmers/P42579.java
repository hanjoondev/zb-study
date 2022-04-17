package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

class Song implements Comparable<Song> {
    private int id;
    private int playCount;
    private String genre;

    public Song(int id, int playCount, String genre) {
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

    public int compareTo(Song s) {
        return this.playCount - s.getPlayCount();
    }
}

class Chart {
    private HashMap<String, ArrayList<Song>> songsByGenre;
    private HashMap<String, Integer> playCountByGenre;

    public Chart() {
        songsByGenre = new HashMap<>();
        playCountByGenre = new HashMap<>();
    }

    public void addSong(Song song) {
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

    public ArrayList<Song> getSongsInGenreByPlayCount(String genre) {
        ArrayList<Song> songs = songsByGenre.get(genre);
        Collections.sort(songs, Collections.reverseOrder());
        return songs;
    }
}

public class P42579 {
    public int[] solution(String[] genres, int[] plays) {
        Chart chart = new Chart();
        for (int i = 0; i < genres.length; i++)
            chart.addSong(new Song(i, plays[i], genres[i]));

        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (String genre : chart.getGenresByPlayCount()) {
            ArrayList<Song> songs = chart.getSongsInGenreByPlayCount(genre);
            for (int i = 0; i < Math.min(2, songs.size()); i++)
                ans.add(songs.get(i).getId());
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new P42579().solution(new String[] {"classic", "pop", "classic", "classic", "pop"}, new int[] {500, 600, 150, 800, 2500})));
    }
}
