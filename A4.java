
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
    
    public A4(int a[][], int b[][])  {
	this.maximum = a;
	this.allocation = b;
    }
    public A4() {
	;
    }
    
    public int request_resources(int customer_num, int[] request) {
	
	return 0;
    }
    
    public void release_resources(int customer_num, int[] release) {
	;
	
    }
    public void calculate_need(int max[][], int allocation[][])
    {
	int[][] temp = new int[NUMBER_OF_CUSTOMERS][NUMBER_OF_RESOURCES];
	for(int i=0; i<NUMBER_OF_CUSTOMERS; i++)
	    {
		for(int j=0; j<NUMBER_OF_RESOURCES; j++)
		    { 
			temp[i][j] = max[i][j] - allocation[i][j]; 
		    }	
	    }
	need = temp; 
    }
    public void calculate_Available()
    {
	//int[][] temp = new int[NUMBER_OF_RESOURCES][NUMBER_OF_CUSTOMERS];
	for(int i=0; i<NUMBER_OF_RESOURCES; i++)
	    {
		for(int j=0; j<NUMBER_OF_CUSTOMERS; j++)
		    {
			available[j] -= allocation[j][i]; 	
		    }	
	    }	
    }
    //helper methods.
    
    public boolean safety_Algorithm()
    {
	  int[] Work = new int[NUMBER_OF_RESOURCES];
	  int[] Finish = new int[NUMBER_OF_CUSTOMERS];
	  
	  int safetyCount=0;
	  int smallerCount=0;
	  
	  boolean finalSafetyCheck=true;
	  while(safetyCount != NUMBER_OF_CUSTOMERS)
	      {
		  for(int i=0; i<NUMBER_OF_CUSTOMERS; i++)
		      {
			  if(Work[0] <= need[i][0] && Finish[i] == 0)
			      {		
				  for(int j=0; j<NUMBER_OF_RESOURCES; j++)
				      {
					  if(Work[j] <= need[i][j])
					      {
						  smallerCount++;
					      }
					  else if(smallerCount==NUMBER_OF_RESOURCES)
					      {
						  for(int k=0; k<NUMBER_OF_RESOURCES; k++)
						      {
							  Work[k] += allocation[i][k];
						      }
						  smallerCount=0;
					      }
					  else
					      smallerCount=0;
				      }
				  Finish[i] = 1;
				  safetyCount = 0;		
			      }
			  else		
			      {
				  safetyCount++;
			      }	
		      }
	      }
	  
	  for(int i=0; i<NUMBER_OF_RESOURCES; i++)
	      {
		  if(Finish[i] == 0)
		      {
			  finalSafetyCheck = false;
		      }
		  else
		      {	
			  ;
		      }
	      }
	  
	  return finalSafetyCheck; 
    }
    
    public void fill_available() {
	Scanner reader = new Scanner(System.in);
	
	for(int i=0; i<NUMBER_OF_RESOURCES; i++) {
	    System.out.println("Enter data for available: ");
	    available[i] = reader.nextInt();
	}
	
    }
    
    public boolean resource_Request_Accepted(int index, int[] request)
    {
	boolean needSuccess=false;
	boolean availableSuccess=false;
	boolean finalSuccess;
	
	int count = 0;
	int custNum = 0;

	//for(int i=0; i <NUMBER_OF_CUSTOMERS; i++)
	//{
	for(int j=0; j<NUMBER_OF_RESOURCES; j++)
	    {
		if(request[j] <= need[index][j])
		    {
			count++;
		    }
		else if(count == NUMBER_OF_RESOURCES)
		    {
			needSuccess = true;
			custNum = index;
		    }
		else
		    ;
	    }
	//	count=0;
	//	}
	
	for(int i=0; i<NUMBER_OF_RESOURCES; i++)
	    {
		if(request[i] <= available[i])
		    {
			count++;  
		    } 
		else if(count == NUMBER_OF_RESOURCES)
		    {
			availableSuccess = true; 
		    }
		else
		    ;
	    }
	
	if(needSuccess == true && availableSuccess == true)
	    {
		for(int i=0; i<NUMBER_OF_RESOURCES; i++)
		    {
			available[i] = available[i] - request[i];
			allocation[custNum][i] = allocation[custNum][i] + request[i];
			need[custNum][i] = need[custNum][i] - request[i];
		    }
		return true;
	    }
	else
	    ;
	
	return false;
    }

    public void resource_Release(int index, int[] request) {
	
	for(int i=0; i<NUMBER_OF_RESOURCES; i++) {
	    available[i] = available[i] + request[i];
	    allocation[index][i] = allocation[index][i] - request[i];
	    need[index][i] = need[index][i] + request[i];
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

    public void print_2dArray(int[][] a) {
	for(int i=0; i<NUMBER_OF_CUSTOMERS;i++) {
	    for(int j=0; j<NUMBER_OF_RESOURCES; j++) {
		System.out.print(a[i][j]+",");
	    }
	    System.out.println(" ");
	}

    }
    
    
    public static void main(String[] args)  {
	
	Scanner inpt = new Scanner(System.in);
	
	int ar[][] = new int[][]{
	    {6,4,7,3},
	    {4,2,3,2},
	    {2,5,3,3},
	    {6,3,3,2},
	    {5,6,7,5}
	};
	int br[][] = new int[][]{
	    {1,1,1,1},
	    {1,1,1,1},
	    {1,1,1,1},
	    {1,1,1,1},
	    {1,1,1,1}
	};
	
	A4 test = new A4(ar,br);
	test.calculate_need(ar,br);
	test.fill_available();


	boolean isGoing = true;
	String command;
	
	while(isGoing) {
	    System.out.println("Enter command: ");
	    command = inpt.nextLine();

	    switch(command.split(" ")[0]) {
	   
	    case "exit":
		isGoing = false;
		break;

	    case "RQ":
		String[] req = command.split(" ");
		if(req.length !=6) {
		    System.out.println("Error:invalid Argument size");
		    
		}
		else {
		    int cID = Integer.parseInt(req[1]);
		    int reqArr[] = {
			Integer.parseInt(req[2]),Integer.parseInt(req[3]), Integer.parseInt(req[4]),

			
			Integer.parseInt(req[5])
		    };
		    
		    
		    
		    
		    
		    boolean safety =test.safety_Algorithm();
		    if(safety) {
			boolean accepted = test.resource_Request_Accepted(cID,reqArr);
			if(accepted)
			    System.out.println("Resource allocated.");

			else
			    System.out.println("Resource not allocated. ");
		    }
		    else
			{

			    System.out.println("Safety Algorithm failed");
			
			}
		    break;
		    
		}

		

	    case "RL":

		String[] req2 = command.split(" ");
		if(req2.length !=6) {
		    System.out.println("Error:invalid Argument size");
		}
		else {
		    int cID2 = Integer.parseInt(req2[1]);
		    int reqArr2[] = {
			Integer.parseInt(req2[2]),Integer.parseInt(req2[3]), Integer.parseInt(req2[4]),
			Integer.parseInt(req2[5])
		    };
		    test.resource_Release(cID2,reqArr2);
		    System.out.println("Resource released.");
		}
		
		break;
		
	    case "*":
		System.out.println("Maximum:");
		test.print_2dArray(test.maximum);
		System.out.println("Allocation:");
		test.print_2dArray(test.allocation);
		System.out.println("Need:");
		test.print_2dArray(test.need);
		
		break;
		
	    default:
		System.out.println("Invalid command... try again");
		break;
		
		
		
	    }
	    
	    
	}
	
	
    
    }
}
