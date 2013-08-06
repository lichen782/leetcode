package cn.edu.lich.algo;

import java.util.ArrayList;

public class SimplifyPath {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SimplifyPath sp = new SimplifyPath();
		System.out.println(sp.simplifyPath("/home/"));
		System.out.println(sp.simplifyPath("/a/./b/../../c/"));
		System.out.println(sp.simplifyPath("/../"));
		System.out.println(sp.simplifyPath("/home//foo/"));
	}
	
	 public String simplifyPath(String path) {
	    // Start typing your Java solution below
	    // DO NOT write main() function
	    String[] folders = path.split("/");
	    ArrayList<String> folderList = new ArrayList<String>();
	    for(int i = 0; i < folders.length; i++){
	    	if(folders[i].equals(".")){
	    		continue;
	    	}else if(folders[i].equals("..")){
	    		if(folderList.size() > 0){
	    			folderList.remove(folderList.size() - 1);
	    		}
	    	}else if(folders[i].length() > 0){
	    		folderList.add(folders[i]);
	    	}
	    }
	    StringBuilder sb = new StringBuilder();
	    for(int i = 0; i < folderList.size(); i++){
	    	sb.append("/" + folderList.get(i));
	    }
	    if(sb.length() == 0) sb.append("/");
	    return sb.toString();
	 }

}
