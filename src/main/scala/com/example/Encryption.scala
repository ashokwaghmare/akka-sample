package com.example

import java.security.MessageDigest
import java.util.Base64
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec
import java.io.{ByteArrayInputStream, ByteArrayOutputStream, ObjectInputStream, ObjectOutputStream}


object Encryption {
  def encrypt(key: String, value: Any): Array[Byte] = {
    val cipher: Cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING")
    cipher.init(Cipher.ENCRYPT_MODE, keyToSpec(key))
    cipher.doFinal(serialise(value))
  }

  def decrypt(key: String, encryptedValue: Array[Byte]): Any = {
    val cipher: Cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING")
    cipher.init(Cipher.DECRYPT_MODE, keyToSpec(key))
    deserialise(cipher.doFinal(encryptedValue))
  }

  def keyToSpec(key: String): SecretKeySpec = {
    var keyBytes: Array[Byte] = (SALT + key).getBytes("UTF-8")
    val sha: MessageDigest = MessageDigest.getInstance("SHA-1")
    keyBytes = sha.digest(keyBytes)
    keyBytes = java.util.Arrays.copyOf(keyBytes, 16)
    new SecretKeySpec(keyBytes, "AES")
  }

  def serialise(value: Any): Array[Byte] = {
    val stream: ByteArrayOutputStream = new ByteArrayOutputStream()
    val oos = new ObjectOutputStream(stream)
    oos.writeObject(value)
    oos.close
    stream.toByteArray
  }

  def deserialise(bytes: Array[Byte]): Any = {
    val ois = new ObjectInputStream(new ByteArrayInputStream(bytes))
    val value = ois.readObject
    ois.close
    value
  }


  private val SALT: String =
    "jMhKlOuJnM34G6NHkqo9V010GhLAqOpF0BePojHgh1HgNg8^72k"
}
