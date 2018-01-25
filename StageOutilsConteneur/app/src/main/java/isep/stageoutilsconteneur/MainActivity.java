package isep.stageoutilsconteneur;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

import io.paperdb.Paper;
import isep.stageoutilsconteneur.helper.LocaleHelper;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button btnclick;
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase,"en"));
    }

    private static final String TAG="MainActivity";
    private static final int ERROR_DIALOG_REQUEST=9001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=(TextView)findViewById(R.id.text_view);
        btnclick =(Button)findViewById(R.id.btn);
/*
        btnclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mapActivity = new Intent(MainActivity,MapActivity.class);
                startActivity(mapActivity);
            }
        });
   */

        if(isServiceOk()){
            init();

        }

        //init paper first
        Paper.init(this);
        //default lang is fr
        String language=Paper.book().read("language");
        if(language==null){
            Paper.book().write("language","fr");
            updateView((String)Paper.book().read("language"));
        }

    }
    private void init(){
        btnclick =(Button)findViewById(R.id.btn);
        btnclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mapActivity = new Intent(MainActivity.this,MapActivity.class);
                startActivity(mapActivity);
            }
        });
    }

    public boolean isServiceOk(){
        Log.d(TAG,"isServicesOK: checking google services version");
        int available= GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MainActivity.this);
        if(available== ConnectionResult.SUCCESS){
            Log.d(TAG,"isServicesOK: Google play service is working");
            return true;
        }else if(GoogleApiAvailability.getInstance().isUserResolvableError(available)){
            Log.d(TAG,"isServicesOk: an error occured but we can fix it");
            Dialog dialog=GoogleApiAvailability.getInstance().getErrorDialog(MainActivity.this,available,ERROR_DIALOG_REQUEST);
            dialog.show();
        }else{
            Toast.makeText(this,"you can't make map requests", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    private void updateView(String lang) {
        Context context =LocaleHelper.setLocale(this,lang);
        Resources res = context.getResources();
        textView.setText(res.getString(R.string.welcome_message));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.language_fr){
            Paper.book().write("language","fr");
            updateView((String)Paper.book().read("language"));
        }
        else if(item.getItemId()==R.id.language_en){
            Paper.book().write("language","en");
            updateView((String)Paper.book().read("language"));

        }
        return true;
    }
//test debug;
    public void clickHandler(View view) {
        int j=0;
        for (int i = 0; i <10 ; i++) {
            j=i;
            i=j+i;
        }
    }
}
