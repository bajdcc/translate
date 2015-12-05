package com.translate.lexer.iterator;

/**
 * 基于查找的装饰器
 * @author bajdc_000
 */
public interface IRefStringFindIterator {

	/**
	 * @return 是否查找成功，确定位置
	 */
	boolean found();
	
	/**
	 * @return 包装的迭代器
	 */
	IRefStringIterator iterator();
	
	///////////////////////////////////////////////
	
	/**
	 * 从查找模式指定的位置开始计数，取指定数量的字符为止
	 * @param count 数量
	 * @return 迭代器
	 */
	IRefStringIterator take(int count);
}
