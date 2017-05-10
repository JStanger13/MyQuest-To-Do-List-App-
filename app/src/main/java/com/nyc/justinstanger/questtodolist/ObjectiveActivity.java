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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.content.DialogInterface;

public class ObjectiveActivity extends AppCompatActivity {
    RecyclerView mObjRecyclerView;
    final Context objContext = this;
    Button mAddObj;
    ImageButton mDeleteObj;

    ObjectiveAdapter mObjectiveAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objective);

        Intent intent = getIntent();
        int position = intent.getIntExtra("Id", -1);

        int objectiveListSize =
                QuestBucket.getInstance().getQuests().get(position).getObjectiveList().size();

        if (objectiveListSize < 0) {
            Toast.makeText(this, "Nothing was found", Toast.LENGTH_SHORT).show();
            finish();
        }


        final Quest userQuest = QuestBucket.getInstance().getQuests().get(position);

        mObjRecyclerView = (RecyclerView) findViewById(R.id.objrecyclerview);

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mObjRecyclerView.setLayoutManager(linearLayoutManager);

        mObjectiveAdapter = new ObjectiveAdapter(userQuest.getObjectiveList());
        mObjRecyclerView.setAdapter(mObjectiveAdapter);

        mObjRecyclerView.setAdapter(new ObjectiveAdapter(userQuest.getObjectiveList()));

        mAddObj = (Button) findViewById(R.id.addObj);

        mAddObj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(v.getContext());

                LayoutInflater inflater = ObjectiveActivity.this.getLayoutInflater();
                View createObjective = inflater.inflate(R.layout.create_objective, null);
                alert.setView(createObjective);

                final EditText mObjectiveTitle = (EditText)
                        createObjective.findViewById(R.id.objectiveTitle);
                final EditText mObjectiveDescription = (EditText)
                        createObjective.findViewById(R.id.objectiveDescription);

                alert.setPositiveButton("Create", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String userObjectiveTitle =
                                mObjectiveTitle.getText().toString();
                        String userObjectiveDescription =
                                mObjectiveDescription.getText().toString();

                        Objective userObjective =
                                new Objective(userObjectiveTitle, userObjectiveDescription);
                        userQuest.getObjectiveList().add(userObjective);
                    }
                });

                AlertDialog dialog = alert.create();
                dialog.show();
            }
        });
    }
}