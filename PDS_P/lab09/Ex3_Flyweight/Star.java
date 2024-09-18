package lab09.Ex3_Flyweight;

import lab09.Ex3_Flyweight.startypes.StarType;
import java.awt.*;

public class Star {
    private int x, y;
    private StarType starType;
    Star (int x, int y, StarType starType) {
        this.x = x;
        this.y = y;
        this.starType = starType;
    }
    public void draw(Graphics g) {
        g.setColor(this.starType.getColor());
        g.fillOval(this.x, this.y , this.starType.getSize(), this.starType.getSize());
    }
}

