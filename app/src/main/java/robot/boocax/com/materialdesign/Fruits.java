package robot.boocax.com.materialdesign;

/**
 * Created by lly on 2018/5/2.
 */

public class Fruits {
    private int imageID;
    private String name;

    public Fruits(String name, int imageID) {
        this.imageID = imageID;
        this.name = name;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
