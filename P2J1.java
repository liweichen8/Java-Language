
/**
 * Write a description of class P2J1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Arrays;

public class P2J1 extends P2J1Test{

    public static void main(String[] args) {
        
        int[] num = {3,1,2};
        long test = fallingPower(5, -4);
        //System.out.println("The number is " + test);
        everyOther(num);
        //System.out.println("The array is " + Arrays.toString(arr));
        createZigZag(4,5,4);
        countInversions(num);


    }
    
    public static long fallingPower(int n, int k) {
        //System.out.println("The question n is " + n);
	//System.out.println("The question k is " + k);
	if (k<0) {
		return 0;
	}
	else if (k==0) {
		return 1;
	}
	else {
		long num=1;
		for(int i = k; i>0; i--) {
			num = num * n;
			n--;
		}
			//System.out.println("The number is " + num);
		return num;
	}
    }
    
    public static int[] everyOther(int[] arr) {
        int size = arr.length;
        int h = 0;
        int[] newarr = new int[(size+(size%2))/2];
        //System.out.println(size);
        //System.out.println(newarr.length);
        if (size <= 1) {
            return arr;
        }
        else {
            for (int i=0; i<size; i++) {
                if (i%2==0) {
                    newarr[h] = arr[i];
                    h++;
                }
            }
            //System.out.println("The array is " + Arrays.toString(newarr));
            return newarr;
        }
    }
    
    public static int[][] createZigZag(int rows, int cols, int start){
        int[][] matrix = new int[rows][cols];
        for (int i=0; i<rows; i++) {
            if (i%2==0) {
                for(int j=0; j<cols; j++) {
                    matrix[i][j]=start;
                    start++;
                }
            }
            else {
                for(int j=cols-1; j>-1; j--) {
                    matrix[i][j]=start;
                    start++;
                }
            }
        }
        //System.out.println("The array is " + Arrays.deepToString(matrix));
        return matrix;
    }
    
    public static int countInversions(int[] arr) {
        int count = 0;
        int len = arr.length;
        if (len<=1) {
            return 0;
        }
        for (int i=0; i<len-1; i++) {
            for (int j=i+1; j<len; j++) {
                if (arr[i]>arr[j]) {
                    count+=1;
                }
            }
        }
        //System.out.println(count);
        return count;
    }
    

}
