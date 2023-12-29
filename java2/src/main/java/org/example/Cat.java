package org.example;

public class Cat implements Participant,SuperJump {
    private int maxHeight;
    private int maxLenght;
    private String name;
    private boolean superRun=true;
    public static int superJumpCount=0;

    public Cat(String name, int maxHeight, int maxLenght) {
        this.name = name;
        this.maxHeight = maxHeight;
        this.maxLenght = maxLenght;
    }

    @Override
    public boolean run(int distance) {
        if (distance <= maxLenght) {
            System.out.println("Кот " + this.name + " пробежал " + distance + " метров");
            return true;
        }
        else if (superRun) {
            System.out.println("Кот " + this.name + " пробежал с superRun`ом");
            return superRun=false;
        }
        else {
            System.out.println("Кот " + this.name + " не смог пробежать " + distance + " метров - выбывает");
            return false;
        }
    }
    @Override
    public boolean jump(int height) {
        if (height <= maxHeight) {
            System.out.println("Кот " + this.name + " перепрыгнул " + height + " метров");
            return true;
        } else if (superJumpCount<2){
            return defaultSuperJump(this.name);
        }
        else {
            System.out.println("Кот " + this.name + " не смог перепрыгнуть " + height + " метров - выбывает");
            return false;
        }
    }
}
