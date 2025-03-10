package terry.framework;

import terry.command.Command;
import terry.command.CommandKeyword;
import terry.command.CommandOptionArgument;
import terry.entity.Deadline;
import terry.entity.Event;
import terry.entity.ToDo;
import terry.exception.ExceptionHandler;
import terry.exception.OptionArgumentException;
import terry.message.Message;
import terry.message.MessageHandler;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Executes commands.
 */
public class CommandRunner {

    /**
     * Returns a {@code true} signal if {@code CmdKeyword.CMD_EXIT} is executed, otherwise returns {@code false}.
     * <ul>
     * <li>Calls {@link Controller} methods for data access</li>
     * <li>Shows {@link Message} via {@link MessageHandler}</li>
     * <li>Handles runtime exceptions via {@link ExceptionHandler}</li>
     */
    public static boolean executeCommand(Command cmd) {
        try {
            CommandKeyword keyword = cmd.getKeyword();
            ArrayList<CommandOptionArgument> optArgList = cmd.getOptionArgumentList();

            switch (keyword) {
            case CMD_EXIT:
                MessageHandler.printExitMessage();
                return true;
            case CMD_LIST:
                MessageHandler.printMessageGeneric(Controller.getToDoList());
                break;
            case CMD_MARK:
                CommandOptionArgument.assertLeastOptionCount(optArgList, 1);
                MessageHandler.printMessageGeneric(Controller.markToDo(
                        optArgList.iterator().next().parseInt() - 1));
                break;
            case CMD_UNMARK:
                CommandOptionArgument.assertLeastOptionCount(optArgList, 1);
                MessageHandler.printMessageGeneric(Controller.unmarkToDo(
                        optArgList.iterator().next().parseInt() - 1));
                break;
            case CMD_FIND:
                CommandOptionArgument.assertLeastOptionCount(optArgList, 1);
                MessageHandler.printMessageGeneric(Controller.findToDoByKeyword(
                        optArgList.iterator().next().getArg()));
                break;
            case CMD_DDL:
                Deadline ddl = Deadline.parse(optArgList);
                MessageHandler.printMessageGeneric(Controller.addToDo(ddl));
                break;
            case CMD_EVENT:
                Event event = Event.parse(optArgList);
                MessageHandler.printMessageGeneric(Controller.addToDo(event));
                break;
            case CMD_TODO:
                ToDo todo = ToDo.parse(optArgList);
                MessageHandler.printMessageGeneric(Controller.addToDo(todo));
                break;
            case CMD_DELETE:
                CommandOptionArgument.assertLeastOptionCount(optArgList, 1);
                MessageHandler.printMessageGeneric(Controller.deleteToDo(
                        optArgList.iterator().next().parseInt() - 1));
                break;
            case CMD_SAVE:
                MessageHandler.printMessageGeneric(Controller.saveFile());
                break;
            case CMD_LOAD:
                MessageHandler.printMessageGeneric(Controller.readFile());
                break;
            default:
                break;
            }
        } catch (OptionArgumentException e) {
            ExceptionHandler.handleOptionArgumentException(e);
        } catch (NumberFormatException e) {
            ExceptionHandler.handleNumberFormatException(e);
        } catch (IOException e) {
            ExceptionHandler.handleIOException(e);
        } catch (RuntimeException e) {
            ExceptionHandler.handleRuntimeException(e);
        }

        return false;
    }
}
