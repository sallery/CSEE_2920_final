import java.util.Date;

public class Block {
    
    public String previousHash;
    public String hash;
    private String transaction;
    private long timeStamp;
    
    public Block(String prevHash, String transaction) {
	this.previousHash = prevHash;
	this.transaction = transaction;
	this.timeStamp = new Date().getTime();
	this.hash = calculateHash();
    }
    
    public String getPreviousHash() {
	return previousHash;
    }

    public String getTransaction() {
	return transaction;
    }
    
    public String getBlockHash() {
	return hash;
    }
    
    public String calculateHash(){
	String calculatedHash = StringUtil.applySha256(
						       previousHash +
						       Long.toString(timeStamp) +
						       transaction);
	return calculatedHash;
    }
}
