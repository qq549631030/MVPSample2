package cn.huangx.mvpsample2.presenter;


import cn.huangx.mvpsample2.base.BasePresenter;
import cn.huangx.mvpsample2.model.Callback;
import cn.huangx.mvpsample2.model.IUserModel;
import cn.huangx.mvpsample2.view.ILoginView;

/**
 * Created by huangx on 2016/8/24.
 */
public class LoginPresenter extends BasePresenter<ILoginView> implements ILoginPresenter {

    private IUserModel userModel;

    public LoginPresenter(IUserModel userModel) {
        this.userModel = userModel;
    }

    /**
     * 登录
     */
    @Override
    public void login() {
        checkViewAttached();
        getMvpView().showLoading("登录中...");
        userModel.login(getMvpView().getUsername(), getMvpView().getPassword(), new Callback() {
            @Override
            public void onSuccess() {
                if (isViewAttached()) {
                    getMvpView().hideLoading();
                    getMvpView().showResult("登录成功");
                }
            }

            @Override
            public void onFailure(String errorMsg) {
                if (isViewAttached()) {
                    getMvpView().hideLoading();
                    getMvpView().showResult(errorMsg);
                }
            }
        });
    }
}
