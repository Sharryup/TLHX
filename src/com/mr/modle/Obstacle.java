package com.mr.modle;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import com.mr.view.BackgroundImage;





/**
 * 障碍类
 * 
 * @author mingrisoft
 *
 */

public class Obstacle {
    public int x, y;// 横纵坐标
    public boolean judge=false;
    Random r = new Random();
    Dinosaur Dinosaur=new Dinosaur();
    public BufferedImage image,image1;
    private BufferedImage stone;// 石头图片
    private BufferedImage cacti;// 仙人掌图片
    public BufferedImage grub,bird1,mg;
    int temp = r.nextInt(5) + 1;

    private int speed;// 移动速度

    public Obstacle() {
        try {
            stone = ImageIO.read(new File("image/石头.png"));
            cacti = ImageIO.read(new File("image/仙人掌.png"));
            grub = ImageIO.read(new File("image/grub2.png"));
            bird1 = ImageIO.read(new File("image/bird1.png"));
            mg = ImageIO.read(new File("image/mg.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        image1 = mg;
        switch (temp) {
        case 1:
            image = stone;
            break;
        case 2:
            image = cacti;
            break;
        case 3:
            image = grub;
            break;
        case 4:
        	image = bird1;
        	break;
//        case 5:
//        	image = mg;
//        	break;
            default:
                judge=true;
    }
        x = 800;// 初始恒做包
        y = 160;
//        		- image.getHeight();// 纵坐标
        speed = BackgroundImage.SPEED;// 移动速度与背景同步
    }

    
 
    /**
     * 移动
     */
    public void move() {
        x -= speed*2;// 横坐标递减

    }

    /**
     * 获取边界
     * 
     * @return
     */
    public Rectangle getBounds() {
        if (image == cacti) {// 如果使用仙人掌图片
            // 返回仙人掌的边界
            return new Rectangle(x + 7, y, 15, image.getHeight());
        }
        // 返回石头的边界
        return new Rectangle(x + 5, y + 4, 23, 21);
    }
    public Rectangle mgBounds() {//地面蘑菇的碰撞区域
		Rectangle imageicon;
		return new Rectangle(x,y,image1.getWidth(),image1.getHeight());
	}
    public void mgMove() {//蘑菇消失
		y-=700;
	}
	
    
    
    
    /**
     * 是否存活
     * 
     * @return
     */
    public boolean isLive() {
        // 如果移出了游戏界面
        if (x <0) {
            return false;// 消亡
        }
        return true;// 存活
    }
}
