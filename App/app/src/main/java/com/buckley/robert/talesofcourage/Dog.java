package com.buckley.robert.talesofcourage;

public class Dog {
    String imgUrl;
    String name;
    String age;
    String breed;
    String sex;
    String size;
    String sheddding;
    String child;
    String train;
    String energy;
    String bark;
    public Dog(){

    }
    public void printInfo(){
        System.out.print("My name is " + name + ", url: " + imgUrl + "\n");
    }
    public String getimgUrl(){
        return imgUrl;
    }
    public String getName(){
        return name;
    }
    public String getAge() {
        return age;
    }
    public String getBreed() {
        return breed;
    }
    public String getSex() {
        return sex;
    }
    public String getSize() {
        return size;
    }
    public String getSheddding() {
        return sheddding;
    }
    public String getChild() {
        return child;
    }
    public String getTrain() {
        return train;
    }
    public String getEnergy() {
        return energy;
    }
    public String getBark() {
        return bark;
    }
}