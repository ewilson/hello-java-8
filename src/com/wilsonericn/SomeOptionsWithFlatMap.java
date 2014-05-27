package com.wilsonericn;

import java.util.Arrays;
import java.util.Optional;

public class SomeOptionsWithFlatMap {

    static Computer computer1;
    static Computer computer2;
    static Computer computer3;
    static OldComputer oldComputer;

    public static String getUsbNameOldWay(OldComputer computer) {
        OldSoundcard soundcard = computer.getSoundcard();
        if (soundcard != null) {
            USB usb = soundcard.getUSB();
            if (usb != null) {
                return usb.getVersion();
            }
        }
        return "UNKNOWN";
    }

    public static String getUsbNameBetter(Optional<Computer> computer) {
        return computer.flatMap(Computer::getSoundcard)
                       .flatMap(Soundcard::getUSB)
                       .map(USB::getVersion)
                       .orElse("UNKNOWN");
    }

    public static void main(String[] args) {
        computer1 = new Computer(Optional.of(new Soundcard(Optional.of(new USB("14.04")))));
        computer2 = new Computer(Optional.of(new Soundcard(Optional.empty())));
        computer3 = new Computer(Optional.empty());
        oldComputer = new OldComputer(new OldSoundcard(null));
        System.out.println(getUsbNameOldWay(oldComputer));
        System.out.println(getUsbNameBetter(Optional.of(computer1)));
        System.out.println(getUsbNameBetter(Optional.of(computer2)));
        System.out.println(getUsbNameBetter(Optional.of(computer3)));
        System.out.println(getUsbNameBetter(Optional.empty()));
        System.out.println(String.join("#", Arrays.asList("help", "me")));
    }
}

class Computer {
    private Optional<Soundcard> soundcard;
    public Optional<Soundcard> getSoundcard() { return soundcard; }

    Computer(Optional<Soundcard> soundcard) {
        this.soundcard = soundcard;
    }
}
class Soundcard {
    private Optional<USB> usb;
    public Optional<USB> getUSB() { return usb; }

    public Soundcard(Optional<USB> usb) {
        this.usb = usb;
    }
}
class USB{
    private String version;
    public String getVersion(){ return version; }

    public USB(String version) {
        this.version = version;
    }
}

class OldComputer {
    private OldSoundcard soundcard;
    public OldSoundcard getSoundcard() { return soundcard; }

    OldComputer(OldSoundcard soundcard) {
        this.soundcard = soundcard;
    }
}
class OldSoundcard {
    private USB usb;
    public USB getUSB() { return usb; }

    public OldSoundcard(USB usb) {
        this.usb = usb;
    }
}

