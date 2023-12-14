const fs = require("fs");

class Node {
  constructor(data) {
    this.data = data;
    this.rightLength = 0;
    this.leftLength = 0;
    this.left = null;
    this.right = null;
  }

  getBiggerLength() {
    return Math.max(this.rightLength, this.leftLength);
  }

  getDifference() {
    return this.leftLength - this.rightLength;
  }

  updateLength() {
    this.leftLength = this.left ? this.left.getBiggerLength() + 1 : 0;
    this.rightLength = this.right ? this.right.getBiggerLength() + 1 : 0;
  }

  compareTo(otherNode) {
    return this.data
      .toString()
      .localeCompare(otherNode.data.toString(), undefined, {
        ignorePunctuation: true,
        sensitivity: "base",
      });
  }

  getHash() {
    return Crypt.sha1(this.data.toString());
  }
}

class BinarySearchTree {
  constructor() {
    this.root = null;
  }

  hashTree() {
    return this.hashSubTree(this.root);
  }

  hashSubTree(node) {
    if (!node) return "";

    const nodeHash =
      node.left === null && node.right === null
        ? Crypt.sha1(node.data.toString())
        : Crypt.sha1(
            this.hashSubTree(node.left) +
              this.hashSubTree(node.right) +
              Crypt.sha1(node.data.toString())
          );

    console.log(`Node: ${node.data}, Hash: ${nodeHash}`);

    return nodeHash;
  }

  insert(value) {
    const newNode = new Node(value);
    if (!this.root) {
      this.root = newNode;
    } else {
      this.insertNode(this.root, newNode);
    }
  }

  insertNode(node, newNode) {
    if (node.data !== newNode.data) {
      if (newNode.compareTo(node) < 0) {
        if (node.left === null) {
          node.left = newNode;
        } else {
          this.insertNode(node.left, newNode);
        }
      } else {
        if (node.right === null) {
          node.right = newNode;
        } else {
          this.insertNode(node.right, newNode);
        }
      }

      node.updateLength();
      this.balance(node);
    }
  }

  remove(value) {
    const comparisonNode = new Node(value);
    this.root = this.removeNode(this.root, comparisonNode);
  }

  removeNode(node, comparisonNode) {
    if (node === null) return null;

    if (comparisonNode.compareTo(node) < 0) {
      node.left = this.removeNode(node.left, comparisonNode);
    } else if (comparisonNode.compareTo(node) > 0) {
      node.right = this.removeNode(node.right, comparisonNode);
    } else {
      if (node.left === null && node.right === null) {
        return null;
      } else if (node.left !== null && node.right === null) {
        return node.left;
      } else if (node.left === null && node.right !== null) {
        return node.right;
      } else {
        const successor = this.findMinChildren(node.right);
        node.data = successor.data;
        node.right = this.removeNode(node.right, successor);
      }
    }

    node.updateLength();
    this.balance(node);

    return node;
  }

  // Encontra o nó mínimo na subárvore direita
  findMinChildren(node) {
    let currentNode = node;
    while (currentNode.left !== null) {
      currentNode = currentNode.left;
    }
    return currentNode;
  }

  balance(node) {
    if (node.getDifference() < -1) {
      if (node.right !== null && node.right.getDifference() > 0) {
        this.rotateRight(node.right);
      }
      this.rotateLeft(node);
    }
    if (node.getDifference() > 1) {
      if (node.left !== null && node.left.getDifference() < 0) {
        this.rotateLeft(node.left);
      }
      this.rotateRight(node);
    }
  }

  rotateLeft(node) {
    const auxNode = node.right;

    node.right = auxNode.right;
    auxNode.right = auxNode.left;
    auxNode.left = node.left;
    node.left = auxNode;

    this.swapValues(node, auxNode);
    auxNode.updateLength();
    node.updateLength();
  }

  rotateRight(node) {
    const auxNode = node.left;

    node.left = auxNode.left;
    auxNode.left = auxNode.right;
    auxNode.right = node.right;
    node.right = auxNode;

    this.swapValues(node, auxNode);
    auxNode.updateLength();
    node.updateLength();
  }

  swapValues(nodeA, nodeB) {
    const aux = nodeA.data;
    nodeA.data = nodeB.data;
    nodeB.data = aux;
  }
}

const Crypt = {
  sha1: function (string) {
    const crypto = require("crypto");
    const hash = crypto.createHash("sha1");
    hash.update(string);
    return hash.digest("hex");
  },
};

function main() {
  try {
    const fileContent = fs.readFileSync("arquivo.txt", "utf8");

    fileContent.split("\n").forEach((line) => {
      if (line.trim() !== "") {
        const wordStack = [];
        const treeStack = [new BinarySearchTree()];

        line.split(/\s+/).forEach((word) => {
          wordStack.push(word);
        });

        while (wordStack.length > 0) {
          treeStack[treeStack.length - 1].insert(wordStack.pop());
        }

        while (treeStack.length > 0) {
          console.log(treeStack.pop().hashTree());
        }
      }
    });
  } catch (error) {
    console.error(error);
  }
}

main();
