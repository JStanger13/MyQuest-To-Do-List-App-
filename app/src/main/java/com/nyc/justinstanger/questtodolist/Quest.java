package com.nyc.justinstanger.questtodolist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by justinstanger on 3/21/17.
 */

public class Quest {
    private List<Objective> mObjectiveList;
    private String mTitle;
    private String mDescription;
    private Boolean mCheck;
    private String mType;

    public Quest(String title, String description) {
        mTitle = title;
        mDescription = description;
        mCheck = false;
        mObjectiveList = new ArrayList<>();
        mType = QuestType.SWORD;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getTitle() {
        if (mTitle == null) return null;
        else return mTitle;
    }


    public void setType(String type){
        mType = type;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setCheck() {
        mCheck = !mCheck;
    }

    public boolean isChecked() {
        return mCheck;
    }
    public List<Objective> getObjectiveList(){
        return mObjectiveList;
    }
}
