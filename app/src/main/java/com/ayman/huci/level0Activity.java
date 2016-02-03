package com.ayman.huci;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.HashMap;
import java.util.Map;

public class level0Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner math1,intro,english,chemistry,drawing,linear,physics1,economics,humanities,italian,pro;
    String s[]={"--","A","A-","B+","B","B-","C+","C","C-","D+","D","F"};
    Map m1=new HashMap();
    SubjectsDB my;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level0);

        math1=(Spinner) findViewById(R.id.math1id);
        math1.setOnItemSelectedListener(this);

        intro=(Spinner) findViewById(R.id.introid);
        intro.setOnItemSelectedListener(this);

        english=(Spinner) findViewById(R.id.englishid);
        english.setOnItemSelectedListener(this);

        chemistry=(Spinner) findViewById(R.id.chemistryid);
        chemistry.setOnItemSelectedListener(this);

        drawing=(Spinner) findViewById(R.id.drawingid);
        drawing.setOnItemSelectedListener(this);

        linear=(Spinner) findViewById(R.id.linearid);
        linear.setOnItemSelectedListener(this);

        physics1=(Spinner) findViewById(R.id.physics1id);
        physics1.setOnItemSelectedListener(this);

        economics=(Spinner) findViewById(R.id.economicsid);
        economics.setOnItemSelectedListener(this);

        humanities=(Spinner) findViewById(R.id.humanitiesid);
        humanities.setOnItemSelectedListener(this);

        italian=(Spinner) findViewById(R.id.italianid);
        italian.setOnItemSelectedListener(this);

        pro=(Spinner) findViewById(R.id.productionid);
        pro.setOnItemSelectedListener(this);


        ArrayAdapter<String> sad=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,s);
        math1.setAdapter(sad);
        intro.setAdapter(sad);
        english.setAdapter(sad);
        chemistry.setAdapter(sad);
        drawing.setAdapter(sad);
        linear.setAdapter(sad);
        physics1.setAdapter(sad);
        economics.setAdapter(sad);
        humanities.setAdapter(sad);
        italian.setAdapter(sad);
        pro.setAdapter(sad);

        my=new SubjectsDB(this);
        m1.put("--", 0);
        m1.put("A",1);
        m1.put("A-",2);
        m1.put("B+",3);
        m1.put("B",4);
        m1.put("B-",5);
        m1.put("C+",6);
        m1.put("C",7);
        m1.put("C-",8);
        m1.put("D+",9);
        m1.put("D",10);
        m1.put("F", 11);

        math1.setSelection((int)m1.get(my.getSubjectByName("math1").getGrade()));
        intro.setSelection((int) m1.get(my.getSubjectByName("intro").getGrade()));
        english.setSelection((int)m1.get(my.getSubjectByName("english").getGrade()));
        chemistry.setSelection((int)m1.get(my.getSubjectByName("chemistry").getGrade()));
        drawing.setSelection((int)m1.get(my.getSubjectByName("drawing").getGrade()));
        linear.setSelection((int)m1.get(my.getSubjectByName("linear").getGrade()));
        physics1.setSelection((int)m1.get(my.getSubjectByName("physics1").getGrade()));
        economics.setSelection((int)m1.get(my.getSubjectByName("economics").getGrade()));
        humanities.setSelection((int)m1.get(my.getSubjectByName("humanities").getGrade()));
        italian.setSelection((int)m1.get(my.getSubjectByName("italian").getGrade()));
        pro.setSelection((int)m1.get(my.getSubjectByName("production").getGrade()));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Spinner sp=(Spinner) parent;
        if(sp.getId()==R.id.math1id)
            my.updateSubjectByName("math1",s[position]);
        else if(sp.getId()==R.id.introid)
            my.updateSubjectByName("intro",s[position]);
        else if(sp.getId()==R.id.englishid)
            my.updateSubjectByName("english",s[position]);
        else if(sp.getId()==R.id.chemistryid)
            my.updateSubjectByName("chemistry",s[position]);
        else if(sp.getId()==R.id.drawingid)
            my.updateSubjectByName("drawing",s[position]);
        else if(sp.getId()==R.id.linearid)
            my.updateSubjectByName("linear",s[position]);
        else if(sp.getId()==R.id.physics1id)
            my.updateSubjectByName("physics1",s[position]);
        else if(sp.getId()==R.id.economicsid)
            my.updateSubjectByName("economics",s[position]);
        else if(sp.getId()==R.id.humanitiesid)
            my.updateSubjectByName("humanities",s[position]);
        else if(sp.getId()==R.id.italianid)
            my.updateSubjectByName("italian",s[position]);
        else if(sp.getId()==R.id.productionid)
            my.updateSubjectByName("production",s[position]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
