package br.com.unisinos.Lista1;

public class MinhaExcecao extends Exception {
	private String msg;
	
	public MinhaExcecao(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	public String getMessage() {
		return msg;
	}
	
}
