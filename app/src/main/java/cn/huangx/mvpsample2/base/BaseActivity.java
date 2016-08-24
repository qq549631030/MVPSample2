package cn.huangx.mvpsample2.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by huangx on 2016/8/24.
 */
public class BaseActivity extends AppCompatActivity implements MvpView {

    protected ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progressDialog = new ProgressDialog(this);
    }

    /**
     * 显示loading对话框
     *
     * @param msg
     */
    @Override
    public void showLoading(String msg) {
        progressDialog.setMessage(msg);
        if (!progressDialog.isShowing()) {
            progressDialog.show();
        }
    }

    /**
     * 隐藏loading对话框
     */
    @Override
    public void hideLoading() {
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    /**
     * 显示错误信息
     *
     * @param errorMsg
     */
    @Override
    public void showError(String errorMsg) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();
    }
}
