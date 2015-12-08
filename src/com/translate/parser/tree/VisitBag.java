package com.translate.parser.tree;

/**
 * 遍历参数
 * @author bajdc_000
 */
public class VisitBag {

	private boolean visitChilren = true;
	private boolean visitEnd = true;
	private boolean visitReverse = false;
	
	public boolean canVisitChilren() {
		return visitChilren;
	}
	public void setVisitChilren(boolean visitChilren) {
		this.visitChilren = visitChilren;
	}
	public boolean canVisitEnd() {
		return visitEnd;
	}	
	public void setVisitEnd(boolean visitEnd) {
		this.visitEnd = visitEnd;
	}
	public boolean isVisitReverse() {
		return visitReverse;
	}
	public void setVisitReverse(boolean visitReverse) {
		this.visitReverse = visitReverse;
	}	
}
