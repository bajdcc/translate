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
	 * 存储接口
	 * @return 存储接口
	 */
	IStoreableNode storeable();
}
