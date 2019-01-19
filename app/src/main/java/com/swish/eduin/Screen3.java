package com.swish.eduin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Screen3 extends AppCompatActivity {
    ArrayList<ModuleClass> arrayList;
    ListView list;
    EditText inputSearchS;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen3);
        arrayList = new ArrayList<>();
        list=(ListView)findViewById(R.id.list_item);
        db = new DBHelper(this);

        String type = getIntent().getStringExtra("TYPE");

        arrayList = db.retriveData(type);

        int i;

        for (i = 0; i < arrayList.size(); i++) {

            Log.e("Listofarray", arrayList.get(i).phno + " " + arrayList.get(i).name + " " + arrayList.get(i).location);
        }
        Adaptor adaptor = new Adaptor(Screen3.this, 0);
        list.setAdapter(adaptor);

    }

    class Adaptor extends ArrayAdapter {
        public Adaptor(Context context, int resource)
        {
            super(context, resource);
        }

        @Override
        public int getCount() {
            return arrayList.size();

        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(Screen3.this);
            convertView =inflater.inflate(R.layout.screen31,null);
            ImageView imageView;
            TextView firstName,secondName,thr;
            firstName=(TextView)convertView.findViewById(R.id.Schoolname);
            secondName=(TextView)convertView.findViewById(R.id.Addss);
            thr=(TextView)convertView.findViewById(R.id.contactinfo);
            imageView=(ImageView) convertView.findViewById(R.id.imageView) ;



            firstName.setText(arrayList.get(position).name);
            secondName.setText(arrayList.get(position).location);
            thr.setText(arrayList.get(position).phno);

            // image.setImageResource(R.mipmap.ic_launcher);
            return convertView;

        }


    }

    public void filter(View view){
        Intent intent=new Intent(Screen3.this, Screen4.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.more_tab_menu, menu);

        // return true so that the menu pop up is opened
        return true;
    }
}
