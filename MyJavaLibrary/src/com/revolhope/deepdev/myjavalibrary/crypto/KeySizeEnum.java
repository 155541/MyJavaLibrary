package com.revolhope.deepdev.myjavalibrary.crypto;

public enum KeySizeEnum 
{
	
	AES_128(128), 	// Only that i'm sure that is supported
	AES_192(192), 	// TODO: Need to be tested
	AES_256(256), 	// TODO: Need to be tested
	RSA_1024(1024),	// I'm sure that is supported
	RSA_2048(2048),	// I'm sure that is supported
	RSA_3072(3072),	// TODO: Need to be tested
	RSA_4096(4096); // TODO: Need to be tested
	
	private final int value;
	
	KeySizeEnum(final int value) 
	{
		this.value = value;
	}
	
	public int getValue()
	{
		return this.value;
	}
}
