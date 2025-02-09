package terry.framework;

import terry.cmd.CmdKeyword;
import terry.entity.ToDo;
import terry.msg.Msg;
import terry.msg.MsgString;
import terry.msg.ReturnStatus;

public class Controller {
    private static String generateErrorInfo(CmdKeyword keyword, String errorInfo) {
        return keyword + ": " + errorInfo;
    }

    private static String generateInfo(MsgString title, String description) {
        return title + "\n\t" + description;
    }


    public static Msg getFormattedToDoInfoList() {
        String[] infoList = Service.getFormattedToDoInfoList();

        if (infoList.length == 0) {
            return new Msg(ReturnStatus.SUCCESS, MsgString.LIST_TODO_NONE_MSG.toString());
        }

        StringBuilder ret = new StringBuilder();
        int cnt = 0;
        for (String info : infoList) {
            ret.append(++cnt).append('.').append(info).append('\n');
        }
        return new Msg(ReturnStatus.SUCCESS, MsgString.LIST_TODO_MSG + "\n" + ret.toString());
    }

    public static Msg addToDo(ToDo todo) {
        boolean status = Service.addToDo(todo);
        String info = status ?
                generateInfo(MsgString.CMD_FAILED_MSG, "add: [PLACEHOLDER]Some error") :
                generateInfo(MsgString.ADD_TODO_MSG, todo.toString());
        ReturnStatus returnStatus = status ? ReturnStatus.FAILED : ReturnStatus.SUCCESS;
        return new Msg(returnStatus, info);
    }

    public static Msg markToDo(int id) {
        boolean status = Service.markToDo(id);
        if (status) {
            String errorInfo = generateErrorInfo(CmdKeyword.CMD_MARK, "[PLACEHOLDER]some error");
            return new Msg(ReturnStatus.FAILED, generateInfo(MsgString.CMD_FAILED_MSG, errorInfo));
        }
        String info = generateInfo(MsgString.MARK_TODO_MSG, Service.getFormattedToDoInfo(id));
        return new Msg(ReturnStatus.SUCCESS, info);
    }

    public static Msg unmarkToDo(int id) {
        boolean status = Service.unmarkToDo(id);
        if (status) {
            String errorInfo = generateErrorInfo(CmdKeyword.CMD_UNMARK, "[PLACEHOLDER]some error");
            return new Msg(ReturnStatus.FAILED, generateInfo(MsgString.CMD_FAILED_MSG, errorInfo));
        }
        String info = generateInfo(MsgString.UNMARK_TODO_MSG, Service.getFormattedToDoInfo(id));
        return new Msg(ReturnStatus.SUCCESS, info);
    }
}
