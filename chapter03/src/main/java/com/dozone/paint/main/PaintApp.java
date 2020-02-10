package com.dozone.paint.main;

import com.dozone.paint.interF.Drawable;
import com.dozone.paint.point.ColorPoint;
import com.dozone.paint.point.Point;
import com.dozone.paint.shape.Circle;
import com.dozone.paint.shape.Rect;
import com.dozone.paint.shape.Shape;
import com.dozone.paint.shape.Triangle;
import com.dozone.paint.text.GraphicText;

public class PaintApp {

	public static void main(String[] args) {
		Point point = new Point(2,5);
		//point.setX(2);
		//point.setY(5);
		draw(point);
		
		Point point2 = new Point(10,20);
		draw(point2);
		
		// point2.show(false);
		// ColorPoint a = (ColorPoint) new Point();
		
		ColorPoint point3 = new ColorPoint(50, 100, "red");
		draw(point3);
		
		point3.show(false);
		point3.show(true);
		
		Rect rect = new Rect();
		//drawShape(circle);
		draw(rect);
		
		Triangle triangle = new Triangle();
		//drawShape(circle);
		draw(triangle);
		
		Circle circle = new Circle();
		//drawShape(circle);
		draw(circle);
		
		draw(new GraphicText("hello"));
		
		// instanceof test
		System.out.println(circle instanceof Object);
		System.out.println(circle instanceof Shape);
		System.out.println(circle instanceof Circle);
		// 오류. class는 hierachy의 상위와 하위만  instanceof 연산자를 사용할 수 있다.
		// System.out.println(circle instanceof Rect);
		
		Shape c = new Circle();
		System.out.println(c instanceof Object);
		System.out.println(c instanceof Shape);
		System.out.println(c instanceof Circle);
		System.out.println(c instanceof Rect);
		
		// Interface는 hierachy 상관없이 instanceof 연산자를 사용할 수 있다.
		System.out.println(c instanceof Drawable);
		System.out.println(c instanceof Runnable);
	}
	public static void draw(Drawable drawable) {
		drawable.draw();
	}
	
	
//	public static void drawPoint(Point point) {
//		point.show();
//	}
//	public static void drawShape(Shape shape) {
//		shape.draw();
//	}
}
