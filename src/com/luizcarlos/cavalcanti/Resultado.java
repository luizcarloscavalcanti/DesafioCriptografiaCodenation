package com.luizcarlos.cavalcanti;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Resultado {

@SerializedName("numero_casas")
@Expose
private int numeroCasas;
@SerializedName("token")
@Expose
private String token;
@SerializedName("cifrado")
@Expose
private String cifrado;
@SerializedName("decifrado")
@Expose
private String decifrado;
@SerializedName("resumo_criptografico")
@Expose
private String resumoCriptografico;

public int getNumeroCasas() {
return numeroCasas;
}

public void setNumeroCasas(int numeroCasas) {
this.numeroCasas = numeroCasas;
}

public String getToken() {
return token;
}

public void setToken(String token) {
this.token = token;
}

public String getCifrado() {
return cifrado;
}

public void setCifrado(String cifrado) {
this.cifrado = cifrado;
}

public String getDecifrado() {
return decifrado;
}

public void setDecifrado(String decifrado) {
this.decifrado = decifrado;
}

public String getResumoCriptografico() {
return resumoCriptografico;
}

public void setResumoCriptografico(String resumoCriptografico) {
this.resumoCriptografico = resumoCriptografico;
}

public Resultado(int numeroCasas, String token, String cifrado, String decifrado, String resumoCriptografico) {
	super();
	this.numeroCasas = numeroCasas;
	this.token = token;
	this.cifrado = cifrado;
	this.decifrado = decifrado;
	this.resumoCriptografico = resumoCriptografico;
}

}