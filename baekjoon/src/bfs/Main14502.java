package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main14502 {
	static int N, M;
	static int[][] map;
	static int[] dirX = { 1, 0, -1, 0 };
	static int[] dirY = { 0, 1, 0, -1 };
	static Queue<Virus> queue = new LinkedList<Virus>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//
		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 2) {
					queue.add(new Virus(i, j));
				}
			}
		}
		
		bfs();
	}

	static void bfs() {
		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				Virus virus = queue.poll();

				for (int j = 0; j < 4; j++) {
					int nx = virus.x + dirX[j];
					int ny = virus.y + dirY[j];

					if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
						if (map[nx][ny] == 0) {
							map[nx][ny] = 2;
							queue.add(new Virus(nx, ny));
						}
					}
					
				}
				
			}
			
		}
	}

	static class Virus {
		int x, y;

		public Virus(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Virus [x=" + x + ", y=" + y + "]";
		}

	}

}
