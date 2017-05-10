package com.nyc.justinstanger.questtodolist;

import android.support.annotation.NonNull;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by justinstanger on 3/23/17.
 */

public class QuestBucket {


    private static QuestBucket sInstance;
    private List<Quest> mQuestList;


    private QuestBucket() {
        mQuestList = new ArrayList<>();
    }
    public static QuestBucket getInstance(){
        if(sInstance == null){
            sInstance = new QuestBucket();
        }

        return sInstance;
    }

    public void addQuest(Quest quest) {
        mQuestList.add(0, quest);
    }

    public List<Quest> getQuests() {return mQuestList;}
}
