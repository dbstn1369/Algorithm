import java.util.*;

public class Solution {

	static boolean[][] board = new boolean[31][12];
	static int N;
	static int M;
	static int H;
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		N = scan.nextInt();
		M = scan.nextInt();
		H = scan.nextInt();

		for (int i = 0; i < M; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();

			board[a][b] = true;

		}

		for (int i = 0; i < 4; i++) {
			solve(1, 0, i);
			if (ans != Integer.MAX_VALUE)
				break;
		}

		if (ans == Integer.MAX_VALUE) {
			ans = -1;
		}

		System.out.println(ans);

	}

	static void solve(int x, int count, int num) {

		if (ans != Integer.MAX_VALUE) {
			return;
		}

		if (count == num) {
			if (test()) {
				ans = count;
			}
			return;
		}

		for (int i = x; i <= H; i++) {
			if (count + 1 >= ans)
				break;
			for (int j = 1; j < N; j++) {

				if (board[i][j] == false) {
					if (board[i][j + 1] == false && board[i][j - 1] == false) {
						board[i][j] = true;

						if (count + 1 < ans) {
							solve(i, count + 1, num);
						}
						board[i][j] = false;
					}

				}

			}

		}

	}

	static boolean test() {

		for (int i = 1; i <= N; i++) {
			int current = i;
			for (int j = 1; j <= H; j++) {
				if (board[j][current] == true)
					current++;
				else if (current - 1 > 0 && board[j][current - 1] == true)
					current--;
			}
			if (i == current)
				continue;
			else
				return false;
		}
		return true;
	}

}
