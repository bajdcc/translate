package com.translate.parser.tree;

/**
 * 结点接口
 * @author bajdc_000
 */
public interface ITreeNode {

	/**
	 * 被访问
	 * @param visitor 访问者
	 */
	void visit(ITreeNodeVisitor visitor);
	
	/**
	 * 添加孩子
	 * @param node 结点
	 * @param end 是否添加到最后
	 */
	void addNode(ITreeNode node, boolean end);
	
	/**
	 * 孩子结点是否为空
	 * @return 结点是否为空
	 */
	boolean isEmptyNodes();
	
	/**
	 * 孩子结点数
	 * @return 结点数
	 */
	int size();
	
	/**
	 * 存储接口
	 * @return 存储接口
	 */
	IStoreableNode storeable();
}
