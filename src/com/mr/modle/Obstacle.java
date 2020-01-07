package com.mr.modle;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import com.mr.view.BackgroundImage;





/**
 * �ϰ���
 * 
 * @author mingrisoft
 *
 */

public class Obstacle {
    public int x, y;// ��������
    public boolean judge=false;
    Random r = new Random();
    Dinosaur Dinosaur=new Dinosaur();
    public BufferedImage image,image1;
    private BufferedImage stone;// ʯͷͼƬ
    private BufferedImage cacti;// ������ͼƬ
    public BufferedImage grub,bird1,mg;
    int temp = r.nextInt(5) + 1;

    private int speed;// �ƶ��ٶ�

    public Obstacle() {
        try {
            stone = ImageIO.read(new File("image/ʯͷ.png"));
            cacti = ImageIO.read(new File("image/������.png"));
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
        x = 800;// ��ʼ������
        y = 160;
//        		- image.getHeight();// ������
        speed = BackgroundImage.SPEED;// �ƶ��ٶ��뱳��ͬ��
    }

    
 
    /**
     * �ƶ�
     */
    public void move() {
        x -= speed*2;// ������ݼ�

    }

    /**
     * ��ȡ�߽�
     * 
     * @return
     */
    public Rectangle getBounds() {
        if (image == cacti) {// ���ʹ��������ͼƬ
            // ���������Ƶı߽�
            return new Rectangle(x + 7, y, 15, image.getHeight());
        }
        // ����ʯͷ�ı߽�
        return new Rectangle(x + 5, y + 4, 23, 21);
    }
    public Rectangle mgBounds() {//����Ģ������ײ����
		Rectangle imageicon;
		return new Rectangle(x,y,image1.getWidth(),image1.getHeight());
	}
    public void mgMove() {//Ģ����ʧ
		y-=700;
	}
	
    
    
    
    /**
     * �Ƿ���
     * 
     * @return
     */
    public boolean isLive() {
        // ����Ƴ�����Ϸ����
        if (x <0) {
            return false;// ����
        }
        return true;// ���
    }
}
