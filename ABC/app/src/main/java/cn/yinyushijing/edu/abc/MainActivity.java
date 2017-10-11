package cn.yinyushijing.edu.abc;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tvUpper = (TextView) findViewById(R.id.tv_up);
        final TextView tvLower = (TextView) findViewById(R.id.tv_lo);
        tvUpper.setTextSize(TypedValue.COMPLEX_UNIT_PT,72);
        tvLower.setTextSize(TypedValue.COMPLEX_UNIT_PT,72);

        LetterPair letterPair = AlphabetHandler.getInstance().getLetterPair();
        tvUpper.setText(String.valueOf(letterPair.getUpper()));
        tvLower.setText(String.valueOf(letterPair.getLower()));


        Button btn_next = (Button)findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LetterPair letterPair = AlphabetHandler.getInstance().getLetterPair();
                tvUpper.setText(String.valueOf(letterPair.getUpper()));
                tvLower.setText(String.valueOf(letterPair.getLower()));

            }
        });

        Button btn_spk = (Button)findViewById(R.id.btn_spk);
        btn_spk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  =new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,"en-US");

                try{
                    startActivityForResult(intent,1);
                    Toast.makeText(getApplicationContext(),"called",Toast.LENGTH_SHORT).show();

                }catch(ActivityNotFoundException anfe){
                    Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            Log.d("MyAbc",String.valueOf(resultCode));
            if(data!=null){
                List<String> text = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                for (String s :text) {
                    Log.d("Myabc",s);
                }
                Toast.makeText(getApplicationContext(),text.get(0),Toast.LENGTH_LONG).show();
            }

        }
    }
}
