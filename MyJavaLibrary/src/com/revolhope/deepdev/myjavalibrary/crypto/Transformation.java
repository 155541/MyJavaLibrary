package com.revolhope.deepdev.myjavalibrary.crypto;

public enum Transformation
{
	AES_CBC_NoPadding("AES/CBC/NoPadding"),                                         // (128)
	AES_CBC_PKCS5Padding("AES/CBC/PKCS5Padding"),                                   // (128)
	AES_ECB_NoPadding("AES/ECB/NoPadding"),                                         // (128)
	AES_ECB_PKCS5Padding("AES/ECB/PKCS5Padding"),                                   // (128)
	DES_CBC_NoPadding("DES/CBC/NoPadding"),                                         // (56)
	DES_CBC_PKCS5Padding("DES/CBC/PKCS5Padding"),                                   // (56)
	DES_ECB_NoPadding("DES/ECB/NoPadding"),                                         // (56)
	DES_ECB_PKCS5Padding("DES/ECB/PKCS5Padding"),                                   // (56)
	DESede_CBC_NoPadding("DESede/CBC/NoPadding"),                                   // (168)
	DESede_CBC_PKCS5Padding("DESede/CBC/PKCS5Padding"),                             // (168)
	DESede_ECB_NoPadding("DESede/ECB/NoPadding"),                                   // (168)
	DESede_ECB_PKCS5Padding("DESede/ECB/PKCS5Padding"),                             // (168)
	RSA_ECB_PKCS1Padding("RSA/ECB/PKCS1Padding"),                                   // (1024, 2048)
	RSA_ECB_OAEPWithSHA_1AndMGF1Padding("RSA/ECB/OAEPWithSHA-1AndMGF1Padding"),     // (1024, 2048)
	RSA_ECB_OAEPWithSHA_256AndMGF1Padding("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");  // (1024, 2048)
	
	private String toString;
	
	private Transformation(String transformation)
	{
		this.toString = transformation;
	}
	
	public String toString()
	{
		return this.toString;
	}
}