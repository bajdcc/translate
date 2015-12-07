package com.translate.lexer.match;

import java.util.ArrayList;
import java.util.List;

/**
 * 词法分析的匹配结果
 * @author bajdc_000
 */
public class MatchGroup {

	private List<RefString> results;

	public MatchGroup() {
		results = new ArrayList<RefString>();
	}
	
	public RefString getResult(int index) {
		return results.get(index);
	}
	
	public List<RefString> getResults() {
		return results;
	}
	
	public void addResult(RefString result) {
		this.results.add(result);
	}
	
	@Override
	public String toString() {
		return results.toString();
	}
}
