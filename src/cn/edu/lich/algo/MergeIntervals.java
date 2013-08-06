package cn.edu.lich.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MergeIntervals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Interval[] intervals = new Interval[] {
				new Interval(1,3),
				new Interval(2,6),
				new Interval(8,10),
				new Interval(15,18),
		};
		System.out.println(new MergeIntervals().merge(new ArrayList<Interval>(Arrays.asList(intervals))));
	}
	
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Start typing your Java solution below
        // DO NOT write main() function
		ArrayList<Interval> result = new ArrayList<Interval>();
		if(intervals.size() == 0) return result;
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
			
		});
		
		int i = 1;
		result.add(intervals.get(0));
		while(i < intervals.size()){
			Interval last = result.get(result.size() - 1);
			if(last.end >= intervals.get(i).start){//overlapping.
				last.end = Math.max(last.end, intervals.get(i).end);
			}else {
				result.add(intervals.get(i));
			}
			i++;
		}
		
        return result;
    }
	
	 public static class Interval {
	      int start;
	      int end;
	      Interval() { start = 0; end = 0; }
	      Interval(int s, int e) { start = s; end = e; }
	      @Override
	      public String toString() {
	    	  return "[" + start + ", " + end + "]";
	      }
	 }

}
