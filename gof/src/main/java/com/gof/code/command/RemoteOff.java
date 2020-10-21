package com.gof.code.command;

/**
 * @author: cxz
 * @create: 2020/8/12 10:56
 * @description:
 **/
public class RemoteOff implements Command {
    private Equipment equipment;

    public RemoteOff(Equipment equipment) {
        this.equipment = equipment;
    }
    @Override
    public void execute() {
        equipment.offButton();
    }
}
