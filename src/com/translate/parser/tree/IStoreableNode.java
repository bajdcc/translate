package com.translate.parser.tree;

import com.translate.style.rmb.RmbParser.NodeDataType;

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
	void set(NodeDataType key, Object value);

	/**
	 * 取得数据
	 * @param key 键
	 * @return 数据
	 */
	Object get(NodeDataType key);
}
