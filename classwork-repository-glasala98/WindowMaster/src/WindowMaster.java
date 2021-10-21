import java.util.Scanner;
public class WindowMaster {

    public static void main(String [] args)

    {
        // declare variables
        float height;
        float width;

        String stringHeight;
        String stringWidth;

        float area;
        float cost;
        float perimeter;

        Scanner myScanner = new Scanner(System.in);

        // get user input
        System.out.println("Please enter window height:");
        stringHeight = myScanner.nextLine();
        System.out.println("Please enter window width:");
        stringWidth = myScanner.nextLine();

        height = Float.parseFloat(stringHeight);
        width = Float.parseFloat(stringWidth);

        // calculate the area
        area = height * width;

        // calculate the perimeter
        perimeter = 2 * (height + width);

        // calculate the total cost
        cost = ((3.50f * area) + (2.25f * perimeter));

        // display the results
        System.out.println("Window height = " + stringHeight);
        System.out.println("Window width = " + stringWidth);
        System.out.println("Window area = " + area);
        System.out.println("Window perimeter = " + perimeter);
        System.out.println("Total Cost =  " + cost);
    }
}
