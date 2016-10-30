package cn.edu.gdmec.a07150847.intent;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText e1,e2;
    private TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1= (EditText) findViewById(R.id.url);
        e2= (EditText) findViewById(R.id.phone);
        t1= (TextView) findViewById(R.id.textView1);
    }

    public void componentname(View v) {
        ComponentName componentName = new ComponentName(this,IntentDemo2.class);
        Intent i1 = new Intent();
        i1.setComponent(componentName);
        startActivity(i1);
    }

    public  void intentfilter(View v){
        String action = "cn.edu.gdmec.kissme";
        Intent i2 = new Intent();
        i2.setAction(action);
        startActivity(i2);
    }


    public  void view(View v){
        Intent i3 = new Intent();
        i3.setAction(Intent.ACTION_VIEW);
        Uri url = Uri.parse(e1.getText().toString());
        i3.setData(url);
        startActivity(i3);
    }


    public void dial(View v){
        Intent i3 = new Intent(Intent.ACTION_DIAL);
        Uri uri = Uri.parse("tel:"+e2.getText().toString());
        i3.setData(uri);
        startActivity(i3);
    }


    public  void startactivityforresult(View v){
        Bundle bundle = new Bundle();
        bundle.putString("value",e1.getText().toString());
        Intent intent = new Intent(MainActivity.this,IntentDemo2.class);
        intent.putExtras(bundle);
        startActivityForResult(intent,10);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 10:
                    Bundle bundle = data.getExtras();
                    t1.setText(bundle.getString("result"));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
