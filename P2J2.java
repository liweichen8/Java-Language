
/**
 * Write a description of class P2J2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.*;
//import java.util.Character;


public class P2J2 extends P2J2Test{

    public static void main(String[] args) {
        int n = 2;
        String text = "Kokkarinen";
        boolean[][] rooks= {{false,false}, {false,true}};
        removeDuplicates(text);
        uniqueCharacters(text);
        countSafeSquaresRooks(n, rooks);
        recaman(n);
    }
    
    
    public static String removeDuplicates(String text) {
        String res = "";
	    for (int i = 0; i < text.length(); i++) {
	        if (i == 0 || text.charAt(i) != res.charAt(res.length() - 1)) {
	            res += text.charAt(i);
	        }
	    }
	    //System.out.println(res);
	    return res;
    }   
    
    public static String uniqueCharacters(String text) {
        HashSet<String> set=new HashSet();
        String res="";
        set.add(Character.toString(text.charAt(0)));
        res+=text.charAt(0);
        for (int i=1; i<text.length(); i++) {
            if (set.contains(Character.toString(text.charAt(i)))!=true) {
                set.add(Character.toString(text.charAt(i)));
                res+=text.charAt(i);
            }
        }
        //System.out.println(set);
        //System.out.println(res);
        return res;
    }
    
    public static int countSafeSquaresRooks(int n, boolean[][] rooks) {
        int count=0, countrow=0, countcol=0;
        HashSet<Integer> setrow =new HashSet();
        HashSet<Integer> setcol =new HashSet();
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (rooks[i][j]==true) {
                    setrow.add(i);
                    setcol.add(j);
                }
            }
        }
        countrow = n-setrow.size();
        countcol = n-setcol.size();
        count = countrow*countcol;
        //System.out.println(count);
        return count;
    }
    
    
    public static int recaman(int n) {
        int[] res = new int[n];
        HashSet<Integer> set =new HashSet();
        res[0]=1;
        set.add(1);
        for(int i=1; i<n; i++) {
            //System.out.println(res[i-1]);
            if (res[i-1]-(i+1)>0 && set.contains(res[i-1]-(i+1))!=true) {
                res[i]=res[i-1]-(i+1);
                set.add(res[i-1]-(i+1));
            }
            else {
                res[i]=res[i-1]+(i+1);
                set.add(res[i-1]+(i+1));
            }
        }
        //System.out.println(res[n-1]);
        return res[n-1];
    }
    
    
    
    
    

}