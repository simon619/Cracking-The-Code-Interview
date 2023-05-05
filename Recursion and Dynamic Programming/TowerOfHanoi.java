class MoveRing<anyType> {

    void movingRing(int n, anyType from, anyType to, anyType spear) {
        if (n == 1) {
            System.out.println(from + " Moved to " + to);
        }
        else {
            this.movingRing(n - 1, from, spear, to);
            this.movingRing(1, from, to, spear);
            this.movingRing(n - 1, spear, to, from);
        }
    }

}

public class TowerOfHanoi {
    public static void main(String[] args) {
        MoveRing<Character> obj = new MoveRing<Character>();
        obj.movingRing(3, 'A', 'B', 'C');
    }
}
