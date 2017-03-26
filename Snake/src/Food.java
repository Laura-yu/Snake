/*
Food�ࣺ
    isEatBySnake()�ж���û�б�snake�Ե�
    drawMe()����ʳ��
    addFood()���ʳ��
*/
import java.awt.*;
public class Food extends Point{

    public boolean isEatBySnake(Snake snake){
    	Point head=snake.getHead();
    	if(this.equals(head)){
    		return true;
    	}
    	return false;
    }
    public void drawMe(Graphics g){
    	g.setColor(Color.orange);
    	g.fillOval(x*Global.CELL_SIZE, y*Global.CELL_SIZE, Global.CELL_SIZE,Global.CELL_SIZE);
    }
    public void addFood(Point p){
    	this.x=p.x;
    	this.y=p.y;
    	
    }
}
