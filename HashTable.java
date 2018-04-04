/*
 * Peter Hess
 * 3/21/17
 * CSC 172 - Lab 12: Hash Tables
 * 
 * Hash function came from sect. 5.2 of Shaffer.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HashTable {

	static final int def_Cap = 10; //Default capacity

	private String[] table;
	private int Cap; //Table capacity
	private int Items; //Current number of elements
	private double load; //Load factor

	public HashTable() {
		table = new String[def_Cap];
		Cap = def_Cap;
		Items = 0;
		load = 0.0;
	}

	public HashTable(int size) {
		table = new String[size];
		Cap = size;
		Items = 0;
		load = 0.0;
	}
	
	/**
	 * @param str to be inserted
	 */
	public void insert(String str){
		int probe = hash(str, getCap());
		while(table[probe] != null){
			if(table[probe].equals(str)){
				return;
			}
			probe = ++probe % getCap();
		}
		table[probe] = str;
		Items++;
		load = ((double) Items) / Cap;
		if(load > 0.5){
			this.rehash();
		}
	}
	
	/**
	 * Rehashes the table into an array of twice the current capacity.
	 */
	public void rehash(){
		String[] rehash = new String [2*getCap()];
		for(int i = 0; i < table.length; i++){
			if(table[i] != null){
				int probe = hash(table[i], 2*getCap());
				while(rehash[probe] != null){
					probe = ++probe % (2*getCap());
				}
				rehash[probe] = table[i];
			}
		}
		table = rehash;
		Cap = 2*getCap();
	}
	
	//Prints non-null elements in hash table.
	public void print(){
		for(int i = 0; i < table.length; i++){
			if(table[i] != null)
				System.out.print(table[i] + " ");
		}
		System.out.println();
	}

	/**
	 * A hash routine for String objects.
	 * 
	 * @param key the String to hash.
	 * @param tableSize the size of the hash table.
	 * @return the hash value.
	 */
	public static int hash(String key, int tableSize) {
		int hashVal = 0;

		for (int i = 0; i < key.length(); i++)
			hashVal = 37 * hashVal + key.charAt(i);

		hashVal %= tableSize;
		if (hashVal < 0)
			hashVal += tableSize;
		
		return hashVal;
	}

	/** Returns capacity */
	public int getCap() {
		return Cap;
	}

	/** Returns number of unique items */
	public int getItems() {
		return Items;
	}

	/** Returns current load factor */
	public double getLoad() {
		return load;
	}
	
	public static void main(String[] args) {
		HashTable lipsum = new HashTable(13);
		String linetoRead = null;
		int count = 0;
		if (args.length >= 0) {
			try {
				FileReader fileReader = new FileReader(args[0]);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				while ((linetoRead = bufferedReader.readLine()) != null) {
					String[] temp = linetoRead.split(" ");
					for(String i: temp){
						count++;
						lipsum.insert(i);
					}
				}
				bufferedReader.close();
			} catch (IOException ex) {
				System.out.println("File processing error.");
			}
			lipsum.print();
			System.out.println("\nCurrent capacity:" + lipsum.getCap());
			System.out.println("Current number of items:" + lipsum.getItems());
			System.out.println("Items read in:" + count);
		}
	}
}
