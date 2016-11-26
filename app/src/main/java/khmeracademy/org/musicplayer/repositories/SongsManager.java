package khmeracademy.org.musicplayer.repositories;

import android.os.Environment;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Chhai Chivon on 11/14/16.
 */

public class SongsManager {
    /*
    *GET DATA FROM SDCard
    */
    private ArrayList<HashMap<String,String>> songList = new ArrayList<>();

    public ArrayList<HashMap<String,String>> getSongPlayList(){
        //TODO get path from storage
        File file   = Environment.getExternalStorageDirectory();
        if (file.list(new FileExtensionFilter()).length > 0)
        {
            for (File myFile : file.listFiles(new FileExtensionFilter())){
                HashMap<String,String> song = new HashMap<>();
                song.put("songTitle",file.getName().substring(0,(file.getName().length() -4 )));
                song.put("songPath" ,file.getPath());
                //TODO add all song to songList
                songList.add(song);
            }
        }
        return songList;
    }

    public class FileExtensionFilter implements FilenameFilter {
        public boolean accept(File dir,String name){
            return (name.endsWith(".mp3") || name.endsWith(".MP3"));
        }
    }
}
