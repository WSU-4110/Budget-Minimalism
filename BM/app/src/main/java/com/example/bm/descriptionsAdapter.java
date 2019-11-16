package com.example.bm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import androidx.recyclerview.widget.RecyclerView;

public class descriptionsAdapter extends RecyclerView.Adapter<descriptionsAdapter.descriptionsHolder> {

    class descriptionsHolder extends RecyclerView.ViewHolder {
        private final TextView objectView;

        private descriptionsHolder(View itemView) {
            super(itemView);
            objectView = itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater mInflater;
    private List<description> mDescriptions; // Cached copy of words

    descriptionsAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public descriptionsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new descriptionsHolder(itemView);
    }

    @Override
    public void onBindViewHolder(descriptionsHolder holder, int position) {
        if (mDescriptions != null) {
            description current = mDescriptions.get(position);
            holder.objectView.setText(current.getDescription());
        } else {
            // Covers the case of data not being ready yet.
            holder.objectView.setText("NULL");
        }
    }

    void setWords(List<description> words) {
        mDescriptions = words;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mDescriptions != null)
            return mDescriptions.size();
        else return 0;
    }
}
