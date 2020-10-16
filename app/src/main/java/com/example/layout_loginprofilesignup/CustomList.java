package com.example.layout_loginprofilesignup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomList extends AppCompatActivity {
    ListView lv;
    String mTitle[] = {"Android","Java","PHP","Python","MySQL"};
    String mDesc[] = {"Android Description", "Java Description", "PHP Description", "Python Description", "MySQL Description"};
    int img[] = {R.drawable.android,R.drawable.java,R.drawable.php,R.drawable.python,R.drawable.mysql};
    ImageView iv,iv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);
        iv = (ImageView) findViewById(R.id.next);
        iv1 = (ImageView) findViewById(R.id.pre1);
        lv = findViewById(R.id.List);

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CustomList.this, ProfileActivity.class);
                startActivity(i);
            }
        });
        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CustomList.this, MainActivity.class);
                startActivity(i);
            }
        });
        myAdapter adapter = new myAdapter(this, mTitle, mDesc, img);
        lv.setAdapter(adapter);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    Toast.makeText(CustomList.this, "Android Description", Toast.LENGTH_SHORT).show();
                }
                if (position == 0){
                    Toast.makeText(CustomList.this, "Java Description", Toast.LENGTH_SHORT).show();
                }
                if (position == 0){
                    Toast.makeText(CustomList.this, "PHP Description", Toast.LENGTH_SHORT).show();
                }
                if (position == 0){
                    Toast.makeText(CustomList.this, "Python Description", Toast.LENGTH_SHORT).show();
                }
                if (position == 0){
                    Toast.makeText(CustomList.this, "MySQL Description", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    class myAdapter extends ArrayAdapter<String> {
        Context ct;
        String rTitle[];
        String rDesc[];
        int rImg[];

        myAdapter(Context c, String title[], String desc[], int images[]){
            super(c, R.layout.rowlist, R.id.tv1, title);
            this.ct = c;
            this.rTitle = title;
            this.rDesc = desc;
            this.rImg = images;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater li = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = li.inflate(R.layout.rowlist,parent,false);
            ImageView imgs = row.findViewById(R.id.anh);
            TextView myTitle = row.findViewById(R.id.tv1);
            TextView myDesc  = row.findViewById(R.id.tv2);

            imgs.setImageResource(rImg[position]);
            myTitle.setText(rTitle[position]);
            myDesc.setText(rDesc[position]);

            return row;
        }
    }
}