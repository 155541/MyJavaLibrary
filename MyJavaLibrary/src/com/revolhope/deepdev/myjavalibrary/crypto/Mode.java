package com.revolhope.deepdev.myjavalibrary.crypto;


public enum Mode
{
	AES_CBC("CBC"),
	AES_CTR("CTR");
	// TODO: Implement more?
	// TODO: RSA modes
	
	private final String mode;
	
	Mode(final String mode)
	{
		this.mode = mode;
	}
	
	public String getValue()
	{
		return this.mode;
	}
}
