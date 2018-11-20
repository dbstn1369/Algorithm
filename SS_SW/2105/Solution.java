import java.util.*;

public class Solution {
	static int T;
	static int N;
	static int ans = Integer.MIN_VALUE;
	static int[][] board = new int[22][22];
	static int nx;
	static int ny;
	static int result;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);

		T = scan.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			N = scan.nextInt();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					board[i][j] = scan.nextInt();
				}
			}

			for (int a = 1; a < N; a++) {
				for (int b = 1; b < N; b++) {
					result = 2 * (a + 1 + b + 1);

					for (int i = 0; i < N; i++) {
						for (int j = 1; j < N; j++) {

							if (ans == result)
								break;
							ans = Math.max(ans, circle(i, j, a, b));

						}

					}

				}

			}

			System.out.println("#" + tc + " " + ans);
			/* 출력 */
			init();
		}
		scan.close();

	}

	static void init() {
		nx = 0;
		ny = 0;
		ans = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = 0;
			}
		}
		// 배열 초기화
	}

	static int circle(int x, int y, int a, int b) {

		nx = x;
		ny = y;

		Queue<Integer> q = new LinkedList<>();

		for (int i = 0; i < a; i++) {
			nx = nx + 1;
			ny = ny + 1;
			if (nx < 0 || nx > N - 1 || ny < 0 || ny > N - 1) {
				q.clear();
				return -1;
			}
			if (q.contains(board[nx][ny])) {
				q.clear();
				return -1;

			}
			q.add(board[nx][ny]);

		}
		for (int i = 0; i < b; i++) {
			nx = nx + 1;
			ny = ny - 1;
			if (nx < 0 || nx > N - 1 || ny < 0 || ny > N - 1) {
				q.clear();
				return -1;
			}

			if (q.contains(board[nx][ny])) {
				q.clear();
				return -1;
			}
			q.add(board[nx][ny]);

		}
		for (int i = 0; i < a; i++) {
			nx = nx - 1;
			ny = ny - 1;
			if (nx < 0 || nx > N - 1 || ny < 0 || ny > N - 1) {
				q.clear();
				return -1;
			}

			if (q.contains(board[nx][ny])) {
				q.clear();
				return -1;
			}
			q.add(board[nx][ny]);

		}
		for (int i = 0; i < b; i++) {
			nx = nx - 1;
			ny = ny + 1;
			if (nx < 0 || nx > N - 1 || ny < 0 || ny > N - 1) {
				q.clear();
				return -1;
			}

			if (q.contains(board[nx][ny])) {
				q.clear();
				return -1;
			}
			q.add(board[nx][ny]);

		}

		return q.size();
	}

}
