package com.example.metroui;

import com.example.effect.ScaleAnimEffect;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MetroUIActivity extends Activity implements
		View.OnFocusChangeListener, MyHomeView {

	private ImageView[] posts = new ImageView[10];
	private ImageView[] backGrounds = new ImageView[10];
	private FrameLayout[] fls = new FrameLayout[10];
	
	ScaleAnimEffect animEffect = new ScaleAnimEffect();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_metro_ui);
		initView();
	}

	private void showLooseFocusAinimation(int paramInt) {
		this.animEffect.setAttributs(1.1F, 1.0F, 1.1F, 1.0F, 100L);
		this.posts[paramInt].startAnimation(this.animEffect.createAnimation());
	//	this.tvs[paramInt].setVisibility(View.GONE);
		this.backGrounds[paramInt].setVisibility(View.GONE);
	}

	private void showOnFocusAnimation(final int paramInt) {
		this.fls[paramInt].bringToFront();
		this.animEffect.setAttributs(1.0F, 1.1F, 1.0F, 1.1F, 100L);
		Animation localAnimation = this.animEffect.createAnimation();
		localAnimation.setAnimationListener(new Animation.AnimationListener() {
			public void onAnimationEnd(Animation paramAnonymousAnimation) {
				MetroUIActivity.this.backGrounds[paramInt]
						.startAnimation(MetroUIActivity.this.animEffect
								.alphaAnimation(0.0F, 1.0F, 150L, 0L));
//				MetroUIActivity.this.tvs[paramInt]
//						.startAnimation(MetroUIActivity.this.animEffect
//								.alphaAnimation(0.0F, 1.0F, 150L, 0L));
//				MetroUIActivity.this.tvs[paramInt].setVisibility(View.VISIBLE);
				MetroUIActivity.this.backGrounds[paramInt].setVisibility(View.VISIBLE);
			}

			public void onAnimationRepeat(Animation paramAnonymousAnimation) {
			}

			public void onAnimationStart(Animation paramAnonymousAnimation) {
			}
		});
		this.posts[paramInt].startAnimation(localAnimation);
	}

	public void onFocusChange(View paramView, boolean paramBoolean) {

		switch (paramView.getId()) {
		case R.id.latest_recommend_poster_0:
			if (paramBoolean) {
				showOnFocusAnimation(0);
				break;
			}
			showLooseFocusAinimation(0);
			break;
		case R.id.latest_recommend_poster_1:
			if (paramBoolean) {
				showOnFocusAnimation(1);
				break;
			}
			showLooseFocusAinimation(1);
			break;
		case R.id.latest_recommend_poster_2:
			if (paramBoolean) {
				showOnFocusAnimation(2);
				break;
			}
			showLooseFocusAinimation(2);
			break;
		case R.id.latest_recommend_poster_3:
			if (paramBoolean) {
				showOnFocusAnimation(3);
				break;
			}
			showLooseFocusAinimation(3);
			break;
		default:
			break;
		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initListener() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initView() {
		// TODO Auto-generated method stub
		
		this.fls[0] = ((FrameLayout) findViewById(R.id.latest_recommend_fl_0));
		this.fls[1] = ((FrameLayout) findViewById(R.id.latest_recommend_fl_1));
		this.fls[2] = ((FrameLayout) findViewById(R.id.latest_recommend_fl_2));
		this.fls[3] = ((FrameLayout) findViewById(R.id.latest_recommend_fl_3));
		
		this.posts[0] = ((ImageView) findViewById(R.id.latest_recommend_poster_0));
		this.posts[1] = ((ImageView) findViewById(R.id.latest_recommend_poster_1));
		this.posts[2] = ((ImageView) findViewById(R.id.latest_recommend_poster_2));
		this.posts[3] = ((ImageView) findViewById(R.id.latest_recommend_poster_3));
	
		this.backGrounds[0] = ((ImageView) findViewById(R.id.latest_recommend_bg_0));
		this.backGrounds[1] = ((ImageView) findViewById(R.id.latest_recommend_bg_1));
		this.backGrounds[2] = ((ImageView) findViewById(R.id.latest_recommend_bg_2));
		this.backGrounds[3] = ((ImageView) findViewById(R.id.latest_recommend_bg_3));
	
		for (int i = 0; i < 4; i++) {
			this.posts[i].setOnFocusChangeListener(this);
			this.backGrounds[i].setVisibility(View.GONE);
		}

	}

	@Override
	public void updateData() {
		// TODO Auto-generated method stub

	}

}
