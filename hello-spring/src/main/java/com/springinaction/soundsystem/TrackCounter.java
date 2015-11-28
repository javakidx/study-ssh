package com.springinaction.soundsystem;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bioyang on 2015/11/28.
 */
@Aspect
public class TrackCounter
{
    private Map<Integer, Integer> trackCounters = new HashMap<Integer, Integer>();

    @Pointcut("execution(* com.springinaction.soundsystem.CompactDisc.playTrack(int))" +
                "&& args(trackNumber)")
    public void trackPlayed(int trackNumber){}

    @Before("trackPlayed(trackNumber)")
    public void countTrack(int trackNumber)
    {
        int currentCount = getPlayCount(trackNumber);
        trackCounters.put(trackNumber, currentCount + 1);
    }

    public int getPlayCount(int trackNumber)
    {
        return trackCounters.containsKey(trackNumber) ? trackCounters.get(trackNumber) : 0;
    }
}
