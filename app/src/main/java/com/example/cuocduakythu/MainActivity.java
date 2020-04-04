package com.example.cuocduakythu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView        txtDiem;
    ImageButton     iBtnPlay;
    CheckBox        cbOne, cbTwo, cbThree;
    SeekBar         sbOne, sbTwo, sbThree;
    int soDiem = 100;
    private static final int diemTru = 10;
    private static final int diemCong = 10;

    // Fullscreen khi focus app
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI(this);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hideSystemUI(this);

        anhXa();

        // Khong cho phep tuong tac voi seekBar
        sbOne.setEnabled(false);
        sbTwo.setEnabled(false);
        sbThree.setEnabled(false);

        txtDiem.setText(soDiem + "");

        final CountDownTimer countDownTimer = new CountDownTimer(60000, 300) {
            @Override
            public void onTick(long l) {
                int max = 5;
                Random random = new Random();
                int one     = random.nextInt(max); // random in [0..4]
                int two     = random.nextInt(max);
                int three   = random.nextInt(max);

                // Kiem tra Win cho Tanjiro
                if (sbOne.getProgress() >= sbOne.getMax()) {
                    this.cancel();
                    iBtnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Tanjiro là người chiến thắng!", Toast.LENGTH_SHORT).show();

                    // Kiem tra dat cuoc
                    if (cbOne.isChecked()) {
                        soDiem += diemCong;
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                Toast.makeText(MainActivity.this, "Bạn đoán chính xác!\n" + "Cộng " + diemCong + "$", Toast.LENGTH_SHORT).show();
                            }
                        }, 1000);
                    } else {
                        soDiem -= diemTru;
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                Toast.makeText(MainActivity.this, "Bạn đoán sai rồi!\n" + "Trừ " + diemTru + "$", Toast.LENGTH_SHORT).show();
                            }
                        }, 1000);
                    }
                    txtDiem.setText(soDiem + "");
                    enableCheckBox();
                }

                // Kiem tra Win cho Inosuke
                if (sbTwo.getProgress() >= sbTwo.getMax()) {
                    this.cancel();
                    iBtnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Inosuke là người chiến thắng!", Toast.LENGTH_SHORT).show();

                    // Kiem tra dat cuoc
                    if (cbTwo.isChecked()) {
                        soDiem += diemCong;
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                Toast.makeText(MainActivity.this, "Bạn đoán chính xác!\n" + "Cộng " + diemCong + "$", Toast.LENGTH_SHORT).show();
                            }
                        }, 1000);
                    } else {
                        soDiem -= diemTru;
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                Toast.makeText(MainActivity.this, "Bạn đoán sai rồi!\n" + "Trừ " + diemTru + "$", Toast.LENGTH_SHORT).show();
                            }
                        }, 1000);
                    }
                    txtDiem.setText(soDiem + "");
                    enableCheckBox();
                }

                // Kiem tra Win cho Zenitsu
                if (sbThree.getProgress() >= sbThree.getMax()) {
                    this.cancel();
                    iBtnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Zenitsu là người chiến thắng!", Toast.LENGTH_SHORT).show();

                    // Kiem tra dat cuoc
                    if (cbThree.isChecked()) {
                        soDiem += diemCong;
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                Toast.makeText(MainActivity.this, "Bạn đoán chính xác!\n" + "Cộng " + diemCong + "$", Toast.LENGTH_SHORT).show();
                            }
                        }, 1000);
                    } else {
                        soDiem -= diemTru;
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                Toast.makeText(MainActivity.this, "Bạn đoán sai rồi!\n" + "Trừ " + diemTru + "$", Toast.LENGTH_SHORT).show();
                            }
                        }, 1000);
                    }
                    txtDiem.setText(soDiem + "");
                    enableCheckBox();
                }

                sbOne.setProgress(sbOne.getProgress() + one);
                sbTwo.setProgress(sbTwo.getProgress() + two);
                sbThree.setProgress(sbThree.getProgress() + three);
            }

            @Override
            public void onFinish() {
                // Do Nothing
            }
        };

        // Chi cho phep chon mot trong ba checkbox
        cbOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    Toast.makeText(MainActivity.this, "Bạn đã đặt cược Tanjro là người chạy nhanh nhất!", Toast.LENGTH_SHORT).show();
                    // Bo check 2, 3
                    cbTwo.setChecked(false);
                    cbThree.setChecked(false);
                }
            }
        });
        cbTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    Toast.makeText(MainActivity.this, "Bạn đã đặt cược Inosuke là người chạy nhanh nhất!", Toast.LENGTH_SHORT).show();
                    // Bo check 1, 3
                    cbOne.setChecked(false);
                    cbThree.setChecked(false);
                }
            }
        });
        cbThree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    Toast.makeText(MainActivity.this, "Bạn đã đặt cược Zenitsu là người chạy nhanh nhất!", Toast.LENGTH_SHORT).show();
                    // Bo check 1, 2
                    cbTwo.setChecked(false);
                    cbOne.setChecked(false);
                }
            }
        });

        iBtnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cbOne.isChecked() || cbTwo.isChecked() || cbThree.isChecked()) {
                    sbOne.setProgress(0);
                    sbTwo.setProgress(0);
                    sbThree.setProgress(0);

                    iBtnPlay.setVisibility(View.INVISIBLE);
                    countDownTimer.start();

                    disableCheckBox();
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng đặt cược trước khi chơi!", Toast.LENGTH_SHORT).show();
                }
                
            }
        });
    }

    public static void hideSystemUI(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                        | View.SYSTEM_UI_FLAG_IMMERSIVE);
    }

    public static void showSystemUI(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }

    private void anhXa() {
        txtDiem     = (TextView) findViewById(R.id.textviewDiemSo);
        iBtnPlay    = (ImageButton) findViewById(R.id.imagebuttonPlay);
        cbOne       = (CheckBox) findViewById(R.id.checkboxOne);
        cbTwo       = (CheckBox) findViewById(R.id.checkboxTwo);
        cbThree     = (CheckBox) findViewById(R.id.checkboxThree);
        sbOne       = (SeekBar) findViewById(R.id.seekbarOne);
        sbTwo       = (SeekBar) findViewById(R.id.seekbarTwo);
        sbThree     = (SeekBar) findViewById(R.id.seekbarThree);
    }

    private void enableCheckBox() {
        cbOne.setEnabled(true);
        cbTwo.setEnabled(true);
        cbThree.setEnabled(true);
    }
    private void disableCheckBox() {
        cbOne.setEnabled(false);
        cbTwo.setEnabled(false);
        cbThree.setEnabled(false);
    }
}
