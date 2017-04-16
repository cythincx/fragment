package com.chengyuxing.fragment.tij.nestedclass;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2016/11/2
 * Time: 上午11:24
 * Description:
 */
public class Parcel4 {

    private class PContents implements Contents{
        private int i = 11;

        //@Override
        public int value() {
            return i;
        }
    }

    protected class PDestination implements Destination{

        private String label;
        private PDestination(String s){
            label = s;
        }

        //@Override
        public String readLabel() {
            return label;
        }
    }

    public class PublicDestination implements Destination{
        private String label;

        public PublicDestination(String s){
            label = s;
        }

        //@Override
        public String readLabel() {
            return label;
        }
    }

    public Destination destination(String s){
        Destination d = new PDestination(s);
        //这说明内部类的私有构造函数是可以被外部类访问的。
        return d;
    }

    public Destination publicDestination(String s){
        return new PublicDestination(s);
    }

    public Contents contents(){
        return new PContents();
    }

    public static void main(String[] args) {

    }
}
