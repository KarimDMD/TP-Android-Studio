package com.example.karimdamadtp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder> {

    private Context context;
    private List<Character> characterList;

    public CharacterAdapter( Context context,List<Character> characterList) {
        this.context = context;
        this.characterList = characterList;
    }

    @NonNull
    @Override
    public CharacterAdapter.CharacterViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.character_item,
                parent,
                false
        );

        CharacterViewHolder characterViewHolder = new CharacterViewHolder(view);

        return characterViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterAdapter.CharacterViewHolder holder, int position) {

        Character character = characterList.get(position);
        holder.nameText.setText(character.getName());

        Glide.with(context)
                .load(character.getImageUrl())
                .placeholder(R.drawable.placeholder)
                .centerCrop()
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return characterList.size();
    }

    public class CharacterViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView nameText;

        public CharacterViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageUrl);
            nameText = itemView.findViewById(R.id.name);
        }
    }
}
