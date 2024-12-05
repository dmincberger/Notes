package com.example.notesdm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.notesdm.R;
import com.example.notesdm.model.Note;
import com.example.notesdm.view.MainActivity;
import com.example.notesdm.viewmodel.NotesViewModel;

import java.util.ArrayList;
import java.util.List;

public class NotesAdapter extends ArrayAdapter {

    private ArrayList<Note> _list;
    private Context _context;
    private int _resource;

    public NotesAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Note> objects) {
        super(context, resource, objects);
        this._list = objects;
        this._context = context;
        this._resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(_resource, null);

    }
}
