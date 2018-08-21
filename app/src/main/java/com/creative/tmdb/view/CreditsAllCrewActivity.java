package com.creative.tmdb.view;

import android.os.Bundle;
import android.view.MenuItem;

import com.creative.tmdb.R;
import com.creative.tmdb.adapter.CreditsAllCrewAdapter;
import com.creative.tmdb.model.CreditsSeeAllCrewImpl;
import com.creative.tmdb.presenter.CreditsSeeAllCrew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CreditsAllCrewActivity extends AppCompatActivity implements CreditsSeeAllCrew {

    private RecyclerView rvCredits;
    private CreditsSeeAllCrewImpl creditsSeeAllCrew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_crew);

        getSupportActionBar().setTitle(getResources().getString(R.string.title_activity_credits_all_crew));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rvCredits = findViewById(R.id.rv_credits);
        rvCredits.setItemAnimator(new DefaultItemAnimator());
        rvCredits.setLayoutManager(new GridLayoutManager(getBaseContext(), 2));

        creditsSeeAllCrew = new CreditsSeeAllCrewImpl(this, getBaseContext());
        creditsSeeAllCrew.loadAllCrewMembers(getIntent().getIntExtra("movie_id", -1));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home :
                finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setCrewAdapter(CreditsAllCrewAdapter crewAdapter) {
        rvCredits.setAdapter(crewAdapter);
    }
}
