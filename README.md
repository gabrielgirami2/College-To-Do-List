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
```

#### Códigos de Resposta

| código | descrição |
|--------|-----------|
|200| Sucesso: Matérias retornadas com sucesso
|401| 	Não autorizado. Por favor, faça a autenticação em /login

---

### Adicionar Matéria

`POST` /materias

Adiciona uma matéria com os dados enviados no corpo da requisição.

#### Corpo da Requisição

| Campo     | Tipo   | Obrigatório | Descrição             |
|-----------|--------|-------------|-----------------------|
| nome      | string |     ✅      | Um nome curto para a matéria |
| professor | string |     ❌      | Nome do professor     |

```js
{
    "nome": "Matemática",
    "professor": "João Silva"
}
```
#### Exemplo de Resposta
```js
{
    "id": 1,
    "nome": "Matemática",
    "professor": "João Silva"
}
```
#### Código de Resposta

| código | descrição |
|--------|-----------|
|201| Sucesso: Matéria adicionada com sucesso
|400| Falha na validação. Por favor, verifique os dados enviados no corpo da requisição
|401| Não autorizado. Por favor, faça a autenticação em /login

---

### Apagar Matéria

`DELETE` /materias/{id}

Apaga a matéria com o ID especificado no parâmetro de caminho.

#### Código de Resposta

| Código | Descrição |
|--------|-----------|
| 204    | Sucesso: Matéria apagada com sucesso |
| 401    | Não autorizado. Por favor, faça a autenticação em /login |

---

### Detalhar Matéria

`GET` /materias/{id}

Retorna os dados da matéria com o ID especificado no parâmetro de caminho.

#### Exemplo de Resposta

```js
{
    "id": 1,
    "nome": "Matemática",
    "professor": "João Silva"
}
```
#### Código de Resposta

| código | descrição |
|--------|-----------|
|201| Sucesso: Matéria retornada com sucesso
|401| Não autorizado. Por favor, faça a autenticação em /login
|404| Matéria com o ID especificado não existe

---

### Atualizar Matéria

`PUT` /materias/{id}

Atualiza os dados da matéria com o ID especificado no parâmetro de caminho.

#### Corpo da Requisição

| Campo     | Tipo   | Obrigatório | Descrição             |
|-----------|--------|-------------|-----------------------|
| nome      | string |     ✅      | Um nome curto para a matéria |
| professor | string |     ❌      | Nome do professor     |

```js
{
    "nome": "Matemática",
    "professor": "João Silva"
}
```
#### Exemplo de Resposta
```js
{
    "id": 1,
    "nome": "Matemática",
    "professor": "João Silva"
}
```
#### Código de Resposta

| código | descrição |
|--------|-----------|
|200| Sucesso: Matéria atualizada com sucesso
|400| Falha na validação. Por favor, verifique os dados enviados no corpo da requisição
|401| Não autorizado. Por favor, faça a autenticação em /login
|404| Matéria com o ID especificado não existe 

---


