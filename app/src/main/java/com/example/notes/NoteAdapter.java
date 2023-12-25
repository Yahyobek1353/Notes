package com.example.notes;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {

    private LayoutInflater inflater;
    private List<Note> list = new ArrayList<>();

    public NoteAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
    }

    public void addNote(Note note){
        list.add(note);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        holder.onBaind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView, desc, data;
        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_add);
            textView= itemView.findViewById(R.id.tae);
            desc= itemView.findViewById(R.id.tae2);
            data= itemView.findViewById(R.id.Data_et);


        }
        protected void onBaind(Note note){
            textView.setText(note.getTitle());
            desc.setText(note.getDeskription());
            data.setText(note.getData());
        }
    }
}
