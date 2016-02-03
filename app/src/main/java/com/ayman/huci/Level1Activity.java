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

public class Level1Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner math2,physic2,analogue1,circuit,huamn,environ,digital,filed,mecahnics,techniques,analogue2;
    String s[]={"--","A","A-","B+","B","B-","C+","C","C-","D+","D","F"};
    Map m1=new HashMap();
    SubjectsDB my;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);

        math2=(Spinner) findViewById(R.id.math2id);
        math2.setOnItemSelectedListener(this);

        physic2=(Spinner) findViewById(R.id.physics2id);
        physic2.setOnItemSelectedListener(this);

        analogue1=(Spinner) findViewById(R.id.analogue1id);
        analogue1.setOnItemSelectedListener(this);

        circuit=(Spinner) findViewById(R.id.circuitid);
        circuit.setOnItemSelectedListener(this);

        huamn=(Spinner) findViewById(R.id.humanid);
        huamn.setOnItemSelectedListener(this);

        environ=(Spinner) findViewById(R.id.environmid);
        environ.setOnItemSelectedListener(this);

        digital=(Spinner) findViewById(R.id.digitaleleid);
        digital.setOnItemSelectedListener(this);

        filed=(Spinner) findViewById(R.id.filedid);
        filed.setOnItemSelectedListener(this);

        mecahnics=(Spinner) findViewById(R.id.mechanicsid);
        mecahnics.setOnItemSelectedListener(this);

        techniques=(Spinner) findViewById(R.id.protechid);
        techniques.setOnItemSelectedListener(this);

        analogue2=(Spinner) findViewById(R.id.analogue2id);
        analogue2.setOnItemSelectedListener(this);

        ArrayAdapter<String> sad=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,s);
        math2.setAdapter(sad);
        physic2.setAdapter(sad);
        analogue1.setAdapter(sad);
        circuit.setAdapter(sad);
        huamn.setAdapter(sad);
        environ.setAdapter(sad);
        digital.setAdapter(sad);
        filed.setAdapter(sad);
        mecahnics.setAdapter(sad);
        techniques.setAdapter(sad);
        analogue2.setAdapter(sad);

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

        math2.setSelection((int)m1.get(my.getSubjectByName("math2").getGrade()));
        physic2.setSelection((int) m1.get(my.getSubjectByName("physics2").getGrade()));
        analogue1.setSelection((int)m1.get(my.getSubjectByName("analogue1").getGrade()));
        circuit.setSelection((int)m1.get(my.getSubjectByName("circuit").getGrade()));
        huamn.setSelection((int)m1.get(my.getSubjectByName("human").getGrade()));
        environ.setSelection((int)m1.get(my.getSubjectByName("environmetanl").getGrade()));
        digital.setSelection((int)m1.get(my.getSubjectByName("digitalele").getGrade()));
        filed.setSelection((int)m1.get(my.getSubjectByName("field").getGrade()));
        mecahnics.setSelection((int)m1.get(my.getSubjectByName("mechanics").getGrade()));
        techniques.setSelection((int)m1.get(my.getSubjectByName("progtech").getGrade()));
        analogue2.setSelection((int)m1.get(my.getSubjectByName("analogue2").getGrade()));

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Spinner sp=(Spinner) parent;
        if(sp.getId()==R.id.math2id)
            my.updateSubjectByName("math2",s[position]);
        else if(sp.getId()==R.id.physics2id)
            my.updateSubjectByName("physics2",s[position]);
        else if(sp.getId()==R.id.analogue1id)
            my.updateSubjectByName("analogue1",s[position]);
        else if(sp.getId()==R.id.circuitid)
            my.updateSubjectByName("circuit",s[position]);
        else if(sp.getId()==R.id.humanid)
            my.updateSubjectByName("human",s[position]);
        else if(sp.getId()==R.id.environmid)
            my.updateSubjectByName("environmetanl",s[position]);
        else if(sp.getId()==R.id.digitaleleid)
            my.updateSubjectByName("digitalele",s[position]);
        else if(sp.getId()==R.id.filedid)
            my.updateSubjectByName("field",s[position]);
        else if(sp.getId()==R.id.mechanicsid)
            my.updateSubjectByName("mechanics",s[position]);
        else if(sp.getId()==R.id.protechid)
            my.updateSubjectByName("progtech",s[position]);
        else if(sp.getId()==R.id.analogue2id)
            my.updateSubjectByName("analogue2",s[position]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
