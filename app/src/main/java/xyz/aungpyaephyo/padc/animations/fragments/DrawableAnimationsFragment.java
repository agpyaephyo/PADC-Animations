package xyz.aungpyaephyo.padc.animations.fragments;

import android.graphics.drawable.AnimationDrawable;
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
public class DrawableAnimationsFragment extends Fragment {

    @BindView(R.id.iv_gyro)
    ImageView ivGyro;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_drawable_animation, container, false);
        ButterKnife.bind(this, rootView);

        return rootView;
    }

    @OnClick(R.id.btn_animate_drawable)
    public void onTapAnimateDrawable(View view) {
        ivGyro.setBackgroundResource(R.drawable.gyro_anim);
        AnimationDrawable animDrawableGyroImage = (AnimationDrawable) ivGyro.getBackground();
        animDrawableGyroImage.start();
    }
}
