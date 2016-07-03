/**
 * 
 */
package projeto2.entidades.seguranca;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author paulo
 *
 */
public class ValidadorDeLogin {

	
	public boolean validarLogin(String senha, String senhaDoBD) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest algorithm = MessageDigest.getInstance("MD5");
        byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));

        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
            hexString.append(String.format("%02X", 0xFF & b));
        }
        String senhaCriptografada = hexString.toString();
        if(senhaCriptografada.equals(senhaDoBD)) return true;
        else return false;
	}
}
