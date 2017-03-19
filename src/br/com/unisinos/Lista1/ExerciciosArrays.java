package br.com.unisinos.Lista1;

public class ExerciciosArrays {

	public static void main(String args[]) {
		int[][] matriz = { { 4, 1, 2 }, { 3, 2, 1 }, { 5, 8, 6 }, {1, 2, 3, 7, 9, 12, 13, 17} };
		int[] array = { 1, 2, 100, 4, 5 };
		ExerciciosArrays exerciciosArray = new ExerciciosArrays();
		//exerciciosArray.imprimeArray(matriz);
		//exerciciosArray.imprimeArray(array);
		//exerciciosArray.imprimeLinhaArray(matriz, 2);
		//exerciciosArray.imprimeColunaArray(matriz, 1);
		int[] leo = new int[0];
		//try {
		//	System.out.println(exerciciosArray.somaDiagonal(matriz));
		//} catch (MinhaExcecao e) {
		//	System.out.println(e.getMessage());
		//}
		
		//exerciciosArray.imprimeArray(exerciciosArray.encontraPares(matriz));
		//exerciciosArray.imprimeArray(exerciciosArray.encontraPrimos(matriz));
		//System.out.println("Média: " + exerciciosArray.calculaMedia(matriz));
		//exerciciosArray.imprimeArray(exerciciosArray.calculaMediaColunas(matriz));
		
		//exerciciosArray.imprimeNumerosRecursivo(10);
		//System.out.println(exerciciosArray.calculaSomaCubos(4));
		System.out.println(exerciciosArray.maiorValorArray(array));
			
	}

	public void imprimeArray(int[][] m) {
		for (int line = 0; line < m.length; line++) {
			for (int column = 0; column < m[line].length; column++) {
				System.out.print(m[line][column] + " ");
			}
			System.out.println();
		}
	}

	public void imprimeArray(int[] m) {
		for (int index = 0; index < m.length; index++) {
			System.out.println(m[index]);
		}
	}
	
	public void imprimeArray(double[] m) {
		for (int index = 0; index < m.length; index++) {
			System.out.println(m[index]);
		}
	}
	
	public void imprimeLinhaArray(int[][] m, int lin) {
		for (int column = 0; column < m[lin].length; column++) {
			System.out.print(m[lin][column] + " ");
		}
		System.out.println();
	}
	
	public void imprimeColunaArray(int[][] m, int col) {
		for (int line = 0; line < m.length; line++) {
			System.out.println(m[line][col]);
		}
	}
	
	public int somaDiagonal(int[][] m) throws MinhaExcecao {
		for (int line = 0; line < m.length; line++) {
			if (m[line].length != m.length) {
				throw new MinhaExcecao("Não é uma matriz quadrada");
			}
		}
		int somaDiagonal = 0;
		for (int index = 0; index < m.length; index++) {
			somaDiagonal += m[index][index];
		}
		return somaDiagonal;
	}
	
	public int[] encontraPares(int[][] m) {
		int numPares = 0;
		for (int line = 0; line < m.length; line++) {
			for (int column = 0; column < m[line].length; column++) {
				if (m[line][column] % 2 == 0) {
					numPares++;
				}
			}
		}
		if (numPares == 0) {
			return null;
		}
		int[] arrayDePares = new int[numPares];
		int index = 0;
		for (int line = 0; line < m.length; line++) {
			for (int column = 0; column < m[line].length; column++) {
				if (m[line][column] % 2 == 0) {
					arrayDePares[index++] = m[line][column];
				}
			}
		}
		return arrayDePares;
	}
	
	public int[] encontraPrimos(int[][] m) {
		int numPrimos = 0;
		for (int line = 0; line < m.length; line++) {
			for (int column = 0; column < m[line].length; column++) {
				boolean isPrimo = true;
				for (int i = 2; i < m[line][column]; i++) {
					if (m[line][column] % i == 0) {
						isPrimo = false; 
						break;
					}
				}
				if (isPrimo && m[line][column] != 1) {
					numPrimos++;
				}
			}
		}
		if (numPrimos == 0) {
			return null;
		}
		int[] arrayDePrimos = new int[numPrimos];
		int index = 0;
		for (int line = 0; line < m.length; line++) {
			for (int column = 0; column < m[line].length; column++) {
				boolean isPrimo = true;
				for (int i = 2; i < m[line][column]; i++) {
					if (m[line][column] % i == 0) {
						isPrimo = false; 
						break;
					}
				}
				if (isPrimo && m[line][column] != 1) {
					arrayDePrimos[index++] = m[line][column];
				}
			}
		}
		return arrayDePrimos;
	}
	
