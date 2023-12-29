package org.example;

public class Human implements Participant {
    private int maxHeight;
    private int maxLenght;
    private String name;
    private boolean superRun=true;

    public Human(String name, int maxHeight, int maxLenght) {
        this.name = name;
        this.maxHeight = maxHeight;
        this.maxLenght = maxLenght;
    }

    @Override
    public boolean run(int distance) {
        if (distance <= maxLenght) {
            System.out.println("Человек " + this.name + " пробежал " + distance + " метров");
            return true;
        }
        else if (superRun) {
                System.out.println("Человек " + this.name + " пробежал с superRun`ом");
                return superRun=false;
        }
        else {
            System.out.println("Человек " + this.name + " не смог пробежать " + distance + " метров - выбывает");
            return false;
        }
    }
    @Override
    public boolean jump(int height) {
        if (height <= maxHeight) {
            System.out.println("Человек " + this.name + " перепрыгнул " + height + " метров");
            return true;
        } else {
            System.out.println("Человек " + this.name + " не смог перепрыгнуть " + height + " метров - выбывает");
            return false;
        }
    }
}
