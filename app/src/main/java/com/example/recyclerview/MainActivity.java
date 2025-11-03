package com.example.recyclerview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvSingers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvSingers = findViewById(R.id.recyclerViewGrid);

        // Dữ liệu demo
        List<String> singers = Arrays.asList("Ca sĩ A", "Ca sĩ B", "Ca sĩ C", "Ca sĩ D", "Ca sĩ E", "Ca sĩ F", "Ca sĩ G");

        Map<String, List<String>> singerSongsMap = new HashMap<>();
        singerSongsMap.put("Ca sĩ A", Arrays.asList("Bài 1", "Bài 2", "Bài 3"));
        singerSongsMap.put("Ca sĩ B", Arrays.asList("Bài 4", "Bài 5"));
        singerSongsMap.put("Ca sĩ C", Arrays.asList("Bài 6", "Bài 7", "Bài 8", "Bài 9"));
        singerSongsMap.put("Ca sĩ D", Arrays.asList("Bài 10", "Bài 11", "Bài 12", "Bài 13"));
        singerSongsMap.put("Ca sĩ E", Arrays.asList("Bài 14", "Bài 15", "Bài 16", "Bài 17"));
        singerSongsMap.put("Ca sĩ F", Arrays.asList("Bài 18", "Bài 19", "Bài 8", "Bài 9"));
        singerSongsMap.put("Ca sĩ G", Arrays.asList("Bài 6", "Bài 7", "Bài 8", "Bài 9"));

        MyAdapter adapter = new MyAdapter(this, singers, singerSongsMap);
        rvSingers.setLayoutManager(new LinearLayoutManager(this));
        rvSingers.setAdapter(adapter);
    }
}
