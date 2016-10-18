package br.com.entity;

import java.security.*;
import br.com.dao.LoginDao;

public class Teste {

	public static void main(String[] args) throws Exception {

		
		
		String senha1 = "tiago";

//		MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
//		byte messageDigest[] = algorithm.digest(senha1.getBytes("UTF-8"));
//
//		StringBuilder hexString = new StringBuilder();
//		for (byte b : messageDigest) {
//			hexString.append(String.format("%02X", 0xFF & b));
//		}
//		String senhaf = hexString.toString();
//		System.out.println(senhaf);
//		
//		
//		Login login = new Login();
//		login.setUsuario("user");
//		login.setSenha(senhaf);
//		Login login2 = new LoginDao().logar(login); 
//		
//		System.out.println("User: "+login2.getUsuario());
//		System.out.println("Senha: "+login2.getSenha());
		
		
		
		
		
		String senha2 = "tiago";

		MessageDigest algorithms = MessageDigest.getInstance("SHA-256");
		byte messageDigests[] = algorithms.digest(senha2.getBytes("UTF-8"));

		StringBuilder hexStrings = new StringBuilder();
		for (byte b : messageDigests) {
			hexStrings.append(String.format("%02X", 0xFF & b));
		}
		String senhaff = hexStrings.toString();
		System.out.println(senhaff);
		
		
		

		// String helloWorld = "Hello World!";

		// helloWorld = Base64.encodeBase64String(helloWorld.getBytes());
		//
		// System.out.println("String codificada " + helloWorld);
		//
		// byte[] decoded = Base64.decodeBase64(helloWorld.getBytes());
		//
		// System.out.println(Arrays.toString(decoded));
		//
		// String decodedString = new String(decoded);
		//
		//
		// System.out.println(helloWorld + " = " + decodedString);
		//
		//

	}

}
