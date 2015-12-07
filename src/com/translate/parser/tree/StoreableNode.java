package com.translate.parser.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public void set(int key, Object value) {
		stores.put(key, value);
	}
	
	@Override
	public Object get(int key) {
		return stores.get(key);
	}

	@Override
	public IStoreableNode storeable() {
		return this;
	}
}
