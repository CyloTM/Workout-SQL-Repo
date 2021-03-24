package com.example.workout_room_persistance.model;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.ArrayList;
import java.util.List;

public class WorkoutWithExercises {
    @Embedded
    public Workout workout;
    @Relation(
            parentColumn = "id",
            entityColumn = "id"
    )
    public List<Exercise> exercises;
}
