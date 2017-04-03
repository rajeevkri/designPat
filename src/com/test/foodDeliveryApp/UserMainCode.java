package com.test.foodDeliveryApp;

import java.io.*;
import java.util.*;

// Read only region start
class UserMainCode {

	public int harry(int input1, int[] input2) {
		// Read only region end
		// Write code here...
		// Input1 is length of iron rod
		// input2 is cost of different size of rods, start index as 1
		int arrLength = input2.length;
		Set<IronRodPrice> sortedSet = new TreeSet<>();
		int index = 0;
		for (int i = 1; i < arrLength; i++) {
			if (i > input1) {
				break;
			}
			sortedSet.add(new IronRodPrice(input2[i], i));
		}
		List<IronRodPrice> sArray = new ArrayList<>(sortedSet);
		int rodLength = input1;
		int maxSum = 0;
		boolean increment = true;
		for (int i = 0;;) {
			IronRodPrice irp = sArray.get(i);
			if (rodLength < irp.rodLength) {
				increment = false;
			} else {
				maxSum += irp.data;
				rodLength = rodLength - irp.rodLength;
			}
			i = increment ? i + 1 : i - 1;

			if ((increment && i >= sArray.size()) ||( !increment &&  i <= 0 )) {
				break;
			}
		}

		return maxSum;
	}

	class IronRodPrice implements Comparable<IronRodPrice> {
		int data;

		int rodLength;

		IronRodPrice(int data, int rodLength) {
			this.data = data;
			this.rodLength = rodLength;
		}

		public int compareTo(IronRodPrice ir) {
			if (data == ir.data) {
				return -1;
			} else if (data > ir.data) {
				return -1;
			} else {
				return 1;
			}
		}
	}

	public static void main(String[] args) {
		int input1 = 5;
		
		int[] input2 = {0,2,1,7,3,5};
		UserMainCode ur = new UserMainCode();
		System.out.println(ur.harry(input1, input2));
	}
}
