package com.shilpa31.clc;

import androidx.cardview.widget.CardView;

import com.shilpa31.clc.Models.Notes;

public interface NotesClickListener {
void onCick(Notes notes);
void onLongClick(Notes notes, CardView cardView);

    void onClick(Notes notes);
}
