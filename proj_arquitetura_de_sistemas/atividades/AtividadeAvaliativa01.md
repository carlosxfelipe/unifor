T200-83 Proj arquitetura de sistemas
Carlos Felipe Araújo

# Diagrama de Caso de Uso:

**Sistema de Controle Acadêmico**

**Ator:**

- Secretaria

**Casos de Uso:**

- Cadastrar Curso (RF01)
- Cadastrar Disciplina (RF02)
- Cadastrar Aluno (RF03)
- Cadastrar Professor (RF04)
- Abrir Turmas (RF05)
- Alocar Professores (RF06)
- Matricular Aluno (RF07)
- Lançar Avaliações (RF08)
- Consultar Avaliações (RF09)
- Emitir Diários de Classe (RF10)
- Emitir Históricos Escolares (RF11)
- Calcular Aprovação de Alunos (RF12)
- Controlar Situação do Aluno (RF13)

# Diagrama de Classes (Domínio):

**Controle Acadêmico**

**Classes:**

- Curso

  - código
  - descrição
  - coordenador

- Disciplina

  - código
  - descrição
  - carga horária
  - ementa
  - bibliografia
  - pré-requisitos

- Aluno

  - matrícula
  - nome
  - endereço
  - telefone
  - curso

- Professor

  - nome
  - endereço
  - telefone
  - titulação máxima
  - cursos vinculados

- Turma

  - ano
  - semestre
  - dias da semana
  - horários de realização
  - disciplina
  - professor

- Avaliação
  - notas parciais
  - nota prova final
  - frequência
  - aluno
  - turma

# Diagrama de Classes (Classes do Sistema):

**Controle Acadêmico**

**Classes do Sistema:**

- Secretaria
- Sistema

# Diagrama de Sequência do Caso de Uso "Matricular Aluno":

**Sistema de Controle Acadêmico**

| Origem          | Destino                  | Ação                                    |
|-----------------|--------------------------|-----------------------------------------|
| Secretaria      | Sistema                  | Solicita matrícula de alunos em turmas  |
| Sistema         | Secretaria               | Exibe lista de turmas e alunos          |
| Secretaria      | Sistema                  | Seleciona turma e aluno                 |
| Sistema         | Turma                    | Verificar Matrícula                     |
| Turma           | Aluno                    | Verificar Matrícula                     |
| Aluno           | Turma                    | Verificar Matrícula                     |
| Turma           | Sistema                  | Matricular Aluno                        |
| Sistema         | Aluno                    | Atualizar Matrícula                     |
| Sistema         | Mensagem de Confirmação  | Retorna resultado da operação           |
| Secretaria      | Sistema                  | Fecha interface                         |
| Mensagem de Confirmação | Secretaria       | Exibe mensagem de confirmação           |
