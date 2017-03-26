/*
Food类：
    isEatBySnake()判断有没有被snake吃掉
    drawMe()画出食物
    addFood()添加食物
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
