import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Song {
    private String title;
    private String artist;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;1
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public String toString() {
        return title + " by " + artist;
    }
}

class MusicPlayer {
    private List<Song> playlist;
    private boolean isPlaying;
    private int currentSongIndex;

    public MusicPlayer() {
        this.playlist = new ArrayList<>();
        this.isPlaying = false;
        this.currentSongIndex = 0;
    }

    public void addSong(Song song) {
        playlist.add(song);
    }

    public void play() {
        if (!playlist.isEmpty()) {
            isPlaying = true;
            System.out.println("Now playing: " + playlist.get(currentSongIndex));
        } else {
            System.out.println("Playlist is empty. Add songs before playing.");
        }
    }

    public void pause() {
        isPlaying = false;
        System.out.println("Paused.");
    }

    public void next() {
        if (!playlist.isEmpty()) {
            currentSongIndex = (currentSongIndex + 1) % playlist.size();
            if (isPlaying) {
                System.out.println("Now playing: " + playlist.get(currentSongIndex));
            } else {
                System.out.println("Next song: " + playlist.get(currentSongIndex));
            }
        } else {
            System.out.println("Playlist is empty. Add songs before skipping.");
        }
    }

    public void showPlaylist() {
        if (!playlist.isEmpty()) {
            System.out.println("Playlist:");
            for (Song song : playlist) {
                System.out.println("- " + song);
            }
        } else {
            System.out.println("Playlist is empty.");
        }
    }

    public boolean isPlaying() {
        return isPlaying;
    }
}

public class MusicStreamingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MusicPlayer musicPlayer = new MusicPlayer();

        // Adding some sample songs
        musicPlayer.addSong(new Song("Song 1", "Artist 1"));
        musicPlayer.addSong(new Song("Song 2", "Artist 2"));
        musicPlayer.addSong(new Song("Song 3", "Artist 3"));

        while (true) {
            System.out.println("\nMusic Streaming Application");
            System.out.println("1. Play");
            System.out.println("2. Pause");
            System.out.println("3. Next");
            System.out.println("4. Show Playlist");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    musicPlayer.play();
                    break;
                case 2:
                    musicPlayer.pause();
                    break;
                case 3:
                    musicPlayer.next();
                    break;
                case 4:
                    musicPlayer.showPlaylist();
                    break;
                case 5:
                    System.out.println("Exiting the application.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
