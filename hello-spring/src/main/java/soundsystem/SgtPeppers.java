package soundsystem;

import org.springframework.stereotype.Component;

/**
 * Created by bioyang on 2015/11/19.
 */
@Component("lonelyHeartClub")
public class SgtPeppers implements CompactDisc
{
    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";

    public void play()
    {
        System.out.printf("Playing %s by %s", title, artist);
    }
}
