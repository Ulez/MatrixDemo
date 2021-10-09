package fun.learnlife.matrixdemo;

import android.content.Context;
import android.util.Log;

import com.tencent.matrix.plugin.DefaultPluginListener;
import com.tencent.matrix.report.Issue;
import com.tencent.matrix.util.MatrixLog;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

import fun.learnlife.matrixdemo.issue.ParseIssueUtil;

public class TestPluginListener extends DefaultPluginListener {
    public static final String TAG = "Matrix.TestPluginListener";

    public TestPluginListener(Context context) {
        super(context);
    }

    @Override
    public void onReportIssue(Issue issue) {
        super.onReportIssue(issue);
//        MatrixLog.e(TAG, issue.toString());
        JSONObject content = issue.getContent();
        try {
            String stack = content.getString("stack");
            Log.e("lcyy", "stack = " + stack);
            StringBuilder sb = new StringBuilder();
            String[] item = stack.split("\n");
            for (int i = 0; i < item.length; i++) {
                if (item[i].contains(",")) {
                    String[] split = item[i].split(",");
                    sb.append(split[0]).append(",").append(MatrixApplication.methodMap.get(Integer.parseInt(split[1]))).append(",").append(split[2]).append(",").append(split[3]);
                }
                sb.append("\n");
            }
            Log.e("lcyy", sb.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.e("lcyy", ParseIssueUtil.parseIssue(issue, true));
        //add your code to process data
    }
}