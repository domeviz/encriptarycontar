package com.pa3.deber1;

import java.util.function.Function;

public class Cadena {

	Function<String, String> convertirTexto = f -> {
		StringBuilder cambiar = new StringBuilder();
		for (int i = 0; i < f.length(); i++) {
			char c = f.charAt(i);
			if (c == 'z') {
				cambiar.append('a');
			} else if (c == 'Z') {
				cambiar.append('A');
			} else if (c == ' ') {
				cambiar.append(' ');
			} else {
				cambiar.append((char) (c + 1));
			}
		}
		return cambiar.toString();
	};

	Function<String, Conteo<String, Integer>> contarPalabrasRepetidas = f -> {
		Conteo<String, Integer> contar = new Conteo<>();
		String[] palabras = f.split("\\s+");
		for (String palabra : palabras) {
			if (contar.containsKey(palabra)) {
				contar.put(palabra, contar.get(palabra) + 1);
			} else {
				contar.put(palabra, 1);
			}
		}
		return contar;
	};

}