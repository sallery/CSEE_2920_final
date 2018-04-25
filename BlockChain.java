import java.util.Arrays;

public class BlockChain {

    private Block[] chain;
    private int length;
    
    public BlockChain() {
	chain= new Block[50];
	length = 0;
    }
    
    public void add(String transaction) {
	if(length == 0) {
	    String first = "0";
	    Block newBlock = new Block(first, transaction);
	    chain[0] = newBlock;
	    length++;
	}
	else {
	    Block newBlock = new Block(chain[length-1].getBlockHash(), transaction);
	    chain[length] = newBlock;
	    length++;
	}
    }
    
    public void print() {
	for(int i=0; i<length; i++){
	    //System.out.print("Transaction: "+chain[i].getTransact$
	    System.out.println(" Hash: "+chain[i].getBlockHash());
	}
    }
}

