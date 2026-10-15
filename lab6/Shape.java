abstract class Shape {
    abstract double area();
    abstract double perimeter();
}

class Circle extends Shape {
    double r;
    Circle(double r) { 
        this.r = r; 
    }
    double area() { 
        return Math.PI * r * r; 
    }
    double perimeter() { 
        return 2 * Math.PI * r; 
    }
}

class Rectangle extends Shape {
    double w, h;
    Rectangle(double w, double h) { 
        this.w = w; 
        this.h = h; 
    }

    double area() { 
        return w * h; 
    }
    double perimeter() { 
        return 2 * (w + h); 
    }
}

class Square extends Rectangle {
    Square(double side) { 
        super(side, side); 
    }
}
