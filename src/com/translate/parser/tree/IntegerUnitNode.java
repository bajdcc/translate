package com.translate.parser.tree;

/**
 * 整数单位
 * @author bajdc_000
 */
public class IntegerUnitNode extends StoreableNode {

	@Override
	public void visit(ITreeNodeVisitor visitor) {
		VisitBag bag = new VisitBag();
		visitor.visitBegin(this, bag);
		if (bag.canVisitChilren()) {
			if (bag.isVisitReverse()) {
				super.visitReverse(visitor);
			} else {
				super.visit(visitor);
			}
		}
		if (bag.canVisitEnd()) {
			visitor.visitEnd(this);
		}
	}

}
