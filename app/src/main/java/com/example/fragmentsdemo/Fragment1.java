package com.example.fragmentsdemo;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {
EditText ed1,ed2;
Button b1;
I i1;
TextView tv;
ImageView iv;

    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v1 = inflater.inflate(R.layout.fragment_fragment1, container, false);
        ed1 = v1.findViewById(R.id.edit);
        ed2 = v1.findViewById(R.id.edit1);
        b1 = v1.findViewById(R.id.b5);
        tv = v1.findViewById(R.id.tv);
        iv = v1.findViewById(R.id.image);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = ed1.getText().toString();
                String s2 = ed2.getText().toString();
                i1.getValues(s1,s2);
            }
        });

        Bundle b= getArguments();
        if(b!=null)
        {
            String text = b.getString("Key1");
            tv.setText(text);
            int image = b.getInt("Key2");
            iv.setImageResource(image);

        }

        return v1;
    }


    static Fragment1 getInstance(int a,String s)
    {
        Fragment1 f1 = new Fragment1();
        Bundle b = new Bundle();

        b.putString("Key1",s);
        b.putInt("Key2",a);
        f1.setArguments(b);

        return f1;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        i1 =(I)context;
    }

    interface I
    {
        void getValues(String s1,String s2);
    }

}
