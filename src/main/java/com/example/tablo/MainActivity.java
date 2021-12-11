package com.example.tablo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int SibirPoint = 0;
    int AkBarsPoint = 0;
    TextView counterView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        resetUI();
    }

    @Override
    protected void onSaveInstanceState(Bundle outstate) {
        super.onSaveInstanceState(outstate);
        outstate.putInt("Sibir", SibirPoint);
        outstate.putInt("Akbars", AkBarsPoint);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null &&
                savedInstanceState.containsKey("Sibir") && savedInstanceState.containsKey("Akbars")) {
            SibirPoint = savedInstanceState.getInt("Sibir");
            AkBarsPoint = savedInstanceState.getInt("Akbars");
        }
    }

    private void resetUI() {
        ((TextView) findViewById(R.id.Sibir)).setText("" + SibirPoint);
        ((TextView) findViewById(R.id.AkBars)).setText("" + AkBarsPoint);

    }

    public void ClickSibir(View view) {
        SibirPoint++;
        counterView = (TextView)findViewById(R.id.Sibir);
        counterView.setText(""+SibirPoint);
        if (SibirPoint > 99){
        counterView.setTextSize(56);}
    }

    public void ClickAkBars(View view) {
        AkBarsPoint++;
        counterView = (TextView)findViewById(R.id.AkBars);
        counterView.setText(""+AkBarsPoint);
        if (AkBarsPoint > 99){
        counterView.setTextSize(56); }
    }

    public void ClickReset(View view) {
        counterView = (TextView)findViewById(R.id.Sibir);
        if (SibirPoint > 99){
        counterView.setTextSize(72);}
        SibirPoint=0;
        counterView.setText(""+SibirPoint);
        counterView = (TextView)findViewById(R.id.AkBars);
        if (AkBarsPoint > 99){
        counterView.setTextSize(72);}
        AkBarsPoint=0;
        counterView.setText(""+AkBarsPoint);
    }
}