package com.example.notesdm.database;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.notesdm.model.Note;

@androidx.room.Database(entities = {Note.class}, version = 2)
public abstract class NoteDatabase extends RoomDatabase {

    private static NoteDatabase roomDatabase;
    private static final String DATABASE_NAME = "notesDB";

    public static synchronized NoteDatabase getInstance(Context context){
        if(roomDatabase==null){
            roomDatabase
                    = Room.databaseBuilder(
                            context.getApplicationContext(), NoteDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return roomDatabase;
    }

    public abstract NoteDAO noteDAO();

}
