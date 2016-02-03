package com.ayman.huci;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.Toast;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    Button level0,level1,level2,level3,level4,fac,about,res,gpa,sly,cal,clear;
    Spinner tryh1,tryg1,tryh2,tryg2,tryh3,tryg3,tryh4,tryg4,tryh5,tryg5,tryh6,tryg6;
    TabHost tabs;
    SharedPreferences sec;
    SubjectsDB my;
    String s[]={"--","A","A-","B+","B","B-","C+","C","C-","D+","D","F"};
    String ss[]={"--","2","3","4"};
    Map m1=new HashMap();
    Map m2=new HashMap();
    double f=0.0,t=0.0;
    double[][] arr = new double[6][2];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sec= PreferenceManager.getDefaultSharedPreferences(this);
        my=new SubjectsDB(this);
        if(sec.getBoolean("start",true)){
            //public MySubject (int id , String name , int hours , String grade)
            my.addSubject(new MySubject(1,"math1",4,"--"));
            my.addSubject(new MySubject(1,"intro",4,"--"));
            my.addSubject(new MySubject(1,"english",3,"--"));
            my.addSubject(new MySubject(1,"chemistry",3,"--"));
            my.addSubject(new MySubject(1,"drawing",4,"--"));
            my.addSubject(new MySubject(1,"linear",3,"--"));
            my.addSubject(new MySubject(1,"physics1",4,"--"));
            my.addSubject(new MySubject(1,"economics",3,"--"));
            my.addSubject(new MySubject(1,"humanities",2,"--"));
            my.addSubject(new MySubject(1,"italian",3,"--"));
            my.addSubject(new MySubject(1,"production",3,"--"));
            my.addSubject(new MySubject(1,"math2",4,"--"));
            my.addSubject(new MySubject(1,"physics2",4,"--"));
            my.addSubject(new MySubject(1,"analogue1",3,"--"));
            my.addSubject(new MySubject(1,"circuit",4,"--"));
            my.addSubject(new MySubject(1,"human",2,"--"));
            my.addSubject(new MySubject(1,"environmetanl",2,"--"));
            my.addSubject(new MySubject(1,"digitalele",4,"--"));
            my.addSubject(new MySubject(1,"field",4,"--"));
            my.addSubject(new MySubject(1,"mechanics",3,"--"));
            my.addSubject(new MySubject(1,"progtech",4,"--"));
            my.addSubject(new MySubject(1,"analogue2",3,"--"));
            my.addSubject(new MySubject(1,"probability",3,"--"));
            my.addSubject(new MySubject(1,"signal",4,"--"));
            my.addSubject(new MySubject(1,"datastructure",4,"--"));
            my.addSubject(new MySubject(1,"complex",4,"--"));
            my.addSubject(new MySubject(1,"computerarch",4,"--"));
            my.addSubject(new MySubject(1,"discrete",4,"--"));
            my.addSubject(new MySubject(1,"microprocessor",3,"--"));
            my.addSubject(new MySubject(1,"comtech",4,"--"));
            my.addSubject(new MySubject(1,"measurment",4,"--"));
            my.addSubject(new MySubject(1,"techwriting",2,"--"));
            my.addSubject(new MySubject(1,"control",4,"--"));
            my.addSubject(new MySubject(1,"digitalcom",4,"--"));
            my.addSubject(new MySubject(1,"numerical",4,"--"));
            my.addSubject(new MySubject(1,"database",4,"--"));
            my.addSubject(new MySubject(1,"electivei1",2,"--"));
            my.addSubject(new MySubject(1,"software",3,"--"));
            my.addSubject(new MySubject(1,"comnetwork",4,"--"));
            my.addSubject(new MySubject(1,"os",4,"--"));
            my.addSubject(new MySubject(1,"oop",4,"--"));
            my.addSubject(new MySubject(1,"antenna",3,"--"));
            my.addSubject(new MySubject(1,"electivei2",2,"--"));
            my.addSubject(new MySubject(1,"dsp",4,"--"));
            my.addSubject(new MySubject(1,"electiveii1",3,"--"));
            my.addSubject(new MySubject(1,"information",4,"--"));
            my.addSubject(new MySubject(1,"electiveii2",3,"--"));
            my.addSubject(new MySubject(1,"gp1",2,"--"));
            my.addSubject(new MySubject(1,"electiveii3",3,"--"));
            my.addSubject(new MySubject(1,"electiveii4",3,"--"));
            my.addSubject(new MySubject(1,"electiveii5",3,"--"));
            my.addSubject(new MySubject(1,"electiveii6",3,"--"));
            my.addSubject(new MySubject(1,"electiveii7",3,"--"));
            my.addSubject(new MySubject(1,"gp2",2,"--"));
            sec.edit().putBoolean("start",false).apply();
        }


        tryg1=(Spinner) findViewById(R.id.tryg1id);
        tryg1.setOnItemSelectedListener(this);

        tryg2=(Spinner) findViewById(R.id.tryg2id);
        tryg2.setOnItemSelectedListener(this);

        tryg3=(Spinner) findViewById(R.id.tryg3id);
        tryg3.setOnItemSelectedListener(this);

        tryg4=(Spinner) findViewById(R.id.tryg4id);
        tryg4.setOnItemSelectedListener(this);

        tryg5=(Spinner) findViewById(R.id.tryg5id);
        tryg5.setOnItemSelectedListener(this);

        tryg6=(Spinner) findViewById(R.id.tryg6id);
        tryg6.setOnItemSelectedListener(this);

        tryh1=(Spinner) findViewById(R.id.tryh1id);
        tryh1.setOnItemSelectedListener(this);

        tryh2=(Spinner) findViewById(R.id.tryh2id);
        tryh2.setOnItemSelectedListener(this);

        tryh3=(Spinner) findViewById(R.id.tryh3id);
        tryh3.setOnItemSelectedListener(this);

        tryh4=(Spinner) findViewById(R.id.tryh4id);
        tryh4.setOnItemSelectedListener(this);

        tryh5=(Spinner) findViewById(R.id.tryh5id);
        tryh5.setOnItemSelectedListener(this);

        tryh6=(Spinner) findViewById(R.id.tryh6id);
        tryh6.setOnItemSelectedListener(this);


        ArrayAdapter<String> sad=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,s);
        ArrayAdapter<String> ssad=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,ss);

        for(int i=0;i<6;i++){
            arr[i][0]=-1;
            arr[i][1]=-1;
        }

        tryg1.setAdapter(sad);
        tryg2.setAdapter(sad);
        tryg3.setAdapter(sad);
        tryg4.setAdapter(sad);
        tryg5.setAdapter(sad);
        tryg6.setAdapter(sad);
        tryh1.setAdapter(ssad);
        tryh2.setAdapter(ssad);
        tryh3.setAdapter(ssad);
        tryh4.setAdapter(ssad);
        tryh5.setAdapter(ssad);
        tryh6.setAdapter(ssad);

        m1.put(0,-1.0);
        m1.put(1,4.0);
        m1.put(2,3.7);
        m1.put(3,3.3);
        m1.put(4,3.0);
        m1.put(5,2.7);
        m1.put(6,2.3);
        m1.put(7,2.0);
        m1.put(8,1.7);
        m1.put(9,1.3);
        m1.put(10,1.0);
        m1.put(11,0.0);


        m2.put(0,-1.0);
        m2.put(1,2.0);
        m2.put(2,3.0);
        m2.put(3,4.0);

        tabs = (TabHost) findViewById(R.id.tabHost);
        tabs.setup();

        TabHost.TabSpec spec1 = tabs.newTabSpec("Tab1");
        spec1.setContent(R.id.tab1);
        spec1.setIndicator("Levels");
        tabs.addTab(spec1);

        TabHost.TabSpec spec2 = tabs.newTabSpec("Tab2");
        spec2.setContent(R.id.tab2);
        spec2.setIndicator("Try");
        tabs.addTab(spec2);

        TabHost.TabSpec spec3 = tabs.newTabSpec("Tab3");
        spec3.setContent(R.id.tab3);
        spec3.setIndicator("More");
        tabs.addTab(spec3);

        level0=(Button) findViewById(R.id.level0id);
        level0.setOnClickListener(this);

        level1=(Button) findViewById(R.id.level1id);
        level1.setOnClickListener(this);

        level2=(Button) findViewById(R.id.level2id);
        level2.setOnClickListener(this);

        level3=(Button) findViewById(R.id.level3id);
        level3.setOnClickListener(this);

        level4=(Button) findViewById(R.id.level4id);
        level4.setOnClickListener(this);

        fac=(Button) findViewById(R.id.faceidid);
        fac.setOnClickListener(this);

        about=(Button) findViewById(R.id.aboutidid);
        about.setOnClickListener(this);

        res=(Button) findViewById(R.id.restidid);
        res.setOnClickListener(this);

        gpa=(Button) findViewById(R.id.gpaididid);
        gpa.setOnClickListener(this);

        sly=(Button) findViewById(R.id.sylid);
        sly.setOnClickListener(this);

        clear=(Button) findViewById(R.id.tryclearid);
        clear.setOnClickListener(this);

        cal=(Button) findViewById(R.id.trycalid);
        cal.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v==level0){
            startActivity(new Intent(this, level0Activity.class));
        }
        else if(v==level1){
            startActivity(new Intent(this, Level1Activity.class));
        }
        else if(v==level2){
            startActivity(new Intent(this, Level2Activity.class));
        }
        else if(v==level3){
            startActivity(new Intent(this, Level3Activity.class));
        }
        else if(v==level4){
            startActivity(new Intent(this, Level4Activity.class));
        }
        else if(v==fac){
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/groups/unihelwan/")));
        }
        else if(v==sly){
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dropbox.com/s/bhw817tbp95vv7u/%D9%84%D8%A7%D8%A6%D8%AD%D8%A9%20%D9%82%D8%B3%D9%85%20%D8%A7%D9%84%D8%A7%D8%AA%D8%B5%D8%A7%D9%84%D8%A7%D8%AA.pdf?dl=0")));
        }
        else if(v==about){
            startActivity(new Intent(this, AboutActivity.class));
        }
        else if(v==gpa){
            startActivity(new Intent(this, CalActivity.class));
        }
        else if(v==clear){

            for(int i=0;i<6;i++){
                arr[i][0]=-1;
                arr[i][1]=-1;
            }

            f=0.0;
            t=0.0;

            tryg1.setSelection(0);
            tryg2.setSelection(0);
            tryg3.setSelection(0);
            tryg4.setSelection(0);
            tryg5.setSelection(0);
            tryg6.setSelection(0);
            tryh1.setSelection(0);
            tryh2.setSelection(0);
            tryh3.setSelection(0);
            tryh4.setSelection(0);
            tryh5.setSelection(0);
            tryh6.setSelection(0);
        }
        else if(v==cal){
            f=0.0;
            t=0.0;
            for(int i=0;i<6;i++)
                if(arr[i][0]>-1&&arr[i][1]>-1){
                    f+=(arr[i][0]*arr[i][1]);
                    t+=arr[i][1];
                }
            double res=0;
            if(t>0) res=f/t;
            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);

            alertBuilder.setTitle("");
            alertBuilder.setMessage("GPA = "+String.format("%.3f",res)+" = "+String.format("%.2f",res));

            DialogInterface.OnClickListener positiveListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            };

            alertBuilder.setPositiveButton("OK", positiveListener);

            AlertDialog alertDialog = alertBuilder.create();
            alertDialog.show();

        }
        else if(v==res){


            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);

            alertBuilder.setTitle("Deleting");
            alertBuilder.setMessage("All grades will be deleted, are you sure?");

            DialogInterface.OnClickListener positiveListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    final ProgressDialog[] progressDialog = new ProgressDialog[1];

                    new AsyncTask<Void, Void, Void>() {

                        @Override
                        protected void onPreExecute() {
                            progressDialog[0] = ProgressDialog.show(MainActivity.this, "", "Deleting...");
                        }

                        @Override
                        protected  Void doInBackground(Void... params) {
                            ArrayList<MySubject> arr=my.getAllSubjects();
                            for(int i=0;i<arr.size();i++)
                                my.updateSubjectByName(arr.get(i).getName(),"--");
                            return null;
                        }

                        @Override
                        protected void onPostExecute(Void args) {
                            progressDialog[0].dismiss();
                        }
                    }.execute();

                }
            };
            DialogInterface.OnClickListener negatuveListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            };

            alertBuilder.setPositiveButton("OK", positiveListener);
            alertBuilder.setNegativeButton("Cancel", negatuveListener);

            AlertDialog alertDialog = alertBuilder.create();
            alertDialog.show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Spinner sp=(Spinner) parent;
        if(sp.getId()==R.id.tryg1id)
            arr[0][0]=(Double)m1.get(position);
        else if(sp.getId()==R.id.tryg2id)
            arr[1][0]=(Double)m1.get(position);
        else if(sp.getId()==R.id.tryg3id)
            arr[2][0]=(Double)m1.get(position);
        else if(sp.getId()==R.id.tryg4id)
            arr[3][0]=(Double)m1.get(position);
        else if(sp.getId()==R.id.tryg5id)
            arr[4][0]=(Double)m1.get(position);
        else if(sp.getId()==R.id.tryg6id)
            arr[5][0]=(Double)m1.get(position);
        else if(sp.getId()==R.id.tryh1id)
            arr[0][1]=(Double)m2.get(position);
        else if(sp.getId()==R.id.tryh2id)
            arr[1][1]=(Double)m2.get(position);
        else if(sp.getId()==R.id.tryh3id)
            arr[2][1]=(Double)m2.get(position);
        else if(sp.getId()==R.id.tryh4id)
            arr[3][1]=(Double)m2.get(position);
        else if(sp.getId()==R.id.tryh5id)
            arr[4][1]=(Double)m2.get(position);
        else if(sp.getId()==R.id.tryh6id)
            arr[5][1]=(Double)m2.get(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
