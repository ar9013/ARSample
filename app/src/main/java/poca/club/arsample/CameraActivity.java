package poca.club.arsample;

import android.Manifest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.vistrav.ask.Ask;
import com.vistrav.ask.annotations.AskDenied;
import com.vistrav.ask.annotations.AskGranted;

public class CameraActivity extends AppCompatActivity {

    private static final String TAG ="CameraActivity";
    private static final int CAMERA =5;
    private static final int WRITE_EXTERNAL_STORAGE =3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        // 檢查相機權限
        Ask.on(CameraActivity.this).id(CAMERA).forPermissions(Manifest.permission.CAMERA).go();
        Ask.on(CameraActivity.this).id(WRITE_EXTERNAL_STORAGE).forPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE).go();


    }

    @AskDenied(Manifest.permission.CAMERA)
    public void Cameras_Denied(int id){
        Log.d(TAG,"CAMERA DENiED");
    }

    @AskGranted(Manifest.permission.CAMERA)
    public void Cameras_Granted(int id){
        Log.d(TAG,"CAMERA GRANTED");
    }

    @AskDenied(Manifest.permission.CAMERA)
    public void WRITE_EXTERNAL_STORAGE_Denied(int id){
        Log.d(TAG,"CAMERA DENiED");
    }

    @AskGranted(Manifest.permission.CAMERA)
    public void WRITE_EXTERNAL_STORAGE_Granted(int id){
        Log.d(TAG,"CAMERA GRANTED");
    }

}
