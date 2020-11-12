package com.rahulg.cryptography

import java.io.ByteArrayOutputStream
import java.math.BigInteger
import java.security.MessageDigest

import sun.security.provider.SecureRandom


object SHA156HashExample {
  def main(args: Array[String]): Unit = {
    testMessageDigest
    testUsingSalt
  }

  def testMessageDigest(): Unit = {
    val sha = MessageDigest.getInstance("SHA-256")

    var message = "Welcome to MD5 Digest!"
    var messageBytes : Array[Byte] = message.getBytes
    // generates 256 bits - 32 bytes of output.
    val messageDigestBytes : Array[Byte] = sha.digest(messageBytes)
    // convert byte array to signum rep
    val bigInt : BigInteger = new BigInteger(1, messageBytes)

    val hashString = bigInt.toString(16)
    println(s"For Inout ${message}, m5d hash is : ${hashString}")
  }

  def generateSalt(): Array[Byte] = {
    val salt = new Array[Byte](16)
    val sec_random = new SecureRandom()
    sec_random.engineNextBytes(salt)
    salt
  }

  def testUsingSalt(): Unit = {
    val salt: Array[Byte] = generateSalt()
    val message = "Welcome to MD5 Digest!"
    val inputStream = new ByteArrayOutputStream()
    inputStream.write(salt)
    inputStream.write(message.getBytes)

    val inputBytes = inputStream.toByteArray
    val sha = MessageDigest.getInstance("SHA-256")

    val digestBytes = sha.digest(inputBytes)

    val bigInt = new BigInteger(1, digestBytes)

    val hashString = bigInt.toString(16)
    println(s"For Input ${message}, and salt ${salt.toString} m5d hash is : ${hashString}")
  }
}
