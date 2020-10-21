package com.gof.code.command;

/**
 * @author: cxz
 * @create: 2020/8/12 11:08
 * @description:
 **/
public class CommandTest {

    public static void main(String[] args) {
        Refrigerator refrigerator = new Refrigerator();
        Audio audio = new Audio();
        AirConditioner airConditioner = new AirConditioner();


        Remote remote = new Remote(3);
        remote.addCommand(0,new RemoteOn(refrigerator),new RemoteOff(refrigerator));
        remote.addCommand(1,new RemoteOn(audio),new RemoteOff(audio));
        remote.addCommand(2,new RemoteOn(airConditioner),new RemoteOff(airConditioner));

        remote.onPressButton(0);
        remote.offPressButton(0);
        remote.onPressButton(1);
        remote.offPressButton(1);
        remote.onPressButton(2);
        remote.offPressButton(2);
    }
}
