import java.util.Scanner;

public class Main {
	static int xSize;
	static int ySize;
	static int lineCnt;
	static int[][] ladder;
	private static Scanner scan;
	static int result;

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		ySize = scan.nextInt();
		lineCnt = scan.nextInt();
		xSize = scan.nextInt();
		ladder = new int[xSize + 2][ySize + 2];

		for (int i = 0; i < lineCnt; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			ladder[x][y] = y + 1;
			ladder[x][y + 1] = y;
		}

		result = -1;
		CountLine(1, 0);

		System.out.println(result);
	}

	static void CountLine(int xCoord, int cnt) {

		if (Check(ladder)) {

			if (result == -1)
				result = cnt;
			else if (result > cnt) {
				result = cnt;
			}
		} else if (cnt < 3) {
			for (int y = 1; y < ySize; y++) {
				for (int x = xCoord; x <= xSize; x++) {
					if (ladder[x][y] == 0 && ladder[x][y + 1] == 0) {
						if (ladder[x][y - 1] != y) {
							ladder[x][y + 1] = y;
							ladder[x][y] = y + 1;

							CountLine(x, cnt + 1);

							ladder[x][y] = 0;
							ladder[x][y + 1] = 0;
						}
					}
				}
			}
		}
	}

	static boolean Check(int[][] ladder) {
		int loc;
		for (int y = 1; y <= ySize; y++) {
			loc = y;
			for (int x = 1; x <= xSize; x++) {
				// print();
				if (ladder[x][loc] != 0) {
					loc = ladder[x][loc];
				}
			}
			if (loc != y) {
				return false;
			}
		}
		return true;
	}

}