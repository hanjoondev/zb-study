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

/* programmers submission
    // Source: 베스트앨범 https://programmers.co.kr/learn/courses/30/lessons/42579?language=java
    // Submission detail:
    //     테스트 1 〉 통과 (4.76ms, 76.4MB)
    //     테스트 2 〉 통과 (6.73ms, 76MB)
    //     테스트 3 〉 통과 (7.15ms, 89.7MB)
    //     테스트 4 〉 통과 (6.96ms, 74.1MB)
    //     테스트 5 〉 통과 (4.74ms, 70.5MB)
    //     테스트 6 〉 통과 (4.64ms, 75.5MB)
    //     테스트 7 〉 통과 (4.49ms, 74MB)
    //     테스트 8 〉 통과 (4.64ms, 81.4MB)
    //     테스트 9 〉 통과 (5.67ms, 72.9MB)
    //     테스트 10 〉통과 (5.97ms, 73.1MB)
    //     테스트 11 〉통과 (5.03ms, 75.3MB)
    //     테스트 12 〉통과 (4.78ms, 67.4MB)
    //     테스트 13 〉통과 (4.74ms, 81.6MB)
    //     테스트 14 〉통과 (4.70ms, 73.2MB)
    //     테스트 15 〉통과 (4.50ms, 70MB)
import java.util.ArrayList;
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

class Solution {
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
}
*/
