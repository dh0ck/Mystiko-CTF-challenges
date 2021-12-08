from cryptography.fernet import Fernet
class Crypto:
    key = b'DYGu2LLfw56nq3FZ6RgkpjETsmUXOHvWskplBJdEWu8='

class Flag:
    def print_flag(password):
        if password == "$aTaN":
            encrypted = ['gAAAAABhsQ1nmnHu2F','qielkDIjj31DKAJ','3fh_CoHd5nVzY0VV','ijdsgSG42SDFk','B7xPP-I3qz6KdafAHnBgdo','OdIJsiej452','rtKUNhckBPxPCcOb_f8','in42b1TF2TU_di3','9ZI2U8DF5pQX5TdGuYXXdZ-N3lm','IJnsuj_0314','HbzGsM7AXKrFC6gPUMlRoK','ouDJues42_325q','1tSDPyG1hJ0X5QBg']
            true_enc = [encrypted[0],encrypted[2],encrypted[4],encrypted[6], encrypted[8],encrypted[10],encrypted[12]]
            return ''.join(true_enc)
