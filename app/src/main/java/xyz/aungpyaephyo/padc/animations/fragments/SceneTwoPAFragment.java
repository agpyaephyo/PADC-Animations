package xyz.aungpyaephyo.padc.animations.fragments;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.aungpyaephyo.padc.animations.R;

/**
 * Created by aung on 8/27/16.
 */
public class SceneTwoPAFragment extends Fragment {

    @BindView(R.id.iv_sun)
    ImageView ivSun;

    @BindView(R.id.iv_cloud1)
    ImageView ivCloud1;

    @BindView(R.id.iv_cloud2)
    ImageView ivCloud2;

    @BindView(R.id.iv_ground)
    ImageView ivGroud;

    @BindView(R.id.iv_window)
    ImageView ivWindow;

    @BindView(R.id.iv_steerWheel)
    ImageView ivSteerWheel;

    @BindView(R.id.car_layout)
    View vCarLayout;

    private AnimatorSet wheelSpinSet;
    private AnimatorSet sunSwingSet;

    private ValueAnimator vaSkyDarkening;

    private ObjectAnimator oaCloudMoving1;
    private ObjectAnimator oaCloudMoving2;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_scene_two_pa, container, false);
        ButterKnife.bind(this, rootView);

        return rootView;
    }

    @OnClick(R.id.btn_animate_scene_two)
    public void onTapAnimateSceneTwo(View view) {
        wheelSpinSet = (AnimatorSet) AnimatorInflater.loadAnimator(getContext(), R.animator.wheel_spin);
        wheelSpinSet.setTarget(ivSteerWheel);
        wheelSpinSet.start();

        sunSwingSet = (AnimatorSet) AnimatorInflater.loadAnimator(getContext(), R.animator.sun_swing);
        sunSwingSet.setTarget(ivSun);
        sunSwingSet.start();

        vaSkyDarkening = ObjectAnimator.ofInt(
                vCarLayout, //Obj apply animation
                "backgroundColor",  //property
                Color.rgb(0x66, 0xcc, 0xff), //fromValue
                Color.rgb(0x00, 0xcc, 0x99)); //toValue
        vaSkyDarkening.setDuration(3000);
        vaSkyDarkening.setRepeatCount(ValueAnimator.INFINITE);
        vaSkyDarkening.setRepeatMode(ValueAnimator.REVERSE);
        vaSkyDarkening.setEvaluator(new ArgbEvaluator());
        vaSkyDarkening.start();

        oaCloudMoving1 = ObjectAnimator.ofFloat(
                ivCloud1,
                "x",
                -350);
        oaCloudMoving1.setDuration(3000);
        oaCloudMoving1.setRepeatCount(ValueAnimator.INFINITE);
        oaCloudMoving1.setRepeatMode(ValueAnimator.REVERSE);
        oaCloudMoving1.start();

        oaCloudMoving2 = ObjectAnimator.ofFloat(
                ivCloud2,
                "x",
                -300);
        oaCloudMoving2.setDuration(3000);
        oaCloudMoving2.setRepeatCount(ValueAnimator.INFINITE);
        oaCloudMoving2.setRepeatMode(ValueAnimator.REVERSE);
        oaCloudMoving2.start();
    }
}
