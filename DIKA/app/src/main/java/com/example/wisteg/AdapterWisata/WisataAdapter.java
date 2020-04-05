package com.example.wisteg.AdapterWisata;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wisteg.Detail;
import com.example.wisteg.ModelData.Wisata;
import com.example.wisteg.R;

import java.util.List;

/**
 * Created by root on 2/3/17.
 */

public class WisataAdapter extends RecyclerView.Adapter<WisataAdapter.MyViewHolder>{
    List<Wisata> wst;


    public WisataAdapter(List<Wisata> DaftarWisata) {
        wst = DaftarWisata;
    }

    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent,int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_daftar_wisata, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder (MyViewHolder holder, int position){
        holder.mTextViewNama.setText(wst.get(position).getTitle());
        holder.getmTextViewProv.setText(wst.get(position).getProvinsi());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), Detail.class);
                mIntent.putExtra("ID", wst.get(position).getId());
                mIntent.putExtra("Nama", wst.get(position).getTitle());
                mIntent.putExtra("Lat", wst.get(position).getLat());
                mIntent.putExtra("Lng", wst.get(position).getLng());
                mIntent.putExtra("Foto", wst.get(position).getFoto());
                mIntent.putExtra("Provinsi", wst.get(position).getProvinsi());
                mIntent.putExtra("Deskripsi", wst.get(position).getDeskripsi());
                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount () {
        return wst.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView  mTextViewNama, getmTextViewProv;
        public ImageView mTextViewFoto;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewNama = (TextView) itemView.findViewById(R.id.tvNama);
            getmTextViewProv = (TextView) itemView.findViewById(R.id.tvNama2);
            mTextViewFoto = (ImageView) itemView.findViewById(R.id.fotoku);
        }
    }
}
