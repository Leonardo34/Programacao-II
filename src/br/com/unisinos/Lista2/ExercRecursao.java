package br.com.unisinos.Lista2;

public class ExercRecursao {
	public static int calculaSoma1aN(int n) {
		if (n == 1) {
			return 1;
		}
		return n + calculaSoma1aN(n - 1);
	}
	
	public static void main(String[] args) {
		System.out.println(calculaSoma1aN(5));
		int[] array = { 1, 2, 100, 4, 5, 50 };
		System.out.println(somaVetor(array));
	}
	
	public static int somaVetor(int[] array) {
		return somaVetorRecursivo(array, 0, 0);
	}
	
	private static int somaVetorRecursivo(int[] array, int pos, int soma) {
		if (pos >= array.length) {
			return soma;
		}
		return somaVetorRecursivo(array, pos + 1, soma + array[pos]);
	}
}
