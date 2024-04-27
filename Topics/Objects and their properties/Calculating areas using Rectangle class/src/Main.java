import org.w3c.dom.css.Rect;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // TODO: Create two Rectangle objects
        Rectangle rectangle1 = new Rectangle();
        Rectangle rectangle2 = new Rectangle();

        // TODO: Read the width and height for the first rectangle
        rectangle1.width = scanner.nextInt();
        rectangle1.height = scanner.nextInt();

        // TODO: Read the width and height for the second rectangle
        rectangle2.width = scanner.nextInt();
        rectangle2.height = scanner.nextInt();

        // TODO: Print the area of each rectangle
        System.out.println(rectangle1.width * rectangle1.height);
        System.out.println(rectangle2.width * rectangle2.height);
    }
}

// TODO: Define the Rectangle class with width and height properties
class Rectangle {
    int width;
    int height;
}