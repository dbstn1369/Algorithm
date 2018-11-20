import java.util.*;

public class Solution {
	static int T;
	static int D;
	static int W;
	static int K;
	static int ans = Integer.MAX_VALUE;
	static int cost = Integer.MAX_VALUE;
	static int[][] board = new int[13][20];
	static boolean[] v = new boolean[13];
	static int[][] temp = new int[13][20];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		// �迭�� �޴´�.
		T = scan.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			D = scan.nextInt();
			W = scan.nextInt();
			K = scan.nextInt();

			for (int i = 0; i < D; i++) {
				for (int j = 0; j < W; j++) {
					board[i][j] = scan.nextInt();
				}
			}

			cloneboard(board);
			boolean f = test(K);
			if (!f) {

				dfs(0, 0);

				ans = Math.min(ans, cost);

			} else {
				ans = 0;
			}
			// �� ���� ��� 0 , 1�� �ٲ۴�.
			System.out.println("#" + tc + " " + ans);
			init();
		}
		scan.close();

	}

	static void init() {
		ans = Integer.MAX_VALUE;
		cost = Integer.MAX_VALUE;

		for (int i = 0; i < D; i++) {
			v[i] = false;
			for (int j = 0; j < W; j++) {
				board[i][j] = 0;
				temp[i][j] = 0;
			}
		}

	}

	static void dfs(int x, int t) {
		int count = t;
		boolean f;

		int[][] te = new int[13][20];
		
		
		if (count >= cost) {
			return;
		}
		
		f = test(K);
		if (f) {

			cost = Math.min(cost, count);
			return;
			// count ���� �׽�Ʈ �ؼ� ��� ����.
		}

		for (int i = x; i < D; i++) {

			if (v[i] == true)
				continue;

			if (count +1 >= cost) {
				break;
			} 
			
			for (int a = 0; a < D; a++) {
				for (int b = 0; b < W; b++) {
					te[a][b] = temp[a][b];
				} // ����Լ��� �θ������� te[][]�� ����.
			}

			for (int j = 0; j < W; j++) {
				temp[i][j] = 0;// �Լ��� ����� i�� ���ؼ� 0���� ����.
			}
			v[i] = true;// i�����ؼ� �湮 üũ
			
				dfs(i, count + 1);
			

			for (int j = 0; j < W; j++) {
				temp[i][j] = 1;
			}
			
				dfs(i, count + 1);
			
			v[i] = false;
			cloneboard(te);
			}
		}

	

	static void cloneboard(int[][] b) {
		for (int i = 0; i < D; i++) {
			for (int j = 0; j < W; j++) {
				temp[i][j] = b[i][j];
			}
		}
	}

	static boolean test(int k) {
		int cnt = 0;
		int t;
		int s = 0;

		for (int j = 0; j < W; j++) {
			t = temp[0][j];
			s = 0;
			cnt = 0;
			for (int i = 0; i < D; i++) {
				if (t == temp[i][j]) {
					cnt++;
				} else {
					cnt = 1;
					t = temp[i][j];
				}
				if (cnt >= k) {
					s = cnt;
					break;
				}

			}
			if (s < k) {

				return false;

			}
		}

		return true;
	}

}
