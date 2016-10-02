package com.image;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 动态生成图片
 * @author 57217
 *
 */
public class ImageDemo {

	public void fun1()
	{
		/**
		 * 1.创建图片缓冲区
		 * 2.设置其宽高
		 * 3.得到这个图片的绘制环境()得到画笔
		 * 4.保存起来
		 */
		BufferedImage bi=new BufferedImage(70,35,BufferedImage.TYPE_INT_RGB);
		Graphics2D g=(Graphics2D)bi.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0,70,35);//填充矩形，从(0,0)开始
		g.setColor(Color.RED);
		g.drawString("hello",2, 35-2);//向图片上写字符串
		
		try {
			ImageIO.write(bi,"JPEG",new FileOutputStream("E:/a.jpg"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String []args)
	{
//		ImageDemo id=new ImageDemo();
//		id.fun1();
		VerifyCode vc=new VerifyCode();
		BufferedImage bi=vc.getImage();
		try {
			VerifyCode.output(bi, new FileOutputStream("E:/image.jpg"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
           System.out.println(vc.getText());
	}
}
