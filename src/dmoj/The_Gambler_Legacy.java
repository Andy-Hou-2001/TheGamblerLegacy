package dmoj;

import java.util.ArrayList;

import java.util.Scanner;


public class The_Gambler_Legacy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		final int LENGTH=in.nextInt();
		int[] origin=new int[LENGTH];
		for(int i=0;i<LENGTH;i++) {
			origin[i]=in.nextInt();
		}
//		printArray(origin);
		
		int[] loop=new int[LENGTH];
		boolean[] isEquilibrium=new boolean[LENGTH];
		int[] spec=new int[LENGTH];
		
		
		for(int i=0;i<LENGTH;i++) {
			ArrayList<Integer> ansList=new ArrayList<Integer>();
			
			while(true) {
				int temp;
				if(ansList.size()==0) {
					temp=origin[i];
				}else {
					temp=ansList.get(ansList.size()-1);
				}
				
				int newValue=cal(temp);
				
				if(newValue==origin[i]) {
					isEquilibrium[i]=true;
					loop[i]=0;
					spec[i]=origin[i];
					break;
				}
				
				if(ansList.size()!=0) {
					if(newValue==ansList.get(ansList.size()-1)) {
						isEquilibrium[i]=true;
						loop[i]=ansList.size();
						spec[i]=newValue;
						break;
					}else if(ansList.contains(newValue)) {
						isEquilibrium[i]=false;
						loop[i]=ansList.size()-1;
						spec[i]=ansList.size()-ansList.indexOf(newValue);
						break;
					}
				}
				
				ansList.add(newValue);
	
			}
//			printArrayList(ansList);
	
		}
		for(int i=0;i<LENGTH;i++) {
			if(isEquilibrium[i]) {
				System.out.println("Equilibrium: Bob's investment becomes $"+spec[i]+" after "+loop[i]+" second(s)!");
			}else {
				System.out.println("Instability: Loop of length "+spec[i]+" encountered after "+loop[i]+" second(s)!");
			}
		}		
		
		
		
	}

//	private static void printArrayList(ArrayList<Integer> ansList) {
//		// TODO Auto-generated method stub
//		for(int i: ansList) {
//			System.out.print(i+" ");
//		}
//		System.out.println();
//		
//	}

	private static int cal(int temp) {
		// TODO Auto-generated method stub
		int length=((Integer)temp).toString().length();
		int ans=0;
		for(int i=0;i<length;i++) {
			ans=(int) (ans+Math.pow(temp%10, length));
			temp=temp/10;
		}
		
		
		return ans;
	}

//	private static void printArray(int[] origin) {
//		// TODO Auto-generated method stub
//		for(int i: origin) {
//			System.out.print(i+" ");
//		}
//		System.out.println();
//	}
}
