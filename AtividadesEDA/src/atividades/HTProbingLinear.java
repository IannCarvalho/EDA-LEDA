package atividades;

import java.util.Arrays;
import java.util.Scanner;

public class HTProbingLinear {

	public static void main(String[] args) {
		Scanner rdr = new Scanner(System.in);

		int len = rdr.nextInt();
		rdr.nextLine();
		HT hashTable = new HT(len);

		String[] entrada = rdr.nextLine().split(" ");
		String saida = null;

		while (!entrada[0].equals("end")) {

			saida = null;
			if (entrada[0].equals("put")) {
				int key = Integer.parseInt(entrada[1]);
				saida = hashTable.push(key, entrada[2]);

			} else if (entrada[0].equals("remove")) {
				int key = Integer.parseInt(entrada[1]);
				saida = hashTable.pop(key);

			} else if (entrada[0].equals("keys")) {
				saida = hashTable.keys();

			} else if (entrada[0].equals("values")) {
				saida = hashTable.values();

			}

			System.out.println(saida);
			entrada = rdr.nextLine().split(" ");
		}

		rdr.close();
	}
}

class HT {
	private ObjetoAuxiliar[] array;
	private int items;

	public HT(int len) {
		this.array = new ObjetoAuxiliar[len];
		this.items = 0;
	}

	public String pop(int key) {
		int hashKey = key % array.length;
		int auxHashKey = hashKey;

		while (array[auxHashKey] == null || array[auxHashKey].getKey() != key) {
			auxHashKey++;
			if (auxHashKey == array.length) {
				auxHashKey = 0;
			}
			if (auxHashKey == hashKey) {
				break;
			}
		}

		array[auxHashKey] = null;

		items--;
		return toString();
	}

	public String push(int key, String value) {
		int hashKey = key % array.length;

		int i = search(key);

		if (i == -1) {
			ObjetoAuxiliar newOne = new ObjetoAuxiliar(key, value);
			int auxHashKey = hashKey;
			while (array[auxHashKey] != null) {
				auxHashKey++;
				if (auxHashKey == array.length) {
					auxHashKey = 0;
				}
				if (auxHashKey == hashKey) {
					break;
				}
			}
			if (array[auxHashKey] == null) {
				array[auxHashKey] = newOne;
				items++;
			}

		} else {
			array[i].setValue(value);
		}
		return toString();
	}

	private int search(int key) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null && array[i].getKey() == key) {
				return i;
			}
		}
		return -1;
	}

	public String values() {
		int j = 0;
		String[] answer = new String[items];
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null) {
				answer[j] = array[i].getValue();
				j++;
			}
		}
		Arrays.sort(answer);
		return Arrays.toString(answer);
	}

	public String keys() {
		int j = 0;
		Integer[] answer = new Integer[items];
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null) {
				answer[j] = array[i].getKey();
				j++;
			}
		}
		Arrays.sort(answer);
		return Arrays.toString(answer);
	}

	@Override
	public String toString() {
		return Arrays.toString(array);
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
