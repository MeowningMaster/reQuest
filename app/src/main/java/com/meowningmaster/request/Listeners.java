package com.meowningmaster.request;

import android.os.Bundle;
import android.view.View;

public class Listeners {
    public interface ItemClickListener {
        public void onClick(View v, int i);
    }

    public interface CommandListener {
        public void onCommand(String command, Bundle data);
    }
}
