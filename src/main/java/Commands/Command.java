package Commands;

import Application.IllegalCommandUsageException;
import Application.MyState;

//TODO: make an interface out of me that is usable for all commands
//TODO: apply polymorphism
public interface Command {
    void execute(MyState state) throws IllegalCommandUsageException;

    void setTail(String part, int length);
}