	public double calculaMedia(int[][] m) {
		int somaMatriz = 0, totalElements = 0;	
		for (int line = 0; line < m.length; line++) {
			for (int column = 0; column < m[line].length; column++) {
				somaMatriz += m[line][column];
				totalElements++;
			}
		}
		if (totalElements == 0) {
			return 0;
		}
		return (double) somaMatriz / totalElements;
	}
	
	public double[] calculaMediaLinhas(int[][] m) {
		double[] mediaLinhas = new double[m.length];
		int index = 0;
		for (int line = 0; line < m.length; line++) {
			int somaLinha = 0;
			for (int column = 0; column < m[line].length; column++) {
				somaLinha += m[line][column];
			}
			mediaLinhas[index++] = (double) somaLinha / m[line].length;
		}
		return mediaLinhas;
	}
	
	public double[] calculaMediaColunas(int[][] m) {
		// Considera que o comprimento não é variavel
		int numColunas = m[0].length, index = 0;
		double[] mediaColunas = new double[numColunas];
		for (int column = 0; column < numColunas; column++) {
			int somaColuna = 0;
			for (int line = 0; line < m.length; line++) {
				somaColuna += m[line][column];
			}
			mediaColunas[index++] = (double) somaColuna / m.length;
		}
		return mediaColunas;
	}
	
	public double calculaMedia(int[][] m, int[][] y) {
		int somaArrays = 0, numElements = 0;
		for (int line = 0; line < m.length; line++) {
			for (int column = 0; column < m[line].length; column++) {
				somaArrays += m[line][column];
				numElements++;
			}
		}
		for (int line = 0; line < y.length; line++) {
			for (int column = 0; column < y[line].length; column++) {
				somaArrays += y[line][column];
				numElements++;
			}
		}
		if (numElements == 0) {
			return 0;
		}
		return (double) somaArrays / numElements;
	}
	
	public int somaArrays(int[][] m, int[][] y) {
		int somaArrays = 0;
		for (int line = 0; line < m.length; line++) {
			for (int column = 0; column < m[line].length; column++) {
				somaArrays += m[line][column];
			}
		}
		for (int line = 0; line < y.length; line++) {
			for (int column = 0; column < y[line].length; column++) {
				somaArrays += y[line][column];
			}
		}
		return somaArrays;
	}
	
	public int[][] somaPosicoesArrays(int[][] m, int[][] y) {
		// Considera-se duas matrizes sem comprimento variavel e de mesmo tamanho
		int[][] matrizSoma = new int[m.length][m[0].length];
		for (int line = 0; line < matrizSoma.length; line++) {
			for (int column = 0; column < matrizSoma[line].length; column++) {
				matrizSoma[line][column] = m[line][column] + y[line][column];
			}
		}
		return matrizSoma;
	}
	
	public void imprimeNumerosRecursivo(int n) {
		if (n > 0) {
			imprimeNumerosRecursivo(n - 1);
		}
		System.out.println(n);
	}
	
	public int calculaSomaCubos(int n) {
		if (n == 1) {
			return 1;
		}
		return (n * n * n) + calculaSomaCubos(n - 1);
	}
	
	public int maiorValorArray(int[] array) {
		return maiorValorArrayRecursivo(array, array.length - 1, Integer.MIN_VALUE);
	}
	
	public int maiorValorArrayRecursivo(int[] array, int index, int maior) {
		if (index < 0) {
			return maior;
		}
		if (array[index] > maior) {
			return maiorValorArrayRecursivo(array, index - 1, array[index]);
		}
		return maiorValorArrayRecursivo(array, index - 1, maior);
	}
}

