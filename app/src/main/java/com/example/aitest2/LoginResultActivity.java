package com.example.aitest2;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;


public class LoginResultActivity extends AppCompatActivity {

    TextView TextViewGet;/* 2.선언*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);/* 1.화면매칭*/

        TextViewGet=findViewById(R.id.TextViewGet);/* 3.값을 찾아오고*/

        Intent intent=getIntent();/* 4.intent는 값을 주고받는데 쓰자라는 규약.*/
        Bundle bundle = intent.getExtras();/* 5.엑스트라들을 번들로 값을 가져온다*/
        String Email = bundle.getString("Email");/* 6.번들에서 스트링을 가져온다*/
        String Password = bundle.getString("Password");
        TextViewGet.setText(Email+"/"+Password);/*6.불러온것을 출력해줘*/

    }
}