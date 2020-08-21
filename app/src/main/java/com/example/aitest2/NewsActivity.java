package com.example.aitest2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.Response;

import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
//import com.google.android.gms.common.api.Response;
import com.google.android.material.textfield.TextInputEditText;


public class NewsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private String[] mDataset = {"1","2"};
    RequestQueue queue; //1-2

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);



        queue=Volley.newRequestQueue(this); //1-3
        getNews(); //초기화후 getNews를 실행해라 //1-7
        //1. 화면 로딩 -> 뉴스 정보 받아온다
        //2. 정보 -> 어댑터에 넘겨준다
        //3. 어댑터 -> 셋팅, 화면에 표시한다
    }


    public void getNews(){
        //1-1. 화면 로딩 -> 뉴스 정보 받아온다 ; volley 간단한 요청 보내기에서 카피후 빨간 맛 수정
        // Instantiate the RequestQueue. 초기화하여 순서대로 처리한다. 1,2,3 주문들어 온대로 쭉쭉 데이터를 빼줌, 위에 전역변수로 빼줬다
        //RequestQueue queue = Volley.newRequestQueue(this);

        //뉴스 api 발급받는 사이트에서 소스 가져와 https://newsapi.org/s/south-korea-news-api
        String url ="http://newsapi.org/v2/top-headlines?country=kr&apiKey=d6c41839a1204c01bb48136320ca9664"; //1-4

        // Request a string response from the provided URL. 주소로 부터 반응을 요청해
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //1-6 Display the first 500 characters of the response string. 스트링 내용들을 500자 내로 가져와라
                        Log.d("News",response); //로그를 가져와서 찍어봐

                        //2-1 정상적으로 처리되면 어댑터로 넘겨줘줘 specif an adapter (see also next example)
                        mAdapter = new MyAdapter(mDataset);
                        recyclerView.setAdapter(mAdapter);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

        //1-5 Add the request to the RequestQueue. queue에다가  stringRequest를 추가해라
        queue.add(stringRequest);


    }

}