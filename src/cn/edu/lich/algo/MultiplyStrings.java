package cn.edu.lich.algo;

import java.util.ArrayList;
import java.util.List;

public class MultiplyStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Integer: " + (997 * 101));
		System.out.println(multiply("997","101"));
	}
	
	public static String multiply(String num1, String num2){
		List<Integer> list = new ArrayList<Integer>();
		if(num1.equals("0") || num2.equals("0"))return "0";
		for(int i = num1.length() - 1; i >= 0; i--){
			int actualValue = 0;
			int reminder = 0;
			int step = 0;
			int offset = num1.length() - 1 - i;
			int addStep = 0;
			for(int j = num2.length() - 1; j >= 0; j--){
				actualValue = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + step;
				reminder = actualValue % 10;
				step = actualValue / 10;
				if(offset == 0){
					list.add(reminder);
				}else {
					int cur = offset >= list.size() ? 0 : list.get(offset);
					cur += reminder;
					cur += addStep;
					addStep = cur / 10;
					cur %= 10;
					if(offset < list.size())
						list.set(offset, cur);
					else list.add(cur);
					offset++;
				}
			}
			if(step != 0 || addStep != 0){
				actualValue = step + addStep;
				reminder = actualValue % 10;
				step = actualValue / 10;
				list.add(reminder);
				if(step != 0) list.add(step);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = list.size() - 1; i >= 0; i--){
			sb.append(list.get(i));
		}
		return sb.toString();
	}

}
