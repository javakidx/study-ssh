package soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by bioyang on 2015/11/19.
 */
//@Component
public class CDPlayer implements MediaPlayer
{
    private CompactDisc cd;

    @Autowired
    public CDPlayer(CompactDisc cd)
    {
        this.cd = cd;
    }

    public void play()
    {
        cd.play();
    }
}
