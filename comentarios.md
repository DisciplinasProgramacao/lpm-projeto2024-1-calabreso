# Comentários - Revisão de 09/06 (fim da Sprint 3)

Todos os comentários referem-se ao código do ramo "master" ou "main". É obrigação do grupo manter o código principal neste ramo. Problemas relatados podem ser:

  - ⚠️ - médios. Erros de lógica, regras mal implementadas... Descontos de até 1 ponto.
  - 🚨 - sérios. Regras faltando, problemas de modularidade... Descontos de até 3 pontos.
  - 💣 - graves. Falta de classes, requisitos ignorados ... Descontos de 5 ou mais pontos.


## Revisão

1. 💣 ClienteController usa um repositório que não está no código do projeto
1. 💣 MesaController usa um serviço que não está no código do projeto e diversos casts para Object
1. 🚨 RequisicaoController está fazendo operações de várias classes (cliente, mesa) e tem vários métodos desnecessários (p.ex, getIdMesa)
1. 💣 Não há um código de aplicativo principal executando
1. ⚠️ sets e construtor de OpcaoCardapio sem validações
1. ⚠️ setOpcoes no Cardápio (deveria ser um método para adicionar produto individualmente)
1. 🚨 setItens no Pedido (deveria ser um método para inserir um item individualmente)
1. 🚨 setValor no Pedido (é um valor calculado)
1. 🚨 Requisicao ainda sem métodos para adicionar produtos etc.