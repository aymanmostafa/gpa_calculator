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

public class Level2Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner probability,signal,data,complex,archic,discrete,micro,comm,measuem,technical;
    String s[]={"--","A","A-","B+","B","B-","C+","C","C-","D+","D","F"};
    Map m1=new HashMap();
    SubjectsDB my;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level2);

        probability=(Spinner) findViewById(R.id.Probabilityid);
        probability.setOnItemSelectedListener(this);

        signal=(Spinner) findViewById(R.id.Signalid);
        signal.setOnItemSelectedListener(this);

        data=(Spinner) findViewById(R.id.Datastructurid);
        data.setOnItemSelectedListener(this);

        complex=(Spinner) findViewById(R.id.Complexid);
        complex.setOnItemSelectedListener(this);

        archic=(Spinner) findViewById(R.id.Computerarchitectureid);
        archic.setOnItemSelectedListener(this);

        discrete=(Spinner) findViewById(R.id.Discreteid);
        discrete.setOnItemSelectedListener(this);

        micro=(Spinner) findViewById(R.id.Microprocessorid);
        micro.setOnItemSelectedListener(this);

        comm=(Spinner) findViewById(R.id.Communicationtechnologiesid);
        comm.setOnItemSelectedListener(this);

        measuem=(Spinner) findViewById(R.id.Measuramentid);
        measuem.setOnItemSelectedListener(this);

        technical=(Spinner) findViewById(R.id.Technicalwritingid);
        technical.setOnItemSelectedListener(this);

        ArrayAdapter<String> sad=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,s);
        probability.setAdapter(sad);
        signal.setAdapter(sad);
        data.setAdapter(sad);
        complex.setAdapter(sad);
        archic.setAdapter(sad);
        discrete.setAdapter(sad);
        micro.setAdapter(sad);
        comm.setAdapter(sad);
        measuem.setAdapter(sad);
        technical.setAdapter(sad);

        my=new SubjectsDB(this);
        m1.put("--", 0);
        m1.put("A", 1);
        m1.put("A-", 2);
        m1.put("B+", 3);
        m1.put("B", 4);
        m1.put("B-", 5);
        m1.put("C+", 6);
        m1.put("C", 7);
        m1.put("C-", 8);
        m1.put("D+", 9);
        m1.put("D", 10);
        m1.put("F", 11);

        probability.setSelection((int)m1.get(my.getSubjectByName("probability").getGrade()));
        signal.setSelection((int) m1.get(my.getSubjectByName("signal").getGrade()));
        data.setSelection((int)m1.get(my.getSubjectByName("datastructure").getGrade()));
        complex.setSelection((int)m1.get(my.getSubjectByName("complex").getGrade()));
        archic.setSelection((int)m1.get(my.getSubjectByName("computerarch").getGrade()));
        discrete.setSelection((int)m1.get(my.getSubjectByName("discrete").getGrade()));
        micro.setSelection((int)m1.get(my.getSubjectByName("microprocessor").getGrade()));
        comm.setSelection((int)m1.get(my.getSubjectByName("comtech").getGrade()));
        measuem.setSelection((int)m1.get(my.getSubjectByName("measurment").getGrade()));
        technical.setSelection((int)m1.get(my.getSubjectByName("techwriting").getGrade()));

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Spinner sp=(Spinner) parent;
        if(sp.getId()==R.id.Probabilityid)
            my.updateSubjectByName("probability",s[position]);
        else if(sp.getId()==R.id.Signalid)
            my.updateSubjectByName("signal",s[position]);
        else if(sp.getId()==R.id.Datastructurid)
            my.updateSubjectByName("datastructure",s[position]);
        else if(sp.getId()==R.id.Complexid)
            my.updateSubjectByName("complex",s[position]);
        else if(sp.getId()==R.id.Computerarchitectureid)
            my.updateSubjectByName("computerarch",s[position]);
        else if(sp.getId()==R.id.Discreteid)
            my.updateSubjectByName("discrete",s[position]);
        else if(sp.getId()==R.id.Microprocessorid)
            my.updateSubjectByName("microprocessor",s[position]);
        else if(sp.getId()==R.id.Communicationtechnologiesid)
            my.updateSubjectByName("comtech",s[position]);
        else if(sp.getId()==R.id.Measuramentid)
            my.updateSubjectByName("measurment",s[position]);
        else if(sp.getId()==R.id.Technicalwritingid)
            my.updateSubjectByName("techwriting",s[position]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
