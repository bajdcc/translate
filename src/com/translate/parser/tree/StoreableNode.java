package com.translate.parser.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.translate.style.rmb.RmbParser.NodeDataType;

/**
 * 可存储数据的结点
 * @author bajdc_000
 */
public abstract class StoreableNode implements ITreeNode, IStoreableNode {
	
	private List<ITreeNode> nodes = new ArrayList<>();
	private Map<Integer, Object> stores = new HashMap<>();

	@Override
	public void visit(ITreeNodeVisitor visitor) {
		for (ITreeNode node : nodes) {
			node.visit(visitor);
		}
	}
	
	protected void visitReverse(ITreeNodeVisitor visitor) {
		for (int i = nodes.size() - 1; i >= 0; i--) {
			nodes.get(i).visit(visitor);
		}
	}
	
	@Override
	public void addNode(ITreeNode node, boolean end) {
		if (end) {
			nodes.add(node);
		}
		else {
			nodes.add(0, node);
		}
	}

	@Override
	public void set(NodeDataType key, Object value) {
		stores.put(key.ordinal(), value);
	}
	
	@Override
	public Object get(NodeDataType key) {
		return stores.get(key.ordinal());
	}

	@Override
	public IStoreableNode storeable() {
		return this;
	}
}
