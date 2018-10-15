package gorental.com.day13ext2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import gorental.com.day13ext2.Interface.ItemClickListener;

class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

    TextView textView;
    ItemClickListener itemClickListener;

    public RecyclerViewHolder(View itemView) {
        super(itemView);

        textView = itemView.findViewById(R.id.textDescription);

        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v, getAdapterPosition(), false);
    }

    @Override
    public boolean onLongClick(View v) {
        itemClickListener.onClick(v, getAdapterPosition(), true);
        return true;
    }
}
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder>{

    Context context;
    List<String> list = new ArrayList<>();

    public RecyclerAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.sample_layout, parent, false);
        return new RecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
      holder.textView.setText(list.get(position));
      holder.setItemClickListener(new ItemClickListener() {
          @Override
          public void onClick(View view, int position, boolean isLongClick) {
              if (isLongClick)
              {
                  Toast.makeText(context, "Long Click: "+list.get(position), Toast.LENGTH_SHORT).show();
              }else {
                  Toast.makeText(context, " "+list.get(position), Toast.LENGTH_SHORT).show();
              }
          }
      });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
