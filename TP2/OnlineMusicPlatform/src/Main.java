public class Main {
    public static void main(String[] args) {
        // Create an artist
        Artist artist = new Artist("John Doe");

        // Create an album
        Album album = new Album("Album Title", artist, "2023-01-01");

        // Create a song
        Song song = new Song(180, "Song Title", "Pop", 0, artist, album, "2023-01-01");

        // Add the album to the artist's discography
        artist.addAlbum(album);

        // Add the song to the album
        album.addSong(song);

        // Display the artist's discography
        artist.ListAlbums();

        // Create a free user
        FreeUser freeUser = new FreeUser("FreeUser123","Paragon");

        // Add the song to the free user's playlist
        freeUser.addToPlaylist(song);

        // Listen to the free user's playlist
        freeUser.listen();
    }
}
