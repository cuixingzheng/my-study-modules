package com.gof.code.command;

/**
 * @author: cxz
 * @create: 2020/8/12 11:01
 * @description:
 **/
public class Remote {
    private Command[] onCommand;
    private Command[] offCommand;

    public Remote(int size) {
        this.onCommand = new Command[size];
        this.offCommand = new Command[size];
    }

    public void addCommand(int i,Command on,Command off){
        if(i<onCommand.length && i<offCommand.length){
            onCommand[i] = on;
            offCommand[i] = off;
        }
    }

    public void onPressButton(int i){
        if(i<onCommand.length && onCommand[i] !=null){
            onCommand[i].execute();
        }else {
            System.out.println("所打开设备不存在");
        }
    }

    public void offPressButton(int i){
        if(i<onCommand.length && offCommand[i] !=null){
            offCommand[i].execute();
        }else {
            System.out.println("所关闭设备不存在");
        }
    }
}
