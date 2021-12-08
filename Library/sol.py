from cryptography.fernet import Fernet
# IMPORTANT, RENAME THE .pyc FILE TO library.pyc!!!
import library

# one could have a list of passwords and iterate when calling the function:
passwords = ['test','12345','$aTaN','qwert']

crypto = library.Crypto
# one could iterate the passwords here
flag = library.Flag.print_flag(passwords[2])
print(flag)

key = crypto.key
print(key)

f = Fernet(key)
dec_flag = f.decrypt(bytes(flag,encoding='utf-8'))
print(dec_flag)
print('asdsasd')

#link to Fernet cipher in python: https://www.tutorialspoint.com/how-to-encrypt-and-decrypt-data-in-python