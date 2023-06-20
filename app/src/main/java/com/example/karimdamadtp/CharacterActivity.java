package com.example.karimdamadtp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CharacterActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private CharacterService characterService;
    private Call<CharacterRoot> characterRootCall;
    private static final String BASE_URL = "https://api.disneyapi.dev/";
    private Thread thread;
    private RecyclerView characterRecycler;
    private CharacterAdapter characterAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);

        characterRecycler = findViewById(R.id.characterRecycler);

        layoutManager = new GridLayoutManager(getApplicationContext(), 2);

        retrofit= new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        characterService = retrofit.create(CharacterService.class);

        characterRootCall = characterService.getCharacterList(2);

        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response<CharacterRoot> response = characterRootCall.execute();
                    if (response.isSuccessful()) {
                        List<Character> characterList = response.body().getCharacterList();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                characterAdapter = new CharacterAdapter(
                                        getApplicationContext(),
                                        characterList
                                );

                                characterRecycler.setAdapter(characterAdapter);
                                characterRecycler.setLayoutManager(layoutManager);
                                characterRecycler.setHasFixedSize(true);
                            }
                        });
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.start();
    }
}