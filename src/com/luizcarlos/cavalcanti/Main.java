package com.luizcarlos.cavalcanti;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.google.gson.Gson;

public class Main {
	public static void main(String[] args) {
		Gson gson = new Gson();
		BufferedReader br = null;
		Cesar cesar = new Cesar();

		try {
			br = new BufferedReader(new FileReader("answer.json"));
			Resultado resultado = gson.fromJson(br, Resultado.class);
			cesar.lerDados(resultado.getCifrado(), resultado.getNumeroCasas());

			MessageDigest md = MessageDigest.getInstance("SHA1");
			md.update(String.valueOf(cesar.decifrar()).getBytes());

			byte[] digest = md.digest();
			StringBuffer sb = new StringBuffer();
			for (byte b : digest) {
				sb.append(String.format("%02x", b & 0xff));
			}

			System.out.println("Número de Casas: " + resultado.getNumeroCasas());
			System.out.println("Token: " + resultado.getToken());
			System.out.println("Texto Cifrado: " + resultado.getCifrado());
			System.out.println("Texto Decifrado: " + String.valueOf(cesar.decifrar()));
			System.out.println("Resumo Criptografico: " + sb.toString());

			Writer writer = Files.newBufferedWriter(Paths.get("answer.json"));

			Resultado result = new Resultado(
					resultado.getNumeroCasas(), 
					resultado.getToken(), 
					resultado.getCifrado(),
					String.valueOf(cesar.decifrar()), 
					sb.toString());

			gson.toJson(result, writer);

			writer.close();

		} catch (FileNotFoundException | NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}
}
