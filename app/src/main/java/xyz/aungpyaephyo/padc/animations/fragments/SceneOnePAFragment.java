package xyz.aungpyaephyo.padc.animations.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.aungpyaephyo.padc.animations.R;

/**
 * Created by aung on 8/27/16.
 */
public class SceneOnePAFragment extends Fragment {

    @BindView(R.id.iv_sun)
    ImageView ivSun;

    @BindView(R.id.iv_clock)
    ImageView ivClock;

    @BindView(R.id.iv_hourHand)
    ImageView ivHourHand;

    private Animation animSunRise;
    private Animation animClockTurn;
    private Animation animHourHandTurn;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        animSunRise = AnimationUtils.loadAnimation(getContext(), R.animator.sun_rise);
        animClockTurn = AnimationUtils.loadAnimation(getContext(), R.animator.clock_turn);
        animHourHandTurn = AnimationUtils.loadAnimation(getContext(), R.animator.hour_hand_turn);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_scene_one_pa, container, false);
        ButterKnife.bind(this, rootView);

        return rootView;
    }

    @OnClick(R.id.btn_animate_scene_one)
    public void onTapAnimateSceneOne(View view) {
        ivSun.startAnimation(animSunRise);
        ivClock.startAnimation(animClockTurn);
        ivHourHand.startAnimation(animHourHandTurn);
    }
}
