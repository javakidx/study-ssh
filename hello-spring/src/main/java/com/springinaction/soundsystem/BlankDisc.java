package com.springinaction.soundsystem;

/**
 * Created by bioyang on 2015/11/20.
 */
public class BlankDisc implements CompactDisc
{
    private String title;
    private String artist;

    public BlankDisc(String title, String artist)
    {
        this.title = title;
        this.artist = artist;
    }

    public void play()
    {
        System.out.printf("Playing %s by %s", title, artist);
    }
}
