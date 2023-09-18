class Node<T> {
  constructor(public value: T, public next: Node<T> | null = null) {}
}

export default class StackLinkedList<T> {
  private top: Node<T> | null = null;

  push(element: T): void {
    const newNode = new Node(element);
    newNode.next = this.top;
    this.top = newNode;
  }

  pop(): T | null {
    if (this.isEmpty()) {
      return null;
    }
    const poppedValue = this.top!.value;
    this.top = this.top!.next;
    return poppedValue;
  }

  peek(): T | null {
    return this.top?.value ?? null;
  }

  isEmpty(): boolean {
    return this.top === null;
  }

  size(): number {
    let count = 0;
    let current = this.top;
    while (current !== null) {
      count++;
      current = current.next;
    }
    return count;
  }

  clear(): void {
    this.top = null;
  }

  toArray(): T[] {
    const newArray: T[] = [];
    let current = this.top;
    while (current !== null) {
      newArray.push(current.value);
      current = current.next;
    }
    return newArray;
  }

  toString(): string {
    return this.toArray().toString();
  }
}
