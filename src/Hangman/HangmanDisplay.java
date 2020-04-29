package Hangman;

//import comp127graphics.Ellipse;
import comp127graphics.*;


public class HangmanDisplay {
    private CanvasWindow canvas;
    private static final int CANVAS_WIDTH = 300;
    private static final int CANVAS_HEIGHT = 400;

    private Ellipse head;
    private Line body;
    private Line rightArm;
    private Line leftArm;
    private Line rightLeg;
    private Line leftLeg;
    // Do we need a variable for every part, or code it within?

    private GraphicsGroup bodyParts;


    public HangmanDisplay(){
        canvas = new CanvasWindow("Hangman", CANVAS_WIDTH, CANVAS_HEIGHT);
    }

    // main here for testing purposes
    public static void main(String args[]) {
        HangmanDisplay h = new HangmanDisplay();
    }

}
