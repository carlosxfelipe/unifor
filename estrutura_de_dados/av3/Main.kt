import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.*

fun main() {
    try {
        // Lê o conteúdo do arquivo
        val fileContent = String(Files.readAllBytes(Paths.get("arquivo.txt")))

        // Itera sobre cada linha do conteúdo do arquivo
        for (line in fileContent.split("\\n".toRegex())) {
            if (line.isNotBlank()) {
                // Pilha para armazenar palavras
                val wordStack = Stack<String>()
                // Pilha para armazenar árvores binárias de pesquisa
                val treeStack = Stack<BinarySearchTree<String>>()
                treeStack.push(BinarySearchTree())

                // Preenche a pilha de palavras com as palavras da linha
                for (word in line.split("\\s+".toRegex())) {
                    wordStack.push(word)
                }

                // Insere as palavras na árvore binária de pesquisa
                while (wordStack.isNotEmpty()) {
                    treeStack.peek().insert(wordStack.pop())
                }

                // Imprime o hash da árvore
                while (treeStack.isNotEmpty()) {
                    println(treeStack.pop().hashTree())
                }
            }
        }
    } catch (e: IOException) {
        e.printStackTrace()
    }
}

// Classe para representar uma árvore binária de pesquisa
class BinarySearchTree<T : Comparable<T>> {

    // Classe interna que representa um nó na árvore
    inner class Node(var data: T) {
        var rightLength: Int = 0
        var leftLength: Int = 0
        var left: Node? = null
        var right: Node? = null

        // Obtém o comprimento do lado mais longo do nó
        fun getBiggerLength(): Int {
            return maxOf(rightLength, leftLength)
        }

        // Obtém a diferença entre os comprimentos dos lados direito e esquerdo do nó
        fun getDifference(): Int {
            return leftLength - rightLength
        }

        // Atualiza os comprimentos dos lados direito e esquerdo do nó
        fun updateLength() {
            leftLength = if (left == null) 0 else left!!.getBiggerLength() + 1
            rightLength = if (right == null) 0 else right!!.getBiggerLength() + 1
        }

        // Compara dois nós com base nos dados que contêm
        fun compareTo(otherNode: Node): Int {
            return data.toString().compareTo(otherNode.data.toString(), ignoreCase = true)
        }

        // Obtém o hash dos dados do nó
        fun getHash(): String {
            return Crypt.sha1(data.toString())
        }
    }

    var root: Node? = null

    // Obtém o hash da árvore
    fun hashTree(): String {
    return hashTree(root)
}

    // Obtém o hash de uma subárvore a partir de um nó específico
    private fun hashTree(node: Node?): String {
    if (node == null) return ""
    
    val nodeHash = if (node.left == null && node.right == null) {
        Crypt.sha1(node.data.toString())
    } else {
        Crypt.sha1(
            hashTree(node.left) +
            hashTree(node.right) +
            Crypt.sha1(node.data.toString())
        )
    }

    // Adiciona um print para visualizar a árvore
    println("Node: ${node.data}, Hash: $nodeHash")

    return nodeHash
}

    // Insere um valor na árvore
    fun insert(value: T) {
        val newNode = Node(value)
        if (root == null) {
            root = newNode
        } else {
            insert(root, newNode)
        }
    }

    // Método auxiliar para inserir um nó em uma subárvore
    private fun insert(node: Node?, newNode: Node) {
        if (node!!.data != newNode.data) {
            if (newNode.compareTo(node) < 0) {
                if (node.left == null) {
                    node.left = newNode
                } else {
                    insert(node.left, newNode)
                }
            } else {
                if (node.right == null) {
                    node.right = newNode
                } else {
                    insert(node.right, newNode)
                }
            }

            node.updateLength()
            balance(node)
        }
    }

    // Remove um valor da árvore
    fun remove(value: T) {
        val comparisonNode = Node(value)
        remove(root, comparisonNode)
    }

    // Método auxiliar para remover um nó de uma subárvore
    private fun remove(node: Node?, comparisonNode: Node): Node? {
        if (node == null) return null

        if (comparisonNode.compareTo(node) < 0) {
            node.left = remove(node.left, comparisonNode)
        } else if (comparisonNode.compareTo(node) > 0) {
            node.right = remove(node.right, comparisonNode)
        } else {
            if (node.left == null && node.right == null) {
                return null
            } else if (node.left != null && node.right == null) {
                return node.left
            } else if (node.left == null && node.right != null) {
                return node.right
            } else {
                val successor = findMinChildren(node.right!!)
                node.data = successor.data
                node.right = remove(node.right, successor)
            }
        }

        node.updateLength()
        balance(node)

        return node
    }

    // Encontra o nó com o valor mínimo em uma subárvore
    private fun findMinChildren(node: Node): Node {
        var currentNode = node
        while (currentNode.left != null) {
            currentNode = currentNode.left!!
        }
        return currentNode
    }

    // Realiza o balanceamento da árvore
    private fun balance(node: Node) {
        if (node.getDifference() < -1) {
            if (node.right != null && node.right!!.getDifference() > 0) {
                rotateRight(node.right!!)
            }
            rotateLeft(node)
        }
        if (node.getDifference() > 1) {
            if (node.left != null && node.left!!.getDifference() < 0) {
                rotateLeft(node.left!!)
            }
            rotateRight(node)
        }
    }

    // Realiza a rotação à esquerda
    private fun rotateLeft(node: Node) {
        val auxNode = node.right

        node.right = auxNode!!.right
        auxNode.right = auxNode.left
        auxNode.left = node.left
        node.left = auxNode

        swapValues(node, auxNode)
        auxNode.updateLength()
        node.updateLength()
    }

    // Realiza a rotação à direita
    private fun rotateRight(node: Node) {
        val auxNode = node.left

        node.left = auxNode!!.left
        auxNode.left = auxNode.right
        auxNode.right = node.right
        node.right = auxNode

        swapValues(node, auxNode)
        auxNode.updateLength()
        node.updateLength()
    }

    // Troca os valores de dois nós
    private fun swapValues(nodeA: Node, nodeB: Node) {
        val aux = nodeA.data
        nodeA.data = nodeB.data
        nodeB.data = aux
    }
}

// Objeto que fornece métodos de criptografia
object Crypt {

    // Gera o hash SHA-1 de uma string
    fun sha1(string: String): String {
        try {
            val digest = MessageDigest.getInstance("SHA-1")

            val hashBytes = digest.digest(string.toByteArray())

            val hexString = StringBuilder()
            for (hashByte in hashBytes) {
                val hex = Integer.toHexString(0xff and hashByte.toInt())
                if (hex.length == 1) {
                    hexString.append('0')
                }
                hexString.append(hex)
            }

            return hexString.toString()
        } catch (e: NoSuchAlgorithmException) {
            throw RuntimeException("Erro: Algoritmo SHA-1 não disponível")
        }
    }
}
