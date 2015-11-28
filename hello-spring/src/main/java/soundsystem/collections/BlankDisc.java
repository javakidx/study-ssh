package soundsystem.collections;

import soundsystem.CompactDisc;

import java.util.List;

/**
 * Created by bioyang on 2015/11/20.
 */
public class BlankDisc implements CompactDisc
{
    private String title;
    private String artist;

    private List<String> tracks;

    public BlankDisc(String title, String artist, List<String> tracks)
    {
        this.title = title;
        this.artist = artist;
        this.tracks = tracks;
    }

    public void play()
    {
        System.out.printf("Playing %s by %s%n", title, artist);

        for (String track : tracks)
        {
            System.out.println("-Track: " + track);
        }
    }
}
