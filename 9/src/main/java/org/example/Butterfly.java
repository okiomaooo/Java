package org.example;

import java.util.Date;

@Table(title = "BUTTERFLY")
public class Butterfly {

    public enum Color {
        ORANGE("Оранжевый"), WHITE("Белый"), BLACK("Черный");
        private Color(String translate){
            this.translate = translate;
        }
        String translate;
        public String getTranslate(){
            return this.translate;
        }

    }
    public Butterfly(String name, int age, String maxRunDistance, Color color, Date date) {
        this.name = name;
        this.age = age;
        this.maxRunDistance = maxRunDistance;
        this.color = color;
        this.translateColor = color.getTranslate();
        this.date=date;
    }
    @Column
    public String name;

    //@Column
    public int age;

    @Column
    public String maxRunDistance;

    @Column
    public Color color;

    @Column
    public Date date;

    public String translateColor;
}
