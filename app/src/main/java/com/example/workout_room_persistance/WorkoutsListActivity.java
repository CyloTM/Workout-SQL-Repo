package com.example.workout_room_persistance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.workout_room_persistance.adapter.WorkoutsRecyclerAdapter;
import com.example.workout_room_persistance.model.Workout;
import com.example.workout_room_persistance.util.VerticalSpacingItemDecorator;

import java.util.ArrayList;

public class WorkoutsListActivity extends AppCompatActivity implements
        WorkoutsRecyclerAdapter.OnWorkoutListener,
        View.OnClickListener
{

    public final static String TAG = "WorkoutsListActivity";

    // Ui components
    private RecyclerView mRecyclerView;


    // Variables
    private ArrayList<Workout> mWorkouts = new ArrayList();
    private WorkoutsRecyclerAdapter mWorkoutsRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_list);

        mRecyclerView = findViewById(R.id.recycler_view);
        initRecyclerView();
        insertFakeWorkouts();

        setSupportActionBar(findViewById(R.id.workout_list_toolbar));
        setTitle("Workouts");

    }
    private void initRecyclerView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        VerticalSpacingItemDecorator itemDecorator = new VerticalSpacingItemDecorator(10);
        mRecyclerView.addItemDecoration(itemDecorator);
        new ItemTouchHelper(itemTouchHelperCallBack).attachToRecyclerView(mRecyclerView);
        mWorkoutsRecyclerAdapter = new WorkoutsRecyclerAdapter(mWorkouts, this);
        mRecyclerView.setAdapter(mWorkoutsRecyclerAdapter);

    }

    public void insertFakeWorkouts(){
        for(int i = 0;i<1000; i++){

            Workout noteFake = new Workout();
            noteFake.setTitle("Workout #"+ i);
            mWorkouts.add(noteFake);
        }
        mWorkoutsRecyclerAdapter.notifyDataSetChanged();
    }

    private void deleteWorkout(Workout workout){
        mWorkouts.remove(workout);
        mWorkoutsRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onWorkoutClicked(int position) {
        Log.d(TAG, "Note " + position + " has been clicked");
        Intent intent = new Intent(this, ExerciseListActivity.class);
        intent.putExtra("selected_workout", mWorkouts.get(position));
        startActivity(intent);

    }

    private ItemTouchHelper.SimpleCallback itemTouchHelperCallBack = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT){

        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            deleteWorkout(mWorkouts.get(viewHolder.getAdapterPosition()));
        }
    };
}