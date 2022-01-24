# encryption-api
Base URL for all encryption commands: http://localhost:8080/encryption

If you are using POST to upload a string to the Encryption suite (e.g. a key),
you will need to wrap it in a little piece of JSON. E.g. to send the string "foo",
you will need:

{"string":"foo"}

If you are POSTing a key which itself is JSON, you will need to turn off the
internal double-quotes:

{"string":"{\"primaryKeyId\":1021111201,\"key\":[{\"keyData\":{\"typeUrl\":\"type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey\",\"keyMaterialType\":\"ASYMMETRIC_PUBLIC\",\"value\":\"EkQKBAgCEAMSOhI4CjB0eXBlLmdvb2dsZWFwaXMuY29tL2dvb2dsZS5jcnlwdG8udGluay5BZXNHY21LZXkSAhAQGAEYARogBHg818YW2ri5bKlGGKFP3TuETSsoGiOaP28jFX8CPe4iIHRg2ZiIVonJ98dUNAKnvbvRJmMAqldcGvnpCbqbQ+Sl\"},\"outputPrefixType\":\"TINK\",\"keyId\":1021111201,\"status\":\"ENABLED\"}]}"}
