package com.example.electronic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    TextView titlepage,subtitlepage,endpage;
    ImageButton btnAddNew;
    ImageButton btnSetting;

    DatabaseReference reference;
    RecyclerView ourdoes;
    ArrayList<ToDo> list;
    DoesAdapter doesAdapter;

    public static final String LIST_KEY = "list";
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//      loadLocale();
        setContentView(R.layout.activity_main);

        titlepage = findViewById(R.id.titlepage);
        subtitlepage = findViewById(R.id.subtitlepage);
        endpage = findViewById(R.id.endpage);

        btnAddNew = findViewById(R.id.btnAddNew);
        btnAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,NewTaskAct.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        ourdoes = findViewById(R.id.ourdoes);
        ourdoes.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<ToDo>();

        reference = FirebaseDatabase.getInstance().getReference().child("ToDoApp");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                {
                    ToDo p = dataSnapshot1.getValue(ToDo.class);
                    list.add(p);
                }
                doesAdapter = new DoesAdapter(MainActivity.this,list);
                doesAdapter.notifyDataSetChanged();
                ourdoes.setAdapter(doesAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),"No Data",Toast.LENGTH_SHORT).show();
            }
        });

        btnSetting = findViewById(R.id.btnSetting);
        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SettingAct.class);
                startActivity(intent);
//                showLanguageDialog();
            }
        });

    }
}
