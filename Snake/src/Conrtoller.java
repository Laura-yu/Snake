/*
Controller类:
	keyPressed()判断键盘按键上下左右为转向，空格为暂停
	snakeMoved()判断snake死没死，如果死了要不要再来一局
	startGame()开始游戏
	getPoint()决定放置食物的地方
*/
import javax.swing.JFrame;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.JOptionPane;

class Controller extends KeyAdapter implements SnakeListener {
	private Snake snake;
	private Food food;
	private Wall wall;
	private GamePanel gamePanel;

	public Controller(Snake snake, Food food, Wall wall, GamePanel gamePanel) {
		super();
		this.snake = snake;
		this.food = food;
		this.wall = wall;
		this.gamePanel = gamePanel;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keycode = e.getKeyCode();
		switch (keycode) {
		case KeyEvent.VK_UP:
			snake.changeDirection(Snake.UP);
			break;
		case KeyEvent.VK_DOWN:
			snake.changeDirection(Snake.DOWN);
			break;
		case KeyEvent.VK_LEFT:
			snake.changeDirection(Snake.LEFT);
			break;
		case KeyEvent.VK_RIGHT:
			snake.changeDirection(Snake.RIGHT);
			break;
		case KeyEvent.VK_SPACE:
			if(Global.STOP==0)
				Global.STOP = 1;
			else
				Global.STOP = 0;
		}

	}

	@Override
	public void snakeMoved() {
		if (food.isEatBySnake(snake)) {
			snake.eatFood(food);
			food.addFood(getPoint());
		}
		if (wall.isEatBySnake(snake)||snake.isEatSelf()) {
			snake.setLife(false);
			//游戏结束后决定是否再来一局
			int ifadd;
			Object[] options = {"再来一局","退出"};
	        ifadd=JOptionPane.showOptionDialog ( null, "        Game Over","贪吃蛇",JOptionPane.YES_OPTION ,JOptionPane.PLAIN_MESSAGE, null, options, options[0] ) ;
	        if (ifadd == 0) {
	        	snake=new Snake();
				snake.addSnakeListener(this);
		        this.startGame();
	        }
	        else if(ifadd == 1) {
	                System.exit(0);
	        }
		}
		gamePanel.display(snake, food, wall);

	}

	public void startGame() {
		snake.start();
		food.addFood(getPoint());
	}

	public Point getPoint() {
		int x, y;
		do {
			x = new Random().nextInt(Global.WIDTH);
			y = new Random().nextInt(Global.HEIGHT);
		} while ((wall.inWall(x,y)||snake.inSnake(x,y)));
		return new Point(x, y);
	}

}
