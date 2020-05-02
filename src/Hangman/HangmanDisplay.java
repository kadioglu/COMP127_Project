package Hangman;

//import comp127graphics.Ellipse;
import comp127graphics.*;

import java.awt.*;


public class HangmanDisplay {
    /**
     * This class creates a basic hangman outline that updates as the user
     * gets the questions wrong
     */
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

//    private GraphicsGroup bodyParts;


    public HangmanDisplay(){
        canvas = new CanvasWindow("Hangman", CANVAS_WIDTH, CANVAS_HEIGHT);
        addHead();
        addBody();
        addLeftLeg();
        addRightLeg();
        addLeftArm();
        addRightArm();
    }

    // main here for testing purposes
/*    public static void main(String args[]) {
        HangmanDisplay h = new HangmanDisplay();
    }*/

    public void addHead() {
        head = new Ellipse (CANVAS_WIDTH / 2 - 30, CANVAS_HEIGHT / 7, 60, 60);
        head.setFilled(false);
        head.setStrokeColor(Color.black);
        head.setStrokeWidth(5);
        canvas.add(head);
    }

    public void addBody() {
        body = new Line(CANVAS_WIDTH / 2, head.getY() + 60, CANVAS_WIDTH / 2, 200);
        body.setStrokeColor(Color.black);
        body.setStrokeWidth(5);
        canvas.add(body);
    }

    public void addLeftLeg() {
        leftLeg = new Line(CANVAS_WIDTH / 2, body.getY2(),
                CANVAS_WIDTH / 2 - 20, body.getY2() + 60);
        leftLeg.setStrokeColor(Color.black);
        leftLeg.setStrokeWidth(5);
        canvas.add(leftLeg);
    }

    public void addRightLeg() {
        rightLeg = new Line(CANVAS_WIDTH / 2, body.getY2(),
                CANVAS_WIDTH / 2 + 20, body.getY2 () + 60);
        rightLeg.setStrokeColor(Color.black);
        rightLeg.setStrokeWidth(5);
        canvas.add(rightLeg);
    }

    public void addRightArm() {
        rightArm = new Line (CANVAS_WIDTH/2 , body.getY1() + 20,
                CANVAS_WIDTH/ 2 + 20, body.getY1() + 60);
        rightArm.setStrokeColor(Color.black);
        rightArm.setStrokeWidth(5);
        canvas.add(rightArm);
    }

    public void addLeftArm() {
        leftArm = new Line(CANVAS_WIDTH/2 , body.getY1() + 20,
                CANVAS_WIDTH/ 2 - 20, body.getY1() + 60);
        leftArm.setStrokeWidth(5);
        leftArm.setStrokeColor(Color.black);
        canvas.add(leftArm);
    }

}
