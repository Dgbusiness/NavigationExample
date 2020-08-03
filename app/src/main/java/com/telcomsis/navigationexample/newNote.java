package com.telcomsis.navigationexample;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.telcomsis.navigationexample.databinding.NewNoteBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link newNote#newInstance} factory method to
 * create an instance of this fragment.
 */
public class newNote extends Fragment {
    private static final String TAG = "newNote";
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private AppViewModel viewModel;
    private NewNoteBinding binding;

    public newNote() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment newNote.
     */
    // TODO: Rename and change types and number of parameters
    public static newNote newInstance(String param1, String param2) {
        newNote fragment = new newNote();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.new_note, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = NewNoteBinding.bind(view);
        viewModel = new ViewModelProvider(requireActivity()).get(AppViewModel.class);
        binding.boton.setOnClickListener(view1 -> viewModel.setValor(binding.input.getText().toString()));
        viewModel.getLiveDataObject().observe(getViewLifecycleOwner(), valor -> {
            Toast.makeText(requireContext(), "el valor es: "+valor, Toast.LENGTH_SHORT).show();
        });
    }
}