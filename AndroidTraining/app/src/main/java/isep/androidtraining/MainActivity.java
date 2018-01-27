package isep.androidtraining;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE="Message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void sendMessage(View view){
        Toast.makeText(this,"send message",Toast.LENGTH_SHORT).show();
        //this is for MainActivity, because Activity is a subclass of Context;
        Intent intent=new Intent(this,DisplayMessageActivity.class);

        EditText editText=(EditText)findViewById(R.id.textView);
        String message = editText.getText().toString();
        //putExtra method puts value to the Intent, this intent carr data type as key-value pairs,
        //key is EXTRA_MESSAGE, and next activity uses the key to retrieve the message;
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);
    }
}
