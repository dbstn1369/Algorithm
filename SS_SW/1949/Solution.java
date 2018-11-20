import java.util.*;

public class Solution {

	static int T;
	static int N;
	static int k;
	static int corenum = 0;
	static int a;
	static int[][] map = new int[8][8];
	static int[][] start = new int[5][2];
	static boolean[][] v = new boolean[8][8];
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int ans = Integer.MIN_VALUE;
	static int ans1 = Integer.MIN_VALUE;
	static int lastans = Integer.MIN_VALUE;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		T = scan.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			N = scan.nextInt();
			k = scan.nextInt();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = scan.nextInt();

				}
			}

			a = map[0][0];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (a <= map[i][j]) {
						a = map[i][j];
					}
				}

			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == a) {
						start[corenum][0] = i;
						start[corenum][1] = j;
						corenum++;

					}
				}

			}

			count(k);
			System.out.println("#"+tc+" "+lastans);
			init();

		}

	}

	private static void count(int k2) {
		// TODO Auto-generated method stub

		for (int t = 0; t <= k2; t++) {

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = map[i][j] - t;

					for (int c = 0; c < corenum; c++) {
						int x = start[c][0];
						int y = start[c][1];
						v[x][y] = true;
						dfs(start[c][0], start[c][1], 1);

						v[x][y] = false;
						ans1 = Math.max(ans1, ans);
						
					}

					map[i][j] = map[i][j] + t;

					lastans = Math.max(lastans, ans1);

				}
			}

		}

	}

	private static void init() {
		// TODO Auto-generated method stub
		ans = Integer.MIN_VALUE;
		ans1 = Integer.MIN_VALUE;
		lastans = Integer.MIN_VALUE;
		corenum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = 0;
				v[i][j] = false;
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 2; j++) {
				start[i][j] = 0;
			}
		}
	}

	private static void dfs(int x, int y, int length) {

		// TODO Auto-generated method stub
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx > N - 1 || ny < 0 || ny > N - 1)
				continue;
			if (v[nx][ny] == false) {
				if (map[nx][ny] < map[x][y]) {
					v[nx][ny] = true;
					dfs(nx, ny, length + 1);

					v[nx][ny] = false;
					continue;
				} else {
					continue;
				}

			} else {
				continue;

			}

		}
		ans = Math.max(ans, length);
	}
}
