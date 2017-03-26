/*
Wall类:
    Wall()构建方法，构建三种不同等级的墙
    inWall()判断Point是否再墙里
    isEatBySnake()判断snake是否撞墙
    drawMe()画出墙
*/
import java.awt.*;
public class Wall {
	private int[][] rocks=new int[Global.WIDTH][Global.HEIGHT];
	public Wall(){
        if(Global.CHOICE==0) {
            for(int y=0;y<Global.HEIGHT;y++){
                for(int x=0;x<Global.WIDTH;x++){
                    if(y==0||y==Global.HEIGHT-1||x==0||x==Global.WIDTH-1){
                        rocks[y][x]=1;
                    }
                }
            }
        }
        else if(Global.CHOICE==1) {
            for(int y=0;y<Global.HEIGHT;y++){
                for(int x=0;x<Global.WIDTH;x++){
                    if((y==0&&x!=Global.WIDTH-3&&x!=Global.WIDTH-4)||(y==Global.HEIGHT-1&&x!=3&&x!=2)||(x==0&&y!=2&&y!=3)||(x==Global.WIDTH-1&&y!=Global.HEIGHT-3&&y!=Global.HEIGHT-4)){
                        rocks[y][x]=1;
                    }
                    else if(y==6)
                        for (int i=1; i<9; i++) {
                            rocks[y][i]=1;
                        }
                    else if(y==13)
                        for (int i=11; i<Global.WIDTH; i++) {
                            rocks[y][i]=1;
                        }
                    else if(x==6)
                        for (int i=11; i<Global.WIDTH; i++) {
                            rocks[i][x]=1;
                        }
                    else if(x==13)
                        for (int i=1; i<9; i++) {
                            rocks[i][x]=1;
                        }
                }
            }
        }
        else {
            for(int y=0;y<Global.HEIGHT;y++){
                for(int x=0;x<Global.WIDTH;x++){
                    if(y==0||y==Global.HEIGHT-1||x==0||x==Global.WIDTH-1){
                        rocks[y][x]=1;
                    }
                    else if(y==6)
                        for (int i=1; i<9; i++) {
                            rocks[y][i]=1;
                        }
                    else if(y==13)
                        for (int i=11; i<Global.WIDTH; i++) {
                            rocks[y][i]=1;
                        }
                    else if(x==6)
                        for (int i=11; i<Global.WIDTH; i++) {
                            rocks[i][x]=1;
                        }
                    else if(x==13)
                        for (int i=1; i<9; i++) {
                            rocks[i][x]=1;
                        }
                }
            }
        }
    }
    public boolean inWall(int r,int c){
       	for(int x=0;x<Global.WIDTH;x++){
    		for(int y=0;y<Global.HEIGHT;y++){
    			if(rocks[c][r]==1){
    			    return true;	
    			}
    		}
    	}
    	return false;
    }
    public boolean isEatBySnake(Snake snake){
    	Point head=snake.getHead();
    	for(int x=0;x<Global.WIDTH;x++){
    		for(int y=0;y<Global.HEIGHT;y++){
    			if(rocks[y][x]==1&&head.x==x&&head.y==y){
    			    return true;	
    			}
    		}
    	}
    	return false;
    }
    public void drawMe(Graphics g){
    	g.setColor(Color.darkGray);
		for(int y=0;y<Global.HEIGHT;y++){
			for(int x=0;x<Global.WIDTH;x++){
				if(rocks[y][x]==1){
					g.fill3DRect(x*Global.CELL_SIZE, y*Global.CELL_SIZE, Global.CELL_SIZE, Global.CELL_SIZE, true);
				}
			}
		}
    }
}
