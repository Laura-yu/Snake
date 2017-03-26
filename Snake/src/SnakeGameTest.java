
/*
������
 version 1.4
*/
import javax.swing.*;
public class SnakeGameTest {
	public static void main(String[] args) {
        
        //��ʼʱѡ���Ѷȵȼ�
        Object[] options = {"����","�м�","�߼�","�˳�"};
        int response=JOptionPane.showOptionDialog ( null, "        ѡ����Ϸ����","̰����",JOptionPane.YES_OPTION ,JOptionPane.PLAIN_MESSAGE, null, options, options[0] ) ;
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
        frame.setLocationRelativeTo(null);      //�˴��ڽ�������Ļ������
        gamePanel.setFocusable(true);   //��ý���
        
		frame.add(gamePanel);
		c.startGame();
        
        frame.setVisible(true);
	}

}
