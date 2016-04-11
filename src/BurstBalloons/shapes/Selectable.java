package BurstBalloons.shapes;

/**
 * Created by Boran1 on 19.3.2016.
 */

public interface Selectable {

    Shape contains(int var1, int var2);

    boolean isSelected();

    void setSelected(boolean selected);
}