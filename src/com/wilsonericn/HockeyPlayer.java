package com.wilsonericn;

import java.util.Arrays;
import java.util.List;

public class HockeyPlayer extends Person {

    private String position;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public HockeyPlayer(String name, int age, double height, String position) {
        super(name, age, height);
        this.position = position;
    }

    public static List<HockeyPlayer> createCbj() {
        return  Arrays.asList(
                new HockeyPlayer("ARTEM ANISIMOV", 25, 6.4, "F"),
                new HockeyPlayer("CAM ATKINSON", 24, 5.8, "F"),
                new HockeyPlayer("JARED BOLL", 28, 6.3, "F"),
                new HockeyPlayer("MATT CALVERT", 24, 5.9, "F"),
                new HockeyPlayer("BLAKE COMEAU", 28, 6.1, "F"),
                new HockeyPlayer("BRANDON DUBINSKY", 28, 6.2, "F"),
                new HockeyPlayer("NICK FOLIGNO", 26, 6.0, "F"),
                new HockeyPlayer("MATT FRATTIN", 26, 6.0, "F"),
                new HockeyPlayer("NATHAN HORTON", 28, 6.2, "F"),
                new HockeyPlayer("BOONE JENNER", 20, 6.2, "F"),
                new HockeyPlayer("RYAN JOHANSEN", 21, 6.3, "F"),
                new HockeyPlayer("MARK LETESTU", 29, 5.9, "F"),
                new HockeyPlayer("DEREK MACKENZIE", 32, 5.9, "F"),
                new HockeyPlayer("COREY TROPP", 24, 6.0, "F"),
                new HockeyPlayer("RJ UMBERGER", 32, 6.2, "F"),
                new HockeyPlayer("JACK JOHNSON", 27, 6.1, "D"),
                new HockeyPlayer("RYAN MURRAY", 20, 6.1, "D"),
                new HockeyPlayer("NIKITA NIKITIN", 27, 6.4, "D"),
                new HockeyPlayer("DALTON PROUT", 24, 6.3, "D"),
                new HockeyPlayer("DAVID SAVARD", 23, 6.2, "D"),
                new HockeyPlayer("NICK SCHULTZ", 31, 6.1, "D"),
                new HockeyPlayer("FEDOR TYUTIN", 30, 6.2, "D"),
                new HockeyPlayer("JAMES WISNIEWSKI", 30, 5.9, "D"),
                new HockeyPlayer("SERGEI BOBROVSKY", 25, 6.2, "G"),
                new HockeyPlayer("CURTIS MCELHINNEY", 30, 6.3, "G")
        );
    }

}
