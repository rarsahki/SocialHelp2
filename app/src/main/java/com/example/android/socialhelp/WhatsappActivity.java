package com.example.android.socialhelp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WhatsappActivity extends AppCompatActivity {
    Intent intent;
    public static ArrayList<Requests> request1 = new ArrayList<>();
    public static ArrayList<Requests> arrayList = new ArrayList<>();
    public ListView listView;
    public CustomArrayAdapter customArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whatsapp);
        final Retrofit.Builder builder = new Retrofit.Builder().
                baseUrl("http://api.jsonbin.io").addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        fetchWhatsAppList gotapi = retrofit.create(fetchWhatsAppList.class);
        Call<Appmodel> call = gotapi.getWhList();
        arrayList.clear();
        call.enqueue(new Callback<Appmodel>() {
            @Override
            public void onResponse(Call<Appmodel> call, Response<Appmodel> response) {
                int i = response.body().getWhapp().size();
                for(int j=0;j<i;j++){
                    arrayList.add(new Requests(response.body().getWhapp().get(j).getTitle(),
                            response.body().getWhapp().get(j).getUrl(),response.body().getWhapp().get(j).getSteps()));
                }
                customArrayAdapter = new CustomArrayAdapter(WhatsappActivity.this,arrayList);
                listView = (ListView) findViewById(R.id.activity_whatsapp);
                listView.setAdapter(customArrayAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Requests requests = (Requests) parent.getItemAtPosition(position);
                        Intent intent = new Intent(WhatsappActivity.this,StepsActivity.class);
                        Bundle bundle = new Bundle();
                        Log.v("URL",requests.getMurl());
                        bundle.putString("url",requests.getMurl());
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onFailure(Call<Appmodel> call, Throwable t) {

            }
        });
        //arrayList.add(new Requests("How to Change DP?",5));
        //arrayList.add(new Requests("How to Change Status?",6));

       /* try {
            FileInputStream fileInputStream = openFileInput("mytext");
                while (fileInputStream.read() != -1){
                    temp = temp + Character.toString((char)fileInputStream.read());
                    Log.v("Main",temp);
                }
                arrayList.clear();
                arrayList.add(new Requests(temp,add.steps));

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }*/

        /*for (int i = 0; i < getCounts(); i++){
            String help = getHelp(i);
            int steps = getSteps(i);
            if(help != null && steps != 0)
                arrayList.add(new Requests(help,steps));
            else
                break;
        }*/
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
       //     @Override
        //    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //        Requests requests = customArrayAdapter.getItem(position);

                /*if(position == 0){
                    request1.clear();
                    request1.add(new Requests(R.drawable.w1_1));
                    request1.add(new Requests(R.drawable.w1_2));
                    request1.add(new Requests(R.drawable.w1_3));
                    request1.add(new Requests(R.drawable.w1_4));
                    request1.add(new Requests(R.drawable.w1_5));
                    intent = new Intent(WhatsappActivity.this,StepsActivity.class);
                    startActivity(intent);
                }
                else if(position == 1){
                    request1.clear();
                    request1.add(new Requests(R.drawable.w2_1));
                    request1.add(new Requests(R.drawable.w2_2));
                    request1.add(new Requests(R.drawable.w2_3));
                    request1.add(new Requests(R.drawable.w2_4));
                    request1.add(new Requests(R.drawable.w2_5));
                    request1.add(new Requests(R.drawable.w2_6));
                    intent = new Intent(WhatsappActivity.this,StepsActivity.class);
                    startActivity(intent);
                }*/
                /*String[] help = {requests.getmRequest()};
                Log.v("Main",getCounts1(help)+"");
                for(int i = 0; i < getCounts1(help); i++){
                    byte[] image = getImage(help,i);
                    Bitmap bitmap = BitmapFactory.decodeByteArray(image,0,image.length);
                    request1.add(new Requests(bitmap));
                    intent = new Intent(WhatsappActivity.this,StepsActivity.class);
                    startActivity(intent);
                }*/

            }
        //});

   // }
}
    /*private int getCounts(){
        TableContract tableContract = new TableContract(this);
        SQLiteDatabase sqLiteDatabase = tableContract.getReadableDatabase();
        String[] column = {Table.WhatsAppTable.COLUMN_HELP, Table.WhatsAppTable.COULMN_STEPS};
        Cursor cursor = sqLiteDatabase.query(Table.WhatsAppTable.TABLE_NAME,column,null,null,null,null,null);
        try{
            int count = cursor.getCount();
            return count;}
        finally {
            cursor.close();
        }
    }
    private String getHelp(int i){
        TableContract tableContract = new TableContract(this);
        SQLiteDatabase sqLiteDatabase = tableContract.getReadableDatabase();
        String[] column = {Table.WhatsAppTable.COLUMN_HELP, Table.WhatsAppTable.COULMN_STEPS};
        Cursor cursor = sqLiteDatabase.query(Table.WhatsAppTable.TABLE_NAME,column,null,null,null,null,null);
        try{
            cursor.moveToPosition(i);
            String help = cursor.getString(cursor.getColumnIndex(Table.WhatsAppTable.COLUMN_HELP));
            return help;}
        finally {
            cursor.close();
        }
    }
    private int getSteps(int i){
        TableContract tableContract = new TableContract(this);
        SQLiteDatabase sqLiteDatabase = tableContract.getReadableDatabase();
        String[] column = {Table.WhatsAppTable.COLUMN_HELP, Table.WhatsAppTable.COULMN_STEPS};
        Cursor cursor = sqLiteDatabase.query(Table.WhatsAppTable.TABLE_NAME,column,null,null,null,null,null);
        try{

            cursor.moveToPosition(i);
            int steps = cursor.getInt(cursor.getColumnIndex(Table.WhatsAppTable.COULMN_STEPS));
            return steps;
        }
        finally {

            cursor.close();
        }
    }

    private int getCounts1(String[] help){
        TableContract tableContract = new TableContract(this);
        SQLiteDatabase sqLiteDatabase = tableContract.getReadableDatabase();
        String[] column = {Table.ImageTable.COLUMN_HELP, Table.ImageTable.COLUMN_IMAGE};
        String selection = Table.ImageTable.COLUMN_HELP + "=?";
        String[] strings = new String[1];
        strings[0] = help[0];
        Cursor cursor = sqLiteDatabase.query(Table.ImageTable.TABLE_NAME,column,null,null,null,null,null);
        try{
            int count = cursor.getCount();
            return count;}
        finally {
            cursor.close();
        }
    }
    private byte[] getImage(String[] help,int i){
        TableContract tableContract = new TableContract(this);
        SQLiteDatabase sqLiteDatabase = tableContract.getReadableDatabase();
        String[] column = {Table.ImageTable.COLUMN_IMAGE};
        String selection = Table.ImageTable.COLUMN_HELP + "=?";
        String[] strings = new String[1];
        strings[0] = help[0];
        Cursor cursor = sqLiteDatabase.query(Table.ImageTable.TABLE_NAME,column,selection,strings,null,null,null);
        try{
            byte[] image = cursor.getBlob(i);
            return image;
            }
        finally {
            cursor.close();
        }
    }
    }*/

