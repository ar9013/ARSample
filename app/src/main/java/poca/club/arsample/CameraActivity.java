package poca.club.arsample;

import android.Manifest;
import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.vistrav.ask.Ask;
import com.vistrav.ask.annotations.AskDenied;
import com.vistrav.ask.annotations.AskGranted;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.core.Mat;

import java.util.List;

public class CameraActivity extends AppCompatActivity implements CameraBridgeViewBase.CvCameraViewListener2 {

    private static final String TAG = "CameraActivity";
    private static final int CAMERA = 5;
    private static final int WRITE_EXTERNAL_STORAGE = 3;
    private static final String STAGE_CAMERA_INDEX = "CameraIndex";
    private static final String STATE_IMAGE_SIZE_INDEX = "imageSizeIndex";
    private static final int MENU_GROUP_ID_SIZE = 2;
    private int mCameraIndex;
    private int mImageSizeIndex;
    private boolean mIsCameraFrontFacing;
    private int mNumCameras;
    private CameraBridgeViewBase mCameraView;
    private List<Camera.Size> mSupportedImageSizes;
    private boolean mIsPhotoPending;
    private Mat mBgr;
    private boolean mIsMenuLocked;

    private BaseLoaderCallback mLoaderCallback = new BaseLoaderCallback(this) {
        @Override
        public void onManagerConnected(int status) {

            switch (status){
                case LoaderCallbackInterface.SUCCESS:
                    Log.d(TAG,"OpenCV loaded successfully");
                    mCameraView.enableView();
                    mBgr = new Mat();
                    break;

                default:
                    super.onManagerConnected(status);
                    break;
            }


        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 檢查相機權限
        Ask.on(CameraActivity.this).id(CAMERA).forPermissions(Manifest.permission.CAMERA).go();
        Ask.on(CameraActivity.this).id(WRITE_EXTERNAL_STORAGE).forPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE).go();

        final Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);



    }

    // 權限申請訊息
    @AskDenied(Manifest.permission.CAMERA)
    public void Cameras_Denied(int id) {
        Log.d(TAG, "CAMERA DENiED");
    }

    @AskGranted(Manifest.permission.CAMERA)
    public void Cameras_Granted(int id) {
        Log.d(TAG, "CAMERA GRANTED");
    }

    @AskDenied(Manifest.permission.CAMERA)
    public void WRITE_EXTERNAL_STORAGE_Denied(int id) {
        Log.d(TAG, "CAMERA DENiED");
    }

    @AskGranted(Manifest.permission.CAMERA)
    public void WRITE_EXTERNAL_STORAGE_Granted(int id) {
        Log.d(TAG, "CAMERA GRANTED");
    }

    // 攝影機操作
    @Override
    public void onCameraViewStarted(int width, int height) {

    }

    @Override
    public void onCameraViewStopped() {

    }

    @Override
    public Mat onCameraFrame(CameraBridgeViewBase.CvCameraViewFrame inputFrame) {
        return null;
    }
}
