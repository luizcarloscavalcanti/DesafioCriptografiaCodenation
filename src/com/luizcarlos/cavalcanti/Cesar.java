package com.luizcarlos.cavalcanti;

import java.util.Scanner;

public class Cesar {

	private String mensagem;
	private int chave;
	private static char[] alfabeto = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
			'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

	public Cesar() {
		super();
	}

	public Cesar(String mensagem, int chave) {
		super();
		this.mensagem = mensagem;
		this.chave = chave;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public int getChave() {
		return chave;
	}

	public void setChave(int chave) {
		this.chave = chave;
	}

	public static char[] getAlfabeto() {
		return alfabeto;
	}

	public static void setAlfabeto(char[] alfabeto) {
		Cesar.alfabeto = alfabeto;
	}

	public void lerDados(String msg, int casas) {
		Scanner sc = new Scanner(System.in);

		setMensagem(msg.toLowerCase());

		setChave(casas);

		sc.close();

	}

	public char[] decifrar() {
		char[] novaMensagem = new char[getMensagem().length()];
		for (int i = 0; i < getMensagem().length(); i++) {

			if (getMensagem().charAt(i) == ' ') {
				novaMensagem[i] = getMensagem().charAt(i);
			} else {
				for (int j = 0; j < getAlfabeto().length; j++) {

					if (getMensagem().charAt(i) == getAlfabeto()[j]) {
						if (j < getChave()) {
							novaMensagem[i] = getAlfabeto()[(j - getChave() + getAlfabeto().length)
									% getAlfabeto().length];
							j = getAlfabeto().length;
						} else {
							novaMensagem[i] = getAlfabeto()[(j - getChave()) % getAlfabeto().length];
							j = getAlfabeto().length;
						}
					} else {
						novaMensagem[i] = getMensagem().charAt(i);
					}
				}
			}
		}

		return novaMensagem;
	}
}
