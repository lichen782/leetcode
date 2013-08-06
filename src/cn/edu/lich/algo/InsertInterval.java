package cn.edu.lich.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


public class InsertInterval {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Interval[] intervals = new Interval[] {
				new Interval(1,2),
				new Interval(3,5),
				new Interval(6,7),
				new Interval(8,10),
				new Interval(12,16),
		};
		System.out.println(new InsertInterval().insert(
				new ArrayList<Interval>(Arrays.asList(intervals)), 
						new Interval(4,9)));
	}
	
	private static final IntervalStartTimeComparator startTimeComparator = new IntervalStartTimeComparator();
	
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ArrayList<Interval> result = new ArrayList<Interval>();
        int k1 = binarySearch(intervals, newInterval, startTimeComparator);
        intervals.add(k1, newInterval);
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
    
    private int binarySearch(ArrayList<Interval> intervals, Interval newInterval, Comparator<Interval> comparator){
    	int lo = 0;
    	int hi = intervals.size() - 1;
    	while(lo <= hi){
    		int mid = lo + (hi - lo)/2;
    		int cmp = comparator.compare(newInterval, intervals.get(mid));
    		if(cmp > 0){
    			lo = mid + 1;
    		}else if(cmp < 0){
    			hi = mid - 1;
    		}else return mid;
    	}
    	return lo;
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
    
    public static class IntervalStartTimeComparator implements Comparator<Interval>{

		@Override
		public int compare(Interval o1, Interval o2) {
			return o1.start - o2.start;
		}
    }
    
}
