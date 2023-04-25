class Generic<anyType> {
    
    anyType x;
    public Generic(anyType x) {
        this.x = x;
    }

    void printValue() {
        System.out.println(x);
    }

}

public class GenericClass {
    public static void main(String[] args) {

        Generic<Integer> objInt = new Generic<Integer>(50);
        Generic<Double> objDouble = new Generic<Double>(50.02);

        objInt.printValue();
        objDouble.printValue();
        
    }
}