import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


class Box {
    int height;
    int width;
    int depth;

    public Box(int height, int width, int depth) {
        this.height = height;
        this.width = width;
        this.depth = depth;
    }

    public boolean canBeAbove(Box aboveBox) {
        if (aboveBox == null) {
            return true;
        }

        if (this.height < aboveBox.height && this.width < aboveBox.width && this.depth <  aboveBox.depth) {
            return true;
        }

        else {
            return false;
        }
    }
}

class BoxShorting implements Comparator<Box> {

    public int compare(Box b1, Box b2) {
        return b2.height - b1.height;
    }

}

class BoxStacking {

    int findHighestHeight(ArrayList<Box> boxes) {
        Collections.sort(boxes, new BoxShorting());
        int [] heightCollection = new int[boxes.size()]; 
        int maxHeight = 0;
        for (int i = 0; i < boxes.size(); i++) {
            int height = this.findHighestHeight(boxes, i, heightCollection);
            maxHeight = Math.max(maxHeight, height);
        }
        return maxHeight;

    }

    int findHighestHeight(ArrayList<Box> boxes, int buttomIndex, int [] heightCollection) {
        if (buttomIndex < boxes.size() && heightCollection[buttomIndex] > 0) {
            return heightCollection[buttomIndex];
        }

        int maxHeight = 0;
        Box belowBox = boxes.get(buttomIndex);
        for (int i = buttomIndex + 1; i < boxes.size(); i++) {
            if (boxes.get(i).canBeAbove(belowBox)) {
                int height = this.findHighestHeight(boxes, i, heightCollection);
                maxHeight = Math.max(maxHeight, height);
            }
            
        }
        maxHeight += belowBox.height;
        heightCollection[buttomIndex] = maxHeight;
        return maxHeight;
    }

}

public class StackOfBoxes {

    public static void main(String[] args) {
        BoxStacking obj = new BoxStacking();
        ArrayList<Box> boxes = new ArrayList<Box>(0);
        boxes.add(new Box(30, 25, 20));
        boxes.add(new Box(25, 18, 22));
        boxes.add(new Box(18, 7, 12));
        boxes.add(new Box(21, 11, 15));
        boxes.add(new Box(27, 21, 17));
        int res = obj.findHighestHeight(boxes);
        System.out.println(res);
        
    }
    
}
