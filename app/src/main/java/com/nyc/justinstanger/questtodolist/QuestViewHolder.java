package com.nyc.justinstanger.questtodolist;

/**
 * Created by justinstanger on 3/22/17.
 */

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by justinstanger on 3/21/17.
 */

public class QuestViewHolder extends RecyclerView.ViewHolder {
    public TextView mQuestTitle;
    public TextView mQuestDescription;

    public Button mAdd;
    public ImageButton mGoToObjectives;
    public ImageButton mDeleteQuest;

    public QuestViewHolder(View itemView) {
        super(itemView);

        mDeleteQuest = (ImageButton) itemView.findViewById(R.id.deleteQuest);
        mQuestTitle = (TextView) itemView.findViewById(R.id.questTitle);
        mQuestDescription = (TextView) itemView.findViewById(R.id.questDescription);
        mAdd = (Button)itemView.findViewById(R.id.add);
        mGoToObjectives = (ImageButton)itemView.findViewById(R.id.goToObjectives);


    }





}

