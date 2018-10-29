package com.revolhope.deepdev.myjavalibrary.util;

import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Base64;

/**
 * Static class that provides methods to convert and invert Base64 Strings
 */
public class Base64Util
{
 
	private static Base64.Decoder decoder;
 	private static Base64.Encoder encoder;
 
 	/**
 	 * Private constructor, it's a static class
 	 */
 	private Base64Util() {}
  
 	/**
 	 * Method to encode String given in base64
 	 * @params str String object to encode to base64
 	 * @params charset String representing the string's charset of the object given, if it's null, it will be default
 	 * @return String encoded in base64
 	 */
 	public static String to64(String str, String charset) throws IllegalCharsetNameException, UnsupportedCharsetException
 	{
 		byte[] bytes;
 		if (charset == null)
 		{
 			bytes = str.getBytes();
 		}
 		else
 		{
 			bytes = str.getBytes(Charset.forName(charset));
 		}      
      if (encoder == null)
      {
        encoder = Base64.getEncoder();
      }
      bytes = encoder.encode(bytes);
      return new String(bytes);
  }
  
  /**
   * Method to convert back from base64 String to String encoded with Charset provided,
   * if this is null or wrong, Charset used will be default
   * @params str64 String object to convert back from base64
   * @params charset String representing the charset to encode the String object encoded with base64
   * @return String decoded from base64 and encoded with Charset provided
   */
  public static String from64(String str64, String charset) throws IllegalCharsetNameException, UnsupportedCharsetException
  {
    if (decoder == null)
    {
        decoder = Base64.getDecoder();
    }
    byte[] bytes = decoder.decode(str64.getBytes());
    if (charset == null)
    {
        return new String(bytes);
    }
    else
    {
        return new String(bytes, Charset.forName(charset));
    }
  }
}
