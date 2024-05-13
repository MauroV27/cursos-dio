menu = """

[d] Depositar
[s] Sacar
[e] Extrato
[i] Infos
[q] Sair

=> """

saldo = 0
limite = 500
extrato = ""
numero_saques = 0
LIMITE_SAQUES = 3

def get_valid_value(input:str) -> float:
    if len(input_valor) > 0 and input_valor.capitalize() != "NAN":
        try:
            return float(input_valor)
        except ValueError:
            return -1
    else: 
        return -1
    

while True:

    opcao = input(menu)

    if opcao == "d":
        input_valor = input("Informe o valor do depósito: ")

        valor = get_valid_value(input_valor)
        
        if valor > 0:
            saldo += valor
            extrato += f"Depósito: R$ {valor:.2f}\n"

        else:
            print("Operação falhou! O valor informado é inválido.")

    elif opcao == "s":
        input_valor = input("Informe o valor do saque: ")

        valor = get_valid_value(input_valor)

        excedeu_saldo = valor > saldo

        excedeu_limite = valor > limite

        excedeu_saques = numero_saques >= LIMITE_SAQUES

        if excedeu_saldo:
            print("Operação falhou! Você não tem saldo suficiente.")

        elif excedeu_limite:
            print("Operação falhou! O valor do saque excede o limite.")

        elif excedeu_saques:
            print("Operação falhou! Número máximo de saques excedido.")

        elif valor > 0:
            saldo -= valor
            extrato += f"Saque: R$ {valor:.2f}\n"
            numero_saques += 1

        else:
            print("Operação falhou! O valor informado é inválido.")

    elif opcao == "e":
        print("\n================ EXTRATO ================")
        print("Não foram realizadas movimentações." if not extrato else extrato)
        print(f"\nSaldo: R$ {saldo:.2f}")
        print("==========================================")

    elif opcao == "i":
        print("\n================ INFORMAÇÕES ================")
        print(f"Saldo atual : {saldo:.2f}")
        print("Limite atual :", limite)
        print(f"Número de saques disponivel {max(LIMITE_SAQUES - numero_saques, 0)}")
        print("==========================================")


    elif opcao == "q":
        break

    else:
        print("Operação inválida, por favor selecione novamente a operação desejada.")