import StackLinkedList from "./StackLinkedList";

const stack = new StackLinkedList<number | string>();

console.log("A pilha está vazia?", stack.isEmpty());

stack.push(10);
stack.push(20);
stack.push(30);

console.log("Tamanho da pilha:", stack.size()); // deve retornar 3

console.log("Elemento no topo da pilha:", stack.peek()); // deve retornar 30

console.log("Pilha como array:", stack.toArray()); // deve retornar [10, 20, 30]

console.log("Pilha como string:", stack.toString()); // deve retornar "10,20,30"

stack.pop();
stack.pop();

console.log("Tamanho da pilha após a remoção:", stack.size()); // deve retornar 1

stack.clear();

console.log("A pilha está vazia após a limpeza?", stack.isEmpty());
