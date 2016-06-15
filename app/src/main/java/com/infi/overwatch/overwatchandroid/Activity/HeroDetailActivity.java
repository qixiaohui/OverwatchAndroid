package com.infi.overwatch.overwatchandroid.Activity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.aakira.expandablelayout.ExpandableLayoutListenerAdapter;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import com.github.aakira.expandablelayout.Utils;
import com.infi.overwatch.overwatchandroid.Component.HeroDetailContainerView;
import com.infi.overwatch.overwatchandroid.Dao.Gateway;
import com.infi.overwatch.overwatchandroid.Dao.RestClient;
import com.infi.overwatch.overwatchandroid.R;
import com.infi.overwatch.overwatchandroid.databinding.ActivityHeroDetailBinding;
import com.infi.overwatch.overwatchandroid.databinding.DialogAbilitiesBinding;
import com.infi.overwatch.overwatchandroid.model.heroDetail.Abilities;
import com.infi.overwatch.overwatchandroid.model.heroDetail.HeroDetail;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by TQi on 6/14/16.
 */
public class HeroDetailActivity extends AppCompatActivity {
    public static final String HERO_ID = "HERO_ID";
    private String heroName = "";
    private Toolbar toolbar;
    private HeroDetailContainerView detailContainer;
    private ActivityHeroDetailBinding activityHeroDetailBinding;
    private TextView bioDescription;
    private ExpandableRelativeLayout expandableDescriptionRelativeLayout;
    private RelativeLayout descriptionBtn;
    private RelativeLayout abilitiesBtn;
    private HeroDetail heroDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         activityHeroDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_hero_detail);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        detailContainer = (HeroDetailContainerView) findViewById(R.id.detailContainer);
        bioDescription = (TextView) findViewById(R.id.bioDescription);
        heroName = getIntent().getStringExtra(HERO_ID);
        expandableDescriptionRelativeLayout = activityHeroDetailBinding.description;
        descriptionBtn = activityHeroDetailBinding.descriptionButton;
        abilitiesBtn = activityHeroDetailBinding.abilitiesBtn;
        toolbar.setTitle(heroName);
        toolbar.setNavigationIcon(R.drawable.ic_action_back);
        setSupportActionBar(toolbar);
        init();
        expandableDescriptionRelativeLayout.setListener(new ExpandableLayoutListenerAdapter() {
            @Override
            public void onPreOpen() {
                createRotationAnimation(descriptionBtn, 0f, 180f).start();
            }

            @Override
            public void onPreClose() {
                createRotationAnimation(descriptionBtn, 180f, 0f).start();
            }

        });
        descriptionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableDescriptionRelativeLayout.invalidate();
                expandableDescriptionRelativeLayout.toggle();
            }
        });

        abilitiesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildDialog();
            }
        });
    }

    private void buildDialog(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(HeroDetailActivity.this);
        final AlertDialog alertDialog = alertDialogBuilder.create();
        AbilitiesChart abilitiesChart = new AbilitiesChart(this);
        abilitiesChart.bindData(heroDetail.getAbilities(), alertDialog);
        alertDialog.setView(abilitiesChart);
        alertDialog.show();
        WindowManager.LayoutParams params = alertDialog.getWindow().getAttributes();
        alertDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        params.dimAmount = 0.7f;
        params.gravity = Gravity.CENTER;
        params.width = (int) getResources().getDimension(R.dimen.dialogWidth);

        alertDialog.getWindow().setAttributes(params);
    }

    private void init(){
        Gateway gateway = RestClient.getAwsGateway();
        gateway.getHeroDetail(heroName.toLowerCase()).enqueue(new Callback<HeroDetail>() {
            @Override
            public void onResponse(Call<HeroDetail> call, Response<HeroDetail> response) {
                heroDetail = response.body();
                activityHeroDetailBinding.setData(heroDetail);
                Picasso.with(HeroDetailActivity.this).load(heroDetail.getPoster()).into(detailContainer);
                String description = "";
                for(String section: heroDetail.getDescription()){
                    description+=section;
                }
                bioDescription.setText(description);
            }

            @Override
            public void onFailure(Call<HeroDetail> call, Throwable t) {
                Log.e("HTTP ERROR", t.toString());
            }
        });
    }

    public static void launchActivity(Activity fromActivity, String heroId){
        Intent intent = new Intent(fromActivity, HeroDetailActivity.class);
        intent.putExtra(HERO_ID, heroId);
        fromActivity.startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    private ObjectAnimator createRotationAnimation(final View target, final float from, final float to){
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(target, "rotation", from, to);
        objectAnimator.setDuration(300);
        objectAnimator.setInterpolator(Utils.createInterpolator(Utils.LINEAR_INTERPOLATOR));
        return objectAnimator;
    }

    private class AbilitiesChart extends LinearLayout{
        private ImageView close;
        public AbilitiesChart(Context context){
            this(context, null);
        }

        public AbilitiesChart(Context context, AttributeSet attrs){
            this(context, attrs, 0);
        }

        public AbilitiesChart(Context context, AttributeSet attrs, int defStyle){
            super(context, attrs, defStyle);
        }

        public void bindData(Abilities abilities, final Dialog dialog){
            DialogAbilitiesBinding dialogAbilitiesBinding = DataBindingUtil.setContentView(HeroDetailActivity.this, R.layout.dialog_abilities);
            dialogAbilitiesBinding.setData(abilities);
            close = dialogAbilitiesBinding.close;
            close.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
        }
    }
}
