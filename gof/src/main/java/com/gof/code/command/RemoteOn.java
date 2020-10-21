package com.gof.code.command;

/**
 * @author: cxz
 * @create: 2020/8/12 10:53
 * @description:
 **/
public class RemoteOn implements Command {
    private Equipment equipment;
    public RemoteOn(Equipment equipment) {
        this.equipment = equipment;
    }
    @Override
    public void execute() {
        equipment.onButton();
    }
}
