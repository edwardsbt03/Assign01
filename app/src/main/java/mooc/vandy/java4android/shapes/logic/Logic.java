package mooc.vandy.java4android.shapes.logic;

import mooc.vandy.java4android.shapes.ui.OutputInterface;
//Added the math library because why reinvent the wheel?
import java.lang.Math;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
 *
 */
public class Logic 
       implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = 
        Logic.class.getName();

    /*
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough)
     */
    private OutputInterface mOut;

    /**
     * These are the numeric values that you will receive from the
     * User Interface and use in your calculations.
     */
    private static double mRadius = 0;
    private static double mLength = 0;
    private static double mWidth = 0;
    private static double mHeight = 0;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance
     * (which implements [OutputInterface]) to 'out'
     */
    public Logic(OutputInterface out){
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */
    @Override
    public void process() {
        // Get which calculation should be computed.  Do not worry
        // about the specifics of this right now.
        Shapes shapeForCalculations = mOut.getShape();

        // Store the values returned by the User Interface.
        mLength = mOut.getLength();
        mWidth = mOut.getWidth();
        mHeight = mOut.getHeight();
        mRadius = mOut.getRadius();

        // Determine which calculation to process right now.  Again,
        // do not worry about the specifics of how this works for now.
        switch (shapeForCalculations) {
            case Box:
                mOut.print("A " 
                           + mLength 
                           + " by " 
                           + mWidth 
                           + " by " 
                           + mHeight 
                           + " box has a volume of: ");
                mOut.println("" 
                             + String.format("%.2f",
                                             boxVolume(mLength, mWidth, mHeight)));
                mOut.println("");

                mOut.print("A " 
                           + mLength 
                           + " by " 
                           + mWidth 
                           + " by " 
                           + mHeight 
                           + " box has a surface area of: ");
                mOut.println("" 
                             + String.format("%.2f",
                                             boxSurfaceArea(mLength, mWidth, mHeight)));
                mOut.println("");
                // If you are paying attention, you will notice that
                // there is no 'break;' here like there is in other
                // places, meaning that if 'Box' was selected, it will
                // run the two sets of print statements above and the
                // two statements below until the 'break;' statement.
            case Rectangle:
                mOut.print("A " 
                           + mLength 
                           + " by " 
                           + mWidth 
                           + " rectangle has a perimeter of: ");
                mOut.println("" + String.format("%.2f", 
                                                rectanglePerimeter(mLength, mWidth)));
                mOut.println("");

                mOut.print("A " 
                           + mLength 
                           + " by " 
                           + mWidth 
                           + " rectangle has area of: ");
                mOut.println("" + String.format("%.2f", rectangleArea(mLength, mWidth)));
                mOut.println("");
                break;
            case Sphere:
                mOut.print("A sphere with radius " + mRadius + " has a volume of: ");
                mOut.println("" + String.format("%.2f", sphereVolume(mRadius)));
                mOut.println("");

                mOut.print("A sphere with radius " + mRadius + " has surface area of: ");
                mOut.println("" + String.format("%.2f", sphereSurfaceArea(mRadius)));
                mOut.println("");
                // Same here as with 'Box' above. If 'Sphere' is picked, it will run the
                // two sets of print statements above and the two below until the 'break;'
            case Circle:
                mOut.print("A circle with radius " + mRadius + " has a perimeter of: ");
                mOut.println("" + String.format("%.2f", circleCircumference(mRadius)));
                mOut.println("");

                mOut.print("A circle with radius " + mRadius + " has area of: ");
                mOut.println("" + String.format("%.2f", circleArea(mRadius)) );
                mOut.println("");
                break;
            case Triangle:
                mOut.print("A right triangle with base " 
                           + mLength 
                           + " and height " 
                           + mWidth + " has a perimeter of: ");
                mOut.println("" 
                             + String.format("%.2f", rightTrianglePerimeter(mLength,
                                                                       mWidth)));
                mOut.println("");

                mOut.print("A right triangle with base " 
                           + mLength 
                           + " and height " 
                           + mWidth 
                           + " has area of: ");
                mOut.println("" 
                             + String.format("%.2f", rightTriangleArea(mLength,
                        mWidth)));
                mOut.println("");
                break;
            default:
                break;
        }
    }

    public static double rectangleArea(double length, double width) {
        double rectangleAreaSol = length * width;
        return rectangleAreaSol;
        // Do I really need documentation here?
    }

    public static double rectanglePerimeter(double length, double width) {
        double rectanglePerimeterSol = (length * 2.0) + (width * 2.0);
        return rectanglePerimeterSol;
        // Or here?
    }

    public static double circleArea(double radius) {
        double circleAreaSol = Math.PI * (radius * radius);
        return circleAreaSol;
        // Used the Math library PI constant otherwise the tests wouldn't pass.
        // pi * r^2
    }

    public static double circleCircumference(double radius) {
        double circleCircumferenceSol = Math.PI * radius * 2.0;
        return circleCircumferenceSol;
        // pi * r * 2
    }

    public static double rightTriangleArea(double base, double height) {
        double rightTriangleAreaSol = (base * height)/2.0;
        return rightTriangleAreaSol;
        // Fun fact; right triangles are half the area of a square.
    }

    public static double rightTrianglePerimeter(double base, double height) {
        double rightTrianglePerimeterSol = (Math.hypot(base, height)) + base + height;
        return rightTrianglePerimeterSol;
        // I wish I was high on potenuse
        // Used the hypotenuse method to reduce the amount of code
    }

    public static double boxVolume(double length, double width, double depth) {
        double boxVolumeSol = length * width * depth;
        return boxVolumeSol;
        // Yup
    }

    public static double boxSurfaceArea(double length, double width, double depth) {
        double surface1 = ((length * width) * 2);
        double surface2 = ((length * depth) * 2);
        double surface3 = ((depth * width) * 2);
        double boxSurfaceAreaSol = surface1 + surface2 + surface3;
        return boxSurfaceAreaSol;
        // Figure out the surface area of one side, multiply it by 2,
        // then do the same for the other sides
    }

    public static double sphereVolume(double radius) {
        double sphereVolumeSol = (Math.pow(radius, 3.0)) * (4.0/3.0) * Math.PI;
        return sphereVolumeSol;
        // Used the power method instead of multiplying radius three times to itself
        // Fuckin PI
    }

    public static double sphereSurfaceArea(double radius) {
        double sphereSurfaceAreaSol = (radius * radius) * Math.PI * 4.0;
        return sphereSurfaceAreaSol;
        // radius squared * fuckin PI * 4
    }


}
