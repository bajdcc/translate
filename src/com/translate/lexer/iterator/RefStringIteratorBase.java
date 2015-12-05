package com.translate.lexer.iterator;

/**
 * 迭代器基类，拥有外部装饰器
 * @author bajdc_000
 */
public abstract class RefStringIteratorBase extends RefStringIteratorDecorator {

	protected IRefStringIterator iterator;	
	
	public RefStringIteratorBase(IRefStringIterator iterator) {
		super();
		this.iterator = iterator;
	}
}