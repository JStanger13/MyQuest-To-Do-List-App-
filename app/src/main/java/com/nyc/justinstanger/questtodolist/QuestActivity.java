package com.nyc.justinstanger.questtodolist;

import java.util.ArrayList;
import java.util.List;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.content.DialogInterface;


//create new object for that info, send to the bucket, notify the adapter.


public class QuestActivity extends AppCompatActivity {
    ImageButton mImageButton;
    Button mAddButton;
    //final Context context = this;
    RecyclerView mRecyclerView;
    QuestRecyclerViewAdapter mQuestAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest);

        //final ImageButton mImageButton = (ImageButton) findViewById(R.id.goToObjectives);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mQuestAdapter = new QuestRecyclerViewAdapter(QuestBucket.getInstance().getQuests());
        mRecyclerView.setAdapter(mQuestAdapter);

        mAddButton = (Button) findViewById(R.id.addQuest);

        mAddButton.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(final View v){
            AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
            LayoutInflater inflater = QuestActivity.this.getLayoutInflater();
            View createQuest = inflater.inflate(R.layout.create_quest, null);
            builder.setView(createQuest);

            final EditText mQuestTitle = (EditText)
                    createQuest.findViewById(R.id.questTitle);
            final EditText mQuestDescription = (EditText)
                    createQuest.findViewById(R.id.questDescription);


            builder.setPositiveButton("Create", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int id) {
                    String userQuestTitle = mQuestTitle.getText().toString();
                    String userQuestDescription = mQuestDescription.getText().toString();
                    Quest userQuest = new Quest(userQuestTitle, userQuestDescription);
                    QuestBucket.getInstance().addQuest(userQuest);

                    mQuestAdapter.notifyItemInserted(0);
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    });
    }
        public void startObjectives() {
        Intent intent = new Intent(QuestActivity.this, ObjectiveActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        startActivity(intent);
    }
}





