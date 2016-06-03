package com.dc3.utils.sys;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TokenUtil {

	private static PooledPBEStringEncryptor encryptor;
	
	public TokenUtil(){
		BouncyCastleProvider provider = new BouncyCastleProvider();
		encryptor = new PooledPBEStringEncryptor();
		encryptor.setAlgorithm("PBEWithSHA256And256BitAES-CBC-BC");
		encryptor.setPassword("W3bD3v1");
		encryptor.setProvider(provider);
		encryptor.setPoolSize(20);
	}

	public String encrypt(final String secretTxt) {
		
		String token = encryptor.encrypt(secretTxt);
		token = new String(Base64.encodeBase64URLSafeString(token.getBytes()));
		return token;
	}

	public String decrypt(final String token) {
		String tk = new String(Base64.decodeBase64(token));
		tk = encryptor.decrypt(tk);
		return tk;
	}
}
