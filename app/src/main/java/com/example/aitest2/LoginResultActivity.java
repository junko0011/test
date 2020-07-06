package com.example.aitest2;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;


public class LoginResultActivity extends AppCompatActivity {

    TextView TextViewGet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);/* 1.화면매칭*/

        TextViewGet=findViewById(R.id.TextViewGet);

        Intent intent=getIntent();
        Bundle bundle = intent.getExtras();/* 엑스트라들을 먼저 가져온뒤 값을 꺼내온다*/
        String Email = bundle.getString("Email");
        String Password = bundle.getString("Password");
        TextViewGet.setText(Email+"/"+Password);/* 불러온것을 출력해줘*/

    }
}