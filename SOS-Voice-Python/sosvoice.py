import pyttsx3  # Biblioteca para síntese de voz
import time

# Configuração inicial do sintetizador de voz
engine = pyttsx3.init()
engine.setProperty('rate', 150)  # Velocidade da fala
engine.setProperty('volume', 1.0)  # Volume máximo

# Dados das comunidades e abrigos
comunidades = {
    "1": {"nome": "Vila Esperança", "abrigo": "Escola Municipal Vila Esperança", "riscos": ["enchente", "deslizamento"]},
    "2": {"nome": "Jardim Aurora", "abrigo": "Centro Comunitário Jardim Aurora", "riscos": ["enchente"]},
    "3": {"nome": "Morro do Sol", "abrigo": "Igreja Nossa Senhora Aparecida", "riscos": ["deslizamento", "incêndio"]}
}

tipos_desastres = {
    "1": {"tipo": "enchente", "instrucoes": "Leve apenas documentos e itens essenciais. Evite áreas baixas."},
    "2": {"tipo": "deslizamento", "instrucoes": "Afaste-se de encostas. Não tente resgatar pertences."},
    "3": {"tipo": "incêndio", "instrucoes": "Cubra nariz e boca com pano úmido. Não use elevadores."},
    "4": {"tipo": "tempestade", "instrucoes": "Evite áreas abertas e objetos metálicos. Procure abrigo sólido."}
}

def validar_entrada(mensagem, opcoes_validas):
    """Valida a entrada do usuário com base nas opções válidas"""
    while True:
        entrada = input(mensagem)
        if entrada in opcoes_validas:
            return entrada
        print(f"Opção inválida. Digite um dos seguintes valores: {', '.join(opcoes_validas)}")

def selecionar_comunidade():
    """Permite ao usuário selecionar uma comunidade"""
    print("\nComunidades cadastradas:")
    for cod, info in comunidades.items():
        print(f"{cod} - {info['nome']} (Riscos: {', '.join(info['riscos'])})")
    
    cod_comunidade = validar_entrada(
        "\nDigite o número da comunidade afetada: ",
        comunidades.keys()
    )
    return comunidades[cod_comunidade]

def selecionar_desastre():
    """Permite ao usuário selecionar um tipo de desastre"""
    print("\nTipos de desastres cadastrados:")
    for cod, info in tipos_desastres.items():
        print(f"{cod} - {info['tipo']}")
    
    cod_desastre = validar_entrada(
        "\nDigite o número do tipo de desastre: ",
        tipos_desastres.keys()
    )
    return tipos_desastres[cod_desastre]

def gerar_mensagem_alerta(comunidade, desastre):
    """Gera a mensagem de alerta personalizada"""
    return (
        f"ATENÇÃO {comunidade['nome'].upper()}! "
        f"Alerta de {desastre['tipo']}! "
        f"Dirijam-se imediatamente ao abrigo em {comunidade['abrigo']}. "
        f"{desastre['instrucoes']} "
        f"Repetindo: Alerta de {desastre['tipo']}! Dirijam-se ao abrigo em {comunidade['abrigo']}."
    )

def emitir_alerta(mensagem):
    """Emite o alerta por texto e voz"""
    print("\n" + "="*50)
    print("ALERTA DE EMERGÊNCIA")
    print("="*50)
    print(mensagem)
    print("="*50 + "\n")
    
    # Emitir o alerta por voz 3 vezes
    for i in range(3):
        engine.say(mensagem)
        engine.runAndWait()
        if i < 2:  # Pausa entre as repetições, exceto na última
            time.sleep(2)

def simular_sistema_alerta():
    """Função principal que orquestra o sistema de alerta"""
    print("\n" + "="*50)
    print("SISTEMA DE ALERTA SONORO INTELIGENTE")
    print("="*50)
    print("Este sistema gera alertas personalizados para comunidades em situação de risco")
    
    while True:
        comunidade = selecionar_comunidade()
        desastre = selecionar_desastre()
        
        # Verifica se o desastre é um risco conhecido para a comunidade
        if desastre["tipo"] not in comunidade["riscos"]:
            print(f"\nAVISO: {desastre['tipo']} não é um risco conhecido para {comunidade['nome']}")
            confirmar = validar_entrada("Deseja continuar mesmo assim? (S/N): ", ["S", "N"])
            if confirmar == "N":
                continue
        
        mensagem = gerar_mensagem_alerta(comunidade, desastre)
        emitir_alerta(mensagem)
        
        continuar = validar_entrada("\nDeseja emitir outro alerta? (S/N): ", ["S", "N"])
        if continuar == "N":
            break

    print("\nSistema encerrado. Mantenha-se seguro!")

# Executa o sistema
if __name__ == "__main__":
    simular_sistema_alerta()