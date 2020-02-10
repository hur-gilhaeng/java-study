package com.dozone.paint.shape;

import com.dozone.paint.interF.Drawable;

public abstract class Shape implements Drawable{
	private String fillColor;
	private String lineColor;

	public String getFillColor() {
		return fillColor;
	}

	public void setFillColor(String fillColor) {
		this.fillColor = fillColor;
	}

	public String getLineColor() {
		return lineColor;
	}

	public void setLineColor(String lineColor) {
		this.lineColor = lineColor;
	}
	
	//	public abstract void draw();
	//	추상클래스는 interface에서 만든 추상메소드의 정의를 생략할 수 있다
	
}
