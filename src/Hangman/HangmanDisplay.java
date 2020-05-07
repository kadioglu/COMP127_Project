package Hangman;

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

    private GraphicsGroup bodyParts;


    public HangmanDisplay(){
        canvas = new CanvasWindow("Hangman", CANVAS_WIDTH, CANVAS_HEIGHT);
    }

    // main here for testing purposes
  /*  public static void main(String args[]) {
        HangmanDisplay h = new HangmanDisplay();
    }*/

    /**
     * This parameter calls the corresponding body part depending
     * on how many guesses left the user has.
     * @param guessesLeft The number of guesses left the user has.
     */
    public void addPart(int guessesLeft) {
       switch(guessesLeft) {
           case 5:
               this.addHead();
               canvas.draw();
               break;
           case 4:
               this.addBody();
               canvas.draw();
               break;
           case 3:
               this.addLeftArm();
               canvas.draw();
               break;
           case 2:
               this.addRightArm();
               canvas.draw();
               break;
           case 1:
               this.addLeftLeg();
               canvas.draw();
               break;
           case 0:
               this.addRightLeg();
               canvas.draw();
               break;
           default:
               break;
       }
    }

    /**
     * Following methods add the different body parts of the hangman drawing
     */
    private void addHead() {
        head = new Ellipse (CANVAS_WIDTH / 2 - 30, CANVAS_HEIGHT / 7, 60, 60);
        head.setFilled(false);
        head.setStrokeColor(Color.black);
        head.setStrokeWidth(5);
        canvas.add(head);
    }

    private void addBody() {
        body = new Line(CANVAS_WIDTH / 2, head.getY() + 60, CANVAS_WIDTH / 2, 200);
        body.setStrokeColor(Color.black);
        body.setStrokeWidth(5);
        canvas.add(body);
    }

    private void addLeftLeg() {
        leftLeg = new Line(CANVAS_WIDTH / 2, body.getY2(),
                CANVAS_WIDTH / 2 - 20, body.getY2() + 60);
        leftLeg.setStrokeColor(Color.black);
        leftLeg.setStrokeWidth(5);
        canvas.add(leftLeg);
    }

    private void addRightLeg() {
        rightLeg = new Line(CANVAS_WIDTH / 2, body.getY2(),
                CANVAS_WIDTH / 2 + 20, body.getY2 () + 60);
        rightLeg.setStrokeColor(Color.black);
        rightLeg.setStrokeWidth(5);
        canvas.add(rightLeg);
    }

    private void addRightArm() {
        rightArm = new Line (CANVAS_WIDTH/2 , body.getY1() + 20,
                CANVAS_WIDTH/ 2 + 20, body.getY1() + 60);
        rightArm.setStrokeColor(Color.black);
        rightArm.setStrokeWidth(5);
        canvas.add(rightArm);
    }

    private void addLeftArm() {
        leftArm = new Line(CANVAS_WIDTH/2 , body.getY1() + 20,
                CANVAS_WIDTH/ 2 - 20, body.getY1() + 60);
        leftArm.setStrokeWidth(5);
        leftArm.setStrokeColor(Color.black);
        canvas.add(leftArm);
    }

    /**
     * Methods clear the screen and close the canvas
     */
    public void clearTheScreen() {
        canvas.removeAll();
    }

    public void closeCanvas() {
        canvas.closeWindow();
    }

}
