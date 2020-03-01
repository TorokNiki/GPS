package com.example.gps;

import android.os.Environment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Naplozas {
public static void kiiras(float hosszusag,float szelesseg)throws IOException{
    String allapot;
    File file;
    String szovegesAdat;
    Date date= Calendar.getInstance().getTime();

    SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
    String formatedDate= dateFormat.format(date);
    szovegesAdat = String.valueOf(hosszusag)+","+String.valueOf(szelesseg)+","+formatedDate+","+"\r\n";

    allapot= Environment.getExternalStorageState();
    if ( allapot.equals(Environment.MEDIA_MOUNTED)){
        file= new File(Environment.getExternalStorageState(),"gps_track.csv");
        try {
            BufferedWriter bw= new BufferedWriter(new FileWriter(file),1024);
            bw.append(szovegesAdat);
            bw.close();
        }catch (IOException e){

        }
    }
}
}
