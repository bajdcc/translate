package com.translate.parser.tree;

/**
 * 小数原子
 * @author bajdc_000
 */
public class DecimalAtomNode extends StoreableNode {

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
