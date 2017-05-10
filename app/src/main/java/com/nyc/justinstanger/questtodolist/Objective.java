package com.nyc.justinstanger.questtodolist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


import org.w3c.dom.Text;

import java.util.List;

import static android.R.attr.description;


public class Objective {

    String mObjTitle;
    String mObjDescription;
    boolean mObjCheck;

        public Objective(String title, String description) {
            mObjTitle = title;
            mObjDescription = description;
            mObjCheck = false;
        }

    public void setTitle(String title) {
        mObjTitle = title;
    }

    public String getTitle() {
        if (mObjTitle == null) return null;
        else return mObjTitle;
    }

        public void setDescription(String description) {
            mObjDescription = description;
    }

    public String getDescription() {
        return mObjDescription;
    }

    public void setCheck() {
        mObjCheck = !mObjCheck;
    }

    public boolean isChecked() {
        return mObjCheck;

    }
}
