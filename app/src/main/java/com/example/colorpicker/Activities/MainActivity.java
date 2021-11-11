package com.example.colorpicker.Activities;

import androidx.appcompat.app.AppCompatActivity;


import android.graphics.PorterDuff;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.colorpicker.R;
import com.example.colorpicker.Utils.Converter;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{

    private SeekBar redSlider, greenSlider, blueSlider;
    private TextView textRedValue, textGreenValue, textBlueValue;
    private EditText  textHex, textCmyk, textRgb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindUI();
        redSlider.setOnSeekBarChangeListener(this);
        greenSlider.setOnSeekBarChangeListener(this);
        blueSlider.setOnSeekBarChangeListener(this);

    }

    private void bindUI()
    {
        redSlider = (SeekBar) findViewById(R.id.seekBarRed);
        greenSlider = (SeekBar) findViewById(R.id.seekBarGreen);
        blueSlider  = (SeekBar) findViewById(R.id.seekBarBlue);

        textRedValue = (TextView) findViewById(R.id.textRedValue);
        textGreenValue = (TextView) findViewById(R.id.textGreenValue);
        textBlueValue = (TextView) findViewById(R.id.textBlueValue);

        textHex = (EditText) findViewById(R.id.textViewHex);
        textCmyk = (EditText) findViewById(R.id.textViewCmyk);
        textRgb = (EditText) findViewById(R.id.textViewRgb);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId())
        {
            case R.id.seekBarRed:
                textRedValue.setText(String.valueOf(progress));

                break;
            case R.id.seekBarGreen:
                textGreenValue.setText(String.valueOf(progress));
                break;
            case R.id.seekBarBlue:
                textBlueValue.setText(String.valueOf(progress));
                break;

                default:
                    Toast.makeText(MainActivity.this, "º_º xd", Toast.LENGTH_LONG).show();
        }

        updateColorValues(redSlider.getProgress(), greenSlider.getProgress(), blueSlider.getProgress());
    }

    private void updateColorValues(int red, int green, int blue)
    {
        String rgb = "rgb(" + redSlider.getProgress() + "," + greenSlider.getProgress() + "," + blueSlider.getProgress() + ")";
        textHex.setText(Converter.rgb_to_hex(red, green, blue));
        textCmyk.setText(Converter.rgb_to_cmyk(red, green, blue));
        textRgb.setText(rgb);

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {}

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {}
}
