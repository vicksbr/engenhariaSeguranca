
 rm -R AES 2>/dev/null
 rm -R KeyPair 2>/dev/null
 rm -R DecryptedFiles 2>/dev/null
 rm -R EncryptedFiles 2>/dev/null
 rm tarefa.txt 

echo "Tarefa paras máquinas" > tarefa.txt 
 

java GenerateRSAKeyPair
java GenerateAESKey
java Encryption
java Decryption
