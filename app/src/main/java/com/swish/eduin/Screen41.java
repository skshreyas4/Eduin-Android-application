package com.swish.eduin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class Screen41 extends AppCompatActivity {
    ArrayList<ModuleClass> arrayList;
    ListView list1;
    List<ModuleClass> list;
    EditText inputSearchS;
    DBHelper db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen41);
        arrayList = new ArrayList<>();
        list1 = (ListView) findViewById(R.id.list_item);
        String location=getIntent().getStringExtra("spinner1");
        String syallabus=getIntent().getStringExtra("spinner2");
        String category=getIntent().getStringExtra("spinner3");
        db = new DBHelper(this);
        List<FilterClass> filter = new ArrayList<>();
        db=new DBHelper(this);
        
        list=db.getAllNotes(location,syallabus,category);

        int i;

        for (i = 0; i < list.size(); i++) {

            Log.e("Listofarray", list.get(i).phno + " " + list.get(i).name + " " + list.get(i).location);
        }
        Screen41.Adaptor adaptor = new Screen41.Adaptor(Screen41.this, 0);
        list1.setAdapter(adaptor);

    }

    class Adaptor extends ArrayAdapter {
        public Adaptor(Context context, int resource) {
            super(context, resource);
        }

        @Override
        public int getCount() {
            return list.size();

        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(Screen41.this);
            convertView = inflater.inflate(R.layout.screen42, null);
            ImageView imageView;
            TextView firstName, secondName, thr;
            firstName = (TextView) convertView.findViewById(R.id.Schoolname);
            secondName = (TextView) convertView.findViewById(R.id.Addss);
            thr = (TextView) convertView.findViewById(R.id.contactinfo);
            imageView = (ImageView) convertView.findViewById(R.id.imageView);


            firstName.setText(list.get(position).getName());
            secondName.setText(list.get(position).getLocation());
            thr.setText(list.get(position).getPhno());

            // image.setImageResource(R.mipmap.ic_launcher);
            return convertView;

        }


    }


}