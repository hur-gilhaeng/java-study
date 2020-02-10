package com.dozone.paint.text;

import com.dozone.paint.interF.Drawable;

public class GraphicText implements Drawable {
	private String text;
	
	public GraphicText(String text) {
		this.text = text;
	}

	@Override
	public void draw() {
		System.out.println("텍스트 \'"+text+"\'를 그렸습니다");
	}

}
