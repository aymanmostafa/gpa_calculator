package com.ayman.huci;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CalActivity extends AppCompatActivity {

    TextView gpaall,gpa0,gpa1,gpa2,gpa3,gpa4;
    double all=0,zero=0,one=0,two=0,three=0,four=0,sumd0=0,sumd1=0,sumd2=0,sumd3=0,sumd4=0;
    int sum0=0,sum1=0,sum2=0,sum3=0,sum4=0,s0=0,s1=0,s2=0,s3=0,s4=0,h0=0,h1=0,h2=0,h3=0,h4=0;
    ArrayList<MySubject> arr;
    SubjectsDB my;
    Map m1=new HashMap();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal);

        m1.put("A",4.0);
        m1.put("A-",3.7);
        m1.put("B+",3.3);
        m1.put("B",3.0);
        m1.put("B-",2.7);
        m1.put("C+",2.3);
        m1.put("C",2.0);
        m1.put("C-",1.7);
        m1.put("D+",1.3);
        m1.put("D",1.0);
        m1.put("F",0.0);
        gpaall=(TextView) findViewById(R.id.gpaallid);
        gpa0=(TextView) findViewById(R.id.gpa0id);
        gpa1=(TextView) findViewById(R.id.gpa1id);
        gpa2=(TextView) findViewById(R.id.gpa2id);
        gpa3=(TextView) findViewById(R.id.gpa3id);
        gpa4=(TextView) findViewById(R.id.gpa4id);

        my=new SubjectsDB(this);

        arr=my.getAllSubjects();

        for(int i=0;i<arr.size();i++) {
            if (!arr.get(i).getGrade().equals("--")){
                if (i >= 0 && i <= 10) {
                   if(!arr.get(i).getGrade().equals("F")) {
                       s0++;
                       h0+=arr.get(i).getHours();
                   }
                    sum0 += arr.get(i).getHours();
                    sumd0 += ((arr.get(i).getHours()) * (double) (m1.get(arr.get(i).getGrade())));
                } else if (i >= 11 && i <= 21) {
                    if(!arr.get(i).getGrade().equals("F")) {
                        s1++;
                        h1+=arr.get(i).getHours();
                    }
                    sum1 += arr.get(i).getHours();
                    sumd1 += ((arr.get(i).getHours()) * (double) (m1.get(arr.get(i).getGrade())));

                } else if (i >= 22 && i <= 31) {
                    if(!arr.get(i).getGrade().equals("F")) {
                        s2++;
                        h2+=arr.get(i).getHours();
                    }
                    sum2 += arr.get(i).getHours();
                    sumd2 += ((arr.get(i).getHours()) * (double) (m1.get(arr.get(i).getGrade())));

                } else if (i >= 32 && i <= 41) {
                    if(!arr.get(i).getGrade().equals("F")) {
                        s3++;
                        h3+=arr.get(i).getHours();
                    }
                    sum3 += arr.get(i).getHours();
                    sumd3 += ((arr.get(i).getHours()) * (double) (m1.get(arr.get(i).getGrade())));

                } else if (i >= 42 && i <= 53) {
                    if(!arr.get(i).getGrade().equals("F")) {
                        s4++;
                        h4+=arr.get(i).getHours();
                    }
                    sum4 += arr.get(i).getHours();
                    sumd4 += ((arr.get(i).getHours()) * (double) (m1.get(arr.get(i).getGrade())));

                }

            }
        }
        if((sum0+sum1+sum2+sum3+sum4)>0) all=(sumd0+sumd1+sumd2+sumd3+sumd4)/(sum0+sum1+sum2+sum3+sum4);
        if(sum0>0) zero=sumd0/sum0;
        if(sum1>0) one=sumd1/sum1;
        if(sum2>0) two=sumd2/sum2;
        if(sum3>0) three=sumd3/sum3;
        if(sum4>0) four=sumd4/sum4;
       /* Double vall=new BigDecimal(all).setScale(2,BigDecimal.ROUND_UP).doubleValue();
        Double vzero=new BigDecimal(zero).setScale(2,BigDecimal.ROUND_UP).doubleValue();
        Double vone=new BigDecimal(one).setScale(2,BigDecimal.ROUND_UP).doubleValue();
        Double vtwo=new BigDecimal(two).setScale(2,BigDecimal.ROUND_UP).doubleValue();
        Double vthree=new BigDecimal(three).setScale(2,BigDecimal.ROUND_UP).doubleValue();
        Double vfour=new BigDecimal(four).setScale(2,BigDecimal.ROUND_UP).doubleValue();*/
        gpaall.setText("overall GPA= "+String.format("%.3f",all)+" = "+String.format("%.2f",all)+"\nfinished subjects= "+(s0+s1+s2+s3+s4)+"\nremained subjects= "+(54-(s0+s1+s2+s3+s4))+"\nfinished hours= "+(h0+h1+h2+h3+h4)+"\nremained hours= "+(180-(h0+h1+h2+h3+h4))+"\n**(GP1&GP2 are counted in hours and subjects)");
        gpa0.setText("GPA= "+String.format("%.3f",zero)+" = "+String.format("%.2f",zero)+"\nfinished subjects= "+(s0)+"\nremained subjects= "+(11-(s0))+"\nfinished hours= "+(h0)+"\nremained hours= "+(36-(h0))+"\n");
        gpa1.setText("GPA= "+String.format("%.3f",one)+" = "+String.format("%.2f",one)+"\nfinished subjects= "+(s1)+"\nremained subjects= "+(11-(s1))+"\nfinished hours= "+(h1)+"\nremained hours= "+(37-(h1))+"\n");
        gpa2.setText("GPA= "+String.format("%.3f",two)+" = "+String.format("%.2f",two)+"\nfinished subjects= "+(s2)+"\nremained subjects= "+(10-(s2))+"\nfinished hours= "+(h2)+"\nremained hours= "+(36-(h2))+"\n");
        gpa3.setText("GPA= "+String.format("%.3f",three)+" = "+String.format("%.2f",three)+"\nfinished subjects= "+(s3)+"\nremained subjects= "+(10-(s3))+"\nfinished hours= "+(h3)+"\nremained hours= "+(36-(h3))+"\n");
        gpa4.setText("GPA= "+String.format("%.3f",four)+" = "+String.format("%.2f",four)+"\nfinished subjects= "+(s4)+"\nremained subjects= "+(12-(s4))+"\nfinished hours= "+(h4)+"\nremained hours= "+(35-(h4))+"\n");

    }

}
