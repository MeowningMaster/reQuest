package com.meowningmaster.request;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.meowningmaster.request.cover.Covers;
import com.meowningmaster.request.cover.CoversAdapter;

import org.json.JSONException;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements Listeners.ItemClickListener {
    private Covers covers;
    private RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        assignViews();

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            recycler.setLayoutManager(new LinearLayoutManager(this));
        } else {
            recycler.setLayoutManager(new GridLayoutManager(this, 2));
        }

        try {
            covers = new Covers(this);
            CoversAdapter adapter = new CoversAdapter(covers, this);
            recycler.setAdapter(adapter);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void assignViews() {
        recycler = findViewById(R.id.activity_main__recycler);
    }

    @Override
    public void onClick(View v, int i) {
        switch (v.getId()) {
            case R.id.item_cover__card: {
                Intent intent = new Intent(this, ReaderActivity.class);
                intent.putExtra("file", covers.get(i).getFile());
                startActivity(intent);
                break;
            }
        }
    }
}
