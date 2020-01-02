package net.skhu.lockerassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class Floor1Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floor1);
    }
    public void mOnFloor(View v){
        Button b=(Button)v;
        Log.d("name",b.getText().toString());
        Intent i=new Intent(Floor1Activity.this,FormActivity.class);
        i.putExtra("name",b.getText().toString());
        startActivity(i);
    }
}
