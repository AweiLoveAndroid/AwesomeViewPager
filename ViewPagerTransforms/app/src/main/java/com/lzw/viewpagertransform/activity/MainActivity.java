package com.lzw.viewpagertransform.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lzw.viewpagertransform.R;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        Button buttonOne = (Button) findViewById(R.id.goto_one);
        Button buttonTwo = (Button) findViewById(R.id.goto_two);
        Button buttonThree = (Button) findViewById(R.id.goto_three);
        Button buttonFour = (Button) findViewById(R.id.goto_flowlayout);

        buttonOne.setOnClickListener(new MainClick());
        buttonTwo.setOnClickListener(new MainClick());
        buttonThree.setOnClickListener(new MainClick());
        buttonFour.setOnClickListener(new MainClick());
    }

    private class MainClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.goto_one:
                    gotoActivity(MainActivity1.class);
                    break;
                case R.id.goto_two:
                    gotoActivity(MainActivity2.class);
                    break;
                case R.id.goto_three:
                    gotoActivity(MainActivity3.class);
                    break;
                case R.id.goto_flowlayout:
                    gotoActivity(FlowLayoutSampleActivity.class);
                    break;
            }
        }
    }

    private void gotoActivity(Class<?> cls){
        startActivity(new Intent(MainActivity.this,cls));
    }

}
