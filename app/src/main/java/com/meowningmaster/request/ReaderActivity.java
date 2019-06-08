package com.meowningmaster.request;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.meowningmaster.request.book.Book;
import com.meowningmaster.request.book.page.widget.Widget;
import com.meowningmaster.request.book.page.widget.Widgets;
import com.meowningmaster.request.book.page.widget.WidgetsAdapter;
import com.meowningmaster.request.book.page.widget.types.ButtonWidget;
import com.meowningmaster.request.book.page.widget.types.ImageWidget;

import org.json.JSONException;

import java.io.IOException;

public class ReaderActivity extends AppCompatActivity implements Listeners.ItemClickListener, Listeners.CommandListener {
    private Book book;
    private String pageId;
    private Widgets widgets;
    private WidgetsAdapter adapter;
    private RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reader);

        Intent intent = getIntent();
        String file = intent.getStringExtra("file");

        assignViews();

        recycler.setLayoutManager(new LinearLayoutManager(this));

        try {
            book = new Book(this, file);

            if (intent.hasExtra("page")) {
                setPageId(intent.getStringExtra("page"));
            } else {
                setPageId(pageId = book.getStart());
            }
            widgets = book.getPages().get(pageId).getWidgets();
            adapter = new WidgetsAdapter(book, widgets, this);
            recycler.setAdapter(adapter);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
        getIntent().putExtra("page", pageId);
    }

    private void assignViews() {
        recycler = findViewById(R.id.activity_reader__recycler);
    }

    @Override
    public void onClick(View v, int i) {
        Widget widget = widgets.get(i);

        switch (widget.getClass().getSimpleName()) {
            case "ButtonWidget": {
                ButtonWidget buttonWidget = (ButtonWidget) widget;
                buttonWidget.getClick().evaluate(this);
                break;
            }
            case "ImageWidget": {
                ImageWidget imageWidget = (ImageWidget) widget;
                imageWidget.getClick().evaluate(this);
                break;
            }
        }
    }

    @Override
    public void onCommand(String command, Bundle data) {
        switch (command) {
            case "OPEN_PAGE": {
                setPageId(data.getString("PAGE"));
                setWidgets(book.getPages().get(pageId).getWidgets());
                recycler.getAdapter().notifyDataSetChanged();
                recycler.scrollToPosition(0);
            }
        }
    }

    private void setWidgets(Widgets widgets) {
        this.widgets = widgets;
        adapter.setWidgets(widgets);
    }
}
