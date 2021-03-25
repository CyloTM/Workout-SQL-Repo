package com.example.workout_room_persistance.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "workouts")
public class Workout implements Parcelable {

    //Fields
    //Primary Key
    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    @ColumnInfo(name = "title")
    private String title;

//    @ColumnInfo(name = "exercises")
//    private ArrayList<Exercise> exercises;


    public Workout(String title) {
        this.title = title;
//        this.exercises = exercises;
    }

    @Ignore
    public Workout(String title, List<Exercise> exercises) {
        super();
        this.title = title;
        this.exercises = exercises;
    }

    @Ignore
    public Workout() {

    }

    @Ignore
    private List<Exercise> exercises = null;

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    protected Workout(Parcel in) {
        id = in.readInt();
        title = in.readString();
        exercises = (List<Exercise>) in.readValue(Exercise.class.getClassLoader());
    }

    public static final Creator<Workout> CREATOR = new Creator<Workout>() {
        @Override
        public Workout createFromParcel(Parcel in) {
            return new Workout(in);
        }

        @Override
        public Workout[] newArray(int size) {
            return new Workout[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public ArrayList<Exercise> getExercises() {
//        return exercises;
//    }

//    public void setExercises(ArrayList<Exercise> exercises) {
//        this.exercises = exercises;
//    }

    @Override
    public String toString() {
        return "Note{" +
                "id =" + id +
                "title='" + title + '\'' +
                ", exercises='" + exercises + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeValue(exercises);
    }

    public Workout(WorkoutWithExercises workoutWithExercises) {
        this.id = workoutWithExercises.getWorkout().getId();
        this.title = workoutWithExercises.getWorkout().getTitle();
        this.exercises = workoutWithExercises.getWorkout().getExercises();
    }


}

