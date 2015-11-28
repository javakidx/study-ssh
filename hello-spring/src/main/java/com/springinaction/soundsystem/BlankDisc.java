package com.springinaction.soundsystem;

import java.util.List;

/**
 * Created by bioyang on 2015/11/20.
 */
public class BlankDisc implements CompactDisc
{
    private String title;
    private String artist;

    private List<String> tracks;

    public BlankDisc()
    {

    }
    public BlankDisc(String title, String artist)
    {
        this.title = title;
        this.artist = artist;
    }

    public void play()
    {
        System.out.printf("Playing %s by %s", title, artist);
    }

    public void playTrack(int trackNumber)
    {

    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getArtist()
    {
        return artist;
    }

    public void setArtist(String artist)
    {
        this.artist = artist;
    }

    public void setTracks(List<String> tracks)
    {
        this.tracks = tracks;
    }
}
