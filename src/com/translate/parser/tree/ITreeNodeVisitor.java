package com.translate.parser.tree;

/**
 * 遍历结点的访问者
 * @author bajdc_000
 */
public interface ITreeNodeVisitor {

	/**
	 * 遍历
	 * @param node 整数
	 */
	void visit(IntegerNode node);
	
	/**
	 * 遍历
	 * @param node 小数点
	 */
	void visit(DotNode node);
	
	/**
	 * 遍历
	 * @param node 小数
	 */
	void visit(DecimalNode node);
	
	/////////////////////////////////////////////////
	
	/**
	 * 遍历
	 * @param node 整数单元
	 */
	void visit(IntegerUnitNode node);
	
	/**
	 * 遍历
	 * @param node 整数原子
	 */
	void visit(IntegerAtomNode node);
}
