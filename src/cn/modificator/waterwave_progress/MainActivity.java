package cn.modificator.waterwave_progress;

import cn.modificator.waterwaveprogressdemo.R;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends Activity{

	WaterWaveProgress waveProgress;
	private static int count = 0;
	private Handler mHandler = new Handler() {
		public void handleMessage(Message msg) {
			waveProgress.setProgress(msg.what);
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		SeekBar bar = (SeekBar) findViewById(R.id.seekBar1);
		waveProgress = (WaterWaveProgress) findViewById(R.id.waterWaveProgress1);
		waveProgress.setShowProgress(true);
		waveProgress.animateWave();

		bar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				setTitle("" + progress);
				waveProgress.setProgress(progress);

			}
		});
		((CheckBox) findViewById(R.id.checkBox1))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						waveProgress.setShowProgress(isChecked);
					}
				});
		((CheckBox) findViewById(R.id.checkBox2))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						waveProgress.setShowNumerical(isChecked);
					}
				});

	}

}
