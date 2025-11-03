package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Map;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Context context;
    private List<String> singers;
    private Map<String, List<String>> singerSongsMap;

    public MyAdapter(Context context, List<String> singers, Map<String, List<String>> singerSongsMap) {
        this.context = context;
        this.singers = singers;
        this.singerSongsMap = singerSongsMap;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_artist, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        String singer = singers.get(position);
        holder.tvSingerName.setText(singer);

        // Lấy danh sách bài hát của ca sĩ
        List<String> songs = singerSongsMap.get(singer);

        // Cài đặt RecyclerView ngang ngay trong adapter
        holder.rvSongs.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.rvSongs.setAdapter(new RecyclerView.Adapter<RecyclerView.ViewHolder>() {

            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(context).inflate(R.layout.item_song_cell, parent, false);
                return new RecyclerView.ViewHolder(view) {};
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder vh, int pos) {
                TextView tvSong = vh.itemView.findViewById(R.id.tv_song_name);
                tvSong.setText(songs.get(pos));
                tvSong.setOnClickListener(v ->
                        Toast.makeText(context, "Bạn chọn bài: " + songs.get(pos), Toast.LENGTH_SHORT).show()
                );
            }

            @Override
            public int getItemCount() {
                return songs.size();
            }
        });
    }

    @Override
    public int getItemCount() {
        return singers.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvSingerName;
        RecyclerView rvSongs;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSingerName = itemView.findViewById(R.id.tv_singer_name);
            rvSongs = itemView.findViewById(R.id.rv_songs);
        }
    }
}
