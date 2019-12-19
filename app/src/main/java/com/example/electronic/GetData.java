package com.example.electronic;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.style.TtsSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

/**
 * A simple {@link Fragment} subclass.
 */
public class GetData extends Fragment {
    View myFragment;
    // [START define_database_reference]
    private DatabaseReference mDatabase;
    // [END define_database_reference]

    private FirebaseRecyclerAdapter<electronic, elecViewHolder> mAdapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private LinearLayoutManager linearLayoutManager;


    public GetData() {
        // Required empty public constructor
    }
    public static GetData newInstances()
    {
        GetData GetData = new GetData();
        return GetData;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        myFragment = inflater.inflate(R.layout.activity_main, container, false);


        mDatabase = FirebaseDatabase.getInstance().getReference().child("electronic");

        recyclerView = myFragment.findViewById(R.id.list_electronic);
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(container.getContext(), 1);
        recyclerView.setLayoutManager(layoutManager);

        Query query = mDatabase;

        FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<>()
                .setQuery(query, MainActivity.class)
                .build();

        mAdapter = new FirebaseRecyclerAdapter<MainActivity, elecViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull elecViewHolder makananViewHolder, int i, @NonNull final TtsSpan.ElectronicBuilder makanan) {
                makananViewHolder.();
                Glide.with(GetData.this).load(makanan.getGambar()).into(makananViewHolder.ivGambar);


                makananViewHolder.cv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Bundle extras = new Bundle();

                        Intent intent = new Intent(view.getContext(), MainActivity.class);

                        extras.putString("" ());
                        extras.putInt(""());
                        extras.putString(""());

                        intent.putExtras(extras);

                        startActivity(intent);
                    }
                });

            }

            @NonNull
            public elecViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
                return new elecViewHolder(inflater.inflate(R.layout.item_menu, parent, false));
            }
        };

        mAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(mAdapter);

        if (mAdapter != null) {
            mAdapter.startListening();
        }

        System.out.println(mAdapter);

        return myFragment;
    }


    @Override
    public void onStop() {
        super.onStop();
        if (mAdapter != null) {
            mAdapter.stopListening();
        }
    }

}
