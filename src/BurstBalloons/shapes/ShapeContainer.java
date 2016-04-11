package BurstBalloons.shapes;

/**
 * Created by Boran1 on 21.3.2016.
 * This class is a container for shapes
 * It holds shapes in an ArrayList
 */
import java.util.ArrayList;
import java.util.Iterator;

public class ShapeContainer implements Iterable {

    //properties
    ArrayList<Shape> shapes = new ArrayList<>();

    public void add(Shape s) {
        this.shapes.add(s);
    }

    public Iterator<Shape> iterator() {
        return this.shapes.iterator();
    }

    public int size() {
        return this.shapes.size();
    }

    public void removeSelected() {
        for (int i = 0; i < this.shapes.size(); ++i) {
            if (!((Selectable)(this.shapes.get(i))).isSelected()) continue;
            this.shapes.remove(i);
            --i;
        }
    }

    public int selectAllAt(int x, int y) {
        int count = 0;
        for (Shape shape : this.shapes) {
            Shape s = ((Selectable)(shape)).contains(x, y);
            if (s == null) continue;
            ((Selectable)(s)).setSelected(true);
            ++count;
        }
        return count;
    }
}