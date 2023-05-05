import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


class Laptop {
    public int ram;
    public double price;
    public String brand;

    public Laptop(int ram, double price, String brand) {
        this.ram = ram;
        this.price = price;
        this.brand = brand;
    }

    public String toString() {
        return "Brand: " + brand + " Ram: " + ram + " Price: " + price;
    }

}

class SortByPrice implements Comparator<Laptop> {

    public int compare(Laptop x, Laptop y) {
        return x.ram - y.ram;   // x.ram - y.ram; => Accending order & y.ram - x.ram; => Decending order 
    }

	
        
}

public class AboutCollector {
    public static void main(String[] args) {
        ArrayList<Laptop> laptops = new ArrayList<Laptop>(0);
        laptops.add(new Laptop(8, 450.20, "Asus Rog"));
        laptops.add(new Laptop(4, 230.20, "Acer"));
        laptops.add(new Laptop(6, 480.20, "Dell"));

        Collections.sort(laptops, new SortByPrice());
        for(int i = 0;  i < laptops.size(); i++) {
            System.out.println(laptops.get(i).brand);
        }
        
    }   
}

class Box {
	public int width;
	public int height;
	public int depth;

	public Box(int w, int h, int d) {
		width = w;
		height = h;
		depth = d;
	}

	public boolean canBeUnder(Box b) {
		if (width > b.width && height > b.height && depth > b.depth) {
			return true;
		}
		return false;
	}

	public boolean canBeAbove(Box b) {
		if (b == null) {
			return true;
		}
		if (width < b.width && height < b.height && depth < b.depth) {
			return true;
		}
		return false;
	}

	public String toString() {
		return "Box(" + width + "," + height + "," + depth + ")";
	}
}