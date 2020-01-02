package net.skhu.lockerassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FormActivity extends Activity {

    boolean confirm = false, depart = false;
    EditText sn, name;
    //    ClearEditText sn,name;
//    CheckBox it,soft,glocal,info,comp;
    CheckBox[] cb = new CheckBox[5];
    String ssn, sname, sdep;
    Button close;

    TextView title;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        sn = findViewById(R.id.sn);
        name = findViewById(R.id.name);
        cb[0] = findViewById(R.id.IT);
        cb[1] = findViewById(R.id.soft);
        cb[2] = findViewById(R.id.glocal);
        cb[3] = findViewById(R.id.info);
        cb[4] = findViewById(R.id.comp);
        close = findViewById(R.id.close);

        title = findViewById(R.id.title);
        intent = getIntent();
        title.setText(intent.getStringExtra("name"));
    }

    public void mOnClose(View v) {
        if (confirm)
            finish();
        else {
            AlertDialog.Builder b = new AlertDialog.Builder(this);
            b.setTitle("배정 신청");
            String msg="입력한 정보로 " + intent.getStringExtra("name") + " 배정을              신청하시겠습니까?";
            String msg0="입력한 정보로 " + intent.getStringExtra("name") + " 배정을%n신청하시겠습니까?";
            b.setMessage(msg);
            b.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    for (int j = 0; j < 5; j++) {
                        if (cb[j].isChecked()) {
                            if (depart) {
                                Toast.makeText(FormActivity.this, "하나의 학과를 선택해야 합니다.", Toast.LENGTH_LONG).show();
                                depart = false;
                                return;
                            } else {
                                depart = true;
                                sdep = cb[j].getText().toString();
                            }
                        }
                    }
                    ssn = sn.getText().toString();
                    sname = name.getText().toString();
                    Log.d("TODO", "이후 데이터베이스에 입력된 데이터 전송");
                    close.setText("닫기");
                    Toast.makeText(FormActivity.this, sdep + " " + ssn + "\n" + sname + " 학생\n배정신청이 완료되었습니다.", Toast.LENGTH_LONG).show();
                    confirm = true;
                    finish();
                }
            });
            b.setNegativeButton("취소", null);
            AlertDialog d = b.create();
            d.show();
        }
    }
}
