package cn.edu.lich.algo;

import java.util.ArrayList;
import java.util.HashSet;

public class SimpleRegexMatch {

	/**
	 * '.' Matches any single character.
		'*' Matches zero or more of the preceding element.
		
		The matching should cover the entire input string (not partial).
		
		The function prototype should be:
		bool isMatch(const char *s, const char *p)
		
		Some examples:
		isMatch("aa","a") ? false
		isMatch("aa","aa") ? true
		isMatch("aaa","aa") ? false
		isMatch("aa", "a*") ? true
		isMatch("aa", ".*") ? true
		isMatch("ab", ".*") ? true
		isMatch("aab", "c*a*b") ? true
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(isMatch("aab","c*a*b"));

	}
	
	public static boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String pattern = "(" + p + ")";
        Digraph graph = new Digraph(pattern.length());
        for(int i = 0; i < pattern.length();i++){
        	if(pattern.charAt(i) == '(') {
        		graph.addEdge(i, i+1);
        	}
        	if(pattern.charAt(i) == '*'){
        		graph.addEdge(i, i+1);
        	}
        	if(i < pattern.length() - 1 && pattern.charAt(i+1) == '*') {
        		graph.addEdge(i, i+1);
        		graph.addEdge(i+1, i);
        	}
        }
        
        return recognize(graph, s, pattern);
        
    }
	
	public static class Digraph {
		private ArrayList<Integer>[] adj;
		private int m_v;
		private int m_e;
		
		@SuppressWarnings("unchecked")
		Digraph(int v) {
			adj = (ArrayList<Integer>[])(new ArrayList[v]);
			for(int i = 0; i < v; i++){
				adj[i] = new ArrayList<Integer>();
			}
			this.m_v = v;
			this.m_e = 0;
		}
		void addEdge(int v, int w){
			adj[v].add(w);
			m_e++;
		}
		
		int V(){return m_v;}
		int E(){return m_e;}
	}
	
	private static void DFS(Digraph graph, boolean[] marked, int source) {
		marked[source]= true;
		for(int v : graph.adj[source]) {
			if(!marked[v]) DFS(graph, marked,v);
		}
	}
	
	private static void DFS(Digraph graph, boolean[] marked, HashSet<Integer> sources) {
		for(int s : sources){
			marked[s] = true;
			for(int v : graph.adj[s]) {
				if(!marked[v]) DFS(graph, marked,v);
			}
		}
	}
	
	private static boolean recognize(Digraph graph, String s, String pattern){
		HashSet<Integer> pc = new HashSet<Integer>();
		boolean[] marked = new boolean[graph.V()];
		DFS(graph, marked, 0);
		for(int i = 0; i < graph.V(); i++) {
			if(marked[i]) pc.add(i);
		}
		for(int i = 0; i < s.length();i++){
			HashSet<Integer> matched = new HashSet<Integer>();
			for(int v : pc) {
				if(v < graph.V()){
					if(s.charAt(i) == pattern.charAt(v) || pattern.charAt(v) == '.') {
						matched.add(v+1);
					}
				}
			}
			pc = new HashSet<Integer>();
			marked = new boolean[graph.V()];
			DFS(graph, marked, matched);
			for(int v = 0; v < graph.V(); v++) {
				if(marked[v]) pc.add(v);
			}
		}
		for(int v: pc) if(v == graph.V() - 1) return true;
		return false;
	}
}
