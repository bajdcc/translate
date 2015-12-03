package com.translate.style;

import com.translate.style.rmb.RmbStyle;

/**
 * 翻译方案的工厂模式
 * @author bajdc_000
 */
public class StyleFactory implements IStyleController {

	static private StyleFactory one;
	
	public enum StyleType {
		RMB
	}
	
	@Override
	public IStyle createStyle(StyleType type) {
		switch (type) {
		case RMB:
			return RmbStyle.singleton();
		default:
			return null;
		}
	}
	
	static public synchronized IStyleController singleton() {
		if (one == null) {
			one = new StyleFactory();
		}
		return one;
	}
}
