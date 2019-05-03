package com.example.fragmentsdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Fragment1.I   {

    Button b1,b2,b3,b4;
    EditText et1;
    ViewPager vp;
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1= (Button)findViewById(R.id.but1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        b4=(Button)findViewById(R.id.b4);
        et1=(EditText)findViewById(R.id.et1);

        vp=findViewById(R.id.vp);

        adapter = new MyAdapter(getSupportFragmentManager());
        vp.setAdapter(adapter);

    }

    public void dothis(View view)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        switch (view.getId())
        {
            case R.id.but1:
                Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
                //ft.add(R.id.frag,new Fragment1(),"One");
                //ft.add(R.id.frag,Fragment1.getInstance(et1.getText().toString()));
                break;
            case R.id.b2:
                Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
                //ft.add(R.id.frag,new Fragment2(),"Two");
                break;
            case R.id.b3:
                Toast.makeText(this, "3", Toast.LENGTH_SHORT).show();
                Fragment f = getSupportFragmentManager().findFragmentByTag("Two");
                if (f!=null)
                 //   ft.replace(R.id.frag,new Fragment3(),"Three");
                break;
            case R.id.b4:
                Fragment f1 = getSupportFragmentManager().findFragmentByTag("One");
                if (f1!=null)
                    ft.remove(f1);
                break;
            case R.id.but5:
                //ft.add(R.id.frag,Fragment1.getInstance(et1.getText().toString()));
                break;
        }
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        if(vp.getCurrentItem()== 0)
        super.onBackPressed();
        else
        {
            vp.setCurrentItem(vp.getCurrentItem()-1);
        }
    }

    @Override
    public void getValues(String s1, String s2) {
        Fragment3 f3 = (Fragment3)getSupportFragmentManager().findFragmentById(R.id.frag3);
        f3.update(s1,s2);
    }
}
