package com.chengyuxing.fragment.effectivejava.item2;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Author: mt-chengyuxing
 * Date: 2017/8/12
 * Time: 下午10:19
 * Desc: 遇见多个构造器参数的时候,考虑使用Builder模式.
 */
public class BuilderPattern {

    private String name;
    private int age;
    private int gender;
    private String country;
    private String province;
    private String city;
    private Date birthDay;

    private BuilderPattern(Builder builder){
        this.name=builder.name;
        this.age=builder.age;
        this.gender=builder.gender;
        this.country=builder.country;
        this.province=builder.province;
        this.city=builder.city;
        this.birthDay=builder.birthDay;
    }

    @Override
    public String toString() {
        return "BuilderPattern{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", birthDay=" + birthDay +
                '}';
    }

    public static class Builder {
        private String name;
        private int age;
        private int gender;
        private String country;
        private String province;
        private String city;
        private Date birthDay;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder gender(int gender){
            this.gender = gender;
            return this;
        }

        public Builder country(String country){
            this.country = country;
            return this;
        }

        public Builder province(String province){
            this.province = province;
            return this;
        }

        public Builder city(String city){
            this.city = city;
            return this;
        }

        public Builder birthDay(Date birthDay){
            this.birthDay = birthDay;
            return this;
        }

        public BuilderPattern build(){
            return new BuilderPattern(this);
        }
    }
}
