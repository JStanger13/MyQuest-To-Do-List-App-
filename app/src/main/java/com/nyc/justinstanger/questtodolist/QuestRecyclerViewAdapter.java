package com.nyc.justinstanger.questtodolist;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class QuestRecyclerViewAdapter extends RecyclerView.Adapter<QuestViewHolder> {
    List<Quest> mQuestList;

    public QuestRecyclerViewAdapter(final List<Quest> questList){
        mQuestList = questList;
    }

    @Override
    public QuestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View parentView = LayoutInflater.from(parent.getContext()).inflate
                (R.layout.custom_quest_layout, parent, false);
        QuestViewHolder viewHolder = new QuestViewHolder(parentView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final QuestViewHolder holder, final int position) {
       final Quest currentQuest = mQuestList.get(position);

        holder.mQuestTitle.setText(currentQuest.getTitle());
        holder.mQuestDescription.setText(currentQuest.getDescription());
        holder.mDeleteQuest.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Quest removed = mQuestList.get(position);
                mQuestList.remove(position);
                notifyItemRemoved(position);
            }
        });
        holder.mGoToObjectives.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent objectiveScreen = new Intent(v.getContext(), ObjectiveActivity.class);
               objectiveScreen.putExtra("Id", holder.getAdapterPosition());
               v.getContext().startActivity(objectiveScreen);
           }
       });
    }

    @Override
    public int getItemCount() {return mQuestList.size();
    }
}




