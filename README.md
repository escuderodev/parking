# Documentação Funcional de Sistema de Parquímetro

## Introdução
Esta documentação apresenta o novo sistema de parquímetro que deve ser desenvolvido para atender às
necessidades de uma cidade turística, que possui uma população de 300.000 habitantes, mas experimenta um
aumento significativo durante a alta temporada, recebendo 250.000 visitantes adicionais, em média, com a mesma
quantidade de veículos. Este sistema substituirá o sistema antigo, que é lento, não escalável e não confiável.
Visão Geral do Sistema.

O novo sistema de parquímetro foi projetado para lidar com a demanda crescente de estacionamento na
cidade. Ele oferece funcionalidades tais, como registro de condutores e veículos, controle de tempo estacionado,
opções flexíveis de pagamento e emissão de recibos.

## Funcionalidades Principais
### 1. Registro de Condutores e Veículos:
- Os condutores podem se registrar no sistema, associando seus dados pessoais, como nome, endereço e
informações de contato.
- Um condutor pode vincular vários veículos à sua conta, facilitando o gerenciamento de múltiplos veículos.

### 2. Registro de Forma de Pagamento:
- Antes de usar o sistema, o condutor deve registrar sua forma de pagamento preferida, que pode incluir
cartão de crédito, débito ou PIX.
- A opção PIX só está disponível para períodos de estacionamento fixos.

### 3. Controle de Tempo Estacionado:
- O sistema permite iniciar o período de estacionamento, oferecendo opções de tempo fixo ou por hora.
- Para períodos fixos, o sistema requer que o condutor indique a duração desejada no momento do registro.
- Para períodos variáveis, o sistema inicia o tempo de estacionamento automaticamente.
- O sistema monitora o tempo com precisão para garantir a cobrança correta.

### 4. Alertas de Tempo Estacionado:
- O sistema inclui um recurso de alerta que notifica o condutor quando o tempo de estacionamento está
prestes a expirar, no caso de horário fixo.
- Para períodos variáveis, o sistema também emite um alerta informando que o sistema estenderá
automaticamente o estacionamento por mais uma hora, a menos que o condutor desligue o registro.

### 5. Opções de Pagamento:
- Os condutores têm a opção de pagar pelo estacionamento de várias maneiras, incluindo cartão de crédito,
débito ou PIX, dependendo da forma de pagamento registrada.
- A cobrança é baseada no tempo utilizado; para tempos fixos, o valor total é cobrado independentemente do
tempo real utilizado, enquanto para períodos variáveis, a cobrança é por hora completa.
Pós-Tech Arquitetura e Desenvolvimento JAVA – 1ADJT Página 1 de 2

### 6. Emissão de Recibos:
- O sistema emite recibos automaticamente sempre que o tempo de estacionamento é encerrado e a
cobrança é realizada.
- Os recibos fornecem informações detalhadas, incluindo o tempo estacionado, a tarifa aplicada e o valor
total pago.

### Fluxo de Trabalho:
1. O condutor se registra no sistema, fornecendo informações pessoais.
2. O condutor registra sua forma de pagamento preferida (cartão de crédito, débito ou PIX).
3. O condutor inicia o registro de tempo no sistema, escolhendo entre tempo fixo (indicando a duração desejada) ou
por hora.
4. O sistema monitora o tempo de estacionamento e cobra o valor adequado com base nas opções de pagamento
selecionadas.
5. Para horários fixos, o sistema emite um alerta quando o tempo está prestes a expirar.
6. Para períodos variáveis, o sistema emite um alerta informando que estenderá automaticamente o estacionamento
por mais uma hora, a menos que o condutor desligue o registro.
7. Quando o tempo de estacionamento é encerrado, o sistema emite um recibo para o condutor.
Pós-Tech Arquitetura e Desenvolvimento JAVA – 1ADJT Página 2 de 2
