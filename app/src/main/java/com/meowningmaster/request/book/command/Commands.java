package com.meowningmaster.request.book.command;

import com.meowningmaster.request.Listeners;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class Commands {
    public Command get(int i) {
        return commands.get(i);
    }

    public int count() {
        return commands.size();
    }

    private ArrayList<Command> commands;

    public Commands(JSONArray json) throws JSONException {
        commands = new ArrayList<>();

        if (json != null) {
            for (int i = 0; i < json.length(); i++) {
                commands.add(new Command(json.getString(i)));
            }
        }
    }

    public void evaluate(Listeners.CommandListener commandListener) {
        for (Command command : commands) {
            command.evaluate(commandListener);
        }
    }
}
