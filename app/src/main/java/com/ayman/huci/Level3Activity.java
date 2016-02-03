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

public class Level3Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner control,digitalcom,numerical,database,electivei1,software,commnetwork,os,oop,anteann;
    String s[]={"--","A","A-","B+","B","B-","C+","C","C-","D+","D","F"};
    Map m1=new HashMap();
    SubjectsDB my;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level3);

        control=(Spinner) findViewById(R.id.Controlid);
        control.setOnItemSelectedListener(this);

        digitalcom=(Spinner) findViewById(R.id.DigitalCommunicatioid);
        digitalcom.setOnItemSelectedListener(this);

        numerical=(Spinner) findViewById(R.id.Numericalid);
        numerical.setOnItemSelectedListener(this);

        database=(Spinner) findViewById(R.id.Databaseid);
        database.setOnItemSelectedListener(this);

        electivei1=(Spinner) findViewById(R.id.Elective1Iid);
        electivei1.setOnItemSelectedListener(this);

        software=(Spinner) findViewById(R.id.Softwareengineeringid);
        software.setOnItemSelectedListener(this);

        commnetwork=(Spinner) findViewById(R.id.CommunicationNetworkid);
        commnetwork.setOnItemSelectedListener(this);

        os=(Spinner) findViewById(R.id.OperatingSystemsid);
        os.setOnItemSelectedListener(this);

        oop=(Spinner) findViewById(R.id.OOPid);
        oop.setOnItemSelectedListener(this);

        anteann=(Spinner) findViewById(R.id.Anteannaid);
        anteann.setOnItemSelectedListener(this);

        ArrayAdapter<String> sad=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,s);
        control.setAdapter(sad);
        digitalcom.setAdapter(sad);
        numerical.setAdapter(sad);
        database.setAdapter(sad);
        electivei1.setAdapter(sad);
        software.setAdapter(sad);
        commnetwork.setAdapter(sad);
        os.setAdapter(sad);
        oop.setAdapter(sad);
        anteann.setAdapter(sad);

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

        control.setSelection((int)m1.get(my.getSubjectByName("control").getGrade()));
        digitalcom.setSelection((int) m1.get(my.getSubjectByName("digitalcom").getGrade()));
        numerical.setSelection((int)m1.get(my.getSubjectByName("numerical").getGrade()));
        database.setSelection((int)m1.get(my.getSubjectByName("database").getGrade()));
        electivei1.setSelection((int)m1.get(my.getSubjectByName("electivei1").getGrade()));
        software.setSelection((int)m1.get(my.getSubjectByName("software").getGrade()));
        commnetwork.setSelection((int)m1.get(my.getSubjectByName("comnetwork").getGrade()));
        os.setSelection((int)m1.get(my.getSubjectByName("os").getGrade()));
        oop.setSelection((int)m1.get(my.getSubjectByName("oop").getGrade()));
        anteann.setSelection((int)m1.get(my.getSubjectByName("antenna").getGrade()));


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Spinner sp=(Spinner) parent;
        if(sp.getId()==R.id.Controlid)
            my.updateSubjectByName("control",s[position]);
        else if(sp.getId()==R.id.DigitalCommunicatioid)
            my.updateSubjectByName("digitalcom",s[position]);
        else if(sp.getId()==R.id.Numericalid)
            my.updateSubjectByName("numerical",s[position]);
        else if(sp.getId()==R.id.Databaseid)
            my.updateSubjectByName("database",s[position]);
        else if(sp.getId()==R.id.Elective1Iid)
            my.updateSubjectByName("electivei1",s[position]);
        else if(sp.getId()==R.id.Softwareengineeringid)
            my.updateSubjectByName("software",s[position]);
        else if(sp.getId()==R.id.CommunicationNetworkid)
            my.updateSubjectByName("comnetwork",s[position]);
        else if(sp.getId()==R.id.OperatingSystemsid)
            my.updateSubjectByName("os",s[position]);
        else if(sp.getId()==R.id.OOPid)
            my.updateSubjectByName("oop",s[position]);
        else if(sp.getId()==R.id.Anteannaid)
            my.updateSubjectByName("antenna",s[position]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
