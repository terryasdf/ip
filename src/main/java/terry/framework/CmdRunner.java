package terry.framework;

import terry.cmd.Cmd;
import terry.cmd.CmdKeyword;
import terry.cmd.CmdOptArg;
import terry.cmd.CmdParser;
import terry.entity.Deadline;
import terry.entity.Event;
import terry.entity.ToDo;
import terry.exception.MissingOptArgException;
import terry.exception.UnknownCmdKeywordException;
import terry.msg.Msg;
import terry.msg.MsgHandler;

import java.util.ArrayList;

/**
 * Executes commands.
 * <ul>
 * <li>Calls {@link Controller} methods for data access</li>
 * <li>Shows {@link Msg} via {@link MsgHandler}</li>
 */
public class CmdRunner {

    /**
     * Process and execute a {@link String} command.
     * <ul>
     * <li>Returns a {@code false} signal if {@code CmdKeyword.CMD_EXIT} is executed</li>
     * <li>Otherwise returns {@code true}</li>
     */
    public static boolean processAndExecuteCmd(String cmdInput) throws UnknownCmdKeywordException, MissingOptArgException {
        Cmd cmd = CmdParser.parseCmdInput(cmdInput);
        CmdKeyword keyword = cmd.getKeyword();
        ArrayList<CmdOptArg> optArgList = cmd.getOptArgList();
        final int listSize = optArgList.size();

        switch (keyword) {
        case CMD_EXIT:
            MsgHandler.printExitMsg();
            return false;
        case CMD_LIST:
            MsgHandler.printMsgGeneric(Controller.getFormattedToDoInfoList());
            break;
        case CMD_MARK:
            if (listSize == 0) throw new MissingOptArgException(optArgList);
            MsgHandler.printMsgGeneric(Controller.markToDo(optArgList.iterator().next().parseInt() - 1));
            break;
        case CMD_UNMARK:
            if (listSize == 0) throw new MissingOptArgException(optArgList);
            MsgHandler.printMsgGeneric(Controller.unmarkToDo(optArgList.iterator().next().parseInt() - 1));
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
        }

        return true;
    }
}
