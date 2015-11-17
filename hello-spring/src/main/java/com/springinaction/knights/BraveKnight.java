package com.springinaction.knights;

/**
 * Created by bioyang on 2015/11/18.
 */
public class BraveKnight implements Knight
{
    private Quest mQuest;

    public BraveKnight(Quest quest)
    {
        this.mQuest = quest;
    }

    @Override
    public void embarkOnQuest() throws QuestException
    {
        mQuest.embark();
    }
}
