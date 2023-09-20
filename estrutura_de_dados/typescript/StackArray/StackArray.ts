export default class StackArray<T> {
  private items: T[];

  constructor() {
    this.items = [];
  }

  push(element: T): void {
    // this.items.push(element);

    const newArray: T[] = [];
    newArray[0] = element;

    for (let i = 0; i < this.items.length; i++) {
      newArray[i + 1] = this.items[i];
    }

    this.items = newArray;
  }

  pop(): T | undefined {
    // return this.items.pop();

    const newArray: T[] = [];

    if (!this.isEmpty()) {
      const last = this.items[this.items.length - 1];
      for (let i = 0; i < this.items.length - 1; i++) {
        newArray.push(this.items[i]);
      }

      this.items = newArray;
      return last;
    }
    return undefined;
  }

  peek(): T | undefined {
    return this.items[this.items.length - 1];
  }

  isEmpty(): boolean {
    return this.items.length === 0;
  }

  size(): number {
    return this.items.length;
  }

  clear(): void {
    this.items = [];
  }

  toArray(): T[] {
    return this.items;
  }

  toString(): string {
    return this.items.toString();
  }
}
