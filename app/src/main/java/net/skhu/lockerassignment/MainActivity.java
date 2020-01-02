package net.skhu.lockerassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test=findViewById(R.id.fT);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,FormActivity.class));
            }
        });
    }

    public void mOnFloor(View v){
        Class c=null;
        switch (v.getId()){
            case R.id.f1:
                c=Floor1Activity.class;
                break;
            case R.id.f2:
                c=Floor2Activity.class;
                break;
            case R.id.f3:
                c=Floor3Activity.class;
                break;
            case R.id.f4:
                c=Floor4Activity.class;
                break;
        }
        startActivity(new Intent(MainActivity.this,c));
    }
}