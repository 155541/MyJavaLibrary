package com.revolhope.deepdev.myjavalibrary.crypto;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

public class Cryptography
{
	private static Cryptography INSTANCE;

	private Cryptography()
	{

	}

	public static synchronized Cryptography GetInstance()
	{
		if (INSTANCE == null)
		{
			INSTANCE = new Cryptography();
		}
		return INSTANCE;
	}

	/* public SymmetricCryptography buildSymmetricCipher(Transformation transformation, int mode, Key key)
    {
    	SymmetricCryptography symCipher = new SymmetricCryptography(transformation, mode, key); // TODO
        return symCipher;
    }

    public SymmetricCryptography buildSymmetricCipher(String algorithm, String provider)
    {
    	SymmetricCryptography symCipher = new SymmetricCryptography(algorithm, provider);
        return symCipher;
    }*/
}
