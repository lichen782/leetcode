package cn.edu.lich.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class WordLadderII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WordLadderII wl = new WordLadderII();
		String start = "red";
		String end = "tax";
		String[] dica = {"ted","tex","red","tax","tad","den","rex","pee"};
		HashSet<String> dict = new HashSet<String>();
		for (String w : dica) {
			dict.add(w);
		}
		System.out.print(wl.findLadders(start, end, dict));
	}
	
	
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>> ();
    	HashMap<String, HashSet<String>> to = new HashMap<String, HashSet<String>>();
    	for(String key : dict) {
    		to.put(key, new HashSet<String>());
    	}
    	to.put(start, new HashSet<String>());
    	LinkedList<String> queue = new LinkedList<String>();
		queue.add(start);
		String lastFirst = start;
		int ret = 1;
		int shortestPath = Integer.MAX_VALUE;
		if(dict.contains(start)) dict.remove(start);
		HashSet<String> marked = new HashSet<String>();
		marked.add(start);
		while (!queue.isEmpty()) {
			String e = queue.removeFirst();
			if (e.equals(lastFirst)) {
				lastFirst = null;
				ret++;
				dict.removeAll(marked);
				if(ret > shortestPath) break;
			}
			for (int i = 0; i < e.length(); i++) {
				char cur = e.charAt(i);
				for (int j = 0; j < 26; j++) {
					StringBuilder sb = new StringBuilder(e);
					char alt = (char)('a' + j);
					if(alt == cur) continue;
					sb.setCharAt(i, alt);
					String s = sb.toString();
					if (dict.contains(s)) {
						queue.addLast(s);
						//dict.remove(s);
						marked.add(s);
						to.get(e).add(s);
						if (lastFirst == null) {
							lastFirst = s;
						}
					}
					if(s.equals(end)) {
						if(shortestPath > ret) shortestPath = ret;
						to.get(e).add(end);
					}
				}
			}
		}
		ArrayList<LinkedList<String>> paths = getPaths(start, to, end);
		for(LinkedList<String> path : paths) {
			result.add(new ArrayList<String>(path));
		}
		
		return result;
    }
    
    private ArrayList<LinkedList<String>> getPaths(String start, HashMap<String, HashSet<String>> to, String end){
    	ArrayList<LinkedList<String>> paths = new ArrayList<LinkedList<String>>();
    	if(to.containsKey(start)){
    		for(String next : to.get(start)){
    			if(next.equals(end)) {
    				LinkedList<String> path = new LinkedList<String>();
    				path.add(start);
    				path.add(end);
    				paths.add(path);
    				continue;
    			}
    			for(LinkedList<String> path : getPaths(next, to, end)){
    				path.addFirst(start);
    				paths.add(path);
    			}
    		}
    	}
    	return paths;
    }
}
