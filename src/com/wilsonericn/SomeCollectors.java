package com.wilsonericn;

import java.util.List;

public class SomeCollectors {

    private static List<HockeyPlayer> roster;

    public static void main(String[] args) {
        roster = HockeyPlayer.createCbj();
    }
}
