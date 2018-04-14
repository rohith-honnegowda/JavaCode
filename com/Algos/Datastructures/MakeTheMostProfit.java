package com.Algos.Datastructures;

public class MakeTheMostProfit {

	public static Pair makeMostProfit(int[] prices){
		int global_profit = Integer.MIN_VALUE, current_profit = Integer.MIN_VALUE, current_buy = prices[0], global_sell = prices[1];
		
		for(int i = 1; i < prices.length; i++) {
			current_profit = prices[i] - current_buy;
			if(current_profit > global_profit) {
				global_profit = current_profit;
				global_sell = prices[i];
			}
			
			if(current_buy > prices[i]) {
				current_buy = prices[i];
			}
			
		}
		
		
		return new Pair(global_sell, current_buy);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		int[] prices = new int[] {12,5,9,19};
		Pair bestGlobalprice = makeMostProfit(prices);
		System.out.println("The best buy price = " +bestGlobalprice.second +" And the best Global Sell price is = " + bestGlobalprice.first);;
	}

}
