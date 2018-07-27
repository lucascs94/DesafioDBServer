# language: pt
Funcionalidade: Venda para um cliente sem cadastro na loja

  Contexto: 
    Dado que acesso a pagina da loja

  Cenario: Venda de um produto aleatorio
    Quando seleciono um produto generico
    E adiciono o produto ao carrinho
    E prossigo para o carrinho
    E prossigo para o checkout
    E preencho o email e inicio o cadastro
      | email               |
      | mail.teste.automacao@mail.com.br |
    E preencho as informacoes pessoais do cliente
      | nome   | sobrenome | senha  |
      | Suzana | Rocha     | 123456 |
    E preencho os dados de endereco do cliente
      | endereco          | complemento     | cidade       | cep   | celular     | referencia |
      | Av. Ipiranga 5000 | Apartamento 402 | Porto Alegre | 68501 | 51983652473 | minha casa |
    E finalizo o registro do cliente
    E verifico se os dados na tela de endereco estao corretos
      | nome completo | endereco                          | cep                          | pais          | telefone    |
      | Suzana Rocha  | Av. Ipiranga 5000 Apartamento 402 | Porto Alegre, Delaware 68501 | United States | 51983652473 |
    E prossigo para a tela de entrega
    E aceito os termos de servico e prossigo para a tela de pagamento
    E verifico o preco total da compra
      | total  |
      | $18.51 |
    E seleciono o pagamento por transferencia e confirmo o pedido
    Entao o pedido e concluido com sucesso
