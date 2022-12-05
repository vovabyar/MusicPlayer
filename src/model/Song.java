package model;

import java.io.File;

/**
 * @author vovabyar
 */
public class Song {
    private File underlyingFile;

    public Song(String path) {
        underlyingFile = new File(path);
    }

    public Song(File f) {
        underlyingFile = f;
    }

    public File getUnderlyingFile() {
        return underlyingFile;
    }

    @Override
    public String toString() {
        return "Song: " + underlyingFile;
    }
}
