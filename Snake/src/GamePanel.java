/*
”Œœ∑√Ê∞Â
*/
import java.awt.Graphics;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
    private Snake snake;
    private Food food;
    private Wall wall;
    public GamePanel(){}
	public GamePanel(Snake snake, Food food, Wall wall) {
		super();
		this.snake = snake;
		this.food = food;
		this.wall = wall;
	}

	public void display(Snake snake, Food food, Wall wall) {
		this.snake = snake;
		this.food = food;
		this.wall = wall;
		repaint();
		
	}


	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (snake != null && food != null && wall != null) {
			snake.drawMe(g);
			food.drawMe(g);
			wall.drawMe(g);
		}
	}
}
