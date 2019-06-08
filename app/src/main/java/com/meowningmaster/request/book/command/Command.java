package com.meowningmaster.request.book.command;

import android.os.Bundle;

import com.meowningmaster.request.Listeners;
import com.meowningmaster.request.Part;

public class Command {
    public String asString() {
        return command;
    }

    private String command;

    public Command(String command) {
        this.command = command;
    }

    public void evaluate(Listeners.CommandListener commandListener) {
        Part part = new Part(command);

        switch (part.first) {
            case "OPEN": {
                Part openPart = new Part(part.second);

                switch (openPart.first) {
                    case "PAGE": {
                        Bundle data = new Bundle();
                        data.putString("PAGE",openPart.second);
                        commandListener.onCommand("OPEN_PAGE", data);
                    }
                }
            }
        }
    }
}
