
import java.util.Scanner;
import java.util.Stack;

public class Main {
	static int[][] a ;
	static int ans = Integer.MAX_VALUE;
	static int n;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static boolean[][] v = new boolean[12][12];
	static int[][] core = new int[12][2];
	static int cornum = 0;
	static int cmp = 0;
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int T;

		T = scan.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			n = scan.nextInt();
			a = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					a[i][j] = scan.nextInt();
					if (a[i][j] == 1) {
						v[i][j] = true;
						core[cornum][0] = i;
						core[cornum][1] = j;
						cornum++;
					}

				}
			}

			dfs(0, 0, 0);

			System.out.print("\n#" + tc + " " + ans);

			init();
		}
		scan.close();

	}

	private static void init() {
		// TODO Auto-generated method stub
		ans = Integer.MAX_VALUE;
		cornum = 0;
		cmp = 0;
		
		for (int i = 0; i < n; i++)
	    {
	        for (int j = 0; j < 2; j++) core[i][j] = 0;
	        for (int j = 0; j < n; j++) a[i][j] = 0;
	        for (int j = 0; j < n; j++)	v[i][j] = false; 	
	        	 
	    }

	}

	private static void dfs(int num, int totalnum, int cost) {
		// TODO Auto-generated method stub
		if (num == cornum) {
			if (cmp < totalnum) {
				cmp = totalnum;
				ans = cost;
			} else if (cmp == totalnum)
				ans = Math.min(ans, cost);
			return;

		}

		if (core[num][0] == 0 || core[num][0] == n - 1 || core[num][1] == 0 || core[num][1] == n - 1) {
			dfs(num + 1, totalnum + 1, cost);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nx = core[num][0];
			int ny = core[num][1];
			int len = 0;
			boolean f = true;

			while (true) {
				nx += dx[i];
				ny += dy[i];

				if (nx < 0 || ny < 0 || nx == n || ny == n)
					break;

				if (v[nx][ny]) {
					f = false;
					break;

				}
				v[nx][ny] = true;
				len++;
			}
			if (f)
				dfs(num + 1, totalnum + 1, cost + len);
			while (nx - dx[i] != core[num][0] || ny - dy[i] != core[num][1]) {
				nx -= dx[i];
				ny -= dy[i];
				v[nx][ny] = false;
			}

		}

		dfs(num + 1, totalnum, cost);
	}

}
