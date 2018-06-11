package aduhchain;
import java.security.Security;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import com.google.gson.GsonBuilder;
import org.bouncycastle.*;


public class AduhChain {
	
	public static int difficulty = 5;
	
	public static ArrayList<Block> blockchain = new ArrayList<Block>();
	public static HashMap<String, TransactionOutput> UTXOs = new HashMap<String,TransactionOutput>();
	public static Wallet walletA;
	public static Wallet walletB;
	
//	public static Boolean isChainValid() {
//		Block currentBlock;
//		Block previousBlock;
//		
//		for(int i=1; i < blockchain.size(); i++) {
//			currentBlock = blockchain.get(i);
//			previousBlock = blockchain.get(i-1);
//			
//			if(!currentBlock.hash.equals(currentBlock.calculateHash()) ) {
//				System.out.println("Current Hashes not equal");
//				return false;
//			}
//			
//			if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
//				System.out.println("Previous Hashes not equal");
//				
//				return false;
//			}				
//		}
//		return true;
//	}
	
	
	public static void main(String[] args) {
		
//		blockchain.add(new Block("Hi im the first block", "0"));
//		System.out.println("Trying to Mine block 1...");
//		blockchain.get(0).mineBlock(difficulty);
//		
//		blockchain.add(new Block("Yo im the second block", blockchain.get(blockchain.size()-1).hash));
//		System.out.println("Trying to Mine block 2...");
//		blockchain.get(1).mineBlock(difficulty);
//		
//		blockchain.add(new Block("Hey im the third block", blockchain.get(blockchain.size()-1).hash));
//		System.out.println("Trying to Mine block 3...");
//		blockchain.get(2).mineBlock(difficulty);
//		
//		System.out.println("\nBlockchain is Valid: " + isChainValid());
//		
//		String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
//		System.out.println("\nThe block chain: ");
//		System.out.println(blockchainJson);
		
//		Block genesisBlock = new Block("Hi im the first Block", "0");
//		System.out.println("Hash for block 1 : " + genesisBlock.hash);
//		
//		Block secondBlock = new Block("Yo im the second", genesisBlock.hash);
//		System.out.println("Hash for block 2 : " + secondBlock.hash);
//		
//		Block thirdBlock = new Block("Hey im the third block", secondBlock.hash);
//		System.out.println("Hash for block 3 : " + thirdBlock.hash);
		
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
		
		walletA = new Wallet();
		walletB = new Wallet();
		
		System.out.println("Private and public keys:");
		System.out.println(StringUtil.getStringFromKey(walletA.privateKey));
		System.out.println(StringUtil.getStringFromKey(walletA.publicKey));
		
		Transaction transaction = new Transaction(walletA.publicKey, walletB.publicKey, 5, null);
		transaction.generateSignature(walletA.privateKey);
		
		System.out.println("Is Signature verified");
		System.out.println(transaction.verifySignature());
	}
}
