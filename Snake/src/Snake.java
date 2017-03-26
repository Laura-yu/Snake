/*
Snake类:
    setLife()设定snake的生死
    move()判断snake的下一步运动的方位
    getHead()得到snake头的位置
    eatFood()如果snake吃到了食物
    changeDirection()snake改变方向
    drawMe()画出snake
    isEatSelf()判断snake有没有撞到自己
    addSnakeListener()设置监听
    start()游戏开始
SnakeDriver类:
	run()设定snake的运动及其速度
	inSnake()判断Point是不是在snake身上
*/
import java.util.*;
import java.awt.*;
public class Snake {
	private SnakeListener snakeListener;
	private LinkedList<Point> body=new LinkedList<Point>(); 
	public static final int UP=1;
	public static final int DOWN=-1;
	public static final int LEFT=3;
	public static final int RIGHT=-3;
	//private int direction;
	private int oldDirection,newDirection;
	private Point tail;
	private boolean life=true;
	public Snake(){
		init();
	}
	private void init(){
		int x = Global.WIDTH/2;
		int y = Global.HEIGHT/2;
		for(int i=0;i<3;i++){
			body.add(new Point(x-i,y));
		}
		this.oldDirection = this.newDirection = RIGHT;

	}
	public void setLife(boolean life){
		this.life=life;
	}
    public void move(){
    	tail=body.removeLast();
    	int x=body.getFirst().x;
    	int y=body.getFirst().y;

    	if(oldDirection+newDirection!=0)     	
    		this.oldDirection=this.newDirection;
    	switch(oldDirection){
    	case UP:
    		y--;
            if(Global.CHOICE==1) {
                if (x==16 && y<0) {
                    x = 2;
                    y = Global.HEIGHT-1;
                }
                if (x==17 && y<0) {
                    x = 3;
                    y = Global.HEIGHT-1;
                }
            }
    		else if(y<0){
    			y=Global.HEIGHT-1;
    		}
    		break;
    	case DOWN:
    		y++;
    		if(Global.CHOICE==1) {
                if (x==2 && y==Global.HEIGHT) {
                    x = 16;
                    y = 0;
                }
                if (x==3 && y==Global.HEIGHT) {
                    x = 17;
                    y = 0;
                }
            }
            else if(y==Global.HEIGHT){
    			y=0;
    		}
    		break;
    	case LEFT:
    		x--;
    		if(Global.CHOICE==1) {
                if (x<0 && y==2) {
                    x = Global.WIDTH-1;
                    y = Global.HEIGHT-4;
                }
                if (x<0 && y==3) {
                    x = Global.WIDTH-1;
                    y = Global.HEIGHT-3;
                }
            }
            else if(x<0){
    			x=Global.WIDTH-1;
    		}
    		break;
    	case RIGHT:
    		x++;
    		if(Global.CHOICE==1) {
                if (x==Global.WIDTH && y==Global.HEIGHT-4) {
                    x = 0;
                    y = 2;
                }
                if (x==Global.WIDTH && y==Global.HEIGHT-3) {
                    x = 0;
                    y = 3;
                }
            }
            else if(x==Global.WIDTH){
    			x=0;
    		}
    		break;
    	}
        //将指定元素插入此列表的开头
    	body.addFirst(new Point(x,y));
    }

    public Point getHead(){
    	return body.getFirst();
    }
    public void eatFood(Food food){
    	body.addLast(tail);
    }
    public void changeDirection(int direction){
    	this.newDirection=direction;
    }
    public void drawMe(Graphics g){
    	g.setColor(Color.cyan);
    	for(Point p:body){
    		g.fill3DRect(p.x*Global.CELL_SIZE,p.y*Global.CELL_SIZE, Global.CELL_SIZE, Global.CELL_SIZE, true);
    	}
    }
    public boolean isEatSelf(){
    	for(int i=1;i<body.size();i++){
    		if(body.get(i).equals(getHead())){
    			return true;
    		}
    	}
    	return false;
    }
    public void addSnakeListener(SnakeListener listener){
    	if(listener!=null){
    		this.snakeListener=listener;
    	}
    }
	public void start() {
		new SnakeDriver().start();
	}
	private class SnakeDriver extends Thread{
		@Override
		public void run() {
            while(life){
            	if(Global.STOP==0) {
	            	move();
            	}
            	snakeListener.snakeMoved();
            	try {
                    if (Global.CHOICE==2) 
                        Thread.sleep(100);
                    else 
					   Thread.sleep(200);
				}
                catch (InterruptedException e) {
					e.printStackTrace();
				}
            }
		}
	}
	public boolean inSnake(int x, int y) {
        Point p=new Point(x,y);
		return body.contains(p);
	}
}
