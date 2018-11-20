import java.util.;

public class Main {
	static int n;
	static int m;
	static int ans = 0;
	static int[][] map;
	static int[][] temp;
	static int[][] a = new int [9][9];
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		n = scan.nextInt();
		m = scan.nextInt();

		
		for (int i = 0; i  n; i++) {
			for (int j = 0; j  m; j++) {
				a[i][j] = scan.nextInt();
			}
		}

		for (int i = 0; i  n; i++) {
			for (int j = 0; j  m; j++) {
				if (a[i][j] == 2  a[i][j] == 1)
					continue;
				
				
				a[i][j] = 1;
				clonemap();
				 0인곳에 벽을 세우고 중점을 두고 다른 벽에 2개의 벽을 더 만들자.
				
				wall(1); 1을 넣었으면 현재 위치에 1을 두고 다른 벽을 찾아서 cost를 찾자. 다른 벽에 1을 두는 함수.

				a[i][j] = 0;
				 다시 a[i][j]=0;초기화

			}
		}

		System.out.println(ans);
		scan.close();
	}

	private static void clonemap() {
		 TODO Auto-generated method stub
		map = new int[n][m];
		for (int i = 0; i  n; i++) {
			for (int j = 0; j  m; j++) {
				map[i][j] = a[i][j];
			}
		}
	}

	private static void wall(int cnt) {
		 TODO Auto-generated method stub

		if (cnt == 3) {
			virus();
			return;
		}

		for (int i = 0; i  n; i++) {
			for (int j = 0; j  m; j++) {
				if (map[i][j] == 2  map[i][j] == 1)
					continue;

				map[i][j] = 1;
				wall(cnt + 1);
				map[i][j] = 0;
			}
		}

	}

	private static void virus() {
		 TODO Auto-generated method stub
		int[][] temp = new int[n][m];
		
		for (int i = 0; i  n; i++) {
			for (int j = 0; j  m; j++) {
				temp[i][j] = map[i][j];
			}
		}
		QueuePoint q = new LinkedList();

		for (int i = 0; i  n; i++) {
			for (int j = 0; j  m; j++) {
				if (temp[i][j] == 2) {
					q.add(new Point(i, j));
				}
			}
		}
		while (!q.isEmpty()) {
			Point now = q.remove();

			int x = now.x;
			int y = now.y;

			for (int i = 0; i  4; i++) {
			
					int nx = x + dx[i];
					int ny = y + dy[i];

					if (nx  0  nx = n  ny  0  ny = m)
						continue;
					if (temp[nx][ny] == 2  temp[nx][ny] == 1)
						continue;
					temp[nx][ny] = 2;
					q.add(new Point(nx, ny));

				
			}

		}

		int cost = 0;
		for (int i = 0; i  n; i++) {
			for (int j = 0; j  m; j++) {
				if (temp[i][j] == 0) {
					cost++;
				}
			}
		}

		ans = Math.max(ans, cost);
	}

}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

}