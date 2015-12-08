package com.translate.parser.tree;

/**
 * 遍历结点的访问者
 * @author bajdc_000
 */
public interface ITreeNodeVisitor {

	/**
	 * 遍历开始
	 * @param node 整数
	 */
	void visitBegin(IntegerNode node, VisitBag bag);
	
	/**
	 * 遍历开始
	 * @param node 小数点
	 */
	void visitBegin(DotNode node, VisitBag bag);
	
	/**
	 * 遍历开始
	 * @param node 小数
	 */
	void visitBegin(DecimalNode node, VisitBag bag);	
	
	/**
	 * 遍历开始
	 * @param node 整数单元
	 */
	void visitBegin(IntegerUnitNode node, VisitBag bag);
	
	/**
	 * 遍历开始
	 * @param node 整数原子
	 */
	void visitBegin(IntegerAtomNode node, VisitBag bag);
	
	/////////////////////////////////////////////////
	
	/**
	 * 遍历结束
	 * @param node 整数
	 */
	void visitEnd(IntegerNode node);
	
	/**
	 * 遍历结束
	 * @param node 小数点
	 */
	void visitEnd(DotNode node);
	
	/**
	 * 遍历结束
	 * @param node 小数
	 */
	void visitEnd(DecimalNode node);	
	
	/**
	 * 遍历结束
	 * @param node 整数单元
	 */
	void visitEnd(IntegerUnitNode node);
	
	/**
	 * 遍历结束
	 * @param node 整数原子
	 */
	void visitEnd(IntegerAtomNode node);
}
