package com.example.geektrust.command;

import com.example.mymoney.exception.CommandNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CommandFactoryTest {

    @Test
    public void testCreateCommand_AllocateCommand() {
        CommandFactory commandFactory = new CommandFactory();
        String inputLine = "ALLOCATE 100.0 200.0 300.0";

        Command command = commandFactory.createCommand(inputLine);

        Assertions.assertTrue(command instanceof AllocateCommand);
    }

    @Test
    public void testCreateCommand_SipCommand() {
        CommandFactory commandFactory = new CommandFactory();
        String inputLine = "SIP 50.0 75.0 100.0";

        Command command = commandFactory.createCommand(inputLine);

        Assertions.assertTrue(command instanceof SipCommand);
    }

    @Test
    public void testCreateCommand_ChangeCommand() {
        CommandFactory commandFactory = new CommandFactory();
        String inputLine = "CHANGE 5.0% 2.5% 3.0% JANUARY";

        Command command = commandFactory.createCommand(inputLine);

        Assertions.assertTrue(command instanceof ChangeCommand);
    }

    @Test
    public void testCreateCommand_BalanceCommand() {
        CommandFactory commandFactory = new CommandFactory();
        String inputLine = "BALANCE JANUARY";

        Command command = commandFactory.createCommand(inputLine);

        Assertions.assertTrue(command instanceof BalanceCommand);
    }

    @Test
    public void testCreateCommand_RebalanceCommand() {
        CommandFactory commandFactory = new CommandFactory();
        String inputLine = "REBALANCE";

        Command command = commandFactory.createCommand(inputLine);

        Assertions.assertTrue(command instanceof RebalanceCommand);
    }

    @Test
    public void testCreateCommand_UnknownCommand() {
        CommandFactory commandFactory = new CommandFactory();
        String inputLine = "UNKNOWN";

        Assertions.assertThrows(CommandNotFoundException.class, () -> {
            commandFactory.createCommand(inputLine);
        });
    }

    @Test
    public void testCreateCommand_InvalidCommandFormat() {
        CommandFactory commandFactory = new CommandFactory();
        String inputLine = "ALLOCATE 100.0";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            commandFactory.createCommand(inputLine);
        });
    }
}
