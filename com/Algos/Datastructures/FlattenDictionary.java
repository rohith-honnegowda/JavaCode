package com.Algos.Datastructures;

import java.util.ArrayList;
import java.util.HashMap;

public class FlattenDictionary {

	@SuppressWarnings({ "unchecked"})
	public static void flattenDictionary(HashMap<String, Object> dict, HashMap<String, String> flattened, String key, Object value){
		if(value instanceof String) {
			flattened.put(key, value.toString());
		} else if (value instanceof HashMap<?, ?>) {
			ArrayList<String> keys = new ArrayList<String>(((HashMap<String,Object>) value).keySet());
			for(String str: keys) {
				//System.out.println("Key: " + key + "  " + "Value: " + ((HashMap<String,Object>) value).get(str));
				flattenDictionary(dict, flattened, key + "." + str, ((HashMap<String,Object>) value).get(str));
			}
		}
		
		
	}
	
	public static void printHashMap(HashMap<String, String> hash) {
		for(String key: hash.keySet()) {
			System.out.format("Key: %s || Value: %s\n", key, hash.get(key));
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Object> dict = new HashMap<String, Object>();	
		dict.put("key1", "1");
		HashMap<String, Object> c = new HashMap<String, Object>();
		c.put("d", "3"); c.put("e", "1");
		HashMap<String, Object> key2 = new HashMap<String, Object>();
		key2.put("a", "2"); key2.put("b", "3"); key2.put("c", c);
		dict.put("key2", key2);
		
		HashMap<String, String> flat = new HashMap<String, String>();
		
		for(String str: dict.keySet()) {
			flattenDictionary(dict, flat, str, dict.get(str));
		}
		
		printHashMap(flat);
		
	}

}
