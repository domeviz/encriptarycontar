package com.pa3.composicion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String texto = "esto es un ejemplo esto es otro ejemplo es";

		Function<String, String> fnTransformar = txt -> {
			StringBuilder sb = new StringBuilder();
			for (char c : txt.toCharArray()) {
				if (c != ' ') {
					c = (char) (c + 1);
				}
				sb.append(c);
			}
			return sb.toString();
		};

		Function<String, Map<String, Integer>> fnContar = txt -> {
			String[] palabras = txt.split(" ");
			Map<String, Integer> cc = new HashMap<>();
			for (String key : palabras) {
				if (cc.containsKey(key)) {
					Integer val = cc.get(key);
					cc.put(key, val + 1);
				} else {
					cc.put(key, 1);
				}
			}
			return cc;
		};

		Function<Map<String, Integer>, List<ConteoPalabra>> fnVector = count -> {
			List<ConteoPalabra> ret = new ArrayList<>();
			for (var entry : count.entrySet()) {
				ret.add(new ConteoPalabra(entry.getKey(), entry.getValue()));
			}
			return ret;
		};

		Function<String, List<ConteoPalabra>> composicion = fnTransformar.andThen(fnContar).andThen(fnVector);

		List<ConteoPalabra> resultado = composicion.apply(texto);
		for (var cc : resultado) {
			System.out.println(cc);
		}

	}

}