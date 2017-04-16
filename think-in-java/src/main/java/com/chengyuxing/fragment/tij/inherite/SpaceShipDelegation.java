package com.chengyuxing.fragment.tij.inherite;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2016/10/30
 * Time: 下午2:45
 * Description:
 */
public class SpaceShipDelegation {
    private String name;
    public SpaceShipDelegation(String name){
        this.name = name;
    }
    private SpaceShipControls controls = new SpaceShipControls();

    public void up(int velocity) {
        controls.up(velocity);
    }

    public void right(int velocity) {
        controls.right(velocity);
    }

    public void down(int velocity) {
        controls.down(velocity);
    }

    public void left(int velocity) {
        controls.left(velocity);
    }

    public void back(int velocity) {
        controls.back(velocity);
    }

    public void forwards(int velocity) {
        controls.forwards(velocity);
    }
}
