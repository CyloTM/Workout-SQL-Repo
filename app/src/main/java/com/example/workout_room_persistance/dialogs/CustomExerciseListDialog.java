package com.example.workout_room_persistance.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.workout_room_persistance.ExerciseListActivity;
import com.example.workout_room_persistance.R;

public class CustomExerciseListDialog extends Dialog implements View.OnClickListener{


    public CustomExerciseListDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    public CustomExerciseListDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }


    public Activity activity;
    public Dialog dialog;
    public Button yes, no;
    public TextView title;
    public RecyclerView recyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter adapter;



    public CustomExerciseListDialog(Activity a, RecyclerView.Adapter adapter) {
        super(a);
        this.activity = a;
        this.adapter = adapter;
        setupLayout();
    }

    private void setupLayout() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_exercise_list);
//        title = findViewById(R.id.title);
        recyclerView = findViewById(R.id.recycler_view);
//        mLayoutManager = new LinearLayoutManager(getApplicationContext());
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()))c;


        recyclerView.setAdapter(adapter);
//        yes.setOnClickListener(this);
//        no.setOnClickListener(this);

    }
    public Context LinearLayoutManager(){
        Context context = activity;
        return context;
    }



    @Override
    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.yes:
//                //Do Something
//                break;
//            case R.id.no:
//                dismiss();
//                break;
//            default:
//                break;
//        }
//        dismiss();
    }}
