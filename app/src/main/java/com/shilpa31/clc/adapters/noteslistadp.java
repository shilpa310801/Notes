package com.shilpa31.clc.adapters;

import android.content.Context;
import android.location.GnssAntennaInfo;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.shilpa31.clc.Models.Notes;
import com.shilpa31.clc.NotesClickListener;
import com.shilpa31.clc.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class noteslistadp extends RecyclerView.Adapter<NotesViewHolder>{
Context context;
List<Notes> list;
NotesClickListener listener;


 public noteslistadp(Context context, List<Notes> notes, NotesClickListener notesClickListener) {
  this.context = context;
  this.list = list;
  this.listener = listener;
 }

 @NonNull
 @Override
 public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
  return new NotesViewHolder(LayoutInflater.from(context).inflate(R.layout.notes_list,parent,false));
 }

 @RequiresApi(api = Build.VERSION_CODES.M)
 @Override
 public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
holder.textview_title.setText(list.get(position).getTitle());
holder.textview_title.setSelected(true);
holder.textView_notes.setText(list.get(position).getNotes());
holder.textView_date.setText(list.get(position).getDate());
holder.textView_date.setSelected(true);
if(list.get(position).isPinned()){
 holder.imageview_pin.setImageResource(R.drawable.ic_pin);

}
else  {
        holder.imageview_pin.setImageResource(0);
      }

int color_code=getRandomColor();
holder.notes_container.setCardBackgroundColor(holder.itemView.getResources().getColor(color_code,null));
holder.notes_container.setOnClickListener(new View.OnClickListener() {
 @Override
 public void onClick(View v) {
  listener.onClick(list.get(holder.getAdapterPosition()));
 }
});
  holder.notes_container.setOnLongClickListener(new View.OnLongClickListener() {
   @Override
   public boolean onLongClick(View v) {
    listener.onLongClick(list.get(holder.getAdapterPosition()), holder.notes_container);
    return true;
   }
  });
 }
    private int getRandomColor()
    {
  List<Integer> colorcode=new ArrayList<>();

  colorcode.add(R.color.c2);
  colorcode.add(R.color.c3);
  colorcode.add(R.color.c4);
  colorcode.add(R.color.c5);
  colorcode.add(R.color.c6);
  colorcode.add(R.color.black);

  Random random=new Random();
  int random_color=random.nextInt(colorcode.size());
  return random_color;
   }

 @Override
 public int getItemCount() {
  return list.size();
 }
}
class NotesViewHolder extends RecyclerView.ViewHolder  {
   CardView notes_container;
    TextView textview_title,textView_notes,textView_date;
    ImageView imageview_pin;



    public NotesViewHolder(@NonNull View itemView)
    {
       super(itemView);
        notes_container=itemView.findViewById(R.id.notes_container);
        textview_title=itemView.findViewById(R.id.textview_title);
        textView_notes=itemView.findViewById(R.id.textView_notes);
        textView_date=itemView.findViewById(R.id.textView_date);
        imageview_pin=itemView.findViewById(R.id.imageview_pin);



    }
}
