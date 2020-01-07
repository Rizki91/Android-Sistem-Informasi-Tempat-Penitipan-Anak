package com.example.tempatpenitipan.adapterlistener;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tempatpenitipan.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HariAdapter extends
        RecyclerView.Adapter<HariAdapter.ViewHolder> {

    private static final String TAG = HariAdapter.class.getSimpleName();

    private Context context;
    private List<Hari> list;
    private HariAdapterCallback mAdapterCallback;


    public HariAdapter(Context context, List<Hari> list, HariAdapterCallback adapterCallback) {
        this.context = context;
        this.list = list;
        this.mAdapterCallback = adapterCallback;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hari,
                parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Hari item = list.get(position);


        String nama = item.getNama();

        holder.tvNama.setText(nama);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void clear() {
        int size = this.list.size();
        this.list.clear();
        notifyItemRangeRemoved(0, size);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.tvNama)
        TextView tvNama;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);


            /*
            Inisialisasi onclick pada itemview dan memanggil interface yang sudah kita buat tadi.
             */
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*
                    Memanggil interface dan juga methodnya. getAdapterPosition ini adalah method bawaan
                    adapter untuk memanggil index posisi.
                     */
                    mAdapterCallback.onRowHariAdapterClicked(getAdapterPosition());



                }
            });
        }
    }

    /*
    interface sebagai listener onclick adapter ke parent activity
     */
    public interface HariAdapterCallback {
        /*
        Disini kalian bisa membuat beberapa fungsi dengan parameter sesuai kebutuhan. Kebutuhan
        disini adalah untuk mendapatkan pada posisi mana user mengklik listnya.
         */
        void onRowHariAdapterClicked(int position);

    }
}