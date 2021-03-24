package com.example.workout_room_persistance.persistance;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.workout_room_persistance.async.DeleteAsyncTask;
import com.example.workout_room_persistance.async.ExerciseDeleteAsyncTask;
import com.example.workout_room_persistance.async.ExerciseInsertAsyncTask;
import com.example.workout_room_persistance.async.ExerciseUpdateAsyncTask;
import com.example.workout_room_persistance.async.InsertAsyncTask;
import com.example.workout_room_persistance.async.UpdateAsyncTask;
import com.example.workout_room_persistance.model.Exercise;
import com.example.workout_room_persistance.model.Workout;
//import com.example.workout_room_persistance.model.WorkoutWithExercises;

import java.util.List;

public class WorkoutWithExerciseRepository {

    private com.example.workout_room_persistance.persistance.WorkoutDatabase mWorkoutDatabase;
    private ExerciseDatabase mExerciseDatabase;

    public WorkoutWithExerciseRepository(Context context) {
        mWorkoutDatabase = WorkoutDatabase.getInstance(context);
        mExerciseDatabase = ExerciseDatabase.getInstance(context);
    }

    public void insertWorkoutTask(Workout workout){
        new InsertAsyncTask(mWorkoutDatabase.getWorkoutDao()).execute(workout);

    }

    public void updateWorkout(Workout workout){
        new UpdateAsyncTask(mWorkoutDatabase.getWorkoutDao()).execute(workout);

    }

//    public List<WorkoutWithExercises> retrieveWorkoutWithExercisesTask(){
//        return mWorkoutDatabase.getWorkoutExerciseDao().getWorkoutWithExercises();
//    }

    public void deleteWorkout(Workout workout){
        new DeleteAsyncTask(mWorkoutDatabase.getWorkoutDao()).execute(workout);

    }

    public void insertExerciseTask(Exercise exercise){
        new ExerciseInsertAsyncTask(mExerciseDatabase.getExerciseDao()).execute(exercise);

    }

    public void updateExercise(Exercise exercise){
        new ExerciseUpdateAsyncTask(mExerciseDatabase.getExerciseDao()).execute(exercise);

    }

    public LiveData<List<Exercise>> retrieveExerciseTask(){
        return mExerciseDatabase.getExerciseDao().getAllData();
    }

    public void deleteExercise(Exercise exercise){
        new ExerciseDeleteAsyncTask(mExerciseDatabase.getExerciseDao()).execute(exercise);

    }

    public void deleteAll(){
        mExerciseDatabase.getExerciseDao().delete();
    }
}
