package com.example.workout_room_persistance.model;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.ArrayList;
import java.util.List;

public class WorkoutWithExercises {
    @Embedded public Workout workout;
    @Relation(
            parentColumn = "id",
            entityColumn = "workoutId",
            entity = Exercise.class
    )
    public List<Exercise> exercises;

    public Workout getWorkout() {
        return workout;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }
}
