package com.meowningmaster.request.book.page.widget;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.meowningmaster.request.Listeners;
import com.meowningmaster.request.R;
import com.meowningmaster.request.book.Book;
import com.meowningmaster.request.book.image.Image;
import com.meowningmaster.request.book.page.widget.types.ButtonWidget;
import com.meowningmaster.request.book.page.widget.types.HeaderWidget;
import com.meowningmaster.request.book.page.widget.types.ImageWidget;
import com.meowningmaster.request.book.page.widget.types.TextWidget;

import org.jetbrains.annotations.NotNull;

public class WidgetsAdapter extends RecyclerView.Adapter<WidgetsAdapter.ViewHolder> {
    private Book book;
    private Widgets widgets;
    private Listeners.ItemClickListener itemClickListener;

    public WidgetsAdapter(Book book, @NotNull Widgets widgets, Listeners.ItemClickListener itemClickListener) {
        this.book = book;
        this.widgets = widgets;
        this.itemClickListener = itemClickListener;
    }

    @Override
    public int getItemViewType(int position) {
        switch (widgets.get(position).getClass().getSimpleName()) {
            case "HeaderWidget": return 0;
            case "TextWidget": return 1;
            case "ButtonWidget": return 2;
            case "ImageWidget": return 3;
            default: return -1;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        switch (i) {
            case 0: {
                TextView v = new TextView(viewGroup.getContext());
                v.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                v.setTextSize(TypedValue.COMPLEX_UNIT_SP, 36);
                v.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                v.setPadding(16, 16, 16, 16);
                /*v.setShadowLayer(5, 2, 1, Color.WHITE);*/
                return new HeaderViewHolder(v);
            }
            case 1: {
                TextView v = new TextView(viewGroup.getContext());
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    v.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);
                }
                v.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
                v.setPadding(16, 16, 16, 16);
                return new TextViewHolder(v);
            }
            case 2: {
                Button v = new Button(viewGroup.getContext());
                ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );
                ViewGroup.MarginLayoutParams p = new ViewGroup.MarginLayoutParams(params);
                p.setMargins(16, 8, 16, 8);
                v.setLayoutParams(p);
                v.setBackground(viewGroup.getResources().getDrawable(R.drawable.button_borderless));
                v.setAllCaps(false);
                return new ButtonViewHolder(v);
            }
            case 3: {
                ImageView v = new ImageView(viewGroup.getContext());
                ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        600
                );
                ViewGroup.MarginLayoutParams p = new ViewGroup.MarginLayoutParams(params);
                p.setMargins(16, 8, 16, 8);
                v.setLayoutParams(p);
                v.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return new ImageViewHolder(v);
            }
            default: {
                View v = new View(viewGroup.getContext());
                return new ViewHolder(v);
            }
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Widget widget = widgets.get(i);

        switch (widget.getClass().getSimpleName()) {
            case "HeaderWidget": {
                HeaderViewHolder headerViewHolder = (HeaderViewHolder) viewHolder;
                HeaderWidget headerWidget = (HeaderWidget) widget;

                headerViewHolder.header.setText(headerWidget.getText());
                break;
            }
            case "TextWidget": {
                TextViewHolder textViewHolder = (TextViewHolder) viewHolder;
                TextWidget textWidget = (TextWidget) widget;

                textViewHolder.text.setText(textWidget.getText());
                break;
            }
            case "ButtonWidget": {
                ButtonViewHolder buttonViewHolder = (ButtonViewHolder) viewHolder;
                ButtonWidget buttonWidget = (ButtonWidget) widget;

                buttonViewHolder.button.setText(buttonWidget.getText());
                break;
            }
            case "ImageWidget": {
                ImageViewHolder imageViewHolder = (ImageViewHolder) viewHolder;
                ImageWidget imageWidget = (ImageWidget) widget;

                Image image = book.getImages().get(imageWidget.getImage());
                imageViewHolder.image.setImageBitmap(image.asBitmap());
                break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return widgets.count();
    }

    public void setWidgets(Widgets widgets) {
        this.widgets = widgets;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    class HeaderViewHolder extends WidgetsAdapter.ViewHolder {
        TextView header;

        HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            header = (TextView) itemView;
        }
    }

    class TextViewHolder extends WidgetsAdapter.ViewHolder {
        TextView text;

        TextViewHolder(@NonNull View itemView) {
            super(itemView);
            text = (TextView) itemView;
        }
    }

    class ButtonViewHolder extends WidgetsAdapter.ViewHolder implements View.OnClickListener {
        Button button;

        ButtonViewHolder(@NonNull View itemView) {
            super(itemView);
            button = (Button) itemView;
            button.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v, getAdapterPosition());
        }
    }

    class ImageViewHolder extends WidgetsAdapter.ViewHolder implements View.OnClickListener {
        ImageView image;

        ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            image = (ImageView) itemView;
            image.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v, getAdapterPosition());
        }
    }
}
