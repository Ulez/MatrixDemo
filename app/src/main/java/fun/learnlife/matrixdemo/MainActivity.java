package fun.learnlife.matrixdemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.tencent.matrix.AppActiveMatrixDelegate;
import com.tencent.matrix.Matrix;
import com.tencent.matrix.listeners.IAppForeground;
import com.tencent.matrix.plugin.Plugin;
import com.tencent.matrix.trace.TracePlugin;
import com.tencent.matrix.trace.view.FrameDecorator;
import com.tencent.matrix.util.MatrixLog;

import androidx.appcompat.app.AppCompatActivity;
import fun.learnlife.matrixdemo.issue.IssueFilter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, IAppForeground {

    private static String TAG = "Matrix.TestTraceMainActivity";
//    FrameDecorator decorator;
//    private static final int PERMISSION_REQUEST_CODE = 0x02;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("lcyy","start----");

        IssueFilter.setCurrentFilter(IssueFilter.ISSUE_TRACE);

        Plugin plugin = Matrix.with().getPluginByClass(TracePlugin.class);
        if (!plugin.isPluginStarted()) {
            MatrixLog.i(TAG, "plugin-trace start");
            plugin.start();
        }
//        decorator = FrameDecorator.getInstance(this);
//        if (!canDrawOverlays()) {
//            requestWindowPermission();
//        } else {
//            decorator.show();
//        }

        AppActiveMatrixDelegate.INSTANCE.addListener(this);

        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
    }

//    private void requestWindowPermission() {
//        Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
//                Uri.parse("package:" + getPackageName()));
//        startActivityForResult(intent, PERMISSION_REQUEST_CODE);
//    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                method(1000);
                break;
            case R.id.button2:
                method(2000);
                break;
            case R.id.button3:
                method(15000);
                break;
        }

    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        MatrixLog.i(TAG, "requestCode:%s resultCode:%s", requestCode, resultCode);
//        if (requestCode == PERMISSION_REQUEST_CODE) {
//            if (canDrawOverlays()) {
//                decorator.show();
//            } else {
//                Toast.makeText(this, "fail to request ACTION_MANAGE_OVERLAY_PERMISSION", Toast.LENGTH_LONG).show();
//            }
//        }
//    }


//    private boolean canDrawOverlays() {
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            return Settings.canDrawOverlays(this);
//        } else {
//            return true;
//        }
//    }

    private void method(long i) {
        SystemClock.sleep(i);
    }

    @Override
    public void onForeground(boolean isForeground) {
//        if (!canDrawOverlays()) {
//            return;
//        }
//        if (!isForeground) {
//            decorator.dismiss();
//        } else {
//            decorator.show();
//        }
    }
}