package com.nyc.justinstanger.questtodolist;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by justinstanger on 3/23/17.
 */



public class ObjectiveViewHolder extends RecyclerView.ViewHolder {
    public CheckBox mObjCheck;
    public TextView mObjQuestTitle;
    public TextView mObjQuestDescription;

    public ImageButton mDeleteObj;
    public Button mObjAdd;

    public ObjectiveViewHolder(View itemView) {
        super(itemView);

        mObjQuestTitle = (TextView) itemView.findViewById(R.id.objTitle);
        mObjQuestDescription = (TextView) itemView.findViewById(R.id.objDescription);

        mObjCheck = (CheckBox) itemView.findViewById(R.id.objCheck);
        mObjAdd = (Button)itemView.findViewById(R.id.addObj);

        mDeleteObj =(ImageButton) itemView.findViewById(R.id.deleteObjective);
    }



}


