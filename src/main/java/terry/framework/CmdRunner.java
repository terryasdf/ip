package terry.framework;

import terry.cmd.Cmd;
import terry.cmd.CmdKeyword;
import terry.cmd.CmdOptArg;
import terry.entity.Deadline;
import terry.entity.Event;
import terry.entity.ToDo;
import terry.exception.ExceptionHandler;
import terry.exception.MissingOptArgException;
import terry.exception.OptArgException;
import terry.msg.Msg;
import terry.msg.MsgHandler;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Executes commands.
 */
public class CmdRunner {

    /**
     * Returns a {@code false} signal if {@code CmdKeyword.CMD_EXIT} is executed, otherwise returns {@code true}.
     * <ul>
     * <li>Calls {@link Controller} methods for data access</li>
     * <li>Shows {@link Msg} via {@link MsgHandler}</li>
     * <li>Handles runtime exceptions via {@link ExceptionHandler}</li>
     */
    public static boolean executeCmd(Cmd cmd) {
        try {
            CmdKeyword keyword = cmd.getKeyword();
            ArrayList<CmdOptArg> optArgList = cmd.getOptArgList();
            final int listSize = optArgList.size();

            switch (keyword) {
            case CMD_EXIT:
                MsgHandler.printExitMsg();
                return false;
            case CMD_LIST:
                MsgHandler.printMsgGeneric(Controller.getToDoList());
                break;
            case CMD_MARK:
                if (listSize == 0) throw new MissingOptArgException(optArgList);
                MsgHandler.printMsgGeneric(Controller.markToDo(optArgList.iterator().next().parseInt() - 1));
                break;
            case CMD_UNMARK:
                if (listSize == 0) throw new MissingOptArgException(optArgList);
                MsgHandler.printMsgGeneric(Controller.unmarkToDo(optArgList.iterator().next().parseInt() - 1));
                break;
            case CMD_FIND:
                if (listSize == 0) throw new MissingOptArgException(optArgList);
                MsgHandler.printMsgGeneric(Controller.findToDoByKeyword(optArgList.iterator().next().getArg()));
                break;
            case CMD_DDL:
                Deadline ddl = Deadline.parse(optArgList);
                MsgHandler.printMsgGeneric(Controller.addToDo(ddl));
                break;
            case CMD_EVENT:
                Event event = Event.parse(optArgList);
                MsgHandler.printMsgGeneric(Controller.addToDo(event));
                break;
            case CMD_TODO:
                ToDo todo = ToDo.parse(optArgList);
                MsgHandler.printMsgGeneric(Controller.addToDo(todo));
                break;
            case CMD_DELETE:
                if (listSize == 0) throw new MissingOptArgException(optArgList);
                MsgHandler.printMsgGeneric(Controller.deleteToDo(optArgList.iterator().next().parseInt() - 1));
                break;
            case CMD_SAVE:
                MsgHandler.printMsgGeneric(Controller.saveFile());
                break;
            case CMD_LOAD:
                MsgHandler.printMsgGeneric(Controller.readFile());
                break;
            }
        } catch (OptArgException e) {
            ExceptionHandler.handleArgException(e);
        } catch (NumberFormatException e) {
            ExceptionHandler.handleNumberFormatException(e);
        } catch (IOException e) {
            ExceptionHandler.handleIOException(e);
        } catch (RuntimeException e) {
            ExceptionHandler.handleRuntimeException(e);
        }

        return true;
    }
}
