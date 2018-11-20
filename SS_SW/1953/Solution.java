import java.util.*;

public class Solution {

	static int T;
	static int N;
	static int M;
	static int R;
	static int C;
	static int L;
	static int[][] map = new int[55][55];
	static boolean[][] v = new boolean[55][55];
	static int count = 0;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int ans=1;
	static int nx;
	static int ny;

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);

		T = scan.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = scan.nextInt();
			M = scan.nextInt();
			R = scan.nextInt();
			C = scan.nextInt();
			L = scan.nextInt();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = scan.nextInt();
				}
			}
			v[R][C] = true;

			bfs();

			System.out.println("#" + tc + " " + ans);
			init();
		}

	}

	private static void init() {
	
		ans = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				map[i][j] = 0;

				v[i][j] = false;
			}
		}
	}

	private static void bfs() {
		// TODO Auto-generated method stub

		point p;
		int num;
		Queue<point> q = new LinkedList<point>();
		q.add(new point(R, C));
		
		
		for (int tc = 0; tc < L-1; tc++)

		{
			
			int size = q.size();
			for(int j =0 ; j <size ; j++) 
				

			{

				p = q.remove();

				int x = p.x;
				int y = p.y;
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i], ny = y + dy[i];
					if (nx < 0 || nx >= N || ny < 0 || ny >= M || v[nx][ny])
						continue;

					boolean f = false;
					int a = map[x][y], b = map[nx][ny];
					if (a == 1) {
						if (i == 0 && (b == 1 || b == 3 || b == 4 || b == 5))
							f = true;
						else if (i == 1 && (b == 1 || b == 3 || b == 6 || b == 7))
							f = true;
						else if (i == 2 && (b == 1 || b == 2 || b == 4 || b == 7))
							f = true;
						else if (i == 3 && (b == 1 || b == 2 || b == 5 || b == 6))
							f = true;
					} else if (a == 2) {
						if (i == 2 && (b == 1 || b == 2 || b == 4 || b == 7))
							f = true;
						else if (i == 3 && (b == 1 || b == 2 || b == 5 || b == 6))
							f = true;
					} else if (a == 3) {
						if (i == 0 && (b == 1 || b == 3 || b == 4 || b == 5))
							f = true;
						else if (i == 1 && (b == 1 || b == 3 || b == 6 || b == 7))
							f = true;
					} else if (a == 4) {
						if (i == 1 && (b == 1 || b == 3 || b == 6 || b == 7))
							f = true;
						else if (i == 3 && (b == 1 || b == 2 || b == 5 || b == 6))
							f = true;
					} else if (a == 5) {
						if (i == 1 && (b == 1 || b == 3 || b == 6 || b == 7))
							f = true;
						else if (i == 2 && (b == 1 || b == 2 || b == 4 || b == 7))
							f = true;
					} else if (a == 6) {
						if (i == 0 && (b == 1 || b == 3 || b == 4 || b == 5))
							f = true;
						else if (i == 2 && (b == 1 || b == 2 || b == 4 || b == 7))
							f = true;
					} else if (a == 7) {
						if (i == 0 && (b == 1 || b == 3 || b == 4 || b == 5))
							f = true;
						else if (i == 3 && (b == 1 || b == 2 || b == 5 || b == 6))
							f = true;
					}

					if (f) {
						v[nx][ny] = true;
						ans++;
						q.add(new point(nx, ny));
					}
				}
			}
		}
	}
}

class point {
	int x;
	int y;

	point(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
