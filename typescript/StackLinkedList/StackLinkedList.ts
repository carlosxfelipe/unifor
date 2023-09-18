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

  pop(): T | undefined {
    if (this.isEmpty()) {
      return undefined;
    }
    const poppedValue = this.top!.value;
    this.top = this.top!.next;
    return poppedValue;
  }

  peek(): T | undefined {
    return this.top?.value;
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
    const result: T[] = [];
    let current = this.top;
    while (current !== null) {
      result.push(current.value);
      current = current.next;
    }
    return result;
  }

  toString(): string {
    return this.toArray().toString();
  }
}
