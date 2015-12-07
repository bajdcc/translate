package com.translate.parser.tree;

/**
 * 存储结点接口
 * @author bajdc_000
 */
public interface IStoreableNode {

	/**
	 * 设置数据
	 * @param key 键
	 * @param value  值
	 */
	void set(int key, Object value);

	/**
	 * 取得数据
	 * @param key 键
	 * @return 数据
	 */
	Object get(int key);
}
