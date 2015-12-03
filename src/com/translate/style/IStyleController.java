package com.translate.style;

import com.translate.style.StyleFactory.StyleType;

/**
 * 翻译方案的工厂接口
 * @author bajdc_000
 */
public interface IStyleController {

	/**
	 * 创建实例
	 * @param type 实例的类型
	 * @return 实例
	 */
	IStyle createStyle(StyleType type);
}
