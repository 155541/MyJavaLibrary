
public enum Transformation
{
  AES/CBC/NoPadding("AES/CBC/NoPadding"),                                         // (128)
  AES/CBC/PKCS5Padding("AES/CBC/PKCS5Padding"),                                   // (128)
  AES/ECB/NoPadding("AES/ECB/NoPadding"),                                         // (128)
  AES/ECB/PKCS5Padding("AES/ECB/PKCS5Padding"),                                   // (128)
  DES/CBC/NoPadding("DES/CBC/NoPadding"),                                         // (56)
  DES/CBC/PKCS5Padding("DES/CBC/PKCS5Padding"),                                   // (56)
  DES/ECB/NoPadding("DES/ECB/NoPadding"),                                         // (56)
  DES/ECB/PKCS5Padding("DES/ECB/PKCS5Padding"),                                   // (56)
  DESede/CBC/NoPadding("DESede/CBC/NoPadding"),                                   // (168)
  DESede/CBC/PKCS5Padding("DESede/CBC/PKCS5Padding"),                             // (168)
  DESede/ECB/NoPadding("DESede/ECB/NoPadding"),                                   // (168)
  DESede/ECB/PKCS5Padding("DESede/ECB/PKCS5Padding"),                             // (168)
  RSA/ECB/PKCS1Padding("RSA/ECB/PKCS1Padding"),                                   // (1024, 2048)
  RSA/ECB/OAEPWithSHA-1AndMGF1Padding("RSA/ECB/OAEPWithSHA-1AndMGF1Padding"),     // (1024, 2048)
  RSA/ECB/OAEPWithSHA-256AndMGF1Padding("RSA/ECB/OAEPWithSHA-256AndMGF1Padding")  // (1024, 2048)
}
