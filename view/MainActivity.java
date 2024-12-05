package com.example.notesdm.view;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.notesdm.adapter.NotesAdapter;
import com.example.notesdm.databinding.ActivityMainBinding;
import com.example.notesdm.viewmodel.NotesViewModel;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private NotesViewModel notesViewModel;
    private NotesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        notesViewModel = new ViewModelProvider(this).get(NotesViewModel.class);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        notesViewModel.getObservedNotes();
        binding.setNotesViewModel(notesViewModel);

        adapter = new NotesAdapter(notesViewModel);

        binding.listView.setAdapter(adapter);

        notesViewModel.getObservedNotes().observe(this, l -> {

            adapter.notifyDataSetChanged();

        });
    }
}