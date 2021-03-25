package com.example.workout_room_persistance.model;

import android.os.Parcel;
import android.os.Parcelable;

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

//    protected WorkoutWithExercises(Parcel in) {
//        workout = in.readParcelable(Workout.class.getClassLoader());
//        exercises = in.createTypedArrayList(Exercise.CREATOR);
//    }
//
//    public static final Creator<WorkoutWithExercises> CREATOR = new Creator<WorkoutWithExercises>() {
//        @Override
//        public WorkoutWithExercises createFromParcel(Parcel in) {
//            return new WorkoutWithExercises(in);
//        }
//
//        @Override
//        public WorkoutWithExercises[] newArray(int size) {
//            return new WorkoutWithExercises[size];
//        }
//    };

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

//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeInt(getWorkout().getId());
//        dest.writeString(getWorkout().getTitle());
////        dest.writeTypedList(exercises);
//    }
}
