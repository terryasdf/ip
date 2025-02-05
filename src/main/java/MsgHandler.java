public class MsgHandler {
    public static void printInfoList(String[] infoList) {
        int cnt = 0;

        System.out.println(MsgString.SPLIT_LINE);
        for (String info : infoList) {
            System.out.println(++cnt + ". " + info);
        }
        System.out.println(MsgString.SPLIT_LINE);
    }

    public static void printGreetingMsg() {
        System.out.println(MsgString.SPLIT_LINE);
        System.out.println(MsgString.GREETING_MSG);
        System.out.println(MsgString.SPLIT_LINE);
    }

    public static void printExitMsg() {
        System.out.println(MsgString.SPLIT_LINE);
        System.out.println(MsgString.EXIT_MSG);
        System.out.println(MsgString.SPLIT_LINE);
    }

    public static void printMsgGeneric(Msg msg) {
        System.out.println(MsgString.SPLIT_LINE);
        System.out.println(msg.getInfo());
        System.out.println(MsgString.SPLIT_LINE);
    }
}
