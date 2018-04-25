import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	
	File file = new File("info.txt");
	Scanner sc;
	try {
	    sc = new Scanner(file);
	    BlockChain chain = new BlockChain();
	    
	    int count = 0;
	    while(sc.hasNextLine()) {
		String transaction = sc.nextLine();
		chain.add(transaction);
		count++;
	    }
	    
	    chain.print();
	}
	catch (FileNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }
}
