package com.rahulg.cryptography

import java.security.MessageDigest
import java.math.BigInteger

object MD5HashExample {

  def main(args: Array[String]): Unit = {
    testMD5MessageDigest
  }

  def testMD5MessageDigest(): Unit = {
    val md5 = MessageDigest.getInstance("MD5")

    var message = "Welcome to MD5 Digest!"
    var messageBytes : Array[Byte] = message.getBytes
    // generates 128 bits - 16 bytes of output.
    val messageDigestBytes : Array[Byte] = md5.digest(messageBytes)
    // convert byte array to signum rep
    val bigInt : BigInteger = new BigInteger(1, messageBytes)

    val hashString = bigInt.toString(16)
    println(s"For Inout ${message}, m5d hash is : ${hashString}")
  }

}
