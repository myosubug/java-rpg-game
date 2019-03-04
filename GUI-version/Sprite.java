import javafx.geometry.*;
import scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Sprite {

    private Image image;
    private double positionX;
    private double positionY;
    private double width;
    private double height;

    public Spite(Image image){
        this.image = image;
        this.width = image.getWidth();
        this.height = image.getHeight();
        this.positionX = 0;
        this.positionY = 0;
    }

    public setPosition(double x, double y){
        this.positionX = x;
        this.positionY = y;
    }

    public void render(javafx.scene.canvas.GraphicsContext gc){
        gc.drawImage(this.image, this.positionX, this.positionY);
    }

    public Rectangle2D getBoundary(){
        return new Rectangle2D(this.positionX, this.positionY, this.width, this.height);
    }

    public boolean collision(Sprite sprite){
        return sprite.getBoundary().intersects(this.getBoundary());
    }

}