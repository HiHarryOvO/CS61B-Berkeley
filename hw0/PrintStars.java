public class PrintStars {
	public static void drawTriangle(int N) {
		int i = 1;
		while (i < N + 1) {
			int j = i;
			while (j > 0) {
				System.out.print("*");
				j--;
			}
			System.out.println();
			i++;
		}
	}
	
	public static void main(String[] args) {
		int N = 10;
		drawTriangle(N);
	}
}
