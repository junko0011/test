package com.example.aitest2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
/*3.전역변수에 대한 import*/

import com.google.android.material.textfield.TextInputEditText;
import android.widget.RelativeLayout;
public class MainActivity extends AppCompatActivity {

/*2.전역변수 지정*/
    TextInputEditText TextInputEditTextEmail, TextInputEditTextPassword;
    RelativeLayout RelativeLayout_Login, RelativeLayout_Inroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);/* 1.화면매칭*/

/*4.전역변수와 소스매칭시키기 (전역변수와 소스 이름 같게하여 편리하게) / activity login에서 소스 찾아와! 이름은 R.id.이거야*/
        TextInputEditTextEmail=findViewById(R.id.TextInputEditTextEmail);
        TextInputEditTextPassword=findViewById(R.id.TextInputEditTextPassword);
        RelativeLayout_Login=findViewById(R.id.RelativeLayout_Login);
        RelativeLayout_Inroll=findViewById(R.id.RelativeLayout_Inroll);

/*5. 1)값을 가져온다. 2)클릭을 감지한다. 3)1번의 값을 다음 엑티비티(화면)으로 넘긴다.

        RelativeLayout_Login.setClickable(true);/*클릭이 가능한 녀석을 세팅한다 / setOnClickListener는 클릭을 감지하면 어떻게 하겠다*/
        RelativeLayout_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = TextInputEditTextEmail.getText().toString();/* 텍스트 가져온걸 스트링(문자)으로 바꿔줘*/
                String Password = TextInputEditTextPassword.getText().toString();

                /*아래 4개 함수에 의해 스트링받은 걸 LoginResultActivity로 넘긴다*/
                Intent intent=new Intent(MainActivity.this, LoginResultActivity.class); /*intent값을 주고받음 MainActivity 에서 LoginResultActivity로 보내라*/
                intent.putExtra("Email",Email); /*값 가져온걸 intent로 들고 있어라*/
                intent.putExtra("Password",Password);
                startActivity(intent);


            }
        });
    }
}