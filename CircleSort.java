/*
 * Author : Mert Doðan
 * Date : 21.10.2017
 * Program randomly generating 10 circles and sort them.
 */

package mertproject;

import java.util.Random;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class CircleSort extends Application {

	public void start(Stage primaryStage) {

		int sceneWidth = 900;
		int sceneHeight = 300;

		int number = 0;
		Random randomNumGenerator = new Random();
		int[] randomArray = new int[10];

		for(int i = 0; i < randomArray.length; i++) {
			number = randomNumGenerator.nextInt(30)+5;
			randomArray[i] = number;

			System.out.print(randomArray[i] + "  ");
		}

		Pane pane = new Pane();
		randomSort(randomArray);

		for(int i = 0; i <randomArray.length; i++) {

			Circle circle = new Circle();
			circle.setCenterX(100+i*80);
			circle.setCenterY(150);
			circle.setRadius(randomArray[i]);
			circle.setStroke(null);
			circle.setFill(Color.LIGHTGREEN);
			pane.getChildren().add(circle);

		}	

		for(int i=0 ; i<randomArray.length ; i++)
		{

			Text myText = new Text();
			myText.setFont(Font.font("verdana", FontWeight.THIN, FontPosture.REGULAR, 10));
			myText.setX(100+i*80);
			myText.setY(150);
			myText.setText( randomArray[i] + ""); 
			pane.getChildren().add(myText);
		}


		Scene scene = new Scene(pane, sceneWidth, sceneHeight);
		primaryStage.setTitle("My JavaFX Application"); 
		primaryStage.setScene(scene); 
		primaryStage.setResizable(false);

		primaryStage.show(); 
	}

	public static void randomSort(int[] inputArray){

		Random random = new Random();
		int temp;
		int randomNumber1;
		int randomNumber2;
		for(int i=0 ; i<100000 ; i++){
			randomNumber1=random.nextInt(inputArray.length);
			randomNumber2=random.nextInt(inputArray.length);

			if( randomNumber1<randomNumber2 && inputArray[randomNumber2]<inputArray[randomNumber1] ){
				temp=inputArray[randomNumber1];
				inputArray[randomNumber1]=inputArray[randomNumber2];
				inputArray[randomNumber2]=temp;
			}

			else if( randomNumber2<randomNumber1 && inputArray[randomNumber2]>inputArray[randomNumber1] ){
				temp=inputArray[randomNumber1];
				inputArray[randomNumber1]=inputArray[randomNumber2];
				inputArray[randomNumber2]=temp;
			}
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}