package com.pa3.deber1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String cadena="esto es un ejemplo esto es otro";
		Cadena c=new Cadena();
		System.out.println("Cadena: \n"+cadena);
		System.out.println("Cadena encriptada: \n"+ c.convertirTexto.apply(cadena));
		System.out.println("Conteo de palabras: \n"+ c.contarPalabrasRepetidas.apply(cadena));
	}

}
