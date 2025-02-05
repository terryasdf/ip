import java.util.Scanner;

public class TerryFramework {
    private static int parseInt(CmdOptArg optArg) throws NumberFormatException {
        return Integer.parseInt(optArg.getArg());
    }

    private static boolean parseAndExecuteCmd(String cmdInput) throws NumberFormatException {
        Cmd cmd = CmdParser.parseCmdInput(cmdInput);
        CmdKeyword keyword = cmd.getKeyword();
        CmdOptArg[] argList = cmd.getOptArgList().toArray(CmdOptArg[]::new);

        switch (keyword) {
        case CMD_EXIT:
            MsgHandler.printExitMsg();
            return false;
        case CMD_LIST:
            MsgHandler.printMsgGeneric(TerryService.getFormattedToDoInfoList());
            break;
        case CMD_MARK:
            assert argList.length > 0;
            MsgHandler.printMsgGeneric(TerryService.markToDo(parseInt(argList[0]) - 1));
            break;
        case CMD_UNMARK:
            assert argList.length > 0;
            MsgHandler.printMsgGeneric(TerryService.unmarkToDo(parseInt(argList[0]) - 1));
            break;
        default:
            MsgHandler.printMsgGeneric(TerryService.addToDo(cmdInput));
        };

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
                Msg msg = new Msg(ReturnStatus.FAILED);
                MsgHandler.printMsgGeneric(msg);
            }
        }
    }
}
