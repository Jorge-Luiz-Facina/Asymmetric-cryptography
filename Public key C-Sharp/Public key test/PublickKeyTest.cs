using System;
using System.Security.Cryptography;
using Key_public;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Public_key_test
{
    [TestClass]
    public class PublicKeyTest
    {
        private static readonly string TEXT = "Hello World";
        private AsymmetricCryptography asymmetricCryptography = new AsymmetricCryptography();

        [TestMethod]
        public void encryptUsingPublicKeyAndDecryptUsingPrivateKey()
        {
            Encryption encryption = new Encryption();
            byte[] encryptedText = encryption.encrypt(TEXT, asymmetricCryptography.getPublicKey());
            string dectyptedText = encryption.decryption(encryptedText, asymmetricCryptography.getPrivateKey());
            Assert.AreEqual(TEXT, dectyptedText);
        }

        [TestMethod]
        [ExpectedException(typeof(Exception), "Private key wrong")]
        public void encryptUsingPublicKeyAndDoesNotDecryptUsingDifferentPrivateKey()
        {
            AsymmetricCryptography asymmetricCryptographyOther = new AsymmetricCryptography();
            Encryption encryption = new Encryption();
            byte[] encryptedText = encryption.encrypt(TEXT, asymmetricCryptography.getPublicKey());
            encryption.decryption(encryptedText, asymmetricCryptographyOther.getPrivateKey());
        }
    }
}
