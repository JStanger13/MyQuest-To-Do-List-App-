package com.nyc.justinstanger.questtodolist;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import static android.R.id.list;
import static android.content.ContentValues.TAG;

public class ObjectiveAdapter extends RecyclerView.Adapter<ObjectiveViewHolder> {
    List<Objective> mObjList;

    public ObjectiveAdapter(final List<Objective> objList) {
        mObjList = objList;
    }

    @Override
    public ObjectiveViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View parentView = LayoutInflater.from(parent.getContext()).inflate
                (R.layout.custom_objective, parent, false);
        ObjectiveViewHolder viewHolder = new ObjectiveViewHolder(parentView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ObjectiveViewHolder holder, final int position) {

        final Objective currentObjective = mObjList.get(position);

        holder.mObjQuestTitle.setText(currentObjective.getTitle());
        holder.mObjQuestDescription.setText(currentObjective.getDescription());

        Log.d(TAG, "title: " + currentObjective.getTitle());
        Log.d(TAG, "description: " + currentObjective.getDescription());

        holder.mDeleteObj.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Objective removed = mObjList.get(position);
                // remove your item from data base
                mObjList.remove(position);  // remove the item from list
                notifyItemRemoved(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mObjList.size();
    }
}



