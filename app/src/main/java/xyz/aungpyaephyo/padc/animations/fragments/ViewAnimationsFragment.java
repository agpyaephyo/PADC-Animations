package xyz.aungpyaephyo.padc.animations.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
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
 * A placeholder fragment containing a simple view.
 */
public class ViewAnimationsFragment extends Fragment {

    @BindView(R.id.iv_anim_destination)
    ImageView ivAnimDestination;

    public ViewAnimationsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_view_animations, container, false);
        ButterKnife.bind(this, rootView);

        return rootView;
    }

    @OnClick(R.id.btn_view_animate)
    public void onTapViewAnimate(View view) {
        Animation animHyperSpaceJump = AnimationUtils.loadAnimation(getContext(), R.anim.hyper_space_jump);
        ivAnimDestination.startAnimation(animHyperSpaceJump);
    }

    @OnClick(R.id.btn_animate_zoom)
    public void onTapAnimateZoom(View view) {
        Animation animZoom = AnimationUtils.loadAnimation(getContext(), R.anim.zoom);
        ivAnimDestination.startAnimation(animZoom);
    }

    @OnClick(R.id.btn_animate_clockwise)
    public void onTapAnimateClockwise(View view) {
        Animation animZoom = AnimationUtils.loadAnimation(getContext(), R.anim.clockwise);
        ivAnimDestination.startAnimation(animZoom);
    }

    @OnClick(R.id.btn_animate_fade)
    public void onTapAnimateFade(View view) {
        Animation animFade = AnimationUtils.loadAnimation(getContext(), R.anim.fade);
        ivAnimDestination.startAnimation(animFade);
    }

    @OnClick(R.id.btn_animate_blink)
    public void onTapAnimateBlink(View view) {
        Animation animBlink = AnimationUtils.loadAnimation(getContext(), R.anim.blink);
        ivAnimDestination.startAnimation(animBlink);
    }

    @OnClick(R.id.btn_animate_move)
    public void onTapAnimateMove(View view) {
        Animation animMove = AnimationUtils.loadAnimation(getContext(), R.anim.move);
        ivAnimDestination.startAnimation(animMove);
    }

    @OnClick(R.id.btn_animate_slide)
    public void onTapAnimateSlide(View view) {
        Animation animSlide = AnimationUtils.loadAnimation(getContext(), R.anim.slide);
        ivAnimDestination.startAnimation(animSlide);
    }
}
