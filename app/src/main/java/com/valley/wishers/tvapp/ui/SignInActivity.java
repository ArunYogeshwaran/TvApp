package com.valley.wishers.tvapp.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.valley.wishers.tvapp.R;
import com.valley.wishers.tvapp.viewmodel.SignInViewModel;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignInActivity extends AppCompatActivity implements SignInFragmentInterface {
    public static final String KEY_SIGN_IN_MODE = "key_sign_in_mode";
    private int mMode;
    @BindView(R.id.sign_in_activiy_container)
    protected FrameLayout signInActivityContainer;
    private FragmentManager fragmentManager;
    private SignInViewModel signInViewModel;

    // Constants
    public static final int REGISTER = 0;
    public static final int NEW_LOGIN = 1;
    public static final int PASSWORD_LOGIN = 2;
    public static final int CHANGE_PASSWORD = 3;
    public static final int UPDATE_PASSWORD = 4;

    @IntDef({REGISTER, NEW_LOGIN, PASSWORD_LOGIN, CHANGE_PASSWORD, UPDATE_PASSWORD})
    @Retention(RetentionPolicy.SOURCE)
    public @interface SignInActivityMode {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        ButterKnife.bind(this);
        this.fragmentManager = getSupportFragmentManager();
        this.signInViewModel = ViewModelProviders.of(this).get(SignInViewModel.class);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        mMode = getIntent().getIntExtra(KEY_SIGN_IN_MODE, REGISTER);
        switch (mMode) {
            case REGISTER:
                this.fragmentManager.beginTransaction()
                        .replace(R.id.sign_in_activiy_container,
                                RegistrationFragment.newInstance(null, null))
                        .commit();
                break;
            case NEW_LOGIN:
                this.fragmentManager.beginTransaction()
                        .replace(R.id.sign_in_activiy_container,
                                LoginFragment.newInstance(null, null))
                        .commit();
                break;
            case PASSWORD_LOGIN:
                this.fragmentManager.beginTransaction()
                        .replace(R.id.sign_in_activiy_container,
                                LoginFragment.newInstance(null, null))
                        .commit();
                break;
            case CHANGE_PASSWORD:
                this.fragmentManager.beginTransaction()
                        .replace(R.id.sign_in_activiy_container,
                                ChangePasswordFragment.newInstance(null, null))
                        .commit();
                break;
            case UPDATE_PASSWORD:
                this.fragmentManager.beginTransaction()
                        .replace(R.id.sign_in_activiy_container,
                                UpdatePasswordFragment.newInstance(null, null))
                        .commit();
                break;
            default:
                this.fragmentManager.beginTransaction()
                        .replace(R.id.sign_in_activiy_container,
                                RegistrationFragment.newInstance(null, null))
                        .commit();
        }
        Handler handler = new Handler();
        demo(handler, LoginFragment.newInstance(null, null), 3000);
        demo(handler, ChangePasswordFragment.newInstance(null, null), 6000);
        demo(handler, UpdatePasswordFragment.newInstance(null, null), 9000);
    }

    private void demo(Handler handler, final Fragment fragment, int delay) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SignInActivity.this.fragmentManager.beginTransaction()
                        .replace(R.id.sign_in_activiy_container, fragment)
                        .commit();
            }
        }, delay);
    }

    /**
     * Start SignInActivity in registration mode.
     *
     * @param context The caller's context
     * @return The intent
     */
    @NonNull
    public static Intent launchRegistrationIntent(@NonNull Context context) {
        Intent i = new Intent(context, SignInActivity.class);
        i.putExtra(KEY_SIGN_IN_MODE, REGISTER);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        return i;
    }

    /**
     * Start SignInActivity in new login mode.
     *
     * @param context The caller's context
     * @return The intent
     */
    @NonNull
    public static Intent launchNewLoginIntent(@NonNull Context context) {
        Intent i = new Intent(context, SignInActivity.class);
        i.putExtra(KEY_SIGN_IN_MODE, NEW_LOGIN);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        return i;
    }

    /**
     * Start SignInActivity in password login mode.
     *
     * @param context The caller's context
     * @return The intent
     */
    @NonNull
    public static Intent launchPasswordLoginIntent(@NonNull Context context) {
        Intent i = new Intent(context, SignInActivity.class);
        i.putExtra(KEY_SIGN_IN_MODE, PASSWORD_LOGIN);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        return i;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
