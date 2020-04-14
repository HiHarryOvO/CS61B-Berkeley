package start;

public class WindowPosSum {
	public static void windowPosSum(int[] a, int n) {
	    if (n < 0) {
	    	System.out.println("The value of n should be equal or greater than 0.");
	    }
		
		for (int i = 0; i < a.length; i++) {
			if (a[i] < 0) {
	    		continue;
	    	}
	    	
			int sum = 0;
	    	for (int j = 0; j <= n; j++) {
	    		if (i + j >= a.length) {
	    			break;
	    		}
	    		sum += a[i + j];
	    	}
	    	a[i] = sum;
	    }
	  }

	public static void main(String[] args) {
	    int[] a = {1, -1, -1, 10, 5, -1};
	    int n = 2;
	    windowPosSum(a, n);

	    // Should print 4, 8, -3, 13, 9, 4
	    System.out.println(java.util.Arrays.toString(a));
	}
}
