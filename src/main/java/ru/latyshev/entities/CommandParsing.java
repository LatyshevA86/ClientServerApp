package ru.latyshev.entities;

public class CommandParsing {

    //login command parsing
    public static boolean checkLoginCommand(String command) {
        String[] loginArr = command.trim().split(" ", 2);
        if (loginArr.length != 2) {
            return false;
        }

        String loginCommand = loginArr[0];
        String[] loginParams = loginArr[1].trim().split("=");
        if (loginParams.length != 2 || loginParams[1].isEmpty()) {
            return false;
        }
        String loginKey = loginParams[0].trim();

        if (!loginCommand.equals("login")) {
            return false;
        }
        if (!loginKey.equals("-u")) {
            return false;
        }
        return true;
    }
    public static String getLoginNameFromCommand(String command) {
        String[] loginArr = command.split("=");
        return loginArr[1].trim();
    }

    public static String getTopicName(String command) {
        String topicName = command.split("=")[1].trim();
        return topicName.substring(1, topicName.length() - 1);
    }
}
