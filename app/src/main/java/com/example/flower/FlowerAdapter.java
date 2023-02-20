package com.example.flower;
import android.os.Build;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
public class FlowerAdapter  extends RecyclerView.Adapter<FlowerAdapter.ViewHolder>{
    private List<Flower> mFlowers;

    FlowerAdapter(List<Flower> flowers) {

        this.mFlowers = flowers;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Flower flower = mFlowers.get(position);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            holder.nameTextView.setText(Html.fromHtml(flower.getName(), Html
                    .FROM_HTML_MODE_LEGACY));
        } else {
            holder.nameTextView.setText(Html.fromHtml(flower.getName()));
        }
    }

    @Override
    public int getItemCount() {
        if (mFlowers == null) {
            return 0;
        }
        return mFlowers.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;


        ViewHolder(View itemView) {
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.textView2);

        }
    }
}
