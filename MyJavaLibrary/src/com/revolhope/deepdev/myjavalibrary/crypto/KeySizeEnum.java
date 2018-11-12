package com.revolhope.deepdev.myjavalibrary.crypto;

public enum KeySizeEnum 
{
	
	AES_128(128),
	AES_192(192),
	AES_256(256);
	
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
