package khmeracademy.org.musicplayer.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.List;

import khmeracademy.org.musicplayer.ClassPlayMusic;
import khmeracademy.org.musicplayer.R;
import khmeracademy.org.musicplayer.models.Song;
import khmeracademy.org.musicplayer.repositories.ScannerMusic;
import khmeracademy.org.musicplayer.services.AdapterListener;
import khmeracademy.org.musicplayer.services.RecyclerViewMusicAdapter;

/**
 * Created by Chhai Chivon on 11/20/16.
 */

public class SongListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    ClassPlayMusic classPlayMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);

        mRecyclerView = (RecyclerView)findViewById(R.id.textRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(layoutManager);

        final List<Song> songInfo = ScannerMusic.scanSdCard(getApplicationContext());
        Log.d("MUSIC","SCAN FILE" + songInfo.size());
        final RecyclerViewMusicAdapter recyclerViewMusicAdapter = new RecyclerViewMusicAdapter(songInfo);
        mRecyclerView.setAdapter(recyclerViewMusicAdapter);
        recyclerViewMusicAdapter.setAdapterListener(new AdapterListener() {
            @Override
            public void onItemClick(int adapterPosition) {
                Log.d("ActivionViewList","ClickItem"+adapterPosition);
                Song song = songInfo.get(adapterPosition);
                Intent intent = new Intent(getApplicationContext(),SongPlayerActivity.class).putExtra("pos",adapterPosition);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
