package com.example.wisteg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Detail extends Activity {

    TextView name, prov, deskripsi, lokasi;
    ImageView  tempat;
    String Lat, Lng, id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        name = (TextView) findViewById(R.id.name_name);
        prov = (TextView) findViewById(R.id.prov_prov);
        lokasi = findViewById(R.id.lokasi_lokasi);
        deskripsi = findViewById(R.id.deskripsi_deskripsi);
        tempat = findViewById(R.id.fotoku);

        Intent mIntent = getIntent();
        id = mIntent.getStringExtra("ID");
        String link = mIntent.getStringExtra("Foto");
        String fotoku = String.valueOf(link);

        Picasso.with(this).load(fotoku).into(tempat);
        prov.setText(mIntent.getStringExtra("Provinsi"));
        name.setText(mIntent.getStringExtra("Nama"));
        deskripsi.setText(mIntent.getStringExtra("Deskripsi"));
        Lat = mIntent.getStringExtra("Lat");
        Lng = mIntent.getStringExtra("Lng");

        lokasi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V) {
                Intent A = new Intent(Detail.this, Map.class);
                A.putExtra("Lat", Lat);
                A.putExtra("Lng", Lng);
                V.getContext().startActivity(A);
            }

        });
    }
}
