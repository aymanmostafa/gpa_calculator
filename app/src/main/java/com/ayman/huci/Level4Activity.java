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

public class Level4Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner electivei2,dsp,electiveii1,infor,electiveii2,gp1,electiveii3,electiveii4,electiveii5,electiveii6,electiveii7,gp2;
    String s[]={"--","A","A-","B+","B","B-","C+","C","C-","D+","D","F"};
    Map m1=new HashMap();
    SubjectsDB my;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level4);

        electivei2=(Spinner) findViewById(R.id.ElectiveI2id);
        electivei2.setOnItemSelectedListener(this);

        dsp=(Spinner) findViewById(R.id.DSPid);
        dsp.setOnItemSelectedListener(this);

        electiveii1=(Spinner) findViewById(R.id.ElectiveII1id);
        electiveii1.setOnItemSelectedListener(this);

        infor=(Spinner) findViewById(R.id.Informationid);
        infor.setOnItemSelectedListener(this);

        electiveii2=(Spinner) findViewById(R.id.ElectiveII2id);
        electiveii2.setOnItemSelectedListener(this);

        gp1=(Spinner) findViewById(R.id.GP1id);
        gp1.setOnItemSelectedListener(this);

        electiveii3=(Spinner) findViewById(R.id.ElectiveII3id);
        electiveii3.setOnItemSelectedListener(this);

        electiveii4=(Spinner) findViewById(R.id.ElectiveII4id);
        electiveii4.setOnItemSelectedListener(this);

        electiveii5=(Spinner) findViewById(R.id.ElectiveII5id);
        electiveii5.setOnItemSelectedListener(this);

        electiveii6=(Spinner) findViewById(R.id.ElectiveII6id);
        electiveii6.setOnItemSelectedListener(this);

        electiveii7=(Spinner) findViewById(R.id.ElectiveII7id);
        electiveii7.setOnItemSelectedListener(this);

        gp2=(Spinner) findViewById(R.id.gp2id);
        gp2.setOnItemSelectedListener(this);


        ArrayAdapter<String> sad=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,s);
        electivei2.setAdapter(sad);
        dsp.setAdapter(sad);
        electiveii1.setAdapter(sad);
        infor.setAdapter(sad);
        electiveii2.setAdapter(sad);
        gp1.setAdapter(sad);
        electiveii3.setAdapter(sad);
        electiveii4.setAdapter(sad);
        electiveii5.setAdapter(sad);
        electiveii6.setAdapter(sad);
        electiveii7.setAdapter(sad);
        gp2.setAdapter(sad);

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

        electivei2.setSelection((int) m1.get(my.getSubjectByName("electivei2").getGrade()));
        dsp.setSelection((int) m1.get(my.getSubjectByName("dsp").getGrade()));
        electiveii1.setSelection((int) m1.get(my.getSubjectByName("electiveii1").getGrade()));
        infor.setSelection((int)m1.get(my.getSubjectByName("information").getGrade()));
        electiveii2.setSelection((int)m1.get(my.getSubjectByName("electiveii2").getGrade()));
        gp1.setSelection((int)m1.get(my.getSubjectByName("gp1").getGrade()));
        electiveii3.setSelection((int)m1.get(my.getSubjectByName("electiveii3").getGrade()));
        electiveii4.setSelection((int)m1.get(my.getSubjectByName("electiveii4").getGrade()));
        electiveii5.setSelection((int)m1.get(my.getSubjectByName("electiveii5").getGrade()));
        electiveii6.setSelection((int)m1.get(my.getSubjectByName("electiveii6").getGrade()));
        electiveii7.setSelection((int)m1.get(my.getSubjectByName("electiveii7").getGrade()));
        gp2.setSelection((int)m1.get(my.getSubjectByName("gp2").getGrade()));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Spinner sp=(Spinner) parent;

        if(sp.getId()==R.id.ElectiveI2id)
            my.updateSubjectByName("electivei2",s[position]);
        else if(sp.getId()==R.id.DSPid)
            my.updateSubjectByName("dsp",s[position]);
        else if(sp.getId()==R.id.ElectiveII1id)
            my.updateSubjectByName("electiveii1",s[position]);
        else if(sp.getId()==R.id.Informationid)
            my.updateSubjectByName("information",s[position]);
        else if(sp.getId()==R.id.ElectiveII2id)
            my.updateSubjectByName("electiveii2",s[position]);
        else if(sp.getId()==R.id.GP1id)
            my.updateSubjectByName("gp1",s[position]);
        else if(sp.getId()==R.id.ElectiveII3id)
            my.updateSubjectByName("electiveii3",s[position]);
        else if(sp.getId()==R.id.ElectiveII4id)
            my.updateSubjectByName("electiveii4",s[position]);
        else if(sp.getId()==R.id.ElectiveII5id)
            my.updateSubjectByName("electiveii5",s[position]);
        else if(sp.getId()==R.id.ElectiveII6id)
            my.updateSubjectByName("electiveii6",s[position]);
        else if(sp.getId()==R.id.ElectiveII7id)
            my.updateSubjectByName("electiveii7",s[position]);
        else if(sp.getId()==R.id.gp2id)
            my.updateSubjectByName("gp2",s[position]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
