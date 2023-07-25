# jetbrains-academy-encrypt-decrypt

This Java project is a command-line utility for encrypting and decrypting text using two methods: the Caesar cipher and a Unicode-based cipher. The project offers robust argument parsing to give you flexibility over how the utility behaves.

## Key Functionalities:

### Encryption & Decryption Methods:

1. **Caesar Cipher**: The CaesarCipher uses a simple shift-based method for encryption and decryption where the letters in the message are shifted by a given key. 
2. **Unicode Cipher**: The UnicodeCipher method uses the Unicode value of characters for encryption and decryption. It allows a wider range of characters to be effectively encrypted and decrypted.

### Argument Parsing:

The program is designed to parse command-line arguments to perform a specific action based on the passed parameters. You can pass the following arguments:

- **Mode** `-mode` : It can be either `enc` for encryption or `dec` for decryption.
- **Key** `-key` : The shift key for Caesar cipher or the increment/decrement value for Unicode encryption.
- **Data** `-data` : The text to be encrypted/decrypted.
- **Input** `-in` : Path to the input file. The file should contain the text to be encrypted/decrypted.
- **Output** `-out` : Path to the output file. The encrypted/decrypted text will be written to this file.
- **Algorithm** `-alg` : The encryption/decryption algorithm to use. It can be either `shift` for Caesar Cipher or `unicode` for Unicode Cipher.

The encryption and decryption actions can be performed either by reading the text from an input file or directly from the `-data` argument. The resulting text is either written to an output file or to the standard output (stdout).

Please note that the project is currently structured in a procedural manner and there is an open TODO to refactor it using the Strategy pattern for better scalability and maintainability.

## How to Use:

1. Compile and run the Main class.
2. Provide the command-line arguments according to the task you want to perform.

Example: To encrypt a message "hello" using a shift of 5, run: `java Main -mode enc -key 5 -data "hello" -alg shift`
