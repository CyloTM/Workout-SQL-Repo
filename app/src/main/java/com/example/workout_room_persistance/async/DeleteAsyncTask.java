package com.example.workout_room_persistance.async;

import android.os.AsyncTask;
import com.example.workout_room_persistance.model.Workout;
import com.example.workout_room_persistance.persistance.WorkoutDao;

public class DeleteAsyncTask extends AsyncTask<Workout, Void, Void> {

    private WorkoutDao mWorkoutDao;
    public DeleteAsyncTask(WorkoutDao dao) {
        mWorkoutDao = dao;

    }

    @Override
    protected Void doInBackground(Workout... workouts) {
        mWorkoutDao.delete(workouts);
        return null;
    }
}
