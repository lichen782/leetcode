package cn.edu.lich.algo;

public class EditDistance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EditDistance ed = new EditDistance();
		String word1 = "algorithm";
		String word2 = "altruistic";
		
		System.out.println(ed.minDistance(word1, word2));
	}
	
	private int[][] cost;
	
	 public int minDistance(String word1, String word2) {
		 int m = word1.length();
		 int n = word2.length();
		 cost = new int[m + 1][n + 1];
		 String m_word = " " + word1;
		 String n_word = " " + word2;
		 for(int i = 0; i <= m; i++){
			 cost[i][0] = i;
		 }
		 for(int i = 0; i <= n; i++){
			 cost[0][i] = i;
		 }
		 for(int i = 1; i <= m; i++){
			 for(int j = 1; j <= n; j++){
				 int min = cost[i-1][j-1] + (m_word.charAt(i) == n_word.charAt(j) ? 0 : 1);//replace
				 if(cost[i-1][j] + 1 < min){
					 min = cost[i-1][j] + 1;//insert
				 }
				 if(cost[i][j-1] + 1< min){
					 min = cost[i][j-1] + 1;//delete
				 }
				 cost[i][j] = min;
			 }
		 }
		 return cost[m][n];
	 }

}
