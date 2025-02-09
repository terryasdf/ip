package terry.framework;

import terry.cmd.Cmd;
import terry.cmd.CmdKeyword;
import terry.cmd.CmdOptArg;
import terry.cmd.CmdParser;
import terry.entity.Deadline;
import terry.entity.Event;
import terry.entity.ToDo;
import terry.msg.Msg;
import terry.msg.MsgHandler;
import terry.msg.ReturnStatus;
import java.util.Scanner;

public class Framework {
    private static boolean parseAndExecuteCmd(String cmdInput) {
        Cmd cmd = CmdParser.parseCmdInput(cmdInput);
        CmdKeyword keyword = cmd.getKeyword();
        CmdOptArg[] optArgList = cmd.getOptArgList().toArray(CmdOptArg[]::new);

        switch (keyword) {
        case CMD_EXIT:
            MsgHandler.printExitMsg();
            return false;
        case CMD_LIST:
            MsgHandler.printMsgGeneric(Service.getFormattedToDoInfoList());
            break;
        case CMD_MARK:
            assert optArgList.length > 0;
            MsgHandler.printMsgGeneric(Service.markToDo(optArgList[0].parseInt() - 1));
            break;
        case CMD_UNMARK:
            assert optArgList.length > 0;
            MsgHandler.printMsgGeneric(Service.unmarkToDo(optArgList[0].parseInt() - 1));
            break;
        case CMD_DDL:
            Deadline ddl = Deadline.parse(optArgList);
            MsgHandler.printMsgGeneric(Service.addToDo(ddl));
            break;
        case CMD_EVENT:
            Event event = Event.parse(optArgList);
            MsgHandler.printMsgGeneric(Service.addToDo(event));
            break;
        case CMD_TODO:
            ToDo todo = ToDo.parse(optArgList);
            MsgHandler.printMsgGeneric(Service.addToDo(todo));
            break;
        default:
            throw new RuntimeException("Unknown command");
        }

        return true;
    }

    public static void runCLI() {
        MsgHandler.printGreetingMsg();
        Scanner in = new Scanner(System.in);

        while (true) {
            try {
                String cmdInput = in.nextLine().strip();
                if (cmdInput.length() == 0) continue;
                if (parseAndExecuteCmd(cmdInput)) continue;

                in.close();
                return;
            } catch (NumberFormatException nfe) {
                Msg msg = new Msg(ReturnStatus.FAILED, "Not a number");
                MsgHandler.printMsgGeneric(msg);
            } catch (RuntimeException e) {
                Msg msg = new Msg(ReturnStatus.FAILED, e.getMessage());
                MsgHandler.printMsgGeneric(msg);
            }
        }
    }
}
