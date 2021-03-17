package com.example.workout_room_persistance.model;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.ArrayList;

public class WorkoutWithExercises {
    @Embedded
    public Workout workout;
    @Relation(
            parentColumn = "workouts",
            entityColumn = "exercises"
    )
    public ArrayList<Exercise> mExercises;
}
