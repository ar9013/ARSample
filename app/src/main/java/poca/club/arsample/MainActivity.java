package poca.club.arsample;

import android.Manifest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.vistrav.ask.Ask;
import com.vistrav.ask.annotations.AskDenied;
import com.vistrav.ask.annotations.AskGranted;

public class MainActivity extends AppCompatActivity {

    private static final String TAG ="MainActivity";
    private static final int CAMERA =5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 檢查相機權限
        Ask.on(MainActivity.this).id(CAMERA).forPermissions(Manifest.permission.CAMERA).go();



    }

    @AskDenied(Manifest.permission.CAMERA)
    public void CamerasDenied(int id){
        Log.d(TAG,"CAMERA DENiED");
    }

    @AskGranted(Manifest.permission.CAMERA)
    public void CamerasGranted(int id){
        Log.d(TAG,"CAMERA GRANTED");
    }

}
