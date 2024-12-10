package com.test;

import java.util.*;

class CombinationTest {

	static void unique_combination(int l, int sum, int sumIn, Vector<Integer> CombOut, Vector<Integer> vactorIn) {

		if (sum == sumIn) {
			System.out.print("{");
			for (int i = 0; i < CombOut.size(); i++) {
				if (i != 0)
					System.out.print(" ");
				System.out.print(CombOut.get(i));
				if (i != CombOut.size() - 1)
					System.out.print(", ");
			}
			System.out.println("}");
			return;
		}

		for (int i = l; i < vactorIn.size(); i++) {

			if (sum + vactorIn.get(i) > sumIn)
				continue;

			if (i > l && vactorIn.get(i) == vactorIn.get(i - 1))
				continue;

			CombOut.add(vactorIn.get(i));

			unique_combination(i + 1, sum + vactorIn.get(i), sumIn, CombOut, vactorIn);

			CombOut.remove(CombOut.size() - 1);
		}
	}

	static void Combination(Vector<Integer> vactorIn, int K) {
		Collections.sort(vactorIn);

		Vector<Integer> CombOut = new Vector<Integer>();

		unique_combination(0, 0, K, CombOut, vactorIn);
	}

	public static void main(String[] args) {
		Integer[] arr = { 10, 1, 2, 7, 6, 1, 5 };
		Vector<Integer> vactorIn = new Vector<>(Arrays.asList(arr));

		int sumIn = 8;

		Combination(vactorIn, sumIn);
	}
}
