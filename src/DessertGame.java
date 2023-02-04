import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.application.Platform;
import javafx.geometry.Pos;
import java.util.Random;

public class DessertGame extends Application {
	private int score = 0;

	@Override
	public void start(final Stage stage) {
		// Step 3 & 4
		// Change the window title for this application to "Dessert in the Desert JavaFX
		// Game".
		// Update the dimensions of your scene to be 640 pixels wide by 480 pixels tall.
		BorderPane borderPane = new BorderPane();
		Scene scene = new Scene(borderPane, 640, 480);
		stage.setTitle("Dessert in the Desert JavaFX Game");

		// Step 5
		Label scoreLabel = new Label("Score: 0");
		borderPane.setTop(scoreLabel);
		BorderPane.setAlignment(scoreLabel, Pos.TOP_LEFT);

		Button exitButton = new Button("Exit");
		exitButton.setOnAction(event -> {
			Platform.exit();
		});
		borderPane.setBottom(exitButton);
		BorderPane.setAlignment(exitButton, Pos.BOTTOM_RIGHT);

		// Step 6
		Pane pane = new Pane();
		borderPane.setCenter(pane);
		BorderPane.setAlignment(pane, Pos.CENTER);

		// TODO: Step 7-10
		Random ran = new Random();
		Button but[] = new Button[8];
		for (int i = 0; i < 7; i++) {
			Button desBut = new Button();
			if (i == 6) {
				desBut.setText("Desert");
			} else {
				desBut.setText("Dessert");
			}
			desBut.setOnAction(e -> {
				if (desBut.getText().equals("Dessert")) {
					score--;
				} else {
					score++;
				}
				scoreLabel.setText("Score: " + score);
				randomizeButtonPositions(ran, but);

				exitButton.requestFocus();
			});
			but[i] = desBut;
		}
		randomizeButtonPositions(ran, but);

		pane.getChildren().addAll(but);

		stage.setScene(scene);
		stage.show();
	}
	private void randomizeButtonPositions(Random rand, Button butt[]) {
		for(int i = 0; i < 7; i++) {
			butt[i].setLayoutY(rand.nextInt(400));
			butt[i].setLayoutX(rand.nextInt(600));
		}
	}

	public static void main(String[] args) {
		Application.launch();
	}
}