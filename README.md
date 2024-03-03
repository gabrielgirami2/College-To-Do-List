# Taskfy

API Rest do projeto Gerenciador de Tarefas Universitárias - Sistema de gerenciamento de tarefas para estudantes universitários

## Requisitos

- [ ] CRUD de Matérias
- [ ] CRUD de Tarefas
- [ ] Autenticação de Usuários
- [ ] Listagem de Tarefas
- [ ] Associação de Tarefas com Matérias

## Documentação

### Endpoints

- [Listar Matérias](#listar-matérias)
- [Adicionar Matéria](#adicionar-matéria)
- [Apagar Matéria](#apagar-matéria)
- [Detalhar Matéria](#detalhar-matéria)
- [Atualizar Matéria](#atualizar-matéria)
- [Listar Tarefas](#listar-tarefas)
- [Adicionar Tarefa](#adicionar-tarefa)
- [Apagar Tarefa](#apagar-tarefa)
- [Detalhar Tarefa](#detalhar-tarefa)
- [Atualizar Tarefa](#atualizar-tarefa)


### Listar Matérias

`GET` /materias

Retorna um array com todas as matérias adicionadas pelo usuário atual.

#### Exemplo de Resposta

```js
[
    {
        "id": 1,
        "nome": "Matemática",
        "professor": "João Silva"
    }
]

