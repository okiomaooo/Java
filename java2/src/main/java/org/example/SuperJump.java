package org.example;

public interface SuperJump {

    default boolean defaultSuperJump(String name) {
        if (Cat.superJumpCount <= 2) {
            Cat.superJumpCount++;
            System.out.println(name + " прыгнул с superJump'ом");
            return true;
        } else {
            System.out.println(name + " больше не может использовать superJump");
            return false;
        }
    }
}