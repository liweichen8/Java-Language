//===================================================================================								
//Program name: Puzzle Assignment							
//Programmer:   David Chen							
//Date: 2017.3.31								
//Language: Java								
//===================================================================================
//Program Description: This program needed to solve the fastest way (cost smallest steps) for a puzzle to reach all number are 
// the same. The size of the puzzle is 4*4 that contains 16 numbers. A movement maybe merge the other numbers.
//===================================================================================	
//Input -	Using readfile to input a puzzle in two dimensional array
//output-   output some processes of solving such as finding specific number and the total number of steps at last
//processing-  Use recursion to find the peak number or number in same group. There are four recursions represent for direction in each process.
//===================================================================================
//List of Variables -   Let check[][] as an array to detect the number in the same group (type: integer)
//List of Variables -   Let point[][] as an array to record the direction or number that has been detected or checked (type: integer)
//List of Variables -   Let point[][] to have another founction that record the times of number in single happened in the puzzle (type: integer)
//List of Variables -   Let touch[][] as an array to record the trail (type: integer)
//List of Variables -   Let peak as a gobal variable to find the number that is defined as larger than the number surrounding it (type: integer)
//List of Variables -   Let time as a gobal variable that record the times of the numbers happened in the puzzle (type: integer)
//List of Variables -   The stepnum was a gobal variable that follow the processes and record the total steps (type: integer)
//===================================================================================		


import java.util.ArrayList;
import java.io.*;

public class Puzzle {
	static int puzzle[][] = new int[][]{  
		  { 3, 3, 1, 4, },
		  { 4, 5, 5, 3, },
		  { 1, 2, 5, 1, },
		  { 3, 2, 4, 1, },
		};

	static int[][] check = new int[4][4];
	static int[][] point = new int[4][4];
	static int[][] touch = new int[4][4];
	int peak, time, stepnum = 0;
	
	
		
	public static void main(String[] args){
		Puzzle pu = new Puzzle();
		pu.readfile();
		pu.fillarray();
		//pu.modification();
		pu.findthepeak();
		pu.decretopeak();
		pu.evening();
	}

