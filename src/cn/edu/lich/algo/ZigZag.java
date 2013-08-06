package cn.edu.lich.algo;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * @author lich
 *
 */
public class ZigZag {
	public static void main(String[] args){
		String s = "AB";
		System.out.println(convert(s, 1));
	}
	public static String convert(String s, int nRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
		int columnOffset = 2 * nRows - 2;
		if(nRows == 1) return s;
		char[] chs = new char[s.length()];
		int i = 0;
		for(int r = nRows;r >= 1;r--){
			int st = nRows - r;
			int offset = 0;
			int colOffset = 0;
			boolean onColumn = true;
			while(st + offset < s.length() && i < s.length()) {
				chs[i++] = s.charAt(st+offset);
				if(onColumn) {
					offset += 2 * (r==1?nRows:r) - 2;
				}else {
					colOffset += columnOffset;
					offset = colOffset;
				}
				if(r == 1 || r == nRows){
					onColumn = true;
				}else onColumn = !onColumn;
			}
		}
		
        return new String(chs);
    }
}
