package fun.learnlife.matrixdemo;

import android.content.Context;
import android.util.Log;

import com.tencent.matrix.plugin.DefaultPluginListener;
import com.tencent.matrix.report.Issue;
import com.tencent.matrix.trace.util.TraceDataUtils;
import com.tencent.matrix.util.MatrixLog;

import fun.learnlife.matrixdemo.issue.ParseIssueUtil;

public class TestPluginListener extends DefaultPluginListener {
    public static final String TAG = "Matrix.TestPluginListener";
    public TestPluginListener(Context context) {
        super(context);
        
    }

    @Override
    public void onReportIssue(Issue issue) {
        super.onReportIssue(issue);
        MatrixLog.e(TAG, issue.toString());
        Log.e("lcyy",ParseIssueUtil.parseIssue(issue, true));
        //add your code to process data
    }
}