	public void readfile() {
        String fileName ="h:\\temp.txt";
        // This will reference one line at a time
        String line = null;
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =  new BufferedReader(fileReader);
               

            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + fileName + "'");      
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");                                
            // Or we could just do this: 
            // ex.printStackTrace();
        }
    }

	public void fillarray(){
		for (byte x = 0; x <= 3; x++){
			for (byte y = 0; y <= 3; y++){
				System.out.print(puzzle[x][y]);
			}
			System.out.println();
		}
		System.out.println();
	}
	/**fillarray method
	 * just output the original model of puzzle
	 * @param row 
	 * @param column
	 * @param change
	 */
	
	public void modification(int row, int column, int change){
		int change1 = 0; 
		//the variable change was used to determine how many times of modification will happen
		if(change > 0){
			change1 = 1;
		}
		else{
			change = -change;
			//change1 helps me to increase or decrease only one each time
			change1 = -1;
		}
		
		stepnum += change;
		
		for (byte i = 1; i <= change; i++){
			//the first step was to change the starting point
			puzzle[row][column] += change1;
			//n was the original value of the starting point or the point at the last step
			int n = puzzle[row][column] - change1;
			//get through all four direction to check the same values
			puzzle = checkdown(row, column, n, change1);
			puzzle = checkright(row, column, n, change1);
			puzzle = checkup(row, column, n, change1);
			puzzle = checkleft(row, column, n, change1);
		}
		
		for (byte x = 0; x <= 3; x++){
			for (byte y = 0; y <= 3; y++){
				System.out.print(puzzle[x][y]);
			}
			System.out.println();
		}
		System.out.println();
	}
	/** modification method 
	 * receive the parameter of the coordination of the starting point and the value of changing
	 * call four methods: checkdown, checkright, checkup, checkleft. Checking four directions of 
	 same values that need to change 
	 * @param row the row index of the point
	 * @param column the column index of the point
	 * @param n the initial value of the point before changing 
	 * @param change1 the variable to let the puzzle increase or decrease 1
	 * @return it will not return anything but the gobal array puzzle will be modified
	 */

	private int[][] checkdown(int row, int column, int n, int change1) {
		//row = 3 is the boarder of the puzzle, it is also a base case that the point under is not equal to the last point 
		if ( row == 3 || puzzle[row+1][column] != n)
			return puzzle;
		else
			row += 1;
			puzzle[row][column] += change1;
			puzzle = checkright(row, column, n, change1);
			puzzle = checkleft(row, column, n, change1);
			return checkdown(row, column, n, change1);
	}
	/**
	 * the first recursion of direction down.
	 * @return the puzzle base on the condition. In the base case it will not change anything
	 but if it is the same, the point down the last point will also change and continue to check right and left.
	 Also, call itself to continue to check the next point.
	 */
	
	private int[][] checkup(int row, int column, int n, int change1) {
		if ( row == 0 || puzzle[row-1][column] != n)
			return puzzle;
		else
			row -= 1;
			puzzle[row][column] += change1;
			puzzle = checkright(row, column, n, change1);
			puzzle = checkleft(row, column, n, change1);
			return checkup(row, column, n, change1);
	}
	/**
	 * the recursion of direction up
	 * @return the value of puzzle will be changed
	 */
	
	private int[][] checkright(int row, int column, int n, int change1) {
		if ( column == 3 || puzzle[row][column+1] != n)
			return puzzle;
		else
			column += 1;
			puzzle[row][column] += change1;
			puzzle = checkup(row, column, n, change1);
			puzzle = checkdown(row, column, n, change1);
			return checkright(row, column, n, change1);
	}
	/**
	 * the recursion of direction right
	 * @return the value of puzzle will be changed
	 */
	
	private int[][] checkleft(int row, int column, int n, int change1) {
		if ( column == 0 || puzzle[row][column-1] != n)
			return puzzle;
		else
			column -= 1;
			puzzle[row][column] += change1;
			puzzle = checkup(row, column, n, change1);
			puzzle = checkdown(row, column, n, change1);
			return checkleft(row, column, n, change1);
	}
	/**
	 * the recursion of direction left
	 * @return the value of puzzle will be changed
	 */
	
	public void findthepeak(){
		clearpoint();
		int gonext = 1, peaknum=1; 
		for (byte i = 2; i <= 5; i++){
			for (byte x = 0; x <= 3; x++){
				for (byte y = 0; y <= 3; y++){
					if(puzzle[x][y]==i && point[x][y]==0){ 
						point[x][y] = 1;
						coordination(puzzle, i, x, y);
						gonext = checkpeakarray(peaknum);
						if (gonext==1)
							break;			
					}
				}
				if(gonext==1){
					System.out.println("The peak is " + i);
					clearpoint();
					peak = i;
					break;
				}
			}
			if(gonext==1)
				break;
		}
		System.out.println("Test correct!");
	}
	
	private void clearpoint() {
		for (byte x = 0; x <= 3; x++){
			for (byte y = 0; y <= 3; y++){
				point[x][y]=0;
			}
		}
	}
	/**
	 * the point "peak" is defined as the point which all the value around it are smaller than it.
	 This point will be significant to find the smallest step. The peak value will influence all 
	 other numbers smaller than it
	 * @param puzzle the gobal parameter
	 * @param i the value of peak can be from 2 to 5
	 * @return it does not return anything but find the peak
	 */

	private int coordination(int[][] puzzle, byte i, byte row, byte column) {
		int num = 0;
		if (row<3 && check[row+1][column]==0){
			check[row+1][column] = godown(puzzle, i, row, column);
		}
		if (row>0 && check[row-1][column]==0){
			check[row-1][column] = goup(puzzle, i, row, column);
		}
		if (column<3 && check[row][column+1]==0){
			check[row][column+1] = goright(puzzle, i, row, column);
		}
		if (column>0 && check[row][column-1]==0){
			check[row][column-1] = goleft(puzzle, i, row, column);
		}
		return num;
	}
	/**
	 * the coordination method like a unionstation includes all direction of recursion
	 * @param num this variable is useless but in order to use the method in int type, it has to 
	 create a variable that not affect any other orders 
	 * @return num can be ignored
	 */
		
	public static int checkpeakarray(int num){
		for (byte a=0; a<4; a++){
			for (byte b=0; b<4; b++){
				//System.out.print(check[a][b]);
				if (check[a][b]==-1)
					num = -1;
				check[a][b]=0;
			}
			//System.out.println();
		}
		return num;
	}
	/**
	 * after running through coordination method, the check array is used to check is there 
	 the number smaller or biger than starting point. -1 represents ther is a number bigger than 
	 starting point so that this point is not peak
	 * @return the num will be -1 if some numbers around starting point bigger than it
	 */

	private int goup(int[][] puzzle, byte i, byte row, byte column) {
		if (puzzle[row-1][column] > i)
			return -1;
		else if (puzzle[row-1][column] < i)
			return 1;
		else 
			row -= 1;
			check[row][column] = 1;
			point[row][column] = 1;
			return coordination(puzzle, i, row, column);
	}
	/**
	 * the first recursion for find peak. It allows three situations. 
	 * @param i the value of the peak 
	 * @return If the next point larger,
	 return -1 to the num in method "checkpeakarray". If the next point smaller, return 1. If it equals
	 to starting point, this point need to go back to coordination and go through four direction again.
	 */
	
	private int godown(int[][] puzzle, byte i, byte row, byte column) {
		if (puzzle[row+1][column] > i)
			return -1;
		else if (puzzle[row+1][column] < i)
			return 1;
		else 
			row += 1;
			check[row][column] = 1;
			point[row][column] = 1;
			return coordination(puzzle, i, row, column);
	}
	

	private int goleft(int[][] puzzle, byte i, byte row, byte column) {
		if (puzzle[row][column-1] > i)
			return -1;
		else if (puzzle[row][column-1] < i)
			return 1;
		else
			column -= 1;
			check[row][column] = 1;
			point[row][column] = 1;
			return coordination(puzzle, i, row, column);
	}
	
	private int goright(int[][] puzzle, byte i, byte row, byte column) {
		if (puzzle[row][column+1] > i)
			return -1;
		else if (puzzle[row][column+1] < i)
			return 1;
		else
			column += 1;
			check[row][column] = 1;
			point[row][column] = 1;
			return coordination(puzzle, i, row, column);
	}
	
	public void decretopeak(){
		int change = 0;
		if (peak < 5){
			for (byte i = 5; i > peak; i--){
				for (byte x = 0; x <= 3; x++){
					for (byte y = 0; y <= 3; y++){
						if (puzzle[x][y] == i){
							change = peak - puzzle[x][y];
							modification(x, y, change);
						}
					}
				}
			}
		}
		time = checktime(peak);
		System.out.println("The times of peak is " + time);
		if (time > 1)
			touchmost(peak);
	}
	
	public int checktime(int num){
		time = 0;
		for (byte x = 0; x <= 3; x++){
			for (byte y = 0; y <= 3; y++){
				if (puzzle[x][y]==num && point[x][y]==0){
					time+=1;
					point[x][y]=time;
					point = timeup(x ,y , num);
					point = timedown(x ,y , num);
					point = timeleft(x ,y , num);
					point = timeright(x ,y , num);
				}
			}
		}
		clearpoint();
		return time;
	}

	private int[][] timeup(byte row, byte column, int num) {
		if(row==0 || point[row-1][column]==time || puzzle[row-1][column] != num)
			return point;
		else
			row-=1;
			point[row][column]=time;
			point = timeleft(row ,column , num);
			point = timeright(row ,column , num);
			return timeup(row, column, num);
	}
	
	private int[][] timedown(byte row, byte column, int num) {
		if(row==3 || point[row+1][column]==time || puzzle[row+1][column] != num)
			return point;
		else
			row+=1;
			point[row][column]=time;
			point = timeleft(row ,column , num);
			point = timeright(row ,column , num);
			return timedown(row, column, num);
	}
	
	private int[][] timeleft(byte row, byte column, int num) {
		if(column==0 || point[row][column-1]==time || puzzle[row][column-1] != num)
			return point;
		else
			column-=1;
			point[row][column]=time;
			point = timeup(row ,column , num);
			point = timedown(row ,column , num);
			return timeleft(row, column, num);
	}
	
	private int[][] timeright(byte row, byte column, int num) {
		if(column==3 || point[row][column+1]==time || puzzle[row][column+1] != num)
			return point;
		else
			column+=1;
			point[row][column]=time;
			point = timeup(row ,column , num);
			point = timedown(row ,column , num);
			return timeright(row, column, num);
	}
	
	private void clearcheck() {
		for (byte x = 0; x <= 3; x++){
			for (byte y = 0; y <= 3; y++){
				check[x][y]=0;
			}
		}
	}
	
	private void cleartouch() {
		for (byte x = 0; x <= 3; x++){
			for (byte y = 0; y <= 3; y++){
				touch[x][y]=0;
			}
		}
	}
	
	public void touchmost(int exnum){
		int touch = 0, max = 0, min = 0, change = 0, move = 0, connect = 0;
		ArrayList<Integer> step = new ArrayList<Integer>();
		ArrayList<Integer> timenum = new ArrayList<Integer>();
		ArrayList<Integer> touchnum = new ArrayList<Integer>();
		if (exnum == peak){
			for (int i = 1; i < exnum; i++){
				time=0;
				for (byte x = 0; x <= 3; x++){
					for (byte y = 0; y <= 3; y++){
						if (puzzle[x][y]==i && point[x][y]==0){
							step.add(i);
							time+=1;
							point[x][y]=time;
							timenum.add(time);
							point = timeup(x, y, i);
							point = timedown(x, y, i);
							point = timeleft(x, y, i);
							point = timeright(x, y, i);
							touch = findtouch(x, y, i, exnum);
							touchnum.add(touch);
							clearcheck();
							cleartouch();
						}
					}	
				}
			}
		}

		int[][] puzzlenum = new int[3][step.size()];
		for (byte s=0; s<step.size(); s++){
				puzzlenum[0][s] = step.get(s).intValue();	//relate to puzzle
				puzzlenum[1][s] = timenum.get(s).intValue();	//relate to point 
				puzzlenum[2][s] = touchnum.get(s).intValue();
				//System.out.print(puzzlenum[1][s] + " ");
		}
		
		for (byte a = 1; a < step.size(); a++){
			max = puzzlenum[2][0];
			if (puzzlenum[2][a]>max)
				max=puzzlenum[2][a];
		}
		
		for (byte b = 0; b < step.size(); b++){
			if(puzzlenum[2][b]==max){
				change = exnum - puzzlenum[0][b];
				min = change;
				move = puzzlenum[0][b];
				connect = puzzlenum[1][b];
				if (exnum - puzzlenum[0][b]<min){
					change = exnum - puzzlenum[0][b];
					move = puzzlenum[0][b];
					connect = puzzlenum[1][b];
				}
			}
		}
		//System.out.println(change + " " + move + " " + connect);
		
		for(byte c=0; c<=3; c++){
			for(byte d=0; d<=3; d++){
				if (puzzle[c][d]==move&&point[c][d]==connect){
					modification(c, d, change);
					time = checktime(exnum);
				}
			}
		}
		
		if(time>1){
			clearpoint();
			clearcheck();
			cleartouch();
			step.clear();
			timenum.clear();
			touchnum.clear();
			for (byte f = 0; f < 3; f++){
				for(byte e = 0; e < step.size(); e++){
					puzzlenum[f][e]=0;
				}
			}
			touchmost(exnum);
		}
			
	}

	private int findtouch(int row, int column, int num, int exnum) {
		int a=0;
		unionstation(row, column, num, exnum);
		for (byte x = 0; x <= 3; x++){
			for (byte y = 0; y <= 3; y++){
				if (check[x][y]==2)
					a+=1;
			}
		}
		return a;
	}

	private int[][] unionstation(int row, int column, int num, int exnum) {
		int walk = 0;
		check[row][column]=1;
		if (row>0 && touch[row-1][column]==0)
			touchup(row, column, num, walk, exnum);
		if(row<3 && touch[row+1][column]==0)
			touchdown(row, column, num, walk, exnum);
		if(column<3 && touch[row][column+1]==0)
			touchright(row, column, num, walk, exnum);
		if(column>0 && touch[row][column-1]==0)
			touchleft(row, column, num, walk, exnum);
		return check;
	}
	
	private int[][] touchup(int row, int column, int num, int walk, int exnum) {
		if(row > 0 && puzzle[row-1][column]==num){
			row-=1;
			check[row][column] = touch[row][column]=1;
			return unionstation(row, column, num, exnum);
		}
		else if(row == 0 || puzzle[row-1][column]!=exnum){	
			return check;
		}
		else{
			row-=1;
			check[row][column] = 2;
			touch[row][column] = 1;
			if (walk==1){
				check[row][column] = 3;
			}
			check = finchup(row, column, exnum);
			check = finchdown(row, column, exnum);
			check = finchright(row, column, exnum);
			check = finchleft(row, column, exnum);
			walk = 1;
			return touchup(row, column, num, walk, exnum);
		}
	}
	
	private int[][] touchdown(int row, int column, int num, int walk, int exnum) {
		if (row < 3 && puzzle[row+1][column]==num){
			row+=1;
			check[row][column] = touch[row][column]=1;
			return unionstation(row, column, num, exnum);
		}
		else if(row == 3 || puzzle[row+1][column]!=exnum){
			return check;
		}
		else{ 
			row+=1;
			check[row][column] = 2;
			touch[row][column] = 1;
			if (walk == 1){
				check[row][column] = 3;
			}
			check = finchup(row, column, exnum);
			check = finchdown(row, column, exnum);
			check = finchright(row, column, exnum);
			check = finchleft(row, column, exnum);
			walk = 1;
			return touchdown(row, column, num, walk, exnum);
		}
	}
	

	private int[][] touchright(int row, int column, int num, int walk, int exnum) {
		if (column < 3 && puzzle[row][column+1]==num){
			column+=1;
			check[row][column] = touch[row][column]=1;
			return unionstation(row, column, num, exnum);
		}
		else if(column == 3 || puzzle[row][column+1]!=exnum)
			return check;
		else{
			column+=1;
			check[row][column] = 2;
			touch[row][column] = 1;
			if (walk == 1){
				check[row][column] = 3;
			}
			check = finchup(row, column, exnum);
			check = finchdown(row, column, exnum);
			check = finchright(row, column, exnum);
			check = finchleft(row, column, exnum);
			walk = 1;
			return touchright(row, column, num, walk, exnum);
		}
	}
	
	private int[][] touchleft(int row, int column, int num, int walk, int exnum) {
		if (column > 0 && puzzle[row][column-1]==num){
			column-=1;
			check[row][column] = touch[row][column]=1;
			return unionstation(row, column, num, exnum);
		}
		else if(column == 0 || puzzle[row][column-1]!=exnum)
			return check;
		else{
			column-=1;
			check[row][column] = 2;
			touch[row][column] = 1;
			if (walk == 1){
				check[row][column] = 3;
			}
			check = finchup(row, column, exnum);
			check = finchdown(row, column, exnum);
			check = finchright(row, column, exnum);
			check = finchleft(row, column, exnum);
			walk = 1;
			return touchleft(row, column, num, walk, exnum);
		}
	}

	private int[][] finchup(int row, int column, int exnum) {
		if (row==0 || touch[row-1][column]==1 || puzzle[row-1][column]!=exnum){
			//System.out.println("This is check");
			return check;
		}
		else
			row-=1;
			check[row][column]=3;
			touch[row][column]=1;
			
			check = finchright(row, column, exnum);
			check = finchleft(row, column, exnum);
			return finchup(row, column, exnum);
	}
	
	private int[][] finchdown(int row, int column, int exnum){
		if (row==3 || touch[row+1][column]==1 || puzzle[row+1][column]!=exnum){
			return check;
		}
		else
			row+=1;
			check[row][column]=3;
			touch[row][column]=1;
			check = finchright(row, column, exnum);
			check = finchleft(row, column, exnum);
			return finchdown(row, column, exnum);
	}

	private int[][] finchright(int row, int column, int exnum) {
		if (column==3 || touch[row][column+1]==1 || puzzle[row][column+1]!=exnum)
			return check;
		else
			column+=1;
			check[row][column]=3;
			touch[row][column]=1;
			check = finchup(row, column, exnum);
			check = finchdown(row, column, exnum);
			return finchright(row, column, exnum);
	}
	
	private int[][] finchleft(int row, int column, int exnum){
		if (column==0 || touch[row][column-1]==1 || puzzle[row][column]!=exnum){
			return check;
		}
		else
			column-=1;
			check[row][column]=3;
			touch[row][column]=1;
			check = finchup(row, column, exnum);
			check = finchdown(row, column, exnum);
			return finchleft(row, column, exnum);
	}
	
	public void evening(){
		int last, min = 0;
		System.out.println();
		for (byte x = 0; x <= 3; x++){
			for (byte y = 0; y <= 3; y++){
				min = puzzle[0][0];
				//System.out.print(puzzle[x][y]);
				if (puzzle[x][y]<min)
					min = puzzle[x][y];

			}
			//System.out.println();
		}
		last = peak - min;
		stepnum += last;
		System.out.println("It takes " + stepnum + " steps");
	}
}