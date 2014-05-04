package com.example.seakbar2demo;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;


	public class MainActivity extends Activity {
		 
	    private SeekBar volumeControl = null;
	 
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_seekbar);
	 
	        volumeControl = (SeekBar) findViewById(R.id.volume_bar);
	 
	        volumeControl.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
	            int progressChanged = 0;
	 
	            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
	                progressChanged = progress;
	                if(progress <= 50){
	                	setProgressBarColor(volumeControl,Color.rgb( 255 - (255/100 * (100 - progress*2)), 255, 0));
	                	
				     }else{
				    	 setProgressBarColor(volumeControl,Color.rgb( 255, 255 - (255/100 * (progress - 50)*2), 0));

				     }
	            }
	 
	            public void onStartTrackingTouch(SeekBar seekBar) {
	                // TODO Auto-generated method stub
	            }
	 
	            public void onStopTrackingTouch(SeekBar seekBar) {
	                Toast.makeText(MainActivity.this,"seek bar progress:"+progressChanged, 
	                        Toast.LENGTH_SHORT).show();
	            }
	        });
	 
	    }
	    
	    public void setProgressBarColor(SeekBar seakBar, int newColor){ 
	        LayerDrawable ld = (LayerDrawable) seakBar.getProgressDrawable();
	        ClipDrawable d1 = (ClipDrawable) ld.findDrawableByLayerId(R.id.progressshape);
	        d1.setColorFilter(newColor, PorterDuff.Mode.SRC_IN);

	    }
	 
	  
	 
	}

