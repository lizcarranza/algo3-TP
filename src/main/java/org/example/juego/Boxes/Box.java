package org.example.juego.Boxes;

public class Box {
    public boolean visible = false;
    public boolean flag = false;
    public int number;
    public boolean bomb = false;

    public Box(int number) {
        this.number = number;
    }

    public void setFlag() {
        this.flag = true;
    }

    public void unsetFlag(){
        this.flag = false;
    }

    public int getNumber() {
        return number;
    }

    public void printBox() {
        if (flag)
            System.out.print("|F|");
        else if (visible == false)
            System.out.print("|x|");
        else if (bomb)
            System.out.print("|B|");
        else
            System.out.print("|" + number + "|");

    }

    public boolean isABomb() {
        return bomb;
    }

    public boolean click() {
        if (flag == true || visible == true) {
            return false;
        }
        return true;
    }
}
