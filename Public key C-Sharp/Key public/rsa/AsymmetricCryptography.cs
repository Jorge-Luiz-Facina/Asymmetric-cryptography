using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;

namespace Key_public
{
    public class AsymmetricCryptography
    {
        private RSACryptoServiceProvider rSACryptoServiceProvider;

        public AsymmetricCryptography()
        {
            rSACryptoServiceProvider = new RSACryptoServiceProvider();
        }

        public string getPublicKey()
        {
            return rSACryptoServiceProvider.ToXmlString(false); 
        }

        public string getPrivateKey()
        {
            return rSACryptoServiceProvider.ToXmlString(true);
        }
    }
}
