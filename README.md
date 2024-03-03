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

### Listar Tarefas

`GET` /tarefas

Retorna um array com todas as tarefas associadas às matérias do usuário atual.

#### Exemplo de Resposta

```js
{
    "id": 1,
    "descricao": "Trabalho de Matemática",
    "prazo": "2024-03-10",
    "materia": {
        "id": 1,
        "nome": "Matemática",
        "professor": "João Silva"
    }
}
```

#### Códigos de Resposta

| Código | Descrição                |
| ------ | ------------------------ |
| 200    | Sucesso: Tarefas retornadas com sucesso |
| 401    | Não autorizado. Por favor, faça a autenticação em /login |

---

### Adicionar Tarefa

`POST` /tarefas

Adiciona uma nova tarefa associada a uma matéria do usuário atual.

#### Parâmetros da Requisição

| Campo     | Tipo   | Obrigatório | Descrição             |
|-----------|--------|-------------|-----------------------|
| descricao | string |     ✅     | Uma descricao breve da tarefa |
| prazo 	| LocalDate |     ✅     | Prazo da tarefa     |
| materiaId | Long |     ✅     | ID da matéria     |

#### Exemplo de Corpo da Requisição

```json
{
    "descricao": "Trabalho de História",
    "prazo": "2024-03-15",
    "materiaId": 2
}
```

#### Códigos de Resposta

| Código | Descrição                |
| ------ | ------------------------ |
| 201    | Sucesso: Tarefa adicionada com sucesso |
| 400    | Requisição inválida: Verifique os parâmetros da requisição |
| 401    | Não autorizado. Por favor, faça a autenticação em /login |

---

### Apagar Tarefa

`DELETE` /tarefas/{id}

Apaga a tarefa com o ID especificado, associada a uma matéria do usuário atual.

#### Parâmetros da Requisição

| Parâmetro | Descrição               |
| --------- | ----------------------- |
| id        | ID da tarefa a ser apagada |

#### Códigos de Resposta

| Código | Descrição                |
| ------ | ------------------------ |
| 204    | Sucesso: Tarefa apagada com sucesso |
| 401    | Não autorizado. Por favor, faça a autenticação em /login |
| 404    | Tarefa não encontrada: Verifique o ID da tarefa |

---

### Detalhar Tarefa

`GET` /tarefas/{id}

Retorna os detalhes da tarefa com o ID especificado, associada a uma matéria do usuário atual.

#### Parâmetros da Requisição

| Parâmetro | Descrição               |
| --------- | ----------------------- |
| id        | ID da tarefa a ser detalhada |

#### Exemplo de Resposta

```json
{
    "id": 1,
    "descricao": "Trabalho de Matemática",
    "prazo": "2024-03-10",
    "materia": {
        "id": 1,
        "nome": "Matemática",
        "professor": "João Silva"
    }
}
```

#### Códigos de Resposta

| Código | Descrição                |
| ------ | ------------------------ |
| 200    | Sucesso: Tarefa detalhada retornada com sucesso |
| 401    | Não autorizado. Por favor, faça a autenticação em /login |
| 404    | Tarefa não encontrada: Verifique o ID da tarefa |

---

### Atualizar Tarefa

`PUT` /tarefas/{id}

Atualiza os detalhes da tarefa com o ID especificado, associada a uma matéria do usuário atual.

#### Parâmetros da Requisição

| Parâmetro | Descrição               |
| --------- | ----------------------- |
| id        | ID da tarefa a ser atualizada |

#### Exemplo de Corpo da Requisição


| Campo     | Tipo   | Obrigatório | Descrição             |
|-----------|--------|-------------|-----------------------|
| descricao      | string |     ✅      | Uma descricao breve da tarefa |
| prazo 	 | LocalDate |     ✅       | Prazo da tarefa     |
| materiaId 	 | Long |     ✅       | ID da matéria     |

#### Códigos de Resposta

| Código | Descrição                |
| ------ | ------------------------ |
| 200    | Sucesso: Tarefa atualizada com sucesso |
| 400    | Requisição inválida: Verifique os parâmetros da requisição |
| 401    | Não autorizado. Por favor, faça a autenticação em /login |
| 404    | Tarefa não encontrada: Verifique o ID da tarefa |



