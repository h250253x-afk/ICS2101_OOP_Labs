public class Rectangle {
    double width;
    double height;

    double area() { return width * height; }
    double perimeter() { return 2 * (width + height); } 

    public static void main(String[] args) {
        Rectangle[] rects = new Rectangle[5];
        for (int i = 0; i < rects.length; i++) {
            rects[i] = new Rectangle();
            rects[i].width = (i + 1) * 2;
            rects[i].height = (i + 1) * 3;
        }
        
        Rectangle maxRect = rects[0];
        for (Rectangle r : rects) {
            if (r.area() > maxRect.area()){
                maxRect = r;
            }
        }
        System.out.println("Largest area: " + maxRect.area());

        Rectangle r1 = new Rectangle();
        r1.width = 10;
        Rectangle r2 = r1;
        r2.width = 20;
        System.out.println("r1.width: " + r1.width);
    }
}

