
/*
启动类
 version 1.4
*/
import javax.swing.*;
public class SnakeGameTest {
	public static void main(String[] args) {
        
        //开始时选择难度等级
        Object[] options = {"初级","中级","高级","退出"};
        int response=JOptionPane.showOptionDialog ( null, "        选择游戏类型","贪吃蛇",JOptionPane.YES_OPTION ,JOptionPane.PLAIN_MESSAGE, null, options, options[0] ) ;
        if(response == 3) {
                System.exit(0);
        }
        Global.CHOICE = response;

        Snake snake = new Snake();
        Food food = new Food();
        Wall wall = new Wall();
        GamePanel gamePanel = new GamePanel(snake, food, wall);
        Controller c = new Controller(snake, food, wall, gamePanel);
        snake.addSnakeListener(c);
        gamePanel.addKeyListener(c);
        JFrame frame = new JFrame("version 1.4");

        frame.setSize(Global.CELL_SIZE*Global.WIDTH+20, Global.CELL_SIZE*Global.HEIGHT+40);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);      //此窗口将置于屏幕的中央
        gamePanel.setFocusable(true);   //获得焦点
        
		frame.add(gamePanel);
		c.startGame();
        
        frame.setVisible(true);
	}

}
