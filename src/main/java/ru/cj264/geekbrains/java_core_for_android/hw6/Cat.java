package ru.cj264.geekbrains.java_core_for_android.hw6;

public class Cat {
    private String name;
    private int appetite;
    private int health;
    private int damage;

    public Cat(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public void takeHit(Cat another) {
        this.health -= another.getDamage();
        if (this.health > 0) System.out.println("Got a hit. Health is now " + health);
        if (this.health <= 0) {
            System.out.println(name + "dead");
            throw new RuntimeException(String.format("%s's dead baby, %s's dead...", name, name));
        }
    }

    public void kick(Cat another) {
        System.out.println(this.name + " hits " + another.name);
        another.takeHit(this);
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate plate) {
        plate.decreaseFood(appetite);
        System.out.println("Cat ate for " + appetite);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAppetite() {
        return appetite;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
