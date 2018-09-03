package atividades;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Scanner;

public class HashTable {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int len = sc.nextInt();
		sc.nextLine();
		String[] input = sc.nextLine().split(" ");

		ArrayList<Integer> keys = new ArrayList<Integer>();
		ArrayList<String> values = new ArrayList<String>();
		ArrayList[] hashTable = new ArrayList[len];

		for (int i = 0; i < len; i++) {
			hashTable[i] = new ArrayList<ObjetoAuxiliar>();
		}

		while (!input[0].equals("end")) {
			if (input[0].equals("end")) {
				break;
			} else if (input[0].equals("keys")) {
				System.out.println(keys.toString());
			} else if (input[0].equals("values")) {
				String[] aux = new String[values.size()];
				for (int i = 0; i < values.size(); i++) {
					aux[i] = values.get(i);
				}
				Arrays.sort(aux);
				System.out.println(aux.toString());
			} else if (input[0].equals("put")) {
				int key = Integer.parseInt(input[1]);
				String value = input[2];

				int hash = key % len;
				ObjetoAuxiliar newOne = new ObjetoAuxiliar(key, value);
				if (hashTable[hash] == null) {
					hashTable[hash] = new ArrayList<ObjetoAuxiliar>();
				}
				if (keys.contains(key)) {
					for (int i = 0; i < hashTable[hash].size(); i++) {
						ObjetoAuxiliar objetoDaVez = (ObjetoAuxiliar) hashTable[hash].get(i);
						if (objetoDaVez.getKey() == key) {
							values.remove(objetoDaVez.getValue());
							objetoDaVez.setValue(value);
							values.add(value);
						}
					}
				} else {
					hashTable[hash].add(newOne);
					keys.add(key);
					values.add(value);
				}
				toString(hashTable);
			} else {
				int key = Integer.parseInt(input[1]);

				int hash = key % len;
				if (hashTable[hash] != null) {
					for (int i = 0; i < hashTable[hash].size(); i++) {
						if (hashTable[hash].get(i) != null) {
							ObjetoAuxiliar objetoDaVez = (ObjetoAuxiliar) hashTable[hash].get(i);
							if (objetoDaVez.getKey() == key) {
								String aux = objetoDaVez.getValue();
								hashTable[hash].remove(i);
								values.remove(aux);
								keys.remove((Integer) (key));

							}
						}

					}
				}
				toString(hashTable);
			}
			input = sc.nextLine().split(" ");
		}
		sc.close();
	}

	public static void toString(ArrayList[] hashTable) {
		String linha = "[";
		for (int i = 0; i < hashTable.length; i++) {
			ArrayList<ObjetoAuxiliar> arraylist = hashTable[i];
			linha += "[";
			for (int y = 0; y < arraylist.size(); y++) {
				linha += arraylist.get(y).toString();
				if (!(y == arraylist.size() - 1))
					linha += ", ";
			}
			linha += "]";
			if (!(i == hashTable.length - 1)) {
				linha += ", ";
			}
		}
		linha += "]";
		System.out.println(linha);
	}

}

class ObjetoAuxiliar {
	public int key;
	public String value;

	public ObjetoAuxiliar(int key, String value) {
		this.key = key;
		this.value = value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "<" + key + ", " + value + ">";
	}

}
