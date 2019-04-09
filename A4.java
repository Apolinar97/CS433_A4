
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;


public class A4 {

    public static final int NUMBER_OF_CUSTOMERS = 5;
    public static final int NUMBER_OF_RESOURCES = 4;
    
    public int[] available = new int[NUMBER_OF_RESOURCES];
    public int[][] maximum = new int[NUMBER_OF_CUSTOMERS][NUMBER_OF_RESOURCES]; 
    public int[][] allocation = new int[NUMBER_OF_CUSTOMERS][NUMBER_OF_RESOURCES];
    public int[][] need = new int[NUMBER_OF_CUSTOMERS][NUMBER_OF_RESOURCES];
    
    public A4(int a[][])  {
	this.maximum = a;
    }
    public A4() {
	;
    }
    public int request_resources(int customer_num, int[] request) {
	
	return 0;
    }
    
    public void release_resources(int customer_num, int[] release) {
	

    }
    
    //helper methods.
    public void fill_available() {
	Scanner reader = new Scanner(System.in);
	
	for(int i=0; i<NUMBER_OF_RESOURCES; i++) {
	    System.out.println("Enter data for available: ");
	    available[i] = reader.nextInt();
	}

    }

    public void print_ava() {
	for(int i=0; i<NUMBER_OF_RESOURCES; i++) {
	    System.out.println(available[i]);
	}

    }


    public void fill_max() {
	File file = new File("data.txt");
	int i=0;
	int j=0;
	
	try {
	    Scanner scanner = new Scanner(file);
	    
	    while(scanner.hasNext()) {
		int num = scanner.nextInt();
		
		
		//System.out.println(num);
		if(j == 3 ) {
		    maximum[i][j] = num;
		    i++;
		    j=0;
		   
		    System.out.println(maximum[i][j]);
		}
		else if(i==4) {
		    
		    break;
		}
		else {
		    maximum[i][j] = num;
		    System.out.println(maximum[i][j]);
		    
		}
		j++;
		
	    }
	}
	catch(FileNotFoundException e) {
	    ;
	}
    }

    public void print_max() {
	for(int i=0; i<NUMBER_OF_CUSTOMERS;i++) {
	    for(int j=0; j<NUMBER_OF_RESOURCES; j++) {
		System.out.println(maximum[i][j]+ " ");
	    }
	    
	}
    }
    
    
    public static void main(String[] args)  {
	int ar[][] = new int[][]{
	    {6,4,7,3},
	    {4,2,3,2},
	    {2,5,3,3},
	    {6,3,3,2},
	    {5,6,7,5}
	};

	A4 test = new A4(ar);
	
	test.print_max();
    }


    
}
