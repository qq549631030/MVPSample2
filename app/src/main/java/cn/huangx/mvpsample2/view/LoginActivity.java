package cn.huangx.mvpsample2.view;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import cn.huangx.mvpsample2.R;
import cn.huangx.mvpsample2.base.BaseActivity;
import cn.huangx.mvpsample2.model.UserModel;
import cn.huangx.mvpsample2.presenter.LoginPresenter;

public class LoginActivity extends BaseActivity implements ILoginView, View.OnClickListener {

    private EditText username;
    private EditText password;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        findViewById(R.id.login).setOnClickListener(this);
        presenter = new LoginPresenter(new UserModel());
        presenter.attachView(this);//这里与View建立连接
    }

    @Override
    protected void onDestroy() {
        presenter.detachView();//这里与View断开连接
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login:
                presenter.login();
                break;
        }
    }

    /**
     * 从UI中获取用户输入的用户名
     *
     * @return
     */
    @Override
    public String getUsername() {
        return username.getText().toString().trim();
    }

    /**
     * 从UI中获取用户输入的密码
     *
     * @return
     */
    @Override
    public String getPassword() {
        return password.getText().toString().trim();
    }

    /**
     * 显示结果
     *
     * @param result
     */
    @Override
    public void showResult(String result) {
        Toast.makeText(LoginActivity.this, result, Toast.LENGTH_SHORT).show();
    }
}
