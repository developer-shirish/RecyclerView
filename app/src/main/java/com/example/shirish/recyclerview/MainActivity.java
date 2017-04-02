package com.example.shirish.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements onClickListner{

    private MovieAdapter movieAdapter;
    private ArrayList<Movies> moviesArrayList;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        moviesArrayList = new ArrayList<Movies>();
        movieAdapter = new MovieAdapter(moviesArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new RecyclerDivider(getApplicationContext()));
        recyclerView.setAdapter(movieAdapter);

        prepareMovieData();


        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Movies movie = moviesArrayList.get(position);
                Toast.makeText(getApplicationContext(), movie.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {
           }

        }));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void prepareMovieData(){
        Movies movie = new Movies("Mad Max: Fury Road", "Action & Adventure", "2015");
        moviesArrayList.add(movie);

        movie = new Movies("Inside Out", "Animation, Kids & Family", "2015");
        moviesArrayList.add(movie);

        movie = new Movies("Star Wars: Episode VII - The Force\nAwakens", "Action", "2015");
        moviesArrayList.add(movie);

        movie = new Movies("Shaun the Sheep", "Animation", "2015");
        moviesArrayList.add(movie);

        movie = new Movies("The Martian", "Science Fiction & Fantasy", "2015");
        moviesArrayList.add(movie);

        movie = new Movies("Mission: Impossible Rogue Nation", "Action", "2015");
        moviesArrayList.add(movie);

        movie = new Movies("Up", "Animation", "2009");
        moviesArrayList.add(movie);

        movie = new Movies("Star Trek", "Science Fiction", "2009");
        moviesArrayList.add(movie);

        movie = new Movies("The LEGO Movies", "Animation", "2014");
        moviesArrayList.add(movie);

        movie = new Movies("Iron Man", "Action & Adventure", "2008");
        moviesArrayList.add(movie);

        movie = new Movies("Aliens", "Science Fiction", "1986");
        moviesArrayList.add(movie);

        movie = new Movies("Chicken Run", "Animation", "2000");
        moviesArrayList.add(movie);

        movie = new Movies("Back to the Future", "Science Fiction", "1985");
        moviesArrayList.add(movie);

        movie = new Movies("Raiders of the Lost Ark", "Action & Adventure", "1981");
        moviesArrayList.add(movie);

        movie = new Movies("Goldfinger", "Action & Adventure", "1965");
        moviesArrayList.add(movie);

        movie = new Movies("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
        moviesArrayList.add(movie);

        movieAdapter.notifyDataSetChanged();

    }



}
