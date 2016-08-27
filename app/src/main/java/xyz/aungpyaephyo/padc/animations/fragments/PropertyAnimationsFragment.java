package xyz.aungpyaephyo.padc.animations.fragments;

import android.animation.ObjectAnimator;
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
 * Created by aung on 8/26/16.
 */
public class PropertyAnimationsFragment extends Fragment {

    @BindView(R.id.iv_anim_destination)
    ImageView ivAnimDestination;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_property_animation, container, false);
        ButterKnife.bind(this, rootView);

        return rootView;
    }

    @OnClick(R.id.btn_alpha_animate)
    public void onTapAlphaAnimate(View view) {
        ObjectAnimator anim = ObjectAnimator.ofFloat(ivAnimDestination, "alpha", 1f, 0f);
        anim.setDuration(1000);
        anim.start();
    }
}
