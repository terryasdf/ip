public class TerryService {
    private static String generateErrorInfo(CmdKeyword keyword, String errorInfo) {
        return keyword + ": " + errorInfo;
    }

    private static String generateInfo(MsgString title, String description) {
        return title + "\n\t" + description;
    }


    public static Msg getFormattedToDoInfoList() {
        String[] infoList = TerryController.getFormattedToDoInfoList();
        return new Msg(ReturnStatus.SUCCESS, String.join("\n", infoList));
    }

    public static Msg addToDo(String description) {
        boolean status = TerryController.addToDo(description);
        String info = status ?
                generateInfo(MsgString.CMD_FAILED_MSG, "add: [PLACEHOLDER]Some error") :
                generateInfo(MsgString.ADD_TODO_MSG, description);
        ReturnStatus returnStatus = status ? ReturnStatus.FAILED : ReturnStatus.SUCCESS;
        return new Msg(returnStatus, info);
    }

    public static Msg markToDo(int id) {
        boolean status = TerryController.markToDo(id);
        if (status) {
            String errorInfo = generateErrorInfo(CmdKeyword.CMD_MARK, "[PLACEHOLDER]some error");
            return new Msg(ReturnStatus.FAILED, generateInfo(MsgString.CMD_FAILED_MSG, errorInfo));
        }
        String info = generateInfo(MsgString.MARK_TODO_MSG, TerryController.getFormattedToDoInfo(id));
        return new Msg(ReturnStatus.SUCCESS, info);
    }

    public static Msg unmarkToDo(int id) {
        boolean status = TerryController.unmarkToDo(id);
        if (status) {
            String errorInfo = generateErrorInfo(CmdKeyword.CMD_UNMARK, "[PLACEHOLDER]some error");
            return new Msg(ReturnStatus.FAILED, generateInfo(MsgString.CMD_FAILED_MSG, errorInfo));
        }
        String info = generateInfo(MsgString.UNMARK_TODO_MSG, TerryController.getFormattedToDoInfo(id));
        return new Msg(ReturnStatus.SUCCESS, info);
    }
}
