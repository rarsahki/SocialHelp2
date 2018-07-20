package com.example.android.socialhelp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.android.socialhelp.WhatsappActivity.request1;

public class FacebookActivity extends AppCompatActivity {
    Intent intent = null;
    public static ArrayList<Requests> arrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook);
        arrayList.clear();
        arrayList.add(new Requests("How to Change DP?",10));
        arrayList.add(new Requests("How to Change Status?",6));
        final CustomArrayAdapter customArrayAdapter = new CustomArrayAdapter(this,arrayList);
        ListView listView = (ListView) findViewById(R.id.activity_facebook);
        listView.setAdapter(customArrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    request1.clear();
                    request1.add(new Requests(R.drawable.facebook));
                    intent = new Intent(FacebookActivity.this,StepsActivity.class);
                    startActivity(intent);
                }
                else if(position == 1){
                    request1.clear();
                    request1.add(new Requests(R.drawable.whatsapp));
                    request1.add(new Requests(R.drawable.facebook));
                    request1.add(new Requests(R.drawable.whatsapp));
                    intent = new Intent(FacebookActivity.this,StepsActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

}
