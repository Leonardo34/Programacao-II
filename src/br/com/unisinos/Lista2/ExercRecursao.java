package br.com.unisinos.Lista2;

public class ExercRecursao {
	public static int calculaSoma1aN(int n) {
		if (n == 1) {
			return 1;
		}
		return n + calculaSoma1aN(n - 1);
	}

	public static void main(String[] args) {
		// System.out.println(calculaSoma1aN(5));
		//double[] array = { 1, 2, 100, 4, 5, 50 };
		// System.out.println(somaVetor(array));
		// System.out.println(contains("Leonardo", 'o'));
		// System.out.println(contains("Leonardo", 't'));
		// System.out.println(potencia(3, 0));
		// inverteArray(array);
		// printArray(array);
		//char[][] matriz = { { 'a', 'b', 'c' }, { 'd', 'e', 'f' } };
		//imprimeMatriz(matriz);
		int[][] matriz = {{0, 1, 1, 1, 1}, {0,0,0,1,1}, {1,0,1,1,1}, {1,0,0,1,1}, {1,1,0,0,1}, {1,1,1,0,0}};
		System.out.println(encontraCaminho(matriz, 0, 0));
	}
	
	public static void printArray(double[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ", ");
		}
	}

	public static int somaVetor(int[] array) {
		return somaVetorRecursivo(array, 0, 0);
	}

	private static int somaVetorRecursivo(int[] array, int pos, int soma) {
		if (pos == array.length) {
			return soma;
		}
		return somaVetorRecursivo(array, pos + 1, soma + array[pos]);
	}

	public static boolean contains(String word, char c) {
		return containsRec(word, c, 0);
	}

	private static boolean containsRec(String word, char c, int index) {
		if (index == word.length()) {
			return false;
		}
		if (word.charAt(index) == c) {
			return true;
		}
		return containsRec(word, c, ++index);
	}

	public static int potencia(int m, int n) {
		if (n < 0) {
			return 0;
		}
		if (n == 0) {
			return 1;
		}
		return potenciaRec(m, n);
	}

	private static int potenciaRec(int m, int n) {
		if (n == 1) {
			return m;
		}
		return m * potenciaRec(m, n - 1);
	}

	public static void inverteArray(double[] array) {
		inverteArrayRec(array, 0, array.length - 1);
	}

	private static void inverteArrayRec(double[] array, int base, int limite) {
		if (base < limite) {
			double aux = array[base];
			array[base] = array[limite];
			array[limite] = aux;
			inverteArrayRec(array, ++base, --limite);
		}
	}

	public static void imprimeMatriz(char[][] matriz) {
		imprimeMatrizRec(matriz, 0, 0);
	}

	private static void imprimeMatrizRec(char[][] matriz, int line, int column) {
		if (line == matriz.length) {
			return;
		}
		if (column == matriz[line].length) {
			System.out.println();
			imprimeMatrizRec(matriz, ++line, 0);
		} else {
			System.out.print(matriz[line][column] + " ");
			imprimeMatrizRec(matriz, line, ++column);
		}
	}

	public static int sequenciaPadovan(int n) {
		if (n < 3 && n >= 0) {
			return 1;
		}
		if (n < 0) {
			return 0;
		}
		return sequenciaPadovan(n - 2) + sequenciaPadovan(n - 3);
	}
	
	public static boolean isIdentidade(int[] matriz) {
		//return isIdentidadeRec(matriz, 0, 0);
		return true;
	}
	
	private static boolean isIdentidadeRec(int[][] matriz, int line, int column) {
		if (line < matriz.length) {
			if (column == matriz[line].length) {
				isIdentidadeRec(matriz, ++line, 0);
			} else {
				if (line == column) {
					if (matriz[line][column] == 1) {
						isIdentidadeRec(matriz, line, ++column);
					} else {
						return true;
					}
				} else {
					
				}
			}
		}
		return true;
	}
	
	public static void encontraCaminho(int[][] matriz) {
		if (encontraCaminhoR(matriz, 0, 0)) {
			System.out.println("Encontrou Caminho");
		} else {
			System.out.println("Não encontrou");
		}
	}
	
	private static boolean encontraCaminhoR(int matriz[][], int line, int column) {
		if (line == matriz.length - 1 && column == matriz[0].length - 1) {
			return true;
		}
		
		if (line >= 0 && line < matriz.length) {
			if (column >= 0 && column < matriz[line].length) {
				if (matriz[line][column] != 1) {
					System.out.println("Line: " + line + "Column: " + column);
					if (encontraCaminhoR(matriz, line, column + 1)) {
						return true;
					}
					if (encontraCaminhoR(matriz, line + 1, column)) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
}
