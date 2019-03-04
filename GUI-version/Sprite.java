import javafx.geometry.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Sprite {

    private Image image;
    private double positionX;
    private double positionY;
    private double width;
    private double height;

  
    
    public Sprite(Image image){
        this.image = image;
        this.width = image.getWidth();
        this.height = image.getHeight();
        this.positionX = 0;
        this.positionY = 0;
    }

    public double getPositionX() {
        return this.positionX;
    }

    public double getPositionY() {
        return this.positionY;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }

    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    public void setPosition(double x, double y){
        this.positionX = x;
        this.positionY = y;
    } 

    public void render(javafx.scene.canvas.GraphicsContext gc){
        gc.drawImage(this.image, this.positionX, this.positionY);
    }

    public Rectangle2D getBoundary(){
        return new Rectangle2D(this.positionX, this.positionY, this.width, this.height);
    }

    public boolean intersects(Sprite sprite){
        return sprite.getBoundary().intersects(this.getBoundary());
    }

}