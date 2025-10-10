# Registro de apoio de IA — Q1 (Websearch / Strategy)

## Como usei IA
Usei consultas pontuais para **confirmar conceitos** e **tirar dúvidas específicas**, além de, é claro, construir esse relatório aqui. 

## Linha do tempo (tópicos objetivos)

### Strategy e filtros (planejamento)
- **O que eu queria:** aplicar Strategy para acoplar um filtro a cada observador.
- **Consulta à IA (apoio):** verifiquei se fazia sentido manter a checagem em um método pequeno e testável por linha.
- **O que fiz:** defini `Filter`, criei filtros de palavra e tamanho e **extraí `processLine`** para isolar parsing/notificação.
- **Motivo:** separação de responsabilidades e facilidade de teste.

### Case-insensitive e acento
- **Problema que eu percebi:** casos com acento/variação de maiúsculas.
- **Consulta à IA (apoio):** confirmei como normalizar texto em Java (remoção de diacríticos e `toLowerCase`).
- **O que fiz:** normalização + `trim` no filtro de palavra.
- **Motivo:** evitar falsos negativos.

### Modelo e leitura do arquivo
- **O que eu queria:** registrar `(filtro, observador)` e ignorar linhas inúteis.
- **Consulta à IA (apoio):** confirmei boas práticas de leitura e quando pular linhas.
- **O que fiz:** `addObserver(filter, obs)` e ignorei vazias/`#`.
- **Motivo:** saída mais limpa e previsível.

### Execução e repositório limpo
- **Objetivo meu:** não versionar `*.class` e rodar fácil em qualquer máquina.
- **Consulta à IA (apoio):** confirmei uso do “modo fonte” (`java Main.java`) e `.gitignore` para `*.class/out/bin/target`.
- **O que fiz:** README com instruções e `.gitignore`.
