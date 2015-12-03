package com.translate.style;

import com.translate.style.rmb.RmbStyle;

/**
 * @author bajdc_000
 * 翻译方案的工厂模式
 */
public class StyleFactory implements IStyleController {

	static private StyleFactory one = new StyleFactory();
	
	public enum StyleType {
		RMB
	}
	
	@Override
	public IStyle createStyle(StyleType type) {
		switch (type) {
		case RMB:
			return new RmbStyle();
		default:
			return null;
		}
	}
	
	static public IStyleController singleton() {
		return one;
	}
}
