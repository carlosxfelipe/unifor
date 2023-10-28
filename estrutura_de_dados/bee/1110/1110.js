// const input = require("fs").readFileSync("./dev/stdin", "utf8");
const input = require("fs").readFileSync("/dev/stdin", "utf8");
const lines = input.trim().split("\n");

const createDeque = () => {
  const deque = [];
  return {
    pushFront: (value) => deque.unshift(value),
    pushBack: (value) => deque.push(value),
    popFront: () => deque.shift(),
    popBack: () => deque.pop(),
    getFront: () => deque[0],
    getBack: () => deque[deque.length - 1],
    getSize: () => deque.length,
    isEmpty: () => deque.length === 0,
  };
};

lines.pop();

while (lines.length) {
  const n = parseInt(lines.shift());
  const deque = createDeque();

  for (let i = 1; i <= n; i++) {
    deque.pushBack(i);
  }

  const discarded = [];
  while (deque.getSize() > 1) {
    discarded.push(deque.getFront());
    deque.popFront();
    deque.pushBack(deque.getFront());
    deque.popFront();
  }

  console.log(`Discarded cards: ${discarded.join(", ")}`);
  console.log(`Remaining card: ${deque.getFront()}`);
}